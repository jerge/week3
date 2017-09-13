package exercises;

import static java.lang.System.out;

/*
 *  Some puzzlers
 *
 *  See:
 *  - LoopPuzzler
 */
public class Ex1LoopPuzzlers {

    public static void main(String[] args) {
        new Ex1LoopPuzzlers().program();
    }


    void program() {
        // Write solution (for loops) directly here

        // Multiplication table
        int[][] arr = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                arr[i][j] = (i+1)*(j+1);
                out.print(arr[i][j] + " ");
                int spaces = 3-(int)(Math.log10(arr[i][j])+1);
                for (int k = 0; k < spaces; k++) {
                    out.print(" ");
                }
            }
            out.println();
        }
        // Plot a half square
        int stop = 100;
        for (int i = 0; i < stop; i++) {
            for (int j = 0; j < i; j++) {
                out.print("X");
            }
            out.println();
        }
        // Plot a rhombus
        int width = 10;
        for (int i = 0; i < stop; i ++) {
            for (int j = 0; j < i; j++) {
                out.print(" ");
            }
            for (int k = 0; k < width; k++) {
                out.print("X");
            }
            out.println();
        }
    }
}
