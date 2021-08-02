/*
Quick Select: Quick Sort + Binary Search
- Get the target index, array.length - k is the kth largest element in a sorted array
- Do quick sort:
    - Base Case:
        - If start equals end index, we reach the value at index 0 or index arr.length-1, which is the only possible number and the answer.
        - Else if start > end, return it

    - After that, do binary search:
    - If the pivot index is the target index, we found the kth largest!
    - Else if pivot index is smaller than target index, do quick sort to the right section
    - Else if pivot index is greater than target index, do quick sort to the left section

Time: O(N) on average, Space: O(logN)
*/
class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
    }
    int targetIndex;
    int res;
    public int findKthLargest(int[] nums, int k) {
        targetIndex = nums.length - k;

        quickSort(nums, 0, nums.length-1);
        return res;
    }

    public void quickSort(int [] nums, int start, int end) {
        if(start == end) {
            res = nums[start];
            return ;
        }
        if(start > end) {
            return ;
        }

        int pivot = nums[start + (end - start) / 2];
        int l = start;
        int r = end;
        int i = start;
        while(i <= r) {
            if(nums[i] < pivot) {
                swap(nums, i, l);
                i++;
                l++;
            }
            else if(nums[i] > pivot){
                swap(nums, i, r);
                r--;
            }
            else {
                i++;
            }
        }

        // Binary Search
        if(l <= targetIndex && r >= targetIndex) {
            res = nums[l];
            return ;
        }
        else if(targetIndex < l) {
            quickSort(nums, start, l - 1);
        }
        else {
            quickSort(nums, r + 1, end);
        }
    }

    public void swap(int [] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
