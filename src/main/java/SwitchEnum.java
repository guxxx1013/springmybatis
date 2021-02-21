import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author quanju.gu
 * @date 2018/8/17
 */
public enum SwitchEnum {
    ONE(1, "x"),
    TWO(2, "x2"),
    THREE(3, "x");

    private int type;
    private String name;

    SwitchEnum(int type, String name) {
        this.type = type;
        this.name = name;
    }
    // 查找某一个枚举值
    public static SwitchEnum findAny(String name) {
        return Arrays.stream(SwitchEnum.values())
                .filter(switchEnum -> switchEnum.getName().equals(name))
                .findAny()
                .orElse(null);
    }

    // 匹配到第一个枚举值就返回
    public static SwitchEnum findFirst(String name) {
        return Arrays.stream(SwitchEnum.values())
                .filter(switchEnum -> switchEnum.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    // 枚举匹配
    public static boolean anyMatch(int type) {
        return Arrays.stream(SwitchEnum.values())
                //匹配任何一个则返回
                .anyMatch(switchEnum -> switchEnum.getType() == type);
    }

    // 枚举匹配
    public static boolean allMatch(String name) {
        return Arrays.stream(SwitchEnum.values())
                //匹配所有
                .allMatch(switchEnum -> switchEnum.getName().equals(name));
    }

    public int getType() {
        return type;
    }


    public String getName() {
        return name;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("findAny============>" + findAny("x"));
        System.out.println("findFirst============>" + findFirst("x"));
        Future<Integer> future = new SquareCalculator().calculate(10);
//        while(!future.isDone()) {
//            System.out.println("Calculating...");
//        }
        System.out.println("anyMatch============>" + anyMatch(2));
        Integer result = future.get();
        System.out.println("------------>" + result);
        System.out.println("anyMatch============>" + allMatch("x"));

    }

}
