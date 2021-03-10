// Given an array of integers arr:
//
// Write a function flip(arr, k) that reverses the order of the first k elements in the array arr.
// Write a function pancakeSort(arr) that sorts and returns the input array. You are allowed to use only the function flip you wrote in the first step in order to make changes in the array.

// [1, 5, 4, 3, 2]
// Use an index end starts from the end. Everything after end is sorted
// Each round, find the max number from index 0 to index j
// Call flip to reverse from 0 to target index -> max will be reversed to index 0
// Call flip to reverse from 0 to end index -> max will be reversed to the end index (sorted)
// Keep doing above until finished
// Time: O(n^2), Space: O(1)
public class Solution {
    public static void main(String[] args) {
        int [] arr = new int[]{2, 3, 5, 1, 4};
        int end = arr.length-1;
        while(end > 0) {
            int max = Integer.MIN_VALUE;
            int maxIndex = -1;
            for(int i = 0; i <= end; i++) {
                if(arr[i] > max) {
                    max = arr[i];
                    maxIndex = i;
                }
            }
            new Solution().flip(arr, maxIndex);
            new Solution().flip(arr, end);
            end--;
        }

        for(int n : arr) {
            System.out.print(n + " ");
        }
    }

    public void flip(int [] arr, int k) {
        int i = 0;
        int j = k;
        while(i < j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++;
            j--;
        }
    }
}
