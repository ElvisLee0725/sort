import java.util.Arrays;
// Given an array of integers (which may include repeated integers), determine if there's a way to split the array into two subsequences A and B such that the sum of the integers in both arrays is the same, and all of the integers in A are strictly smaller than all of the integers in B.
// Note: Strictly smaller denotes that every integer in A must be less than, and not equal to, every integer in B.

public class Solution {
    public static void main(String[] args) {
        int [] arr = {3, 6, 3, 4, 4};
        System.out.print(new Solution().balancedSplitExists(arr));
    }

    // Sort the input arr from small to large
    // Use 2 indices i and j. i starts from 0 and j starts from arr.length - 1
    // While i and j are not next to each other, if leftSum <= rightSum, i++, update maxLeft and get new leftSum. Else, j--, update minRight and get new rightSum
    // LeftSum (sum from index 0 to i), starts from arr[0]. RightSum (sum from last index to j, starts from arr.length-1)
    // maxLeft (the largest number from 0 to i), minRight (the smallest number from last index to j)
    // After the while loop, if leftSum equals to rightSum and maxLeft < minRight, return true; Else return false
    // Time: O(nlogn), Space: O(n)

    boolean balancedSplitExists(int[] arr) {
        // Write your code here
        Arrays.sort(arr);
        int i = 0;
        int j = arr.length-1;
        int leftSum = arr[i];
        int rightSum = arr[j];
        int maxLeft = arr[i];
        int minRight = arr[j];
        while(i < j - 1) {
            if(leftSum <= rightSum) {
                i++;
                leftSum += arr[i];
                maxLeft = Math.max(maxLeft, arr[i]);
            }
            else {
                j--;
                rightSum += arr[j];
                minRight = Math.min(minRight, arr[j]);
            }
        }
        return leftSum == rightSum && maxLeft < minRight;
    }
}
