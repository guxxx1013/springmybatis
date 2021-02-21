import java.util.Date;
import java.util.List;

/**
 * @author quanju.gu
 * @date 2018/9/12
 */
public class StatisticsReq {

    private List<Integer> shopIds;

    /**
     * 门店id
     */
    private Integer shopId;

    /**
     * 单日统计
     */
    private List<Date> dates;

    /**
     * 求平均日期
     */
    private List<Date> avgDates;

    /**
     * 增量被减数
     */
    private Date incrementMinuend;

    /**
     * 增量减数
     */
    private Date incrementSubtrahend;

    /**
     * 单日统计
     */
    private List<Integer> dayIds;

    /**
     * 求平均日期
     */
    private List<Integer> avgDayIds;

    /**
     * 增量被减数
     */
    private Integer incrementMinuendDayId;

    /**
     * 增量减数
     */
    private Integer incrementSubtrahendDayId;


    /**
     * 周增量被减数
     */
    private Integer incrementMinuendWeekId;

    /**
     * 周增量减数
     */
    private Integer incrementSubtrahendWeekId;

    /**
     * Top size
     */
    private Integer topSize;

    /**
     * Post size
     */
    private Integer postSize;

    /**
     * 排序的字段
     */
    private Integer sortedMetrics;

    /**
     * 统计时间段
     */
    private List<Integer> hourIds;

    /**
     * 三级分类id
     */
    private Integer classId;

    private List<Integer> classIds;
    /**
     * 商品id
     */
    private Integer skuId;

    private List<Integer> skuIds;

    private Integer hourId;

    public List<Integer> getShopIds() {
        return shopIds;
    }

    public void setShopIds(List<Integer> shopIds) {
        this.shopIds = shopIds;
    }

    private Integer wowHourId;

    private Date day;

    private Integer dayId;

    private Date wowDay;

    private Integer wowDayId;

    private List<Integer> allDayIds;

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public List<Date> getDates() {
        return dates;
    }

    public void setDates(List<Date> dates) {
        this.dates = dates;
    }

    public List<Date> getAvgDates() {
        return avgDates;
    }

    public void setAvgDates(List<Date> avgDates) {
        this.avgDates = avgDates;
    }

    public Date getIncrementMinuend() {
        return incrementMinuend;
    }

    public void setIncrementMinuend(Date incrementMinuend) {
        this.incrementMinuend = incrementMinuend;
    }

    public Date getIncrementSubtrahend() {
        return incrementSubtrahend;
    }

    public void setIncrementSubtrahend(Date incrementSubtrahend) {
        this.incrementSubtrahend = incrementSubtrahend;
    }

    public List<Integer> getDayIds() {
        return dayIds;
    }

    public void setDayIds(List<Integer> dayIds) {
        this.dayIds = dayIds;
    }

    public List<Integer> getAvgDayIds() {
        return avgDayIds;
    }

    public void setAvgDayIds(List<Integer> avgDayIds) {
        this.avgDayIds = avgDayIds;
    }

    public Integer getIncrementMinuendDayId() {
        return incrementMinuendDayId;
    }

    public void setIncrementMinuendDayId(Integer incrementMinuendDayId) {
        this.incrementMinuendDayId = incrementMinuendDayId;
    }

    public Integer getIncrementSubtrahendDayId() {
        return incrementSubtrahendDayId;
    }

    public void setIncrementSubtrahendDayId(Integer incrementSubtrahendDayId) {
        this.incrementSubtrahendDayId = incrementSubtrahendDayId;
    }

    public Integer getTopSize() {
        return topSize;
    }

    public void setTopSize(Integer topSize) {
        this.topSize = topSize;
    }

    public Integer getPostSize() {
        return postSize;
    }

    public void setPostSize(Integer postSize) {
        this.postSize = postSize;
    }

    public Integer getSortedMetrics() {
        return sortedMetrics;
    }

    public void setSortedMetrics(Integer sortedMetrics) {
        this.sortedMetrics = sortedMetrics;
    }

    public List<Integer> getHourIds() {
        return hourIds;
    }

    public void setHourIds(List<Integer> hourIds) {
        this.hourIds = hourIds;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Integer getSkuId() {
        return skuId;
    }

    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
    }

    public Integer getHourId() {
        return hourId;
    }

    public void setHourId(Integer hourId) {
        this.hourId = hourId;
    }

    public Integer getWowHourId() {
        return wowHourId;
    }

    public void setWowHourId(Integer wowHourId) {
        this.wowHourId = wowHourId;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public Integer getDayId() {
        return dayId;
    }

    public void setDayId(Integer dayId) {
        this.dayId = dayId;
    }

    public Date getWowDay() {
        return wowDay;
    }

    public void setWowDay(Date wowDay) {
        this.wowDay = wowDay;
    }

    public Integer getWowDayId() {
        return wowDayId;
    }

    public void setWowDayId(Integer wowDayId) {
        this.wowDayId = wowDayId;
    }

    public List<Integer> getAllDayIds() {
        return allDayIds;
    }

    public void setAllDayIds(List<Integer> allDayIds) {
        this.allDayIds = allDayIds;
    }

    public List<Integer> getClassIds() {
        return classIds;
    }

    public void setClassIds(List<Integer> classIds) {
        this.classIds = classIds;
    }

    public List<Integer> getSkuIds() {
        return skuIds;
    }

    public void setSkuIds(List<Integer> skuIds) {
        this.skuIds = skuIds;
    }

    public Integer getIncrementMinuendWeekId() {
        return incrementMinuendWeekId;
    }

    public void setIncrementMinuendWeekId(Integer incrementMinuendWeekId) {
        this.incrementMinuendWeekId = incrementMinuendWeekId;
    }

    public Integer getIncrementSubtrahendWeekId() {
        return incrementSubtrahendWeekId;
    }

    public void setIncrementSubtrahendWeekId(Integer incrementSubtrahendWeekId) {
        this.incrementSubtrahendWeekId = incrementSubtrahendWeekId;
    }

    @Override
    public String toString() {
        return "StatisticsReq{" +
                "shopIds=" + shopIds +
                ", shopId=" + shopId +
                ", dates=" + dates +
                ", avgDates=" + avgDates +
                ", incrementMinuend=" + incrementMinuend +
                ", incrementSubtrahend=" + incrementSubtrahend +
                ", dayIds=" + dayIds +
                ", avgDayIds=" + avgDayIds +
                ", incrementMinuendDayId=" + incrementMinuendDayId +
                ", incrementSubtrahendDayId=" + incrementSubtrahendDayId +
                ", incrementMinuendWeekId=" + incrementMinuendWeekId +
                ", incrementSubtrahendWeekId=" + incrementSubtrahendWeekId +
                ", topSize=" + topSize +
                ", postSize=" + postSize +
                ", sortedMetrics=" + sortedMetrics +
                ", hourIds=" + hourIds +
                ", classId=" + classId +
                ", classIds=" + classIds +
                ", skuId=" + skuId +
                ", skuIds=" + skuIds +
                ", hourId=" + hourId +
                ", wowHourId=" + wowHourId +
                ", day=" + day +
                ", dayId=" + dayId +
                ", wowDay=" + wowDay +
                ", wowDayId=" + wowDayId +
                ", allDayIds=" + allDayIds +
                '}';
    }
}
