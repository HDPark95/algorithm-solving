class Solution {
    public long solution(int n, int[] times) {
        long left = 0;
        long right = (long) n * times[times.length - 1];
        long mid;
        long sum;
        long min = Long.MAX_VALUE;

        while (left <= right) {
            sum = 0;
            mid = (left + right) / 2;
            for (int time : times) {
                sum += mid / time;
            }
            if (sum >= n) {
                min = Math.min(min, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return min;
    }
}