class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x >= 0 && x < 10) return true;

        int original = x;
        int rev = 0;
        while (x != 0) {
            int digit = x % 10;
            x /= 10;
            if (rev > (Integer.MAX_VALUE - digit) / 10) return false; // overflow check
            rev = rev * 10 + digit;
        }
        return rev == original;
    }
}
