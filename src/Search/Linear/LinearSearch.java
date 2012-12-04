/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Search.Linear;

/**
 *
 * @author sarbull
 */
public class LinearSearch {
    public static void main(String[] args) {
        int[] A = {31, 41, 59, 26, 41, 58};
        int v = 26;
        int i;

        int length = A.length;

        //If A was a vector of 1.000.000.000 elements, for each i in the for syntax, 
        //java will calculate the length of 1.000.000.000 for 1.000.000.000 times.

        for (i = 0; (i < length) && (A[i] != v); ++i);

        if (i == length)
            System.out.println("Not found.");
        else
            System.out.printf("Found at index %d.\n", i);
    }
}
