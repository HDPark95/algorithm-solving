
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");
        List<Integer> findNumber = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            findNumber.add(Integer.parseInt(inputs[i]));
        }
        Collections.sort(findNumber);  
        Integer answersCount = Integer.parseInt(br.readLine());
        String[] answers = br.readLine().split(" ");
        for (int i = 0; i < answersCount; i++) {
            System.out.println(binarySearch(findNumber, Integer.parseInt(answers[i])));
        }
    }
    public static int binarySearch(List<Integer> arr, int target){
        int left = 0;
        int right = arr.size() - 1;

        while(left<=right){
            int mid = left + (right - left) /2;
            if(arr.get(mid) == target){
                return 1;
            }else if(arr.get(mid) < target){
                left = mid + 1;
            }else{
                right = mid -1;
            }
        }
        return 0;
    }
}
