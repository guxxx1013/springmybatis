import com.alibaba.fastjson.JSON;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Lists;
import com.google.common.collect.Table;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.tuple.Pair;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

import java.util.stream.Collectors;


/**
 * @author quanju.gu
 * @date 5/10/18
 */
public class HttpClientTestProgram {


    public static int NO_DATE_GAP = 0;
    public static int DEFAULT_DATE_GAP = -1;
    public static int TWO_WEEK_GAP = -13;
    public static int ONE_WEEK_GAP = -6;
    public static int WOW_GAP = -7;

    public static int DEFAULT_TOP_SIZE = 5;
    public static int DEFAULT_POST_SIZE = 5;


    public static List<Integer> FULL_DAY_HOURS = Lists.newArrayList(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23);

    public static void main(String[] args){

        try {


            System.out.println("Http client test!");

            System.out.println("nothing is on the url path");

//            LocalDateTime begin = LocalDate.now().atStartOfDay();
//            LocalDateTime end = begin.plusDays(4);
//            Date beginDate = Date.from(begin.atZone(ZoneId.systemDefault()).toInstant());
//            Date endDate = Date.from(end.atZone(ZoneId.systemDefault()).toInstant());
//            System.out.println(beginDate + "mmmmmmm" + endDate);
//            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//            Date datetest = dateFormat.parse("2014-07-15");
//            LocalDateTime today = datetest.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
//            LocalDateTime tommorow = today.plusDays(1);
//            String abc = Strings.padStart( String.valueOf(0), 3, '0' );
//            System.out.println(abc);
//            BigDecimal price = new BigDecimal(3.21);
//            price = price.add(null);
//            System.out.println(price);
            Date today = new Date();
            Date queryDate = DateUtils.addInteger(today, DEFAULT_DATE_GAP);
            StatisticsReq req = new StatisticsReq();
            req.setDates(DateUtils.getDateTRange(queryDate, TWO_WEEK_GAP, NO_DATE_GAP));
            req.setAvgDates(DateUtils.getDateTRange(queryDate, ONE_WEEK_GAP, NO_DATE_GAP));
            req.setIncrementMinuend(queryDate);
            req.setIncrementSubtrahend(DateUtils.addInteger(queryDate, WOW_GAP));
            System.out.println("End of World");
            LocalDate localdate = LocalDate.now();
            DayOfWeek dayOfWeek = localdate.getDayOfWeek();
            LocalDate lastMonday = localdate.minusDays(7 * 4 + dayOfWeek.getValue() - 1);
            Date date = DateUtils.localDateToDate(lastMonday);
            List<BigDecimal> testArry = new ArrayList<>();
            System.out.println("End of World");

            List<PrepayOrderPO> prepayOrderPOS = new ArrayList<>();
            Map<String, PrepayOrderPO> prepayOrderPOMap = prepayOrderPOS.stream().collect(Collectors.toMap(PrepayOrderPO::getAge, po -> po));

            Table<Integer, Integer, Integer> hashBasedTable = HashBasedTable.create();
            hashBasedTable.put(1,2,3);
            hashBasedTable.put(1,3,4);
            hashBasedTable.put(4,2,8);
            hashBasedTable.put(1,5,6);
            hashBasedTable.put(6,5,7);
            hashBasedTable.put(1,2,2);
            System.out.println(hashBasedTable.row(0).values());


            Comparator<Integer> strcmp = Comparator.nullsLast(Comparator.naturalOrder());
            System.out.println("End of World");
            PrepayOrderPO prepayOrderPO = new PrepayOrderPO();

            Integer dayId = 20180611;
            //DateTimeFormatter.ofPattern("yyyyMMdd");
            LocalDate localDate = LocalDate.parse(dayId.toString(), DateTimeFormatter.ofPattern("yyyyMMdd"));
            String test = localDate.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
            System.out.println(test);

            String test21 = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
            NumberUtils.createInteger(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().format(DateTimeFormatter.ofPattern("yyyyMMdd")));

            BigDecimal fieldValue = new BigDecimal(Math.abs(49 - 100)/100);
            BigDecimal threshold = new BigDecimal(0.5);

            threshold= threshold.setScale(4, RoundingMode.HALF_UP);
            fieldValue = fieldValue.setScale(4, RoundingMode.HALF_UP);


            Integer initCheck = 49;
            Integer initShouldStock = 100;

            BigDecimal diff = new BigDecimal(initCheck - initShouldStock).abs();
            BigDecimal div = new BigDecimal(initShouldStock);

            //RoundingMode.HALF_UP;
            BigDecimal asd = diff.divide(div,4 ,4);


            Integer fieldEnum = null;
            Integer testt = null;

            Pair<Integer, Integer> pairValue = Pair.of(1,10);
            Integer a = pairValue.getLeft();
            Integer f = pairValue.getValue();

            System.out.println("End of World");
            PrepayOrderPO prepayOrderPO1 = new PrepayOrderPO();
            System.out.println(prepayOrderPO1.test);


            System.out.println(JSON.toJSONString(Lists.newArrayList(1)));


            Page page = new Page();
            Page page1 = new Page();
            User user = new User();
            User user1 = new User();

            System.out.println(page.hashCode());//102
            System.out.println(page1.hashCode());//102
            System.out.println(user.hashCode());
            System.out.println(user1.hashCode());

            boolean b = page.equals(page1);
            boolean b1 = user.equals(user1);//没有重写equals方法，内部使用的是==

            System.out.println(b);//true
            System.out.println(b1);//false
            System.out.println(page==page1);//false


            String account = "BCF123456";
            boolean prefix = account.startsWith("BCF");
            System.out.println("prefix is : " + prefix);


            String dateTest = "20200330 16:30:00";
//            String timeZoneId = "Asia/Calcutta";
            String timeZoneId = "Australia/Sydney";
            TimeZone timeZone = TimeZone.getTimeZone(timeZoneId);

            String timeZoneIdTarget = "";

            DateFormat dateFormatLocal = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
            dateFormatLocal.setTimeZone(timeZone);

            Date parsedDate = dateFormatLocal.parse(dateTest);
            Calendar cal = Calendar.getInstance();
            cal.setTime(parsedDate);
            System.out.println("ParsedDate is : " + cal.getTime());

            Date dateLocal = new Date();
            Calendar calLocal = Calendar.getInstance();
            calLocal.setTime(dateLocal);
            System.out.println("dateLocal is : " + calLocal.getTime());


        } catch (Exception e) {
            System.out.println("the result is :" + e);
        }

        //URL url = new URL(path);
    }

    public static Date convertTimezone(Date sourceDate, TimeZone sourceTimezone, TimeZone targetTimezone){


        // targetDate - sourceDate=targetTimezone-sourceTimezone
        // --->
        // targetDate=sourceDate + (targetTimezone-sourceTimezone)


        Calendar calendar=Calendar.getInstance();
        // date.getTime() 为时间戳, 为格林尼治到系统现在的时间差,世界各个地方获取的时间戳是一样的,
        // 格式化输出时,因为设置了不同的时区,所以输出不一样
        long sourceTime=sourceDate.getTime();


        calendar.setTimeZone(sourceTimezone);
        calendar.setTimeInMillis(sourceTime);// 设置之后,calendar会计算各种filed对应的值,并保存

        //获取源时区的到UTC的时区差
        int sourceZoneOffset=calendar.get(Calendar.ZONE_OFFSET);


        calendar.setTimeZone(targetTimezone);
        calendar.setTimeInMillis(sourceTime);

        int targetZoneOffset=calendar.get(Calendar.ZONE_OFFSET);
        int targetDaylightOffset=calendar.get(Calendar.DST_OFFSET); // 夏令时


        long targetTime=sourceTime+ (targetZoneOffset+targetDaylightOffset) -sourceZoneOffset;

        return new Date(targetTime);

    }


}
