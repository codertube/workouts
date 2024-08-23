import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ISBNValidatorImpl implements ISBNValidator {

    /**
     * Decides whether the input is a valid ISBN code.
     * The ISBN-10 is a book identification number containing 9 digits (0 to 9) plus one check character (either a digit or an X only).
     * Check character 'X' represents the number 10. ISBN code can contain hyphens, however they don't influence
     * the formula and can be omited.
     * Valid ISBN code follows this formula:
     *      (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9 * 2 + x10 * 1) mod 11 == 0
     * Example: ISBN code 3-598-21508-8 is valid
     *
     * @param isbn ISBN-10 code to be validated
     * @return true if the input code is in a valid ISBN format, false otherwise
     * @throws IllegalArgumentException if the input is null
     */
    @Override
    public boolean isValidISBN(String isbn) {

        if (isbn == null) {
            throw new IllegalArgumentException("Invalid ISBN");
        }

        return isValidISBNPattern(isbn);
    }

    private boolean isValidISBNPattern(String isbn) {
        isbn = isbn.replaceAll("-","");
        Pattern pattern = Pattern.compile("[0-9X]+");
        Matcher matcher = pattern.matcher(isbn);
        if (matcher.matches() && isbn.length() == 10) {
            int sum = 0;
            for (int i=10; i>0; i--) {
                char ch = isbn.charAt(i-1);
                if (ch == 'X')
                    ch = 10;
                sum = sum + ch * i;
            }
            return sum % 11 == 0;
        }
        return false;
    }

}
