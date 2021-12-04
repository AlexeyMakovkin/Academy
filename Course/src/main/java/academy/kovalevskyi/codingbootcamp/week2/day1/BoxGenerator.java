package academy.kovalevskyi.codingbootcamp.week2.day1;

public class BoxGenerator {

    public static void main(String[] args) {

        if (args.length != 4) {
            System.out.println("Please provide 4 input arguments, current amount: " + args.length);
            return;
        }
        if (Integer.parseInt(args[0]) < 0
                || Integer.parseInt(args[1]) < 0
                || args[2].length() > 1
                || args[3].length() > 1
                || args[0] == null
                || args[1] == null) {
            throw new IllegalArgumentException();
        }
        if (Integer.parseInt(args[0]) == 0 || Integer.parseInt(args[1]) == 0) {
            return;
        }

        char ch = args[3].charAt(0);
        char angle = ch;
        char side = args[2].charAt(0);
        int width = Integer.parseInt(args[0]);
        int height = Integer.parseInt(args[1]);

        char[][] symbol = new char[height][width];
        fillArray(symbol, ' ');
        makeAngle(symbol, angle);
        makeSide(symbol, side);
        TextPrinter.arrayPrinter(symbol);
    }

    public static void makeAngle(char[][] symbol, char angle1, char angle2) {
        int width = symbol[0].length;
        int height = symbol.length;
        symbol[0][0] = angle1;
        symbol[0][width - 1] = angle2;
        symbol[height - 1][0] = angle2;
        symbol[height - 1][width - 1] = angle1;
    }

    public static void makeAngle(char[][] symbol, char angle) {
        makeAngle(symbol, angle, angle);
    }

    public static void makeSide(char [][] symbol, char side) {
        int width = symbol[0].length;
        int height = symbol.length;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (i == 0 || i == height - 1) {
                    if (j != 0 && j != width - 1) {
                        symbol[i][j] = side;
                    }
                } else {
                    if (j == 0 || j == width - 1) {
                        symbol[i][j] = side;
                    }
                }
            }
        }
    }

    public static void fillArray(char[][] symbol, char space) {
        for (int i = 0; i < symbol.length; i++) {
            for (int j = 0; j < symbol[i].length; j++) {
                symbol[i][j] = space;
            }
        }
    }
}
