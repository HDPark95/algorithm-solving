
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String chongchongName = "ChongChong";
        Set<String> meetPersons = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String persons = br.readLine();
            String person1 = persons.split(" ")[0];
            String person2 = persons.split(" ")[1];
            if(person1.equals(chongchongName) || person2.equals(chongchongName)) {
                meetPersons.add(person1);
                meetPersons.add(person2);
            }
            if(meetPersons.contains(person1) || meetPersons.contains(person2)) {
                meetPersons.add(person1);
                meetPersons.add(person2);
            }
        }
        System.out.println(meetPersons.size());
    }
}
