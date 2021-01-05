import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int [] arr = new int[]{2, 5, 7, 3, 1};
        new Solution().mergeSort(arr, 0, arr.length-1);
        for(int n : arr) {
            System.out.print(n + " ");
        }
    }

    public void mergeSort(int [] arr, int left, int right) {
        if(left >= right) {
            return ;
        }

        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid+1, right);
        merge(arr, left, mid, right);
    }

    public void merge(int [] arr, int left, int mid, int right) {
        int [] arr1 = Arrays.copyOfRange(arr, left, mid+1);
        int [] arr2 = Arrays.copyOfRange(arr, mid+1, right+1);

        int i = 0;
        int j = 0;
        while(i < arr1.length && j < arr2.length) {
            if(arr1[i] < arr2[j]) {
                arr[left] = arr1[i];
                i++;
            }
            else {
                arr[left] = arr2[j];
                j++;
            }
            left++;
        }
        while(i < arr1.length) {
            arr[left] = arr1[i];
            i++;
            left++;
        }
        while(j < arr2.length) {
            arr[left] = arr2[j];
            j++;
            left++;
        }
    }


}
