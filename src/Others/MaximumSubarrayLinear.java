/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Others;

/**
 *
 * @author mihnea
 */
public class MaximumSubarrayLinear {
    public static void main(String[] args) {
        int[] A = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
        int start, end, i, max_ending_here, max_so_far;
        start = end = max_ending_here = max_so_far = 0;
        
        for (i = 0; i < A.length; ++i) {
            if (max_ending_here + A[i] > 0) {
                max_ending_here += A[i];
            }
            else {
                max_ending_here = 0;
                start = i + 1;
            }
            if (max_ending_here > max_so_far) {
                end = i;
                max_so_far = max_ending_here;
            }
            
        }
        System.out.println("Max subarray has sum: " + max_so_far);
        System.out.print("Consisting of: ");
        
        for (i = start; i <= end; ++i)
            System.out.print(A[i] + " ");
        System.out.println("");
    }
}
