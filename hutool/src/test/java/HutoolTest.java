import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author: Ryan
 * @Date: 2020/11/11 17:00
 * @Version: 1.0
 * @Description:
 */
public class HutoolTest {

    /**
     * 时间偏移一年
     * @param args
     */
//    public static void main(String[] args) {
//        Date date = DateUtil.offsetMonth(new Date(), 12);
//        String d = DateUtil.format(date, "yyyy-MM-dd HH:mm:ss");
//        System.out.println(d);
//    }

    /**
     * 星座
     * @param args
     */
//    public static void main(String[] args) {
//        String date = "1991-12-25";
//        Date dateTime = DateUtil.parseDate(date);
//        System.out.println(dateTime);
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(dateTime);
//        int day = calendar.get(Calendar.DAY_OF_MONTH);
//        int month = calendar.get(Calendar.MONTH);
//        System.out.println(">>>>> month:" + month + "----- day:" + day);
//        String zodiac = DateUtil.getZodiac(month, day);
//        System.out.println("zodiac:" + zodiac);
//    }

    /**
     * 模板内容替换工具测试
     * @param args
     */
//    public static void main(String[] args) {
//        String template = "您在{0}提交的反馈有一条新的回复！回复内容是：{1}";
//        Date date = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String format = sdf.format(date);
//        String[] str = {format, "可以检查手机是否联网"};
//        int length = str.length;
//        if (length > 0) {
//            for (int i = 0; i < length; i++) {
//                template = template.replace("{" + i + "}", str[i]);
//            }
//        }
//        System.out.println(template);
//    }


    public static void main(String[] args) {
        String today = DateUtil.today();
        DateTime dateTime = DateUtil.parseDate(today);
        System.out.println(">>>>> today={}" + today);
        System.out.println(dateTime);
        Date day = DateUtil.parseDate(today);
        Date d = new Date();
        System.out.println(day);
        System.out.println(d);


    }
}
