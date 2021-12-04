package academy.kovalevskyi.codingbootcamp.week1.day0;

public class NumbersUtils {

    public static long getFactorial(final int number) throws IllegalArgumentException {
        if (number < 0 || number > 21) {
            throw new IllegalArgumentException();
        } else {
            long fact = 1;
            for (int i = 1; i <= number; i++) {
                fact = fact * i;
            }
            return fact;
        }
    }

    public static long factorialRecursive(int number) throws IllegalArgumentException {
        if (number < 0 || number > 21) {
            throw new IllegalArgumentException();
        } else if (number > 0) {
            return number * factorialRecursive(number - 1);
        } else {
            return 1;
        }
    }

    public static double power(int base, int power) throws IllegalArgumentException {
        double res = 1;
        if (power == 0) {
            return 1.0;
        } else if (power > 0) {
            for (int i = 0; i < power; i++) {
                res *= base;
            }
            return res;
        }
        return 1 / power(base, power * -1);
    }

    public static double powerRecursive(int base, int power) throws IllegalArgumentException {
        if (power == 0) {
            return 1.0;
        } else if (power > 0) {
            return base * powerRecursive(base, power - 1);
        } else {
            return (1 / base) * powerRecursive(base, power + 1);
        }
    }

    public static int fibRecursive(int index) throws IllegalArgumentException {
        if (index < 0) {
            throw new IllegalArgumentException();
        } else if (index < 2) {
            return index;
        } else {
            return fibRecursive(index - 1) + fibRecursive(index - 2);
        }
    }

    public static int[] fibSequence(int length) throws IllegalArgumentException {
        if (length < 0) {
            throw new IllegalArgumentException();
        } else {
            int[] array = new int[length];
            for (int i = array.length; i > 0; i--) {
                array[i - 1] = fibRecursive(i);
            }
            return array;
        }
    }

    public static int sqrt(int target) throws IllegalArgumentException {
        if (target < 0) {
            throw new IllegalArgumentException();
        }
        int temp = 0;
        while (temp * temp < target) {
            temp++;
        }
        if (temp * temp == target) {
            return temp;
        }
        return -1;
    }

    public static boolean isPrime(int target) throws IllegalArgumentException {
        if (target < 0) {
            throw new IllegalArgumentException();
        }
        if (target == 0 || target == 1) {
            return false;
        }
        int divide = 2;
        while (divide < target) {
            if (target % divide == 0) {
                return false;
            }
            divide++;
        }
        return true;
    }

    public static int findNextPrime(int target) throws IllegalArgumentException {
        if (target < 0) {
            throw new IllegalArgumentException();
        } else {
            int i = target;
            while (!isPrime(i)) {
                i++;
            }
            return i;
        }
    }

    public static void sort(int[] target) {
        if (target == null) {
            return;
        }
        int temp;
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < target.length - 1; i++) {
                if (target[i] > target[i + 1]) {
                    isSorted = false;
                    temp = target[i];
                    target[i] = target[i + 1];
                    target[i + 1] = temp;
                }
            }
        }
    }
}
