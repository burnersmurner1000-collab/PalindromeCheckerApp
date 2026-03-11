public class PalindromeCheckerApp {
    public static boolean isPalindromeReverse(String input) {
        String reversed = new StringBuilder(input).reverse().toString();
        return input.equalsIgnoreCase(reversed);
    }

    public static boolean isPalindromeTwoPointer(String input) {
        int left = 0;
        int right = input.length() - 1;
        while (left < right) {
            if (Character.toLowerCase(input.charAt(left)) != Character.toLowerCase(input.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static long measureExecutionTime(Runnable task) {
        long start = System.nanoTime();
        task.run();
        long end = System.nanoTime();
        return end - start;
    }

    public static void main(String[] args) {
        String input = "LeveL";
        System.out.println("Input: " + input);

        long reverseTime = measureExecutionTime(() -> {
            boolean result = isPalindromeReverse(input);
            System.out.println("Reverse Method - Is Palindrome? " + result);
        });
        System.out.println("Execution Time (Reverse): " + reverseTime + " ns");

        long twoPointerTime = measureExecutionTime(() -> {
            boolean result = isPalindromeTwoPointer(input);
            System.out.println("Two-Pointer Method - Is Palindrome? " + result);
        });
        System.out.println("Execution Time (Two-Pointer): " + twoPointerTime + " ns");

        System.out.println("\nPerformance Comparison:");
        if (reverseTime < twoPointerTime) {
            System.out.println("Reverse method is faster.");
        } else if (twoPointerTime < reverseTime) {
            System.out.println("Two-pointer method is faster.");
        } else {
            System.out.println("Both methods performed equally.");
        }
    }
}