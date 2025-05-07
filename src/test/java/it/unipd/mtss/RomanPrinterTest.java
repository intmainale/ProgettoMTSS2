////////////////////////////////////////////////////////////////////
// // Stefano Longhena 2111936
// // Alessandro Savio 2101046
// ////////////////////////////////////////////////////////////////////

package it.unipd.mtss;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class RomanPrinterTest {

    @Test
    void testPrintNumber1() {
        String expected =
                " _ \n" +
                        "|_|\n" +
                        "|_|";
        String actual = RomanPrinter.print(1);
        assertEquals(expected, actual);
    }

    @Test
    void testPrintNumber3() {
        String expected =
                " _  _  _ \n" +
                        "|_||_||_|\n" +
                        "|_||_||_|";
        String actual = RomanPrinter.print(3);
        assertEquals(expected, actual);
    }

    @Test
    void testPrintNumber4() {
        String expected =
                " _ \\   /\n" +
                        "|_| \\ /\n" +
                        "|_|  V";
        String actual = RomanPrinter.print(4);
        assertEquals(expected, actual);
    }

    @Test
    void testPrintNumber9() {
        // IX
        String expected =
                " _ \\ /\n" +
                        "|_|  X\n" +
                        "|_| / \\";
        String actual = RomanPrinter.print(9);
        assertEquals(expected, actual);
    }

    @Test
    void testPrintNumber50() {
        // L
        String expected =
                "|\n" +
                        "|_\n" +
                        "|";
        String actual = RomanPrinter.print(50);
        assertEquals(expected, actual);
    }

    @Test
    void testPrintNumber100() {
        // C
        String expected =
                " __\n" +
                        "/  \n" +
                        "|__";
        String actual = RomanPrinter.print(100);
        assertEquals(expected, actual);
    }

    @Test
    void testPrintNumber500() {
        // D
        String expected =
                " __ \n" +
                        "|  \\\n" +
                        "|__/";
        String actual = RomanPrinter.print(500);
        assertEquals(expected, actual);
    }

    @Test
    void testPrintNumber1000() {
        // M
        String expected =
                "__  __\n" +
                        "|  \\/  |\n" +
                        "|_/\\__|";
        String actual = RomanPrinter.print(1000);
        assertEquals(expected, actual);
    }
}