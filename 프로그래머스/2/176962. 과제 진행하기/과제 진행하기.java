import java.util.*;
class Solution {
    public String[] solution(String[][] plans) {
        List<String> answer = new ArrayList<>();
        List<String[]> listPlans = new ArrayList<>(Arrays.asList(plans));

        Collections.sort(listPlans, (a, b) -> {
            return convertToMinutes(a[1]) - convertToMinutes(b[1]);
        });

        Stack<String[]> stack = new Stack<>();
        int currentTime = 0;

        for (int i = 0; i < listPlans.size(); i++) {
            String[] currentPlan = listPlans.get(i);
            int currentStartTime = convertToMinutes(currentPlan[1]);
            int currentDuration = Integer.parseInt(currentPlan[2]);

            while (!stack.isEmpty() && currentTime < currentStartTime) {
                String[] prevPlan = stack.peek();
                int prevDuration = Integer.parseInt(prevPlan[2]);
                int timeAvailable = currentStartTime - currentTime;

                if (prevDuration <= timeAvailable) {
                    stack.pop();
                    answer.add(prevPlan[0]);
                    currentTime += prevDuration;
                } else {
                    prevPlan[2] = String.valueOf(prevDuration - timeAvailable);
                    currentTime = currentStartTime;
                    break;
                }
            }

            currentTime = Math.max(currentTime, currentStartTime);

            if (i < listPlans.size() - 1) {
                int nextStartTime = convertToMinutes(listPlans.get(i + 1)[1]);
                int timeAvailable = nextStartTime - currentTime;

                if (currentDuration <= timeAvailable) {
                    answer.add(currentPlan[0]);
                    currentTime += currentDuration;
                } else {
                    currentPlan[2] = String.valueOf(currentDuration - timeAvailable);
                    stack.push(currentPlan);
                    currentTime = nextStartTime;
                }
            } else {
                answer.add(currentPlan[0]);
                currentTime += currentDuration;
            }
        }

        while (!stack.isEmpty()) {
            answer.add(stack.pop()[0]);
        }

        return answer.toArray(new String[0]);
    }
    
    private static int convertToMinutes(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }
}