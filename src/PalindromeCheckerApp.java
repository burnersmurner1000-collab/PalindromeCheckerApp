import java.util.*;

public class PalindromeCheckerApp {
    interface PalindromeStrategy {
        boolean check(String input);
    }

    static class StackStrategy implements PalindromeStrategy {
        public boolean check(String input) {
            Stack<Character> stack = new Stack<>();
            for (char c : input.toCharArray()) {
                stack.push(Character.toLowerCase(c));
            }
            for (char c : input.toCharArray()) {
                if (Character.toLowerCase(c) != stack.pop()) {
                    return false;
                }
            }
            return true;
        }
    }

    static class DequeStrategy implements PalindromeStrategy {
        public boolean check(String input) {
            Deque<Character> deque = new ArrayDeque<>();
            for (char c : input.toCharArray()) {
                deque.addLast(Character.toLowerCase(c));
            }
            while (deque.size() > 1) {
                if (deque.removeFirst() != deque.removeLast()) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        String input = "Level";
        System.out.println("Input: " + input);
        PalindromeStrategy stackStrategy = new StackStrategy();
        boolean stackResult = stackStrategy.check(input);
        System.out.println("StackStrategy - Is Palindrome? : " + stackResult);
        PalindromeStrategy dequeStrategy = new DequeStrategy();
        boolean dequeResult = dequeStrategy.check(input);
        System.out.println("DequeStrategy - Is Palindrome? : " + dequeResult);
    }
}