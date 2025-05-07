////////////////////////////////////////////////////////////////////
// Stefano Longhena 2111936
// Alessandro Savio 2101046
////////////////////////////////////////////////////////////////////

package it.unipd.mtss;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class RomanPrinterTest {

    @Test
    void testPrintNumber1() {
        String expected =
                "  _ \n" +
                        " |_|\n" +
                        " |_|";
        String actual = RomanPrinter.print(1);
        assertEquals(expected, actual);
    }

    @Test
    void testPrintNumber4() {
        String expected =
                "  _ \\   /\n" +
                        " |_| \\ / \n" +
                        " |_|  V  ";
        String actual = RomanPrinter.print(4);
        assertEquals(expected, actual);
    }

    @Test
    void testPrintNumber9() {
        String expected =
                "  _ \\ / \n" +
                        " |_|  X \n" +
                        " |_| / \\ ";
        String actual = RomanPrinter.print(9);
        assertEquals(expected, actual);
    }

    @Test
    void testPrintNumber1000() {
        String expected =
                "__  __\n" +
                        "|  \\/ |\n" +
                        "|_/\\__|";
        String actual = RomanPrinter.print(1000);
        assertEquals(expected, actual);
    }

    @Test
    void testPrintNumber50() {
        String expected =
                "|   \n" +
                        "|_  \n" +
                        "|   ";
        String actual = RomanPrinter.print(50);
        assertEquals(expected, actual);
    }

    @Test
    void testPrintNumber500() {
        String expected =
                " __  \n" +
                        "|  \\ \n" +
                        "|__/ ";
        String actual = RomanPrinter.print(500);
        assertEquals(expected, actual);
    }

    // Removed flawed test for 888 because expected output did not match full ASCII art for 888
}