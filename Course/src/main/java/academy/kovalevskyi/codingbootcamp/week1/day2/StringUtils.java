package academy.kovalevskyi.codingbootcamp.week1.day2;

public class StringUtils {

    public static boolean myMethod(char ch) {
        if (ch < 0 || ch > 255) {
            return true;
        }
        return false;
    }

    public static boolean isAsciiUppercase(char ch) {
        if (myMethod(ch)) {
            throw new IllegalArgumentException();
        }
        if (ch >= 'A' && ch <= 'Z') {
            return true;
        }
        return  false;

    }

    public static boolean isAsciiLowercase(char ch) {
        if (myMethod(ch)) {
            throw new IllegalArgumentException();
        }
        if (ch >= 'a' && ch <= 'z') {
            return true;
        }
        return  false;
    }

    public static boolean isAsciiNumeric(char ch) {
        if (myMethod(ch)) {
            throw new IllegalArgumentException();
        }
        if (ch >= '0' && ch <= '9') {
            return true;
        }

        return  false;
    }

    public static boolean isAsciiAlphabetic(char ch) {
        if (myMethod(ch)) {
            throw new IllegalArgumentException();
        }
        if (ch >= 'A' && ch <= 'Z' || ch >= 'a' && ch <= 'z') {
            return true;
        }
        return false;
    }

    public static char toAsciiUppercase(char ch) {
        if (myMethod(ch)) {
            throw new IllegalArgumentException();
        } else {
            if (isAsciiLowercase(ch)) {
                ch = (char) (ch - 32);
            }
        }
        return  ch;
    }

    public static char toAsciiLowercase(char ch) {
        if (ch >= 0 && ch <= 255) {
            if (isAsciiUppercase(ch)) {
                ch = (char) (ch + 32);
            }
        } else {
            throw new IllegalArgumentException();
        }
        return  ch;
    }

    public static StringBuilder makeUppercase(char[] input) {
        char res = ' ';
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < input.length; i++) {
            str.append(toAsciiUppercase(input[i]));
        }
        return str;
    }



    public static StringBuilder makeLowercase(char[] input) {
        char res = ' ';
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < input.length; i++) {
            str.append(toAsciiLowercase(input[i]));
        }
        return str;
    }

    public static StringBuilder makeCamel(char[] input) {
        StringBuilder str = new StringBuilder();
        char ch = ' ';
        for (int i = 0; i < input.length; i++) {

            if (input[i] < 0 || input[i] > 255) {
                throw new IllegalArgumentException(input[i] + ": Symbol is not ASCII");
            }
            if (i == 0) {
                if (input[i] >= 'a' && input[i] <= 'z' || input[i] >= 32 && input[i] <= 64
                        || input[i] >= 97 && input[i] <= 127) {
                    ch = input[i];
                }
                if (input[i] >= 'A' && input[i] <= 'Z') {
                    ch = (char) (input[i] + 32);
                }
                str.append(ch);
            }
            if (i != 0) {
                if (i % 2 != 0) {
                    if (input[i] >= 'A' && input[i] <= 'Z' || input[i] >= 32 && input[i] <= 64
                            || input[i] >= 97 && input[i] <= 127) {
                        ch = input[i];
                    }
                    if (input[i] >= 'a' && input[i] <= 'z') {
                        ch = (char) (input[i] - 32);
                    }
                    str.append(ch);
                } else {
                    if (input[i] >= 'a' && input[i] <= 'z' || input[i] >= 32 && input[i] <= 64
                            || input[i] >= 97 && input[i] <= 127) {
                        ch = input[i];
                    }
                    if (input[i] >= 'A' && input[i] <= 'Z') {
                        ch = (char) (input[i] + 32);
                    }
                    str.append(ch);
                }
            }
        }
        return str;
    }

    public static boolean isStringAlphaNumerical(char[] input) {

        int count = input.length;
        for (int i = 0; i < input.length; i++) {
            if (isAsciiAlphabetic(input[i]) || isAsciiNumeric(input[i]) || input[i] == ' ') {
                count--;
            }
        }
        if (count == 0) {
            return true;
        }
        return false;
    }

    public static char[] concatStrings(char[][] input) {
        char[] res = new char[0];
        String tmp = "";
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                res = new char[input.length * input[j].length];
                if (input[i][j] < 0 || input[i][j] > 255) {
                    throw new IllegalArgumentException();
                }
                tmp += input[i][j];
            }
        }
        for (int k = 0; k < tmp.length(); k++) {
            res[k] = tmp.charAt(k);
        }
        return  res;
    }

    public static int toInt(char[] input) {
        if (input.length == 0) {
            throw new IllegalArgumentException();
        }
        boolean negative = false;
        if (input[0] == '-') {
            input[0] = '0';
            negative = true;
        }
        int ch = 0;
        for (int i = 0; i < input.length; i++) {
            if (isAsciiNumeric(input[i])) {
                ch = ch * 10 + Character.digit(input[i], 10);
            } else {
                throw new NumberFormatException();
            }
        }
        return negative ? - ch : ch;
    }
}
