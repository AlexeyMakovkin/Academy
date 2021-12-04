package academy.kovalevskyi.codingbootcamp.week0.day3;

public class JavaEntryChallenge {

    public static void printHello() {
        System.out.println("Hello World");
    }

    public static int sumOfTwoNumbers(int a, int b) {
        return a + b;
    }

    public static int convertMinToSec(int minutes) {
        return minutes * 60;
    }

    public static void compareTwoNumbers(int a, int b) {
        if (a > b) {
            System.out.print("Result: a is bigger");
        } else {
            if (b > a) {
                System.out.print("Result: b is bigger");
            } else {
                System.out.print("Result: numbers are equal");
            }
        }
    }

    public static void concatTwoStrings(String lastName, String firstName) {
        System.out.print(lastName + " " + firstName);
    }

    public static int remainder(int a, int b) {
        return a % b;
    }

    public static boolean divisibleBy5(int num) {
        return num % 5 == 0;
    }

    public static int firstElementOfArray(int[] arr) {
        return arr[0];
    }

    public static int smallestElementOfArray(int[] arr) {
        var nums = arr;
        var min = nums[0];
        for (int num : nums) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    public static void checkResultOfWork(boolean quick, boolean efficient, boolean reliable) {
        if (quick && efficient && reliable) {
            System.out.print("Result of work: excellent, but you are dreaming");
        }
        if (!quick && efficient && reliable) {
            System.out.print("Result of work: good, but tired of waiting");
        }
        if (quick && efficient && !reliable) {
            System.out.print("Result of work: excellent, but pricey");
        }
        if (quick && !efficient && reliable) {
            System.out.print("Result of work: poor, but fast enough");
        }
        if (!quick && !efficient && reliable) {
            System.out.print("Pick at least two");
        }
    }
}
