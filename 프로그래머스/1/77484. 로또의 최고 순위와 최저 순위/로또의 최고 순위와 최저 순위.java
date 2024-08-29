class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        
        int result = 0;
        int countZero = 0;
        for(int i = 0; i<lottos.length; i++){
            int lottosNumber = lottos[i];
            if(lottosNumber != 0){
                for(int subIndex = 0; subIndex < win_nums.length; subIndex++){
                    int num = win_nums[subIndex];
                    if(num == lottosNumber){
                        result += 1;
                    }
                }
            }else{
                countZero += 1;
            }
        }
    
        int best = (7 - (result+countZero)) < 6 ? (7- (result+countZero)) : 6;
        int worst = (7 - result) < 6 ? (7- result) : 6;
        int[] answer = new int[]  {best,worst};   
        
        return answer;
    }
}