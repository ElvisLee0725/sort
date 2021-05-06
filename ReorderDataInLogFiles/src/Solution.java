// You are given an array of logs. Each log is a space-delimited string of words, where the first word is the identifier.
//
//There are two types of logs:
//
//Letter-logs: All words (except the identifier) consist of lowercase English letters.
//Digit-logs: All words (except the identifier) consist of digits.
//Reorder these logs so that:
//
//The letter-logs come before all digit-logs.
//The letter-logs are sorted lexicographically by their contents. If their contents are the same, then sort them lexicographically by their identifiers.
//The digit-logs maintain their relative ordering.
//Return the final order of the logs.

// Goal: Sort the letter-logs in front of digit-logs. For letter-logs, sort by content first, then sort by identifier

// Optimize: For digit-logs, it will stay in original order. It is stated as "stable sorting algorithms sort equal elements in the same order that they appear in the input.". So we return 0 when both are digit-logs

// Rewrite sort comparator:
// If both are digit-logs, sort by original index
// If only 1 log is digit, the other sort first
// If both are letter logs and contents are the same, sort by identifier using .compareTo()
// Else, sort by contents

import java.util.Arrays;
import java.util.Comparator;

// Time: O(mnlogn), Space: O(mlogn) While m is the max length for each log, n is the number of logs
class Solution {
    public static void main(String[] args) {
        String [] res = new Solution().reorderLogFiles(new String[]{"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"});
        for(String s : res) {
            System.out.println(s);
        }
    }
    public String[] reorderLogFiles(String[] logs) {

        Arrays.sort(logs, new Comparator<String>(){
            public int compare(String s1, String s2) {
                String s1Id = s1.split(" ", 2)[0];
                String s1Log = s1.split(" ", 2)[1];
                String s2Id = s2.split(" ", 2)[0];
                String s2Log = s2.split(" ", 2)[1];

                if(Character.isDigit(s1Log.charAt(0)) && Character.isDigit(s2Log.charAt(0))) {
                    return 0;
                }
                else if(Character.isDigit(s1Log.charAt(0)) || Character.isDigit(s2Log.charAt(0))) {
                    return Character.isDigit(s1Log.charAt(0)) ? 1 : -1;
                }

                if(s1Log.equals(s2Log)) {
                    return s1Id.compareTo(s2Id);
                }
                return s1Log.compareTo(s2Log);
            }
        });
        return logs;
    }
}
