package academy.kovalevskyi.codingbootcamp.week2.day1;

public class TextPrinter {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println(
                    "Please provide only one input argument, current amount: " + args.length);
            return;
        }
        int width = args[0].length() + 4;
        int height = 3;
        char [][]symbol = new char[height][width];
        String str = args[0];
        setText(symbol, str);
        char angle1 = '/';
        char angle2 = '\\';
        char side = '#';
        BoxGenerator.fillArray(symbol, ' ');
        BoxGenerator.makeAngle(symbol, angle1, angle2);
        BoxGenerator.makeSide(symbol, side);
        setText(symbol, str);
        arrayPrinter(symbol);

    }

    public static void setText(char [][] symbol, String str) {
        for (int i = 0; i < str.length(); i++) {
            symbol[1][i + 2] = str.charAt(i);
        }
    }

    public static void arrayPrinter(char [][] symbol) {
        for (int i = 0; i < symbol.length; i++) {
            for (int j = 0; j < symbol[i].length; j++) {
                System.out.print(symbol[i][j]);
            }
            System.out.println();
        }
    }
}
