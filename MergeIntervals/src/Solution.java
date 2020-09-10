// Given a collection of intervals, merge all overlapping intervals.

// Sort the input matrix by the start number: [[startNum, endNum],[startNum, endNum]]
// Once the start number is settled, iterate the matrix and record end number
// Create a while loop that when i + 1 is smaller than interval.length and end number is greater than the start number
// of next interval, keep moving i by 1 and update the end number if the end number at i+1 is greater
// After while loop, update the end number of current interval, and add to list
// After the for loop, convert list back to int [][] and return

// Time: O(nlogn), Space: O(n)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int [][] intervals = {{0,3},{0,6},{0,2},{6,18}};

        int [][] res = new Solution().merge(intervals);
        for(int i = 0; i < res.length; i++) {
            System.out.println("[" + res[i][0] + "," + res[i][1] + "]");
        }
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) {
                    return 0;
                }
                return o1[0] < o2[0] ? -1 : 1;
            }
        });

        List<int []> list = new ArrayList();
        for(int i = 0; i < intervals.length; i++) {
            int [] temp = new int[2];
            temp[0] = intervals[i][0];
            int endNum = intervals[i][1];
            while(i + 1 < intervals.length && endNum >= intervals[i+1][0]) {
                endNum = Math.max(endNum, intervals[i+1][1]);
                i++;
            }
            temp[1] = endNum;
            list.add(temp);
        }

        int [][] res = new int[list.size()][];
        for(int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
