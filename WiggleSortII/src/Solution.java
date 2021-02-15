// Given an integer array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
// You may assume the input array always has a valid answer.

// Copy the input array to a new array and sort it
// From the sorted array, get each element from right to left (big to small) and insert to new array's odd indices. (Use those big numbers at the beginning of odd index)
// Then, do the same to all even indices. (Use from mid to small at even index)
// Time: O(nlogn), Space: O(n)

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        int [] arr = new int[]{1,5,1,1,6,4};
        new Solution().wiggleSort(arr);
        for(int n : arr) {
            System.out.print(n + " ");
        }
    }
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        if(n == 1) {
            return ;
        }

        int [] arr = nums.clone();
        Arrays.sort(arr);
        int j = n-1;
        int i = 1;
        while(i < n) {
            nums[i] = arr[j];
            i += 2;
            j--;
        }

        i = 0;
        while(i < n) {
            nums[i] = arr[j];
            i += 2;
            j--;
        }
    }
}
