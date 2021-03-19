// Goal: To get the most units to load onto the truck
// => Get those boxes with the most units onto the truck first.
// Sort the input matrix by number of units in descending order
// Keep adding boxes and units until the truck is full or we have loaded all boxes
// Return the number of units in the end
// Time: O(nlogn), Space: O(n) for sorting

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public static void main(String[] args) {
        int [][] m = {{1,3},{2,2},{3,1}};
        System.out.print(new Solution().maximumUnits(m, 4));
    }
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, new Comparator<int []>(){
            public int compare(int [] a, int [] b) {
                if(a[1] == b[1]) {
                    return 0;
                }
                return a[1] < b[1] ? 1 : -1;
            }
        });

        int unitSum = 0;
        int remainingCap = truckSize;
        int i = 0;
        while(remainingCap > 0 && i < boxTypes.length) {
            int curBoxes = Math.min(boxTypes[i][0], remainingCap);
            unitSum += curBoxes * boxTypes[i][1];
            remainingCap -= curBoxes;

            if(remainingCap == 0) {
                break;
            }
            i++;
        }
        return unitSum;
    }
}
