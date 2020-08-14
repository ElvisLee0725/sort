// Quick Sort:
// Base Case: when the input array left index is greater or equal to right index, return
// Pick a pivot as the target number, do 3-way partition so all numbers smaller are at left, larger are at right
// After the partition, return the final position of left - 1 and right + 1 index for next round of partition
// Recurse the left side and right side of the pivot.
// Time: O(nlogn)

class Solution {
    public static void main(String[] args) {
        int [] nums = new int[]{5,1,1,2,0,0};
        new Solution().sortArray(nums);
        for(int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            if(i != nums.length - 1) {
                System.out.print(", ");
            }
        }
    }

    public int[] sortArray(int[] nums) {
        if(nums == null || nums.length <= 1) {
            return nums;
        }

        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void quickSort(int [] nums, int left, int right) {
        if(left >= right) {
            return ;
        }

        int mid = left + (right - left) / 2;
        int [] indices = partition(nums, left, right, nums[mid]);

        quickSort(nums, left, indices[0]);
        quickSort(nums, indices[1], right);
    }

    public int [] partition(int [] arr, int l, int r, int t) {
        int i = l;
        while(i <= r) {
            if(arr[i] < t) {
                swap(arr, i, l);
                i++;
                l++;
            }
            else if(arr[i] > t) {
                swap(arr, i, r);
                r--;
            }
            else {
                i++;
            }
        }

        return new int[]{l-1, r+1};
    }

    public void swap(int [] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
