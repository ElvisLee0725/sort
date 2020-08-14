// Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.

// Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

// Three-Way Partition
// Use left = 0, right = last index and i as the current index. Stop when i passing right index
// Case 1: Current index pointing at 0, swap value at left and i and move i by 1
// Case 2: Current index pointing at 2, swap value at right and i and move k by -1
// Case 3: Current index pointing at 1, just move i
// Time: O(n), Space: O(1)

public class Solution {
    public static void main(String[] args) {
        int [] nums = new int[]{2,0,2,1,1,0};
        new Solution().sortColor(nums);
        for(int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            if(i != nums.length - 1) {
                System.out.print(", ");
            }
        }
    }

    public void sortColor(int [] nums) {
        if(nums == null || nums.length == 0) {
            return ;
        }

        int l = 0;
        int r = nums.length - 1;
        int i = 0;
        while(i <= r) {
            if (nums[i] == 0) {
                swap(nums, l, i);
                i++;
                l++;
            } else if (nums[i] == 2) {
                swap(nums, i, r);
                r--;
            } else {
                i++;
            }
        }
    }

    public void swap(int [] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
