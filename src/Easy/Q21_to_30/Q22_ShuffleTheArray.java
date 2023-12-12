// Date: 25 March 2023
// Q22: Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].
// Return the array in the form [x1,y1,x2,y2,...,xn,yn].


package Easy.Q21_to_30;
public class Q22_ShuffleTheArray {
    public int[] shuffle(int[] nums, int n) {
        int[] abc = new int[nums.length];
        int[] a1 = new int[nums.length];
        int[] a2 = new int[nums.length];
        int a=0, b=0;

        for (int i=0; i<n; i++) a1[i] = nums[i];
        for (int i=0; i<n; i++) a2[i] = nums[n+i];

        for (int i=0; i<nums.length; i++){
            if (i%2==0){
                abc[i] = a1[a];
                a=a+1;
            }
            else{
                abc[i] = a2[b];
                b=b+1;
            }
        }
        return abc;
    }
}

