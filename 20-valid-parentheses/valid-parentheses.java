import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        // Mapping of closing brackets to their corresponding opening brackets
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        for (char c : s.toCharArray()) {
            // If it's a closing bracket
            if (map.containsKey(c)) {
                char topElement = stack.isEmpty() ? '#' : stack.pop(); // Use dummy character if stack is empty
                if (topElement != map.get(c)) {
                    return false; // Invalid if top element doesn't match
                }
            } else {
                // It's an opening bracket, push it onto the stack
                stack.push(c);
            }
        }

        return stack.isEmpty(); // Valid if stack is empty
    }
}
