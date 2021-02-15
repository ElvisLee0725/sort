// Given the coordinates of four points in 2D space p1, p2, p3 and p4, return true if the four points construct a square.
// The coordinate of a point pi is represented as [xi, yi]. The input is not given in any order.
// A valid square has four equal sides with positive length and four equal angles (90-degree angles).

import java.util.Arrays;
import java.util.Comparator;

// To form a square, the distance (edge or diagnol) bewteen each point is the same
// Distance: the square root of (x1 - x2)^2 + (y1 - y2)^2
// Sort all points according to their x, then y
// After sorting, we are sure that m[0] and m[3] / m[1] and m[2] are diagnol
// Therefore, just check the distance besides those 2 above
// Be careful when first 2 are the same points, make sure their distance is not 0
// Time: O(1), Space: O(1)
class Solution {
    public static void main(String[] args) {
        System.out.print(new Solution().validSquare(new int[]{0,0}, new int[]{1,1}, new int[]{1,0}, new int[]{0,1}));
    }

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int [][] m = {p1, p2, p3, p4};
        double dist = -1;
        Arrays.sort(m, new Comparator<int []>(){
            public int compare(int [] a1, int [] a2) {
                if(a1[0] == a2[0]) {
                    return a1[1] < a2[1] ? -1 : 1;
                }
                return a1[0] < a2[0] ? -1 : 1;
            }
        });

        return check(m[0], m[1]) != 0 && check(m[0], m[1]) == check(m[1], m[3]) && check(m[1], m[3]) == check(m[3], m[2]) && check(m[3], m[2]) == check(m[2], m[0]) && check(m[0], m[3]) == check(m[1], m[2]);
    }

    public double check(int [] a, int [] b) {
        int x = (a[0] - b[0]) * (a[0] - b[0]);
        int y = (a[1] - b[1]) * (a[1] - b[1]);
        return x + y;
    }
}
