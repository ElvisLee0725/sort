// Heap Sort
// Make the input array a MAX heap, do it in place
// Repeat:
// 1. Swap the first and last elemnt
// 2. Decrease the size of the heap
// 3. Do bubble down for the first element
// Time: O(NlogN), Space: O(1)

class Solution {
    public static void main(String[] args) {
        int [] res = new Solution().sortArray(new int[]{5,1,1,2,0,0});
        for(int n : res) {
            System.out.print(n + " ");
        }
    }
    public int[] sortArray(int[] nums) {
        for(int i = nums.length-1; i >= 0; i--) {
            bubbleDown(nums, i, nums.length);
        }

        int heapLen = nums.length;
        while(heapLen > 1) {
            swap(nums, 0, heapLen-1);
            heapLen--;
            bubbleDown(nums, 0, heapLen);
        }
        return nums;
    }

    private int getChild(int [] arr, int pIndex, int heapLength) {
        int cLeft = pIndex * 2 + 1;
        int cRight = pIndex * 2 + 2;

        if(cLeft >= heapLength) {
            return pIndex;
        }
        else if(cRight >= heapLength) {
            return cLeft;
        }
        return arr[cLeft] >= arr[cRight] ? cLeft : cRight;
    }

    private void swap(int [] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private void bubbleDown(int [] arr, int pIndex, int heapLength) {
        int cIndex = getChild(arr, pIndex, heapLength);

        while(cIndex < heapLength) {
            if(arr[cIndex] > arr[pIndex]) {
                swap(arr, pIndex, cIndex);
                pIndex = cIndex;
            }
            else {
                break;
            }
            cIndex = getChild(arr, pIndex, heapLength);
        }
    }
}
