/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Sort.Merge;

/**
 *
 * @author mihnea
 */
public class MergeSort {

    public static void merge(int[] A, int p, int q, int r) {
        // merge subarrays A[p..q] and A[q+1..r] - index r is included!

        int n1, n2;
        n1 = q - p + 1;
        n2 = r - q;

        int[] L = new int[n1];
        int[] R = new int[n2];

        System.arraycopy(A, p, L, 0, n1);
        System.arraycopy(A, q + 1, R, 0, n2);

        int i = 0, j = 0, k = p;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j])
                A[k++] = L[i++];
            else
                A[k++] = R[j++];
        }

        while (i < n1)
            A[k++] = L[i++];

        while (j < n2)
            A[k++] = L[j++];

    }

    public static void mergeSort(int[] A, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(A, p, q);
            mergeSort(A, q + 1, r);
            merge(A, p, q, r);
        }
    }

    public static void main(String[] args) {
        //int[] A = {31, 41, 59, 26, -1, 15};
        int[] A = {5, 4, 3, 2, 1, 0, -1};

        mergeSort(A, 0, A.length - 1);

        for (int i = 0; i < A.length; ++i)
            System.out.printf("%d ", A[i]);
        System.out.println();
    }

}
