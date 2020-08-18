// Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
// find the minimum number of conference rooms required.

// Sort the input matrix according to start times
// Create a minHeap to store the min end time of all current meetings rooms. Initialize with the first end time
// Loop through the sorted meeting intervals from index 1, if the start time of cur interval is smaller than the
// top of minHeap, add its end time to minHeap
// Else, update the top value of the minHeap with cur interval's end time
// Return the size of minHeap

// Time: O(nlogn), Space: O(n)

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        int [][] intervals = {{7, 10}, {2, 4}, {15, 20}};
        System.out.print(new Solution().minMeetingRooms(intervals));
    }

    public int minMeetingRooms(int[][] intervals) {
        if(intervals == null || intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) {
                    return 0;
                }
                return o1[0] < o2[0] ? -1 : 1;
            }
        });

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.offer(intervals[0][1]);

        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] < minHeap.peek()) {
                minHeap.offer(intervals[i][1]);
            }
            else {
                minHeap.poll();
                minHeap.offer(intervals[i][1]);
            }
        }

        return minHeap.size();
    }
}
