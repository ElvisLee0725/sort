// Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.
// Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2.
// Elements that don't appear in arr2 should be placed at the end of arr1 in ascending order.
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int [] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int [] arr2 = {2,1,4,3,9,6};
        int [] res = new Solution().relativeSortArray(arr1, arr2);
        for(int i : res) {
            System.out.print(i + " ");
        }
    }
    // Rewrite the comparator of the array sort function:
// Case 1: When 2 numbers are both in arr2, sort them by the order in arr2
// Case 2: Only 1 number is in arr2, it should be sort in front of the other number
// Case 3: Both numbers are not in arr2, sort by original sequence
// Use a map <number, index> to store each element from arr2
// ** Be aware of the Comparator can't be applied to primitive type, so must convert to List<Integer> first, and before return, needs to convert it back to int[]
// Time: O(nlogn), Space: O(n)

        public int[] relativeSortArray(int[] arr1, int[] arr2) {
            HashMap<Integer, Integer> map = new HashMap();
            for(int i = 0; i < arr2.length; i++) {
                map.putIfAbsent(arr2[i], i);
            }

            List<Integer> list = new ArrayList();
            for(int n : arr1) {
                list.add(n);
            }

            Collections.sort(list, new Comparator<Integer>(){
                public int compare(Integer n1, Integer n2) {
                    if(map.containsKey(n1) && map.containsKey(n2)) {
                        return map.get(n1) < map.get(n2) ? -1 : 1;
                    }
                    else if(map.containsKey(n1) || map.containsKey(n2)) {
                        return map.containsKey(n1) ? -1 : 1;
                    }
                    else {
                        return n1 < n2 ? -1 : 1;
                    }
                }
            });

            int [] res = new int[list.size()];
            for(int i = 0; i < res.length; i++) {
                res[i] = list.get(i);
            }

            return res;
        }
}
