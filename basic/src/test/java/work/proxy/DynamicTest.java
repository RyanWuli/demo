package work.proxy;

import com.zxw_work.proxy.cglib.ProxyCglib;
import com.zxw_work.proxy.dynamic.ProxyInvocationHandler;
import com.zxw_work.proxy.dynamic.Sale;
import com.zxw_work.proxy.dynamic.SaleImpl;
import org.junit.Test;

/**
 * @Author: Ryan
 * @Date: 2024/5/10 9:55
 * @Version: 1.0
 * @Description: add the description
 */
public class DynamicTest {

    @Test
    public void testJavaDynamicProxy() {
        // 被代理实例
        Sale sale = new SaleImpl();
        // 代理公司（用这个公司的方式去卖产品）
        ProxyInvocationHandler handler = new ProxyInvocationHandler();
        // 需要被代理的实例给代理公司
        handler.setObject(sale);
        // 公司安排新的代理者来进行售卖
        Sale saleProxy = (Sale) handler.getProxy();
        // 按照代理的公司进行售卖
        saleProxy.sellComputer();
        System.out.println(sale == saleProxy);
    }

    @Test
    public void testCglib() {
        SaleImpl sale = new SaleImpl();
        ProxyCglib proxyCglib = new ProxyCglib();
        SaleImpl proxyCglibSale = (SaleImpl) proxyCglib.getInstance(sale);
        proxyCglibSale.sellComputer();
    }

}
