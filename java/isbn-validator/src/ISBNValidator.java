
public interface ISBNValidator {

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
    boolean isValidISBN(final String isbn);

}
