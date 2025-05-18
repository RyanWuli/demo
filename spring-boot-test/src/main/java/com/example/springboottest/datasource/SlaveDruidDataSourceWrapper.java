package com.example.springboottest.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.sql.parser.ParserException;
import com.example.springboottest.constant.Constant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author: Ryan
 * @Date: 2024/12/16 14:26
 * @Version: 1.0
 * @Description: add the description
 */
@Slf4j
@ConfigurationProperties("spring.datasource.druid")
public class SlaveDruidDataSourceWrapper extends DruidDataSource implements InitializingBean {

    @Value("${spring.datasource.slave-db.url}")
    private String slaveUrl;

    @Value("${spring.datasource.slave-db.username}")
    private String slaveUsername;

    @Value("${spring.datasource.slave-db.password}")
    private String slavePassword;

    private static final Map<String, String> parameters = new HashMap<>();

    static {
        parameters.put("serverTimezone", "Asia/Shanghai");
        parameters.put("useUnicode", "true");
        parameters.put("characterEncoding", "UTF8");
        parameters.put("zeroDateTimeBehavior", "convertToNull");
        parameters.put("allowMultiQueries", "true");
        parameters.put("useSSL", "false");
        parameters.put("connectTimeout", "30000");
        parameters.put("rewriteBatchedStatements", "true");
        parameters.put("useAffectedRows", "true");
        parameters.put("allowPublicKeyRetrieval", "true");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        String url = slaveUrl;

        // 把 url 中自定义的参数和默认的参数拼接到一起
        if (StringUtils.hasLength(url)) {
            try {
                int pos = url.indexOf(Constant.QUES);
                if (pos != -1) {
                    String params = url.substring(url.indexOf(Constant.QUES) + 1);
                    // url 中的参数（支持自定义）
                    parameters.putAll(parseParams(params));
                    // 截取参数之前的 url 重新设置参数
                    url = url.substring(0, url.indexOf(Constant.QUES));
                }
            } catch (Exception e) {
                throw new ParserException("slave-db url parse error", e);
            }

            // 重新拼接完整的 url, 固定的参数和自定义的参数一起
            url += parameters.entrySet().stream()
                    .map(e -> e.getKey() + Constant.EQ + e.getValue()).collect(Collectors.joining(Constant.AND));

            log.info("合并后的 slave-db jdbc url: [{}]", url);
        }

        super.setUrl(url);
        super.setUsername(username);
        super.setPassword(password);
    }

    @Override
    public void setMaxEvictableIdleTimeMillis(long maxEvictableIdleTimeMillis) {
        try {
            super.setMaxEvictableIdleTimeMillis(maxEvictableIdleTimeMillis);
        } catch (IllegalArgumentException e) {
            super.maxEvictableIdleTimeMillis = maxEvictableIdleTimeMillis;
        }
    }

    /**
     * 解析 url 中 ? 后面的参数
     */
    private Map<String, String> parseParams(String paramsStr) {
        Map<String, String> paramsMap = new HashMap<>();

        if (StringUtils.hasLength(paramsStr)) {
            String[] params = paramsStr.split(Constant.AND);
            for (String param : params) {
                String name = param.substring(0, param.indexOf(Constant.EQ));
                String value = param.substring(param.indexOf(Constant.EQ) + 1);
                paramsMap.put(name, value);
            }
        }

        return paramsMap;
    }
}
