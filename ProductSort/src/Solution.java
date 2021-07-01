// Given n and an array. Return an array sorted by the frequency of each item and the value
// in ascending order
// Ex. n = 10, [8, 5, 5, 5, 5, 1, 1, 1, 4, 4]
// Return [8, 4, 4, 1, 1, 1, 5, 5, 5, 5]

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int [] arr = new int[]{8, 5, 5, 5, 5, 1, 1, 1, 4, 4};
        int [] res = new Solution().productSort(arr.length, arr);
        for(int i = 0; i < res.length; i++) {
            System.out.print(res[i] + ", ");
        }
    }

    // Create a HashMap<Number, Frequency> Ex. <8, 1>, <5, 4> ...
    // Rewrite the sorting comparator to sort by:
    // If frequency is the same, sort by value
    // Else, the number with less frequency will go first
    // Return the sorted array
    // Time: O(NlogN), Space: O(N)
    private int [] productSort(int n, int [] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        Collections.sort(list, (n1, n2) -> {
           if(map.get(n1) == map.get(n2))  {
               return n1 < n2 ? - 1 : 1;
           }
           return map.get(n1) < map.get(n2) ? -1 : 1;
        });

        for(int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}
