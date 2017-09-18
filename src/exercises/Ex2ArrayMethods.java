package exercises;

import java.util.Arrays;

import static java.lang.System.*;
import static java.util.Arrays.sort;

/*
 *  Some harder array methods
 */
public class Ex2ArrayMethods {


    public static void main(String[] args) {
        new Ex2ArrayMethods().program();
    }

    void program() {
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8};

//        out.println(Arrays.toString(rotate(arr1,3)));

        // Rotate all elements in arr k steps to the right (in a circular fashion)
        // Assume arr.length > 0. NOTE: Original array changed!
        rotate(arr1, 3);
        out.println(Arrays.toString(arr1).equals("[6, 7, 8, 1, 2, 3, 4, 5]"));
        rotate(arr1, 0);
        out.println(Arrays.toString(arr1).equals("[6, 7, 8, 1, 2, 3, 4, 5]"));
        rotate(arr1, arr1.length);
        out.println(Arrays.toString(arr1).equals("[6, 7, 8, 1, 2, 3, 4, 5]"));
        rotate(new int[]{1}, 3);

        int[] result = rotate(arr1, 2);  // INFO: Not possible, no return value

        int[] r = rotate(new int[]{1, 2, 3, 4, 5}, 2);  // Return value!
        out.println(Arrays.toString(r).equals("[4, 5, 1, 2, 3]"));
        r = rotate(new int[]{1, 2, 3, 4, 5}, 5);  // Return value!
        out.println(Arrays.toString(r).equals("[1, 2, 3, 4, 5]"));


        int[] arr2 = {1, 2, 2, 3, 3};   // All sorted in increasing order
        int[] arr3 = {1, 2, 3, 4, 5};
        int[] arr4 = {1, 1, 1, 1, 1, 1};
        int[] arr5 = {1};

        // Remove all duplicates from arr2, ... (original unchanged, copy created)
        // NOTE: Assume arr is sorted in increasing order and > 0

        out.println(Arrays.toString(removeDupl(arr2)).equals("[1, 2, 3]"));
        out.println(Arrays.toString(arr2).equals("[1, 2, 2, 3, 3]"));   // arr2 unchanged!
        out.println(Arrays.toString(removeDupl(arr3)).equals("[1, 2, 3, 4, 5]"));
        out.println(Arrays.toString(removeDupl(arr4)).equals("[1]"));
        out.println(Arrays.toString(removeDupl(arr5)).equals("[1]"));

        arr1 = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        // Use fact that array is sorted to search efficiently
        out.println(search(arr1, 1) == 0);
        out.println(search(arr1, 3) == 2);
        out.println(search(arr1, 8) == 7);

    }

    // -------------- Methods --------------------------

    private int[] rotate(int[] array, int times) {
        if (times % array.length == 0) {
            return array;
        }

        int[] temp = new int[times % array.length];
        int offsetEnd = (array.length - times) % array.length;

        for (int i = offsetEnd; i < array.length; i++) {
            temp[i-offsetEnd] = array[i];
        }
        for (int i = offsetEnd-1; i >= 0; i--) {
            array[i + times] = array[i];
        }
        for (int i = 0; i < temp.length; i++) {
            array[i] = temp[i];
        }
        return array;
    }

    private int[] removeDupl(int[] array) {
        sort(array);
        int uniques = 1; // Last one will always be added, to avoid ArrayOutOfBounds

        for (int i = 0; i < array.length-1; i++) {
            if (array[i] != array[i+1]) {
                uniques ++;
            }
        }

        int[] uniqueArray = new int[uniques];
        int index = 0;

        uniqueArray[uniqueArray.length-1] = array[array.length-1];
        for (int i = 0; i < array.length-1; i++) {
            if (array[i] != array[i+1]) {
                uniqueArray[index] = array[i];
                index++;
            }
        }
        return uniqueArray;
    }

    private int search(int[] array, int key) {
        sort(array);
        int keyIndex = -1;
        int start = 0;
        int end = array.length-1;
        int middle = (end+start)/2;
        while (keyIndex < 0 && start <= end) {
            if (key == array[middle]) {
                keyIndex = middle;
            } else if (key > array[middle]) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
            middle = (end+start)/2;
        }
        return keyIndex;
    }

}

