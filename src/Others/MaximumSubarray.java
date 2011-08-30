/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Others;






/**
 *
 * @author mihnea
 */

class Tuple {
    private int a, b, c;

    public Tuple() {
    }

    public Tuple(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }
    
    
}

public class MaximumSubarray {
    
    static Tuple findMaxCrossingSubArray(int[] A, int low, int mid, int high) {
        /* A is the array, low is the lowest index, mid is the mid index, high
         * is the highest valid index.
         */
        int lSum = Integer.MIN_VALUE, rSum = Integer.MIN_VALUE;
        int sum = 0;
        int lMax = mid, rMax = mid + 1;
        
        for (int i = mid; i >= low; --i) {
            sum += A[i];
            if (sum > lSum) {
                lSum = sum;
                lMax = i;
            }
        }
        
        sum = 0;
        
        for (int i = mid + 1; i <= high; ++i) {
            sum += A[i];
            if (sum > rSum) {
                rSum = sum;
                rMax = i;
            }
        }
        
        return new Tuple(lMax, rMax, lSum + rSum);
        
    }
    
    static Tuple findMaxSubArray(int[] A, int low, int high) {
        
        // base case
        if (low == high)
            return new Tuple(low, high, A[low]);
        
        // divide
        else {
            int mid = (high + low) / 2;
            Tuple left = findMaxSubArray(A, low, mid);
            Tuple right = findMaxSubArray(A, mid + 1, high);
            Tuple crossing = findMaxCrossingSubArray(A, low, mid, high);
            
            if (left.getC() >= right.getC() && left.getC() >= crossing.getC())
                return left;
            else if (right.getC() >= left.getC() && right.getC() >= crossing.getC())
                return right;
            else
                return crossing;
        }
        
    }

    public static void main(String[] args) {
        
        int[] A = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
        
        Tuple max = findMaxSubArray(A, 0, A.length - 1);
        System.out.println("Max subarray has sum: " + max.getC());
        System.out.print("Consisting of: ");
        
        for (int i = max.getA(); i <= max.getB(); ++i)
            System.out.print(A[i] + " ");
        System.out.println("");
    }
}
