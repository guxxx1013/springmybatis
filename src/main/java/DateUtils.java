import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.util.CollectionUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author quanju.gu
 * @date 2018/7/20
 */
public class DateUtils {
    private static final ZoneId DEFAULT_ZONE = ZoneId.systemDefault();
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final DateTimeFormatter DATE_MONTH_DAY_FORMATTER = DateTimeFormatter.ofPattern("MM月dd日");
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter MONTH_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM");
    private static final DateTimeFormatter MONTH_ID_FORMATTER = DateTimeFormatter.ofPattern("yyyyMM");
    private static final DateTimeFormatter MONTH_ID_DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd");

    private static final ZoneId ZONE_ID = ZoneId.systemDefault();

    public static void main(String[] args) {
        Date date = new Date();
        List<Date> dates = getDateTRange(date, 0, 0);
        System.out.println(dates);
    }

    public static String dayIdToMonthDay(Integer dayId) {
        if (dayId == null) {
            return null;
        }
        LocalDate localDate = LocalDate.parse(dayId.toString(), MONTH_ID_DATE_FORMATTER);
        return localDate.format(DATE_MONTH_DAY_FORMATTER);
    }

    public static String dayIdToWeek(Integer dayId) {
        if (dayId == null) {
            return null;
        }
        LocalDate localDate = LocalDate.parse(dayId.toString(), MONTH_ID_DATE_FORMATTER);
        return formatDayOfWeek(localDate.getDayOfWeek());
    }

    public static List<Date> getDateTRange(Date date, int start, int end) {
        List<Date> dates = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            dates.add(addInteger(date, i));
        }
        return dates;
    }

    public static List<Integer> datesToDayIds(Collection<Date> dates) {
        if (CollectionUtils.isEmpty(dates)) {
            return Collections.emptyList();
        }
        return dates.stream().map(DateUtils::dateToDayId).collect(Collectors.toList());
    }

    public static Integer dateToDayId(Date date) {
        return NumberUtils.createInteger(date.toInstant().atZone(ZONE_ID).toLocalDate().format(MONTH_ID_DATE_FORMATTER));
    }

    public static Date dayIdToDate(String dayId) {
        return Date.from(LocalDate.parse(dayId, MONTH_ID_DATE_FORMATTER).atStartOfDay(ZONE_ID).toInstant());
    }

    public static Date parseFullDate(String dateStr) {
        try {
            SimpleDateFormat fullDateFormatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK);
            return fullDateFormatter.parse(dateStr);
        } catch (Exception e) {
            return null;
        }
    }

    public static Date localDateToDate(LocalDate date) {
        ZonedDateTime zdt = date.atStartOfDay(DEFAULT_ZONE);
        return Date.from(zdt.toInstant());
    }

    public static Date localDateTimeToDate(LocalDateTime dateTime) {
        ZonedDateTime zdt = dateTime.atZone(DEFAULT_ZONE);
        return Date.from(zdt.toInstant());
    }

    public static LocalDate dateToLocalDate(Date date) {
        Instant instant = date.toInstant();
        return instant.atZone(DEFAULT_ZONE).toLocalDate();
    }

    public static String formatLocalDate(LocalDate localDate) {
        return localDate.atStartOfDay().format(DATE_TIME_FORMATTER);
    }

    public static String formatDayOfWeek(DayOfWeek dayOfWeek) {
        switch (dayOfWeek) {
            case MONDAY:
                return "星期一";
            case TUESDAY:
                return "星期二";
            case WEDNESDAY:
                return "星期三";
            case THURSDAY:
                return "星期四";
            case FRIDAY:
                return "星期五";
            case SATURDAY:
                return "星期六";
            case SUNDAY:
                return "星期日";
            default:
                return null;
        }
    }

    public static String formatMonthId(LocalDate localDate) {
        return localDate.format(MONTH_ID_FORMATTER);
    }

    public static LocalDate parseMonthId(String localDateStr) {
        return LocalDate.parse(localDateStr + "01", MONTH_ID_DATE_FORMATTER);
    }

    public static LocalDate parseLocalDate(String dateStr) {
        return LocalDate.parse(dateStr, DATE_FORMATTER);
    }

    public static Date parseDate(String dateStr) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.parse(dateStr);
    }

    public static String toYearMonth(LocalDate localDate) {
        return localDate.format(MONTH_FORMATTER);
    }

    public static Integer getBetweenCount(LocalDate start, LocalDate end, int type) {
        if (type == DateType.DAY) {
            return Integer.valueOf((start.until(end, ChronoUnit.DAYS) + 1) + "");
        }
        if (type == DateType.WEEK) {
            return Integer.valueOf((start.until(end, ChronoUnit.WEEKS) + 1) + "");
        }
        if (type == DateType.MONTH) {
            return Integer.valueOf((start.until(end, ChronoUnit.MONTHS) + 1) + "");
        }
        return 0;
    }

    public static Integer getBetweenCount(String start, String end, int type) {
        LocalDate startLocalDate = DateUtils.parseLocalDate(start);
        LocalDate endLocalDate = DateUtils.parseLocalDate(end);
        return getBetweenCount(startLocalDate, endLocalDate, type);
    }

    @Deprecated
    public static String formatOnlyDate(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }

    @Deprecated
    public static Date getYesterday() {
        SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
        Date beginDate = new Date();
        Calendar date = Calendar.getInstance();
        date.setTime(beginDate);
        date.set(Calendar.DATE, date.get(Calendar.DATE) - 1);
        Date endDate = null;
        try {
            endDate = dft.parse(dft.format(date.getTime()));
            return endDate;
        } catch (ParseException e) {
            return null;
        }
    }

    @Deprecated
    public static String secToTime(int time) {
        String timeStr = null;
        int hour = 0;
        int minute = 0;
        int second = 0;
        if (time <= 0)
            return "00:00";
        else {
            minute = time / 60;
            if (minute < 60) {
                second = time % 60;
                timeStr = unitFormat(minute) + ":" + unitFormat(second);
            } else {
                hour = minute / 60;
                if (hour > 99)
                    return "99:59:59";
                minute = minute % 60;
                second = time - hour * 3600 - minute * 60;
                timeStr = unitFormat(hour) + ":" + unitFormat(minute) + ":" + unitFormat(second);
            }
        }
        return timeStr;
    }

    @Deprecated
    public static String unitFormat(int i) {
        String retStr = null;
        if (i >= 0 && i < 10)
            retStr = "0" + Integer.toString(i);
        else
            retStr = "" + i;
        return retStr;
    }

    /**
     * 获取昨天日期
     *
     * @return yyyyMMdd
     */
    public static String getOneDate(int days) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, days);
        String oneday = new SimpleDateFormat("yyyyMMdd ").format(cal.getTime());
        return oneday;
    }

    /**
     * 获取凌晨时间戳（ms）
     *
     * @return
     */
    public static long getDawnTimestamp() {
        long now = System.currentTimeMillis() / 1000L;
        long daySecond = 60 * 60 * 24;
        return (now - (now + 8 * 3600) % daySecond) * 1000;
    }

    /**
     * 获取yyyyMMdd格式日期
     *
     * @param date
     * @return yyyyMMdd
     */
    public static String getDate(Date date) {
        return new SimpleDateFormat("yyyyMMdd").format(date);
    }

    /**
     * 获取当前的小时数
     *
     * @param date
     * @return
     */
    public static int getHour(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 获取昨天日期
     *
     * @return yyyyMMdd
     */
    public static String getDawnTime(int days) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, days);
        String dawnTime = new SimpleDateFormat("yyyy-MM-dd 00:00:00").format(cal.getTime());
        return dawnTime;
    }

    /**
     * 获取两个日期之间的天数 （当跨年的时候会有问题，即两个日期不在同一年）
     *
     * @return
     */
    public static int getDiffDays(Date start, Date end) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(start);
        //日期start 在本年中的第几天
        int day1 = calendar.get(Calendar.DAY_OF_YEAR);
        calendar.setTime(end);
        //日期end 在本年中的第几天
        int day2 = calendar.get(Calendar.DAY_OF_YEAR);
        return Math.abs(day2 - day1);
    }

    /**
     * 获取两个日期之间的天数
     *
     * @param startDate yyyyMMdd
     * @param endDate   yyyyMMdd
     * @return
     */
    public static int getDiffDaysByStr(String startDate, String endDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date start = null;
        Date end = null;
        try {
            start = sdf.parse(startDate);
            end = sdf.parse(endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(start);
        //日期start 在本年中的第几天
        int day1 = calendar.get(Calendar.DAY_OF_YEAR);
        calendar.setTime(end);
        //日期end 在本年中的第几天
        int day2 = calendar.get(Calendar.DAY_OF_YEAR);
        return Math.abs(day2 - day1);
    }

    /**
     * 收集起始时间到结束时间之间所有的时间并以字符串集合方式返回
     *
     * @param timeStart
     * @param timeEnd
     * @return
     */
    public static List<String> collectLocalDates(String timeStart, String timeEnd) {
        return collectLocalDates(LocalDate.parse(timeStart), LocalDate.parse(timeEnd));
    }

    /**
     * 收集起始时间到结束时间之间所有的时间并以字符串集合方式返回
     *
     * @param start
     * @param end
     * @return
     */
    public static List<String> collectLocalDates(LocalDate start, LocalDate end) {
        // 用起始时间作为流的源头，按照每次加一天的方式创建一个无限流
        return Stream.iterate(start, localDate -> localDate.plusDays(1))
                // 截断无限流，长度为起始时间和结束时间的差+1个
                .limit(ChronoUnit.DAYS.between(start, end) + 1)
                // 由于最后要的是字符串，所以map转换一下
                .map(LocalDate::toString)
                // 把流收集为List
                .collect(Collectors.toList());
    }

    /**
     * 将“yyyyMMdd”格式的时间字符串转换为“yyyy-MM-dd"
     *
     * @param dateStr yyyyMMdd 或 yyyy-MM-dd
     * @param plus    是否添加"-"
     * @return yyyy-MM-dd 或 yyyyMMdd
     */
    public static String transformDateFormat(String dateStr, Boolean plus) {

        try {
            String transformedDateStr = null;
            if (plus) {
                Date date = new SimpleDateFormat("yyyyMMdd").parse(dateStr);
                transformedDateStr = new SimpleDateFormat("yyyy-MM-dd").format(date);
            } else {
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
                transformedDateStr = new SimpleDateFormat("yyyyMMdd").format(date);
            }
            return transformedDateStr;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 获取该月的最后一天
     *
     * @param monthId yyyyMM
     * @return
     */
    public static Date getLastDay(String monthId) {
        String date = monthId.substring(0, 4) + "-" + monthId.substring(4, 6) + "-01";
        LocalDate localDate = LocalDate.parse(date);
        int monthLength = localDate.lengthOfMonth();
        String endDateStr = monthId + monthLength;

        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        Date endDate = null;
        try {
            endDate = formatter.parse(endDateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return endDate;
    }

    /**
     * 获取该月的第一天
     *
     * @param monthId yyyyMM
     * @return
     */
    public static Date getFirstDay(String monthId) {

        String beginDateStr = monthId + "01";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        Date startDate = null;
        try {
            startDate = formatter.parse(beginDateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return startDate;

    }

    /**
     * 在指定日期上加减日期
     *
     * @param date
     * @param amount
     * @return
     */
    public static Date addInteger(Date date, int amount) {
        Date myDate = null;
        if (date != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.DATE, amount);
            myDate = calendar.getTime();
        }
        return myDate;
    }

    /**
     * 获取当前日期前或者后的指定周的周一日期
     *
     * @param amount
     * @return
     */
    public static Date getWeekMonday(Date date, int amount) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.WEEK_OF_YEAR, amount);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return calendar.getTime();
    }

    /**
     * 获取当前日期前或者后的指定周的周日日期
     *
     * @param amount
     * @return
     */
    public static Date getWeekSunday(Date date, int amount) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.WEEK_OF_YEAR, amount);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);

        return addInteger(calendar.getTime(), 6);
    }


    /**
     * 日期转星期
     *
     * @param datetime
     * @return
     */
    public static String dateToWeek(String datetime) {
        SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd");
        String[] weekDays = {"周日", "周一", "周二", "周三", "周四", "周五", "周六"};
        Calendar cal = Calendar.getInstance(); // 获得一个日历
        Date datet = null;
        try {
            datet = f.parse(datetime);
            cal.setTime(datet);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1; // 指示一个星期中的某天。
        if (w < 0) {
            w = 0;
        }
        int month = cal.get(Calendar.MONTH) + 1;
        int day = cal.get(Calendar.DATE);
        return month + "/" + day + weekDays[w];
    }

    public static String dateToMMdd(String datetime) {
        SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd");
        Date datet = null;
        Calendar cal = Calendar.getInstance();
        try {
            datet = f.parse(datetime);
            cal.setTime(datet);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int month = cal.get(Calendar.MONTH) + 1;
        int day = cal.get(Calendar.DATE);
        return month + "/" + day;
    }

    public static String getMonthFirstDay(int amount) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Calendar calendar1 = Calendar.getInstance();
        calendar1.add(Calendar.MONTH, amount);
        calendar1.set(Calendar.DAY_OF_MONTH, 1);
        String firstDay = sdf.format(calendar1.getTime());
        return firstDay;
    }

    public static String getMonthLastDay(int amount) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Calendar calendar2 = Calendar.getInstance();
        calendar2.add(Calendar.MONTH, amount + 1);
        calendar2.set(Calendar.DAY_OF_MONTH, 0);
        String lastDay = sdf.format(calendar2.getTime());
        return lastDay;
    }
}
