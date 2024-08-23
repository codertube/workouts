import java.util.HashSet;
import java.util.Set;

public class ElementPresentArray {

    static void ElementNotPresentInSecond(int[] a, int[] b) {

        Set<Integer> set = new HashSet<Integer>();
        for (int i: b){
            set.add(i);
        }
        for (int i: a){
            if (!set.contains(i)){
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 10};
        int[] b = {2, 3, 1, 0, 5};

        ElementNotPresentInSecond(a, b);
    }
}
