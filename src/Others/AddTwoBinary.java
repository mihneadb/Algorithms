/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Others;

/**
 *
 * @author mihnea
 */
public class AddTwoBinary {

    public static int[] addBinary(int[] A, int[] B) {
        int[] C = new int[A.length + 1];

        int tr = 0; //transport
        int s;
        for (int i = A.length - 1; i >= 0; --i) {
            s = A[i] + B[i] + tr;

            if (s >= 2)
                tr = 1;
            else
                tr = 0;

            C[i + 1] = s % 2;
        }

        if (tr == 0)
            C[0] = 0;
        else
            C[0] = 1;

        return C;
    }

    public static void main(String[] args) {
        int[] A = {0, 0, 1};
        int[] B = {0, 1, 1};
        
        int[] C = addBinary(A, B);

        for (int i = 0; i < C.length; ++i)
            System.out.printf("%d ", C[i]);
        System.out.println();
    }
}
