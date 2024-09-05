package work.designparttern;

import com.zxw_work.designpattern.chainofresponsibility.ChainFactory;
import com.zxw_work.designpattern.chainofresponsibility.Resp;
import com.zxw_work.designpattern.chainofresponsibility.ServiceInvocation;
import com.zxw_work.designpattern.chainofresponsibility.ServiceInvoker;
import com.zxw_work.designpattern.chainofresponsibility.interfaces.Invoker;
import org.junit.Test;

/**
 * @Author: Ryan
 * @Date: 2024/9/2 16:40
 * @Version: 1.0
 * @Description: add the description
 */
public class ChainOfResponsibilityTest {

    /**
     * filter 责任链 测试用例
     */
    @Test
    public void test() {

        ServiceInvoker serviceInvoker = new ServiceInvoker();

        serviceInvoker.setResp(new Resp("service invoker resp"));

        Invoker invoker = ChainFactory.buildFilterInvoke(serviceInvoker);

        invoker.invoke(new ServiceInvocation("serviceTest"));

    }

    public void test1() {

    }

}
