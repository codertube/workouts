import java.util.HashSet;
import java.util.Set;

public class FirstRepeatingElement {
    static void firstRepeatElement(int[] arr) {
        int result = -1;
        Set<Integer> set = new HashSet<Integer>();;
        for(int i=arr.length-1; i>=0; i--) {
            if(set.contains(arr[i])) {
               result = i;
            } else {
                set.add(arr[i]);
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {10, 5, 3, 4, 3, 5, 6};
        firstRepeatElement(arr);
    }
}
