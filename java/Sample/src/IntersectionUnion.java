import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IntersectionUnion {
    static List<Integer> intersection(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        for (int j : arr1) {
            set.add(j);
        }
        for (int i : arr2) {
            if(set.contains(i)) {
                result.add(i);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 4, 5, 6 };
        int[] arr2 = { 2, 3, 5, 7 };
        List<Integer> intersection = intersection(arr1, arr2);
        for(int i : intersection) {
            System.out.println(i);
        }
    }
}
