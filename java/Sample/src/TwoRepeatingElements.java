public class TwoRepeatingElements {

    static void printRepeatingElements(int[] arr, int n) {
        int[] count = new int[arr.length];

        for (int i = 0; i < n; i++) {
            if (count[arr[i]] == 1)
                System.out.print(arr[i] + " ");
            else
                count[arr[i]]++;
        }
    }
    public static void main(String[] args) {
        //int[] arr = {1,2,3,1,4,2,5};
        int[] arr = {1,2,3,4};
        int n = arr.length;
        System.out.println(arr.length);
        printRepeatingElements(arr, n);
    }
}
