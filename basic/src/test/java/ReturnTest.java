/**
 * return 的测试
 */
public class ReturnTest {

    public static void main(String[] args) {

        ReturnTest returnTest = new ReturnTest();
        System.out.println(returnTest.m());

    }

    public String m() {
        String s = "aaaaa";
        m2();
        s = "bbbbb";
        return s;
    }

    public void m2() {
        return ;
    }

}
