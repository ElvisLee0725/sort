// We have N different apps with different user growth rates. At a given time t, measured in days, the number
// of users using an app is g^t (for simplicity we'll allow fractional users), where g is the growth rate for
// that app. These apps will all be launched at the same time and no user ever uses more than one of the apps.
// We want to know how many total users there are when you add together the number of users from each app.

public class Solution {
        public static void main(String[] args) {
            float[] test_1 = {1.1f, 1.2f, 1.3f};
            System.out.print(new Solution().getBillionUsersDay(test_1));
        }

    // Create 2 variables start = 1, end = 2000 (temp)
    // Use binary search to find at the mid of start and end, the total user number is equal, greater or less than target?
    // Case 1: Equal, then we return the mid
    // Case 2: Greater than target, set end to mid
    // Case 3: Less than target, set start to mid + 1
    // Return start after the while loop

    int getBillionUsersDay(float[] growthRates) {
        // Write your code here
        int startDay = 1;
        int endDay = 2000;
        float target = 1000000000;

        while(startDay < endDay) {
            int midDay = startDay + (endDay - startDay) / 2;
            float totalUsers = 0;
            for(float g : growthRates) {
                totalUsers += Math.pow(g, midDay);
            }

            if(totalUsers == target) {
                return midDay;
            }
            else if(totalUsers > target) {
                endDay = midDay;
            }
            else {
                startDay = midDay + 1;
            }
        }
        return startDay;
    }
}
