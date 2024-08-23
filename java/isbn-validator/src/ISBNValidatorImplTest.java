import org.junit.Assert;
import org.junit.Test;

public class ISBNValidatorImplTest {

    private static final ISBNValidator VALIDATOR = new ISBNValidatorImpl();

    @Test(expected = IllegalArgumentException.class)
    public void testNullInputThrowsException(){
        VALIDATOR.isValidISBN(null);
    }

    @Test
    public void testInvalidRandomInput(){
        final String isbn = "hello";
        final boolean isValid = VALIDATOR.isValidISBN(isbn);
        Assert.assertFalse(isValid);
    }

    @Test
    public void testInvalidContainsIllegalCharacter(){
        final String isbn = "A13-609181-4";
        final boolean isValid = VALIDATOR.isValidISBN(isbn);
        Assert.assertFalse(isValid);
    }

    @Test
    public void testInvalidTooLittleDigitsAndTooManyHyphens(){
        final String isbn = "1-2-3-4-56";
        final boolean isValid = VALIDATOR.isValidISBN(isbn);
        Assert.assertFalse(isValid);
    }

    @Test
    public void testInvalidCorrectModuloButTooLittleDigits(){
        final String isbn = "15";
        final boolean isValid = VALIDATOR.isValidISBN(isbn);
        Assert.assertFalse(isValid);
    }

    @Test
    public void testValidWithHyphens(){
        final String isbn = "013-609181-4";
        final boolean isValid = VALIDATOR.isValidISBN(isbn);
        Assert.assertTrue(isValid);
    }

    @Test
    public void testValidWithHyphens2(){
        final String isbn = "0-590-76484-5";
        final boolean isValid = VALIDATOR.isValidISBN(isbn);
        Assert.assertTrue(isValid);
    }

    @Test
    public void testValidWithoutHyphens(){
        final String isbn = "0136091814";
        final boolean isValid = VALIDATOR.isValidISBN(isbn);
        Assert.assertTrue(isValid);
    }

    @Test
    public void testValidWithoutHyphens2(){
        final String isbn = "0198526636";
        final boolean isValid = VALIDATOR.isValidISBN(isbn);
        Assert.assertTrue(isValid);
    }

    @Test
    public void testValidWithoutHyphens3(){
        final String isbn = "1861972717";
        final boolean isValid = VALIDATOR.isValidISBN(isbn);
        Assert.assertTrue(isValid);
    }

    @Test
    public void testValidWithXCharacter(){
        final String isbn = "123456789X";
        final boolean isValid = VALIDATOR.isValidISBN(isbn);
        Assert.assertTrue(isValid);
    }

}
