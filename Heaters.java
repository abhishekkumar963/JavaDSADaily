// 475. Heaters

import java.util.*;

public class Heaters {

    public static int findRadius(int[] houses, int[] heaters) {

        Arrays.sort(houses);
        Arrays.sort(heaters);

        int left = 0;
        int right = 1000000000;
        int firstTrueIndex = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (feasible(houses, heaters, mid)) {
                firstTrueIndex = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return firstTrueIndex;
    }

    private static boolean feasible(int[] houses, int[] heaters, int radius) {

        int houseIdx = 0;
        int heaterIdx = 0;

        while (houseIdx < houses.length) {

            if (heaterIdx >= heaters.length) {
                return false;
            }

            int minCoverage = heaters[heaterIdx] - radius;
            int maxCoverage = heaters[heaterIdx] + radius;

            if (houses[houseIdx] < minCoverage) {
                return false;
            }

            if (houses[houseIdx] > maxCoverage) {
                heaterIdx++;
            } else {
                houseIdx++;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of houses: ");
        int n = sc.nextInt();

        int[] houses = new int[n];

        System.out.println("Enter house positions:");
        for (int i = 0; i < n; i++) {
            houses[i] = sc.nextInt();
        }

        System.out.print("Enter number of heaters: ");
        int m = sc.nextInt();

        int[] heaters = new int[m];

        System.out.println("Enter heater positions:");
        for (int i = 0; i < m; i++) {
            heaters[i] = sc.nextInt();
        }

        int result = findRadius(houses, heaters);

        System.out.println("Minimum Required Radius: " + result);

        sc.close();
    }
}