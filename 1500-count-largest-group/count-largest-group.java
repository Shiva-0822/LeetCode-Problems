import java.util.*;

class Solution {
    public int countLargestGroup(int n) {
        Map<Integer, Integer> map = new HashMap<>();

        // Step 1 & 2: Group numbers by digit sum
        for (int i = 1; i <= n; i++) {
            int sum = digitSum(i);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        // Step 3: Find the max size among the groups
        int maxSize = 0;
        for (int size : map.values()) {
            maxSize = Math.max(maxSize, size);
        }

        // Step 4: Count how many groups have this max size
        int count = 0;
        for (int size : map.values()) {
            if (size == maxSize) {
                count++;
            }
        }

        return count;
    }

    // Helper method to calculate the sum of digits of a number
    private int digitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
