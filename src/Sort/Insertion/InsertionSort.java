/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Sort.Insertion;

/**
 *
 * @author mihnea
 */
public class InsertionSort {

    public static void insertionSort(int[] A) {
        int i, j, key;

        // nonincreasing order
        for (i = 1; i < A.length; ++i) {
            key = A[i];
            j = i - 1;
            while (j >= 0 && A[j] < key) {
                A[j + 1] = A[j];
                --j;
            }
            A[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] A = {31, 41, 59, 26, 41, 58};

        insertionSort(A);

        for (int i = 0; i < A.length; ++i) {
            System.out.print(A[i] + " ");
        }
        System.out.println();
    }
}
