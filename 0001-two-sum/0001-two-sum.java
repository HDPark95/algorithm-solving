class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];
        int length = nums.length;
        for(int i = 0; i < length; i++){
            int a = nums[i];
            for(int j = 0; j < length; j++){
                if(i==j) continue;
                int b = nums[j];
                if(a+b == target){
                    answer[0] = i;
                    answer[1] = j;
                }
            }
        }
        return answer;
    }
}