package exercises;

import java.util.Arrays;
import java.util.Random;

import static java.lang.StrictMath.round;
import static java.lang.System.out;

/*
 * Implement generic versions of shuffle and sort
 *
 *  See:
 *  - WrapperTypes
 *  - GenericMethod
 */
public class Ex6GenericMethods {

    public static void main(String[] args) {
        new Ex6GenericMethods().program();
    }

    final Random rand = new Random();

    void program() {

        // Working with wrapper types, generic methods only work with reference type
        Integer[] is = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        String origIs = Arrays.toString(is);
        String[] ss = {"a", "b", "c", "d", "e"};
        String origSS = Arrays.toString(ss);

        // diffIndex works for all arrays reference types
        out.println(diffIndex(is, is) == -1);
        out.println(diffIndex(ss, ss) == -1);

        // shuffle should be a generic method, so we can use it for Integers ...
        shuffle(is);
        out.println(!Arrays.toString(is).equals(origIs));  // May be false, but unlikely
        // ... and here for String.
        shuffle(ss);
        out.println(!Arrays.toString(ss).equals(origSS));

        // sort should also be generic
        sort(is);
        out.println(Arrays.toString(is).equals(origIs));
        sort(ss);
        out.println(Arrays.toString(ss).equals(origSS));

    }

    // ------- Methods -------------------------


    <T extends Comparable<? super T> > void sort(T[] array) {
        T bubble;
        for (int j = array.length-1; j > 0; j--) {
            for (int i = 0; i < j; i++) {
                if (array[i].compareTo(array[i+1]) > 0) {
                    bubble = array[i];
                    array[i] = array[i+1];
                    array[i+1] = bubble;
                }
            }
        }
    }

    <T> int diffIndex(T[] array1, T[] array2) {
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

    <T> void shuffle(T[] arr) {
        int index;
        T a;
        for (int i = 0; i < arr.length;i++) {
            index = rand.nextInt(arr.length);
            a = arr[i];
            arr[i] = arr[index];
            arr[index] = a;
        }
    }

}
