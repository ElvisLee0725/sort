import java.util.Arrays;
import java.util.Comparator;

// Sort the points according to x axis
// Iterate each point and check the width between each pair of points and update the max width
// Time: O(nlogn), Space: O(1)
class Solution {
    public static void main(String[] args) {
        int [][] p = {{3,1},{9,0},{1,0},{1,4},{5,3},{8,8}};
        System.out.print(new Solution().maxWidthOfVerticalArea(p));
    }
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, new Comparator<int []>(){
            public int compare(int [] a, int [] b) {
                return a[0] < b[0] ? -1 : 1;
            }
        });
        int max = Integer.MIN_VALUE;
        for(int i = 1; i < points.length; i++) {
            max = Math.max(max, points[i][0] - points[i-1][0]);
        }
        return max;
    }
}
