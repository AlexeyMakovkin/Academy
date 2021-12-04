package academy.kovalevskyi.codingbootcamp.week2.day2;

public class ProgressBar {

    public static void updateProgress(int percent, int quantity, int count,
                                      int seconds, long minutes, long hour) {
        final int width = 100;
        System.out.print("\r" + percent + " %" + " [");
        int i = 0;
        for (; i <= percent; i++) {
            System.out.print("=");
        }
        System.out.print(">");

        for (; i <= width; i++) {
            System.out.print(" ");
        }
        System.out.print("] " + count + "/" + quantity + ", ETA: "
                +  String.format("%02d:%02d:%02d", hour, minutes, seconds));
    }

    public static int timeLeft(int percent) {
        int time = (100 - percent);
        return time;
    }
}
