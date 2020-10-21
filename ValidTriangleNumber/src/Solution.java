// Given an array consists of non-negative integers, your task is to count the number of triplets chosen from the
// array that can make triangles if we take them as side lengths of a triangle.

import java.util.Arrays;

// Triangle: The sum of any two sides is greater than the 3rd side
// Sort the input array
// Use 2 for loop for index i and j. At outer loop, set k = i + 2. At inner loop, j = i + 1
// We need to find the limit of valid nums[i] + nums[j] > nums[k]. k is the limit. Therefore, k - 1 - j are all valid
// combination, add them to count variable

// Time: O(n^2), Space: O(logn) by sorting
public class Solution {
    public static void main(String[] args) {
        int [] nums = new int[]{2, 2, 3, 9, 10, 11};
        System.out.print(new Solution().triangleNumber(nums));
    }

    public int triangleNumber(int[] nums) {
        int count = 0;
        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i++) {
            int k = i + 2;
            for(int j = i + 1; j < nums.length - 1 && nums[i] > 0; j++) {
                while(k < nums.length && nums[i] + nums[j] > nums[k]) {
                    k++;
                }
                count += k - 1 - j;
            }
        }
        return count;
    }
}
