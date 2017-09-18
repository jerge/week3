package exercises;

import static java.lang.Math.abs;
import static java.lang.System.out;

/*
 * Finding point of inequality in "any" type of arrays
 *
 * See:
 * - Overloading
 */
public class Ex5PointOfInequality {

    public static void main(String[] args) {
        new Ex5PointOfInequality().program();
    }

    void program() {
        int[] a0 = {1, 2};
        int[] a1 = {1, 2, 3, 4, 5};
        int[] a2 = {1, 2, 33, 4, 5};
        double[] d1 = {1.0, 2, 33, 4.5, 6.7};
        double[] d2 = {1.0, 2, 33, 4.5, 6.711};
        String[] s1 = {"a", "b", "c", "d", "e"};
        String[] s2 = {"a", "bb", "c", "d", "e"};

        // All should print true

        out.println(diffIndex(a1, a2) == 2);  // First index from left where they differ
        out.println(diffIndex(a1, a1) == -1); // No diff
        out.println(diffIndex(a0, a1) == -1);
        out.println(diffIndex(d1, d2) == 4);
        out.println(diffIndex(s1, s2) == 1);
    }

    // ----------- Method(s) -----------------------

    int diffIndex(int[] array1, int[] array2) {
        int length = array1.length;
        if (array2.length < array1.length) {
            length = array2.length;
        }
        for (int i = 0; i < length; i++) {
            if (array1[i] != array2[i]) {
                return i;
            }
        }
        return -1;
    }

    int diffIndex(double[] array1, double[] array2) {
        int length = array1.length;
        if (array2.length < array1.length) {
            length = array2.length;
        }
        for (int i = 0; i < length; i++) {
            if (array1[i] != array2[i]) {
                return i;
            }
        }
        return -1;
    }

    int diffIndex(String[] array1, String[] array2) {
        int length = array1.length;
        if (array2.length < array1.length) {
            length = array2.length;
        }
        for (int i = 0; i < length; i++) {
            if (array1[i] != array2[i]) {
                return i;
            }
        }
        return -1;
    }



}
