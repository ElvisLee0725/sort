// A school is trying to take an annual photo of all the students. The students are asked to stand in a single file line in non-decreasing order by height. Let this ordering be represented by the integer array expected where expected[i] is the expected height of the ith student in line.
//
// You are given an integer array heights representing the current order that the students are standing in. Each heights[i] is the height of the ith student in line (0-indexed).
//
// Return the number of indices where heights[i] != expected[i].

// Bucket Sort
// Use an array of length 100, arr[i] = n means there are n people with height i
// EX [0, 3, 1, 1, 1] at example 1
// Iterate the heights array, and get the index that's supposed for curr number. Check if they are not equal? If not, count plus 1
// Return the count
// Time: O(n), Space: O(1)
class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().heightChecker(new int[]{1,1,4,2,1,3}));
    }
    public int heightChecker(int[] heights) {
        int [] arr = new int[101];
        for(int h : heights) {
            arr[h]++;
        }

        int count = 0;
        for(int i = 0; i < heights.length; i++) {
            int curHeight = 0;
            while(arr[curHeight] == 0) {
                curHeight++;
            }

            if(curHeight != heights[i]) {
                count++;
            }

            arr[curHeight]--;
        }
        return count;
    }
}
