import java.util.*;

public class Solution {
    public static void main(String[] args) {
        List<int []> a = new ArrayList<>();
        a.add(new int[]{1, 3});
        a.add(new int[]{2, 5});
        a.add(new int[]{3, 7});
        a.add(new int[]{4, 10});

        List<int []> b = new ArrayList<>();
        b.add(new int[]{1, 2});
        b.add(new int[]{2, 3});
        b.add(new int[]{3, 4});
        b.add(new int[]{4, 5});
        List<int [] > res = new Solution().getPairs2(a, b, 10);
        for(int [] arr : res) {
            System.out.println(arr[0] + ", " + arr[1]);
        }
    }

    // Sol: Brute Force, Time: O(mn), Space: O(mn)
    public List<int[]> getPairs(List<int[]> a, List<int[]> b, int target) {
        List<int [] > res = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;

        for(int i = 0; i < a.size(); i++) {
            for(int j = 0; j < b.size(); j++) {
                int tmp = a.get(i)[1] + b.get(j)[1];
                if(tmp <= target && target - tmp <= minDiff) {
                    if(target - tmp < minDiff) {
                        minDiff = target - tmp;
                        res.clear();
                    }
                    res.add(new int[]{a.get(i)[0], b.get(j)[0]});
                }
            }
        }
        return res;
    }

    // Sol 2: Sorting
    // Sort List a and b by its value.
    // Use a index i pointing at a, an index j pointing at the end of b
    // While i < a.size() && j >= 0, get the current sum.
    // If curSum is > target, just j--
    // Else, check if curSum is greater than maxSum (the target at most)? If so, update the maxSum
    // and clear the result.
    // Add the current combination and check all possible duplications in b. Then, move index i++
    // Time: Max of O(mlogm) and O(nlogn), Space: O(mn)
    public List<int[]> getPairs2(List<int[]> a, List<int[]> b, int target) {
        Collections.sort(a, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] < o2[1] ? -1 : 1;
            }
        });
        Collections.sort(b, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] < o2[1] ? -1 : 1;
            }
        });

        List<int [] > res = new ArrayList<>();
        int maxSum = Integer.MIN_VALUE;
        int i = 0;
        int j = b.size()-1;
        while(i < a.size() && j >= 0) {
            int curSum = a.get(i)[1] + b.get(j)[1];
            if(curSum > target) {
                j--;
            }
            else {
                if(curSum >= maxSum) {
                    if(curSum > maxSum) {
                        maxSum = curSum;
                        res.clear();
                    }
                    res.add(new int[]{a.get(i)[0], b.get(j)[0]});

                    int index = j-1;
                    while(index >= 0 && b.get(index)[1] == b.get(j)[1]) {
                        res.add(new int[]{a.get(i)[0], b.get(index)[0]});
                        index--;
                    }
                }
                i++;
            }
        }

        return res;
    }
}
