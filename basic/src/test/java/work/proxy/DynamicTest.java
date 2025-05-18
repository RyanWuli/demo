package work.proxy;

import com.zxw_work.proxy.cglib.ProxyCglib;
import com.zxw_work.proxy.cglib.ProxyCglibPlus;
import com.zxw_work.proxy.dynamic.ProxyInvocationHandler;
import com.zxw_work.proxy.dynamic.Sale;
import com.zxw_work.proxy.dynamic.SaleImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Author: Ryan
 * @Date: 2024/5/10 9:55
 * @Version: 1.0
 * @Description: add the description
 */
@Slf4j
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
        log.info("i:{}", proxyCglib.i);
    }

    @Test
    public void testCglibPlus() {
        SaleImpl sale = new SaleImpl();
        ProxyCglibPlus proxyCglib = new ProxyCglibPlus();
        SaleImpl proxyCglibSale = (SaleImpl) proxyCglib.getInstance(sale);
        /*
        无注解，所以不被增强
        sell computer...
         */
//        proxyCglibSale.sellComputer();

        /*
        有注解，被增强
        15:55:17.607 [main] INFO com.zxw_work.proxy.cglib.ProxyCglibPlus - 增强 pre...
        sell phone...
        15:55:17.610 [main] INFO com.zxw_work.proxy.cglib.ProxyCglibPlus - 增强 after...
         */
        proxyCglibSale.sellPhone();
        log.info("i:{}", proxyCglib.i);
    }

}
