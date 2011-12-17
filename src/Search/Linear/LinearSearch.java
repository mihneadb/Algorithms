/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Search.Linear;

/**
 *
 * @author mihnea
 */
public class LinearSearch {
    public static void main(String[] args) {
        int[] A = {31, 41, 59, 26, 41, 58};
        int v = 26;
        int i;

        for (i = 0; (i < A.length) && (A[i] != v); ++i);

        if (i == A.length)
            System.out.println("Not found.");
        else
            System.out.printf("Found at index %d.\n", i);
    }
}
