import java.util.*;

public class SmallestDivisibleDigitProductI {

    public static int smallestNumber(int n, int t) {
        for (int currentNumber = n; ; currentNumber++) {
            int digitProduct = 1;
            int tempNumber = currentNumber;

            while (tempNumber > 0) {
                int lastDigit = tempNumber % 10;
                digitProduct *= lastDigit;
                tempNumber /= 10;
            }

            if (digitProduct % t == 0) {
                return currentNumber;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = sc.nextInt();

        System.out.print("Enter t: ");
        int t = sc.nextInt();

        int result = smallestNumber(n, t);

        System.out.println("Smallest Number: " + result);

        sc.close();
    }
}