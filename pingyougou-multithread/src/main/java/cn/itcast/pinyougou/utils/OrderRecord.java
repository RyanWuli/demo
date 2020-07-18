package cn.itcast.pinyougou.utils;

import java.io.Serializable;

/**
 * @Author: Ryan
 * @Date: 2020/7/18 15:18
 * @Version: 1.0
 * @Description:
 */
public class OrderRecord implements Serializable {

    private Long id;
    private String userId;

    public OrderRecord(Long id, String userId) {
        this.id = id;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
