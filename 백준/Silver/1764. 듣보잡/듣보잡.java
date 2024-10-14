
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);
        Set<String> notListen = new HashSet<>();
        for (int i = 0; i < N; i++) {
            notListen.add(br.readLine());
        }

        List<String> resultList = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            if (notListen.contains(name)) {
                resultList.add(name);
            }
        }

        Collections.sort(resultList);

        StringBuilder sb= new StringBuilder();
        sb.append(resultList.size()+"\n");
        for (String person: resultList){
            sb.append(person + "\n");
        }
        System.out.println(sb);
    }
}