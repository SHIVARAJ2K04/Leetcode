public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length; // Base case

        int k = 2; // Initialize the position to start filling valid elements

        for (int i = 2; i < nums.length; i++) {
            // Check if the current number is not a duplicate (more than twice)
            if (nums[i] != nums[k - 2]) {
                nums[k] = nums[i]; // Place the valid number at position k
                k++; // Move the position forward
            }
        }

        return k; // Return the new length of the modified array
    }
}
