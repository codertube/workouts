import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PalindromeDemo {

    public static boolean isPalindrome(String str) {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString().equalsIgnoreCase(str);
    }

    public static List<String> findPalindromes(String Sentence) {
        List<String> palindromes = new ArrayList<>();
        String[] strArray = Sentence.split(" ");
        for (String str : strArray) {
            str = str.toLowerCase();
            if (isPalindrome(str)) {
                palindromes.add(str);
            }
        }
        return palindromes;
    }

    public static void main(String[] args) {
        String Sentence = "Bob went for camping with Dad bob";
        List<String> palindromes = findPalindromes(Sentence);
        Map<String, Integer> palindromeMap = palindromes
                .stream()
                .collect(Collectors.toMap(Function.identity(), V->1, Integer::sum));
        System.out.println(palindromeMap);

    }
}
