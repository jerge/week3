package exercises;

import java.util.Arrays;

import static java.lang.System.out;

/**
 *  Some theory mostly about references and identity
 *
 *  See
 *  - References
 *  - Overloading
 */
public class Ex3Theory {

    public static void main(String[] args) {
        new Ex3Theory().program();
    }

    void program() {
//         1. Uncomment and run.  What will be printed. Explain! ---------
        int[] i1 = {1, 2, 3};
        int[] i2 = {10, 11, 12, 13, 14, 15};
        int[] i3 = i1;

        out.println(i3[1]);     // 2
        i3 = i2;
        out.println(i3[1]);     // 11
        i1 = i2;
        out.println(i3[1]);     // 11
        i3 = i1;
        out.println(i3[1]);     // 11

        // 2. What will be printed. Explain! (methods below) ----------------
        int a = 1;
        int b = 2;
        swap(a, b);
        out.println(a + ", " + b);              // 1, 2     swap for int doesn't actually change anything, since a and b are forgotten

        int[] arr = {1, 2};
        swap(arr);
        out.println(Arrays.toString(arr));      // [2,1]    The local variables changes the referenced object, which affects the printed array.

        Player p1 = new Player();
        Player p2 = new Player();
        p1.name = "olle";
        p1.points = 34;
        p2.name = "fia";
        p2.points = 56;

        swap( p1, p2 );
        out.println(p1.name + ", " + p2.name);  // fia, olle   See above ^^

        // 3. What will be printed. Explain! ----------------
        String s1 = "aaa";
        String s2 = "111";
        String s3 = s1 + s2;
        out.println(s3);            // aaa111  s1 and s2 is concatenated
        s1 = "";
        out.println(s3);            // aaa111  s3 doesn't redefine itself after s1 is changed

        // 4. What will be printed. Explain! Methods below ----------------
        int[] a1 = getArr();
        int[] a2 = getArr();

        out.println(a1.length == a2.length);    // True         The length of the two separate objects a1 & a2 is the same
        out.println(a1[0] == a2[0]);            // True         The index 0 of the two separate objects a1 & a2 is the same
        out.println(a1 == a2);                  // False        The objects created separately and are therefore not the same part of the memory


        // 5. If uncommenting you'll get a compile error. Why? (methods below)
//        out.println(add(1,1));                  // No method takes two int:s as arguments
    }

    // ---------- Some methods used ---------------------------

    void swap(int a, int b) {
        int tmp = a;
        a = b;
        b = tmp;
    }

    void swap(int[] a) {
        int tmp = a[0];
        a[0] = a[1];
        a[1] = tmp;
    }

    void swap( Player p1, Player p2){
        String tmp = p1.name;
        p1.name = p2.name;
        p2.name = tmp;
    }

    int[] getArr() {
        int[] arr = {1, 2, 3};
        return arr;
    }

    double add(double d, int i) {
        return d + i;
    }

    double add(int i, double d) {
        return i + d;
    }

    class Player {
        String name;
        int points;
    }

}
