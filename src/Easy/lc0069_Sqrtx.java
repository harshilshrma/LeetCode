package Easy;

public class lc0069_Sqrtx {
    public int mySqrt(int x) {
        long low = 1, high = x, ans = 1;

        while (low <= high) {
            long mid = (low + high) / 2;

            if (mid  * mid <= x) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return (int)ans;
    }

    // Main function for testing
    public static void main(String[] args) {
        lc0069_Sqrtx obj = new lc0069_Sqrtx();
        System.out.println(obj.mySqrt(2147395599));
    }
}
