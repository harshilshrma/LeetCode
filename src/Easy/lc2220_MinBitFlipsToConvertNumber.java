// 18-06-2024 - 07:14 pm
// 

package Easy;

public class lc2220_MinBitFlipsToConvertNumber {
    // Functions
    public int minBitFlips(int start, int goal) {
        int count = 0;
        int ans = start ^ goal;

        for (int i = 0; i <= 31; i++) {
            if ((ans & (1 << i)) != 0) count++;
        }

        return count;
    }


    // Main function for testing
    public static void main(String[] args) {
        lc2220_MinBitFlipsToConvertNumber obj = new lc2220_MinBitFlipsToConvertNumber();
        System.out.println(obj.minBitFlips(10, 7));
    }
}



