import java.util.ArrayList;
import java.util.List;

/**
 * @author quanju.gu
 * @date 2021/2/17
 */
public class SolutionLaiOffer {
    public int longest(int[] array) {
        // Write your solution here
        if(array.length == 0) {
            return 0;
        }
        int result = 1;
        List<Integer> maxValue = new ArrayList<>();
        int index = 0;
        for (int i : array) {
            int localMax = loopEachArray(array, index, maxValue);
            maxValue.add(localMax);
            index++;
            result = Math.max(result, localMax);
        }
        return result;
    }

    private int loopEachArray(int[] array, int index, List<Integer> maxValue) {
        int curMax = 1;
        for (int i = 0; i < index; i++) {
            if (array[i] < array[index]) {
                curMax = Math.max(maxValue.get(i) + 1,curMax);
            }
        }
        return curMax;
    }
}
