class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        // Start from the last digit and work backwards
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++; // If the current digit is less than 9, just increment it
                return digits; // Return the array as no carry is needed
            }
            digits[i] = 0; // Set the current digit to 0 if it was 9
        }

        // If we are here, it means we need an extra space for the 1
        int[] newDigits = new int[n + 1];
        newDigits[0] = 1; // Set the first digit to 1
        // Copy the remaining digits (which are all 0 now)
        return newDigits; // Return the new digits array
    }
}
