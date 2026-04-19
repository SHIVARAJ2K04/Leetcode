double findMedianSortedArrays(int* nums1, int nums1Size, int* nums2, int nums2Size){
    // Ensure nums1 is the smaller array
    if (nums1Size > nums2Size) return findMedianSortedArrays(nums2, nums2Size, nums1, nums1Size);

    int m = nums1Size, n = nums2Size;
    int imin = 0, imax = m;
    while (imin <= imax) {
        int i = (imin + imax) / 2;
        int j = (m + n + 1) / 2 - i;

        int nums1_left_max  = (i == 0) ? -2147483648 : nums1[i-1];
        int nums1_right_min = (i == m) ? 2147483647  : nums1[i];
        int nums2_left_max  = (j == 0) ? -2147483648 : nums2[j-1];
        int nums2_right_min = (j == n) ? 2147483647  : nums2[j];

        if (nums1_left_max <= nums2_right_min && nums2_left_max <= nums1_right_min) {
            // Found correct partition
            int left_max = (nums1_left_max > nums2_left_max) ? nums1_left_max : nums2_left_max;
            if ((m + n) % 2 == 1) {
                return (double)left_max;
            } else {
                int right_min = (nums1_right_min < nums2_right_min) ? nums1_right_min : nums2_right_min;
                return ((double)left_max + (double)right_min) / 2.0;
            }
        } else if (nums1_left_max > nums2_right_min) {
            imax = i - 1;
        } else {
            imin = i + 1;
        }
    }

    // Fallback (should not reach)
    return 0.0;
}
