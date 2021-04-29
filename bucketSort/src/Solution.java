// Sort the input array in ascending order
// 1 <= nums.length <= 5 * 10^4
// -5 * 10^4 <= nums[i] <= 5 * 10^4

// Bucket Sort:
// Create an array to fit in all possible numbers arr[100001], arr[i] = 3 means value i-50000 shows up 3 times
// Mapping values to new index, ex. -50000 -> 0, -49999 -> 1, ... 0 -> 50000, 50000 -> 100000
// Iterate the new array, If arr[i] is not 0, add i - 50000 to result array arr[i] times
// Return the result array
// Time: O(n), Space: O(1)
public class Solution {
    public static void main(String[] args) {
        int [] res = new Solution().sortArray(new int[]{5,1,1,2,0,0});
        for(int n : res) {
            System.out.print(n + ", ");
        }
    }
    public int[] sortArray(int[] nums) {
        int [] arr = new int[100001];
        for(int n : nums) {
            arr[n + 50000]++;
        }

        int index = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > 0) {
                for(int j = 0; j < arr[i]; j++) {
                    nums[index++] = i - 50000;
                }
            }
        }
        return nums;
    }
}
