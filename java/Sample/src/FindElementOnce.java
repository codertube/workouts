import java.util.Arrays;

public class FindElementOnce {
    static void findElementAppearOnce(int[] arr) {
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result = result ^ arr[i];
        }
        System.out.println(result);
    }
    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 4, 5, 3, 4};
        findElementAppearOnce(arr);
    }
}
