
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int m = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);
        List<String> wordBook = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String word = br.readLine();
            if(word.length() >= n){
                wordBook.add(word);
            }
        }
        List<Map.Entry<String, Long>> list = wordBook
                .stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().sorted(
                        ((o1, o2) -> {
                            if(o1.getValue().equals(o2.getValue())){
                                if(o1.getKey().length() == o2.getKey().length()){
                                    char[] charArray = o1.getKey().toString().toCharArray();
                                    char[] charArray2 = o2.getKey().toString().toCharArray();
                                    for (int i = 0; i < charArray.length; i++) {
                                        char c = charArray[i];
                                        char c2 = charArray2[i];
                                        if(c != c2){
                                            return c - c2;
                                        }
                                    }
                                }else{
                                    return o2.getKey().length() - o1.getKey().length();
                                }
                            }
                            return Math.toIntExact(o2.getValue() - o1.getValue());
                        })
                ).collect(Collectors.toList());
       StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Long> entry : list) {
            sb.append(entry.getKey()).append("\n");
        }
        System.out.println(sb.toString());
    }
}
