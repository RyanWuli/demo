import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.time.*;
import java.util.Date;
import java.util.Set;

/**
 * @Author: Ryan
 * @Date: 2021/9/7 13:53
 * @Version: 1.0
 * @Description: add the description
 */
@Slf4j
public class DateAndTime {

    @Test
    public void test() {
        Date date = new Date();
        log.info("date:{}", date);

        Instant instant = date.toInstant();
        log.info("instant:{}", instant);
        ZoneId zi = ZoneId.systemDefault();
        log.info("zoneId:{}", zi);
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();

        LocalDateTime localDateTime = instant.atZone(zi).toLocalDateTime();
        LocalDate localDate = instant.atZone(zi).toLocalDate();
        LocalTime localTime = instant.atZone(zi).toLocalTime();
        String s = instant.atZone(zi).toString();
        OffsetDateTime offsetDateTime = instant.atZone(zi).toOffsetDateTime();
        Instant ins = Instant.ofEpochMilli(new Date().getTime());

        log.info("localDateTime:{}", localDateTime);
        log.info("localDate:{}", localDate);
        log.info("localTime:{}", localTime);
        log.info("offsetDateTime:{}", offsetDateTime);
        log.info("ins:{}", ins);
        log.info("s:{}", s);
        log.info("availableZoneIds:{}", availableZoneIds);
    }
}
