import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

// Given a list of N triangles with integer side lengths, determine how many different triangles there are.
// Two triangles are considered to be the same if they can both be placed on the plane such that their vertices
// occupy exactly the same three points.
public class Solution {
    public static void main(String[] args) {
        ArrayList<Sides> arr_1 = new ArrayList<>();
        arr_1.add(new Sides(7, 6, 5));
        arr_1.add(new Sides(5, 7, 6));
        arr_1.add(new Sides(8, 2, 9));
        arr_1.add(new Sides(2, 3, 4));
        arr_1.add(new Sides(2, 4, 3));
        System.out.print(new Solution().countDistinctTriangles(arr_1));
    }

    // Convert each Sides into an sorted array of sorted arrays
    // After sorting, record the 1st 3 sides using 3 variables and iterate from the 2nd to compare. If the not the same, count + 1 and update the current sides
    // Return the count variable
    // Time: O(nlogn), Space: O(n)

    int countDistinctTriangles(ArrayList<Sides> arr) {
        // Write your code here
        int [][] triangles = new int[arr.size()][3];
        int index = 0;
        for(Sides s : arr) {
            triangles[index][0] = s.a;
            triangles[index][1] = s.b;
            triangles[index][2] = s.c;
            Arrays.sort(triangles[index]);
            index++;
        }

        Arrays.sort(triangles, new Comparator<int []>(){
            public int compare(int [] a1, int [] a2) {
                if(a1[0] == a2[0] && a1[1] == a2[1]) {
                    return a1[2] < a2[2] ? -1 : 1;
                }
                else if(a1[0] == a2[0]) {
                    return a1[1] < a2[1] ? -1 : 1;
                }
                return a1[0] < a2[0] ? -1 : 1;
            }
        });

        int side1 = triangles[0][0];
        int side2 = triangles[0][1];
        int side3 = triangles[0][2];
        int count = 1;
        for(int i = 1; i < triangles.length; i++) {
            if(triangles[i][0] != side1 || triangles[i][1] != side2 || triangles[i][2] != side3) {
                count++;
                side1 = triangles[i][0];
                side2 = triangles[i][1];
                side3 = triangles[i][2];
            }
        }
        return count;
    }
}
