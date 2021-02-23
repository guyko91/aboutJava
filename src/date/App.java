package date;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class App {
    public static void main(String[] args) {

        // 기계용 시간 API
        Instant instant = Instant.now();
        System.out.println(instant); // 기준시 UTC(=GMT)
        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault());
        System.out.println(zonedDateTime);

        // LocalDateTime
        LocalDateTime today = LocalDateTime.now();
        System.out.println(today);
        LocalDateTime birthDay = LocalDateTime.of(1991, Month.FEBRUARY, 13, 0, 0, 0);
        ZonedDateTime nowInLA = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));

        // 기간을 표시하는 방법 (날짜)
        LocalDate now = LocalDate.now();
        LocalDate thisYearBirthDay = LocalDate.of(2020, Month.FEBRUARY, 13);
        Period period = Period.between(now, thisYearBirthDay);
        System.out.println(period.getDays());
        Period period2 = now.until(thisYearBirthDay);
        System.out.println(period2.get(ChronoUnit.DAYS));

        // 기간을 표시하는 방법
        Instant newInstant = Instant.now();
        Instant newInstant2 = newInstant.plus(10, ChronoUnit.SECONDS);
        Duration duration = Duration.between(newInstant, newInstant2);
        System.out.println(duration.getSeconds());

    }
}
