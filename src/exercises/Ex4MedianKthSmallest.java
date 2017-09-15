package exercises;

import java.util.Arrays;

import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.lang.System.*;

/**
 *  Even more array methods, possibly harder ...
 *
 *
 */
public class Ex4MedianKthSmallest {

    public static void main(String[] args) {
        new Ex4MedianKthSmallest().program();
    }

    void program() {
        int[] arr1 = {9, 3, 0, 1, 3, -2};

        out.println(!isSorted(arr1));  // Is sorted increasing? No not yet!

        sort(arr1);     // Sort in increasing order original order lost!

        out.println(Arrays.toString(arr1).equals("[-2, 0, 1, 3, 3, 9]"));

        out.println(isSorted(arr1));  // Is sorted increasing? Yes!

        int[] arr2 = {5, 4, 2, 1, 7, 0, -1, -4, 12};
        int[] arr3 = {2, 3, 0, 1};
        out.println(median(arr2) == 2);    // Calculate median of elements
        out.println(median(arr3) == 1.5);

        int[] arr4 = {2, 3, 0, 1, 5, 4};
        int[] arr5 = {5, 4, 2, 2, 1, 7, 4, 0, -1, -4, 0, 0, 12};
        out.println(kSmallest(arr4, 2) == 1);   // Second smallest is 1
        out.println(kSmallest(arr5, 5) == 2);   // 5th smallest is 2

    }

    // ---------- Write methods here --------------

    private boolean isSorted(int[] array) { return array == sort(array); }

    private int[] sort(int[] array) {
        int bubble;
        for (int j = array.length-1; j > 0; j--) {
            for (int i = 0; i < j; i++) {
                if (array[i] > array[i+1]) {
                    bubble = array[i];
                    array[i] = array[i+1];
                    array[i+1] = bubble;
                }
            }
        }
        return array;
    }

    private double median(int[] array) {
        sort(array);
        if ((array.length) % 2 == 0) {
            return (double)(array[(array.length-1)/2] + array[array.length/2])/2;
        }
        return array[array.length/2];
    }



    private int kSmallest(int[] array, int k){
        sort(array);
//        removeDupl();
        return array[k-1];
    }



}
