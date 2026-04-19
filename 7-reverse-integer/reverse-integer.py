class Solution:
    def reverse(self, x: int) -> int:
        INT_MIN, INT_MAX = -2**31, 2**31 - 1
        sign = -1 if x < 0 else 1
        x_abs = -x if x < 0 else x

        rev = 0
        while x_abs:
            digit = x_abs % 10
            x_abs //= 10
            # Check overflow before multiplying by 10 (no 64-bit assumed)
            if rev > INT_MAX // 10 or (rev == INT_MAX // 10 and digit > INT_MAX % 10):
                return 0
            rev = rev * 10 + digit

        rev *= sign
        if rev < INT_MIN or rev > INT_MAX:
            return 0
        return rev
