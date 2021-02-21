/**
 * @author quanju.gu
 * @date 2018/7/4
 */
public class Study {

    public void numsLand() {
        int[][] apple = new int[9][9];
        System.out.println("The value of a:" + apple[0][0] + " The value of b:" + apple[0][1]);
        test(apple);
        System.out.println("The new value of a:" + apple[0][0] + " The new value of b:" + apple[0][1]);

    }

    private void test(int[][] square) {
        square[0][0] = 9;
        square[0][1] = 9;
    }

}
