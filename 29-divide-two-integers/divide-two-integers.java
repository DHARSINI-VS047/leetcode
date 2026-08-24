class Solution {
    public int divide(int dividend, int divisor) {

        // Special overflow case
        if (dividend == Integer.MIN_VALUE &&
            divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine the sign of the answer
        boolean negative = (dividend < 0) ^ (divisor < 0);

        // Convert to long to avoid overflow
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);

        long quotient = 0;

        // Find the quotient using bit shifting
        while (a >= b) {

            long temp = b;
            long multiple = 1;

            // Double the divisor
            while ((temp << 1) <= a) {
                temp <<= 1;
                multiple <<= 1;
            }

            // Subtract the largest possible multiple
            a -= temp;
            quotient += multiple;
        }

        // Apply the sign
        if (negative) {
            quotient = -quotient;
        }

        // Handle 32-bit limits
        if (quotient > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        if (quotient < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return (int) quotient;
    }
}