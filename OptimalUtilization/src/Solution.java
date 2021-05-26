import java.util.ArrayList;
import java.util.List;

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
        List<int [] > res = new Solution().getPairs(a, b, 10);
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
}
