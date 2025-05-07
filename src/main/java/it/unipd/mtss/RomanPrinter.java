package it.unipd.mtss;

////////////////////////////////////////////////////////////////////
// // Stefano Longhena 2111936
// // Alessandro Savio 2101046
// ////////////////////////////////////////////////////////////////////

public class RomanPrinter {
    public static String print(int num){
        if (num <= 0 || num > 1000) {
            throw new IllegalArgumentException("Number must be between 1 and 1000");
        }
        return printAsciiArt(IntegerToRoman.convert(num));
    }

    static String printAsciiArt(String romanNumber){
        if (romanNumber == null) {
            throw new IllegalArgumentException("Roman numeral cannot be null");
        }

        if (romanNumber.isEmpty()) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        String[] asciiLines = new String[6];

        for (int i = 0; i < asciiLines.length; i++) {
            asciiLines[i] = "";
        }

        for (char c : romanNumber.toCharArray()) {
            String[] characterArt = getAsciiArt(c);
            for (int i = 0; i < asciiLines.length; i++) {
                asciiLines[i] += characterArt[i];
            }
        }

        for (String line : asciiLines) {
            result.append(line).append("\n");
        }

        return result.toString();
    }

    private static String[] getAsciiArt(char romanChar) {
        switch (romanChar) {
            case 'I':
                return new String[] {
                        " _____ ",
                        "|_   _|",
                        "  | |  ",
                        "  | |  ",
                        " _| |_ ",
                        "|_____|"
                };
            case 'V':
                return new String[] {
                        "__      __",
                        "\\ \\    / /",
                        " \\ \\  / / ",
                        "  \\ \\/ /  ",
                        "   \\  /   ",
                        "    \\/    "
                };
            case 'X':
                return new String[] {
                        " __ __ ",
                        "|  \\/  |",
                        "| \\  / |",
                        "| |\\/| |",
                        "| |  | |",
                        "|_|  |_|"
                };
            case 'L':
                return new String[] {
                        " _      ",
                        "| |     ",
                        "| |     ",
                        "| |     ",
                        "| |____ ",
                        "|______|"
                };
            case 'C':
                return new String[] {
                        "  _____ ",
                        " / ____|",
                        "| |     ",
                        "| |     ",
                        "| |____ ",
                        " \\_____|"
                };
            case 'D':
                return new String[] {
                        " _____  ",
                        "|  __ \\ ",
                        "| |  | |",
                        "| |  | |",
                        "| |__| |",
                        "|_____/ "
                };
            case 'M':
                return new String[] {
                        " __  __ ",
                        "|  \\/  |",
                        "| \\  / |",
                        "| |\\/| |",
                        "| |  | |",
                        "|_|  |_|"
                };
            default:
                throw new IllegalArgumentException("Invalid Roman numeral character: " + romanChar);
        }
    }
}