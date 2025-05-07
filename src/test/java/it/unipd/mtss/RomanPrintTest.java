
////////////////////////////////////////////////////////////////////
// // Stefano Longhena 2111936
// // Alessandro Savio 2101046
// ////////////////////////////////////////////////////////////////////
package it.unipd.mtss;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RomanPrinterTest {

    @Before
    public void setup() {
    }

    @Test
    public void testPrintWithValidSingleDigitNumber() {
        String result = RomanPrinter.print(1);
        String expected =
                " _____ \n" +
                        "|_   _|\n" +
                        "  | |  \n" +
                        "  | |  \n" +
                        " _| |_ \n" +
                        "|_____|\n";
        assertEquals(expected, result);
    }

    @Test
    public void testPrintWithValidNumberTen() {
        String result = RomanPrinter.print(10);
        String expected =
                " __ __ \n" +
                        "|  \\/  |\n" +
                        "| \\  / |\n" +
                        "| |\\/| |\n" +
                        "| |  | |\n" +
                        "|_|  |_|\n";
        assertEquals(expected, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPrintWithZeroShouldThrowException() {
        RomanPrinter.print(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPrintWithNegativeNumberShouldThrowException() {
        RomanPrinter.print(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPrintWithNumberGreaterThan1000ShouldThrowException() {
        RomanPrinter.print(1001);
    }

    @Test
    public void testPrintWithBoundaryValue1() {
        assertNotNull("Should convert number 1", RomanPrinter.print(1));
    }

    @Test
    public void testPrintWithBoundaryValue1000() {
        assertNotNull("Should convert number 1000", RomanPrinter.print(1000));
    }

    @Test
    public void testPrintCorrectlyConvertsRomanNumeralToAsciiArt() {
        String romanNumeral = IntegerToRoman.convert(1);
        assertEquals("I", romanNumeral);

        String result = RomanPrinter.print(1);
        assertTrue("ASCII art output for I should contain vertical lines",
                result.contains("|") && result.contains("_"));
    }

    @Test
    public void testPrintEachBasicRomanNumeral() {
        int[] basicNumerals = {1, 5, 10, 50, 100, 500, 1000};

        for (int num : basicNumerals) {
            String result = RomanPrinter.print(num);
            assertNotNull("Should print ASCII art for " + num, result);
            assertTrue("ASCII art for " + num + " should contain multiple lines",
                    result.split("\n").length > 1);
        }
    }

    @Test
    public void testPrintWithCompositeRomanNumeral() {
        String result = RomanPrinter.print(14);
        assertNotNull("Should print ASCII art for 14", result);

        String singleResult = RomanPrinter.print(1);
        String[] resultLines = result.split("\n");
        String[] singleLines = singleResult.split("\n");

        assertTrue("Composite numeral should be wider than single numeral",
                resultLines[0].length() > singleLines[0].length());
    }

    @Test(timeout = 1000)
    public void testPrintPerformanceForAllValidNumbers() {
        IntStream.rangeClosed(1, 100).forEach(RomanPrinter::print);
    }

    @Test
    public void testPrintAsciiArtWithEmptyStringShouldReturnEmptyResult() {
        try {
            String result = RomanPrinter.printAsciiArt("");
            assertEquals("", result);
        } catch (Exception e) {
            fail("Should not throw exception for empty string but return empty result");
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPrintAsciiArtWithInvalidRomanNumeralShouldThrowException() {
        RomanPrinter.printAsciiArt("ABC");
    }

    @Test
    public void testPrintIntegrationWithIntegerToRoman() {
        int[] testNumbers = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};

        for (int num : testNumbers) {
            String result = RomanPrinter.print(num);
            assertNotNull("Should generate ASCII art for " + num, result);
        }
    }

    @Test
    public void testPrintSmallSampleOfNumbers() {
        int[] sampleNumbers = {3, 6, 7, 12, 19, 25, 42, 87, 99, 246, 789, 999};

        for (int num : sampleNumbers) {
            String result = RomanPrinter.print(num);
            assertNotNull("Should generate ASCII art for " + num, result);
        }
    }

    @Test
    public void testPrintAsciiArtDirectly() {
        try {
            String result = RomanPrinter.printAsciiArt("IV");
            assertNotNull("Should generate ASCII art for IV", result);
            assertEquals(6, result.split("\n").length);
        } catch (Exception e) {
            fail("Exception should not be thrown for valid roman numeral");
        }
    }
}