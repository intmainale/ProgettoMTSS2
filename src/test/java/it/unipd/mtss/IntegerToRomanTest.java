////////////////////////////////////////////////////////////////////
// Stefano Longhena 2111936
// Alessandro Savio 2101046
////////////////////////////////////////////////////////////////////

package it.unipd.mtss;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IntegerToRomanTest {

    @Test
    public void testConvert_1() {
        assertEquals("I", IntegerToRoman.convert(1));
    }

    @Test
    public void testConvert_4() {
        assertEquals("IV", IntegerToRoman.convert(4));
    }

    @Test
    public void testConvert_9() {
        assertEquals("IX", IntegerToRoman.convert(9));
    }

    @Test
    public void testConvert_40() {
        assertEquals("XL", IntegerToRoman.convert(40));
    }

    @Test
    public void testConvert_50() {
        assertEquals("L", IntegerToRoman.convert(50));
    }

    @Test
    public void testConvert_90() {
        assertEquals("XC", IntegerToRoman.convert(90));
    }

    @Test
    public void testConvert_400() {
        assertEquals("CD", IntegerToRoman.convert(400));
    }

    @Test
    public void testConvert_500() {
        assertEquals("D", IntegerToRoman.convert(500));
    }

    @Test
    public void testConvert_888() {
        assertEquals("DCCCLXXXVIII", IntegerToRoman.convert(888));
    }

    @Test
    public void testConvert_900() {
        assertEquals("CM", IntegerToRoman.convert(900));
    }

    @Test
    public void testConvert_999() {
        assertEquals("CMXCIX", IntegerToRoman.convert(999));
    }

    @Test
    public void testConvert_399() {
        assertEquals("CCCXCIX", IntegerToRoman.convert(399));
    }

    @Test
    public void testConvert_1000() {
        assertEquals("M", IntegerToRoman.convert(1000));
    }

    @Test
    public void testConvert_InvalidZero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            IntegerToRoman.convert(0);
        });
        assertEquals("Input must be between 1 and 1000", exception.getMessage());
    }

    @Test
    public void testConvert_InvalidNegative() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            IntegerToRoman.convert(-5);
        });
        assertEquals("Input must be between 1 and 1000", exception.getMessage());
    }

    @Test
    public void testConvert_InvalidAbove1000() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            IntegerToRoman.convert(1001);
        });
        assertEquals("Input must be between 1 and 1000", exception.getMessage());
    }
}
