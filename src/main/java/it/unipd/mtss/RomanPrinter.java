package it.unipd.mtss;

////////////////////////////////////////////////////////////////////
// // Stefano Longhena 2111936
// // Alessandro Savio 2101046
// ////////////////////////////////////////////////////////////////////

public class RomanPrinter {
    public static String print(int num) {
        String roman = IntegerToRoman.convert(num);
        return printAsciiArt(roman);
    }

    private static String printAsciiArt(String romanNumber) {
        if (romanNumber == null || romanNumber.isEmpty()) {
            throw new IllegalArgumentException("Roman numeral cannot be null or empty");
        }

        StringBuilder result = new StringBuilder();
        String[] lines = new String[3]; // Each character is 3 lines tall

        // Initialize lines
        for (int i = 0; i < 3; i++) {
            lines[i] = "";
        }

        for (char c : romanNumber.toCharArray()) {
            String[] charArt = getAsciiArt(c);
            for (int i = 0; i < 3; i++) {
                lines[i] += charArt[i];
            }
        }

        // Join lines with newline separators
        result.append(String.join("\n", lines));
        return result.toString();
    }

    private static String[] getAsciiArt(char c) {
        switch (c) {
            case 'I':
                return new String[] { "  _ ", " |_|", " |_|" }; // 3-line "I"
            case 'V':
                return new String[] { "\\   /", " \\ / ", "  V  " };
            case 'X':
                return new String[] { "\\ / ", "  X ", " / \\ " };
            case 'L':
                return new String[] { "|   ", "|_  ", "|   " };
            case 'C':
                return new String[] { "  __ ", " /   ", "|__  " };
            case 'D':
                return new String[] { " __  ", "|  \\ ", "|__/ " };
            case 'M':
                return new String[] { "__  __", "|  \\/ |", "|_/\\__|" };
            default:
                throw new IllegalArgumentException("Invalid Roman numeral: " + c);
        }
    }
}