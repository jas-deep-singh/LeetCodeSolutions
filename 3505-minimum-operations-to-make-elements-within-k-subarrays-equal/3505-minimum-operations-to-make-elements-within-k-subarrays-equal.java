
import java.util.*;

class Solution {
    class SlidingMedian {
        TreeMap<Integer, Integer> low = new TreeMap<>();
        TreeMap<Integer, Integer> high = new TreeMap<>();
        int lowSize = 0, highSize = 0;
        long lowSum = 0, highSum = 0;
        int target;

        SlidingMedian(int x) {
            target = (x + 1) / 2;
        }

        void add(int num) {
            if(low.isEmpty()) {
                if(high.isEmpty() || num <= high.firstKey()) {
                    low.put(num, low.getOrDefault(num, 0) + 1);
                    lowSize++;
                    lowSum += num;
                } else {
                    high.put(num, high.getOrDefault(num, 0) + 1);
                    highSize++;
                    highSum += num;
                }
            } else if(num <= low.lastKey()) {
                low.put(num, low.getOrDefault(num, 0) + 1);
                lowSize++;
                lowSum += num;
            } else {
                high.put(num, high.getOrDefault(num, 0) + 1);
                highSize++;
                highSum += num;
            }
        }

        void removeOne(TreeMap<Integer, Integer> map, int num) {
            int count = map.get(num);
            if(count == 1) {
                map.remove(num);
            } else {
                map.put(num, count - 1);
            }
        }

        void remove(int num) {
            if(low.containsKey(num)) {
                removeOne(low, num);
                lowSize--;
                lowSum -= num;
            } else {
                removeOne(high, num);
                highSize--;
                highSum -= num;
            }
        }

        void rebalance() {
            while(lowSize > target) {
                int num = low.lastKey();
                removeOne(low, num);
                lowSize--;
                lowSum -= num;

                high.put(num, high.getOrDefault(num, 0) + 1);
                highSize++;
                highSum += num;
            }

            while(lowSize < target) {
                int num = high.firstKey();
                removeOne(high, num);
                highSize--;
                highSum -= num;

                low.put(num, low.getOrDefault(num, 0) + 1);
                lowSize++;
                lowSum += num;
            }
        }

        long getCost() {
            long median = low.lastKey();
            return median * lowSize - lowSum
                 + highSum - median * highSize;
        }
    }

    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;
        long[] cost = new long[n - x + 1];

        SlidingMedian sm = new SlidingMedian(x);

        for(int i = 0; i < x; i++) {
            sm.add(nums[i]);
        }

        sm.rebalance();
        cost[0] = sm.getCost();

        for(int i = x; i < n; i++) {
            sm.remove(nums[i - x]);
            sm.add(nums[i]);
            sm.rebalance();
            cost[i - x + 1] = sm.getCost();
        }

        long INF = Long.MAX_VALUE / 4;
        long[] prev = new long[n + 1];
        long[] curr = new long[n + 1];

        for(int t = 1; t <= k; t++) {
            Arrays.fill(curr, INF);

            for(int i = 1; i <= n; i++) {
                curr[i] = curr[i - 1];

                if(i >= x && prev[i - x] != INF) {
                    curr[i] = Math.min(
                        curr[i],
                        prev[i - x] + cost[i - x]
                    );
                }
            }

            long[] temp = prev;
            prev = curr;
            curr = temp;
        }

        return prev[n];
    }
}
