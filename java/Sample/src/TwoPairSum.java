import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoPairSum {

    public static void printPairs(int[] input, int sum) {
        Map<Integer, Integer> freqCount = new HashMap<>();
        for (int i = 0; i < input.length; i++) {
            int diff = sum - input[i];
            if (diff == input[i]) {
                if (freqCount.containsKey(diff) && freqCount.get(diff) == 1) {
                    System.out.println("("+ input[i] + " ,"+diff+")");
                }
            } else if (freqCount.containsKey(diff) && !freqCount.containsKey(input[i])) {
                System.out.println("("+ input[i] + " ,"+diff+")");
            }
            freqCount.put(input[i], freqCount.getOrDefault(input[i], 0) + 1);
        }

    }

    public static void main(String[] args) {
        int[] arr = {4,0,-1,3,8};
        int target = 7;
        printPairs(arr, target);
    }

}
