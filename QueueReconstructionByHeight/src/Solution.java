// You are given an array of people, people, which are the attributes of some people in a queue (not necessarily in order). Each people[i] = [hi, ki] represents the ith person of height hi with exactly ki other people in front who have a height greater than or equal to hi.

// Reconstruct and return the queue that is represented by the input array people. The returned queue should be formatted as an array queue, where queue[j] = [hj, kj] is the attributes of the jth person in the queue (queue[0] is the person at the front of the queue).

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int [][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        int [][] res = new Solution().reconstructQueue(people);
        for(int [] a : res) {
            for(int n : a) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }
    // Everyone can only see people who are taller or equal height. We sort the people by height, and insert shorter people to its k index to push taller people to the back
    // Sort the people by height in descending order, if the height is equal, sort by k in ascending order
    // Create a List<int []>, Iterate each people and insert at index k
    // Convert List<int []> to int[][] and return
    // Time: O(n^2), Space: O(n), n is the number of people
    public int[][] reconstructQueue(int[][] people) {
        if(people.length == 1) {
            return people;
        }
        Arrays.sort(people, new Comparator<int []>(){
            public int compare(int [] a, int [] b) {
                if(a[0] == b[0]) {
                    return a[1] < b[1] ? -1 : 1;
                }
                return a[0] < b[0] ? 1 : -1;
            }
        });

        List<int []> list = new ArrayList();
        for(int [] a : people) {
            list.add(a[1], a);
        }

        return list.toArray(new int[people.length][2]);
    }
}
