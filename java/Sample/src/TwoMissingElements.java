public class TwoMissingElements {

    static void printTwoMissingElements(int[] arr) {
        boolean[] mark = new boolean[arr.length + 3];

        for (int i=0; i < arr.length; i++) {
            mark[arr[i]] = true;
        }

        for (int i=1; i < mark.length; i++) {
            if (!mark[i]) {
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,5,3,4};
        printTwoMissingElements(arr);
    }
}
