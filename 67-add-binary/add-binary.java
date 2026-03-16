public class Solution {

    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int lenA = a.length(), lenB = b.length();

        int i = lenA - 1, j = lenB - 1;

        // Process the strings from the end
        while (i >= 0 || j >= 0 || carry > 0) {
            int bitA = (i >= 0) ? a.charAt(i--) - '0' : 0; // Convert char to int
            int bitB = (j >= 0) ? b.charAt(j--) - '0' : 0; // Convert char to int

            // Calculate the sum
            int sum = bitA + bitB + carry;
            carry = sum / 2; // Update carry
            result.append(sum % 2); // Append the resulting bit
        }

        // Since we built the result backwards, reverse it
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        // Test the addBinary function
        Solution solution = new Solution();
        String a = "1010";
        String b = "1011";
        String result = solution.addBinary(a, b);
        System.out.println("Output: " + result); // Expected: "10101"
    }
}
