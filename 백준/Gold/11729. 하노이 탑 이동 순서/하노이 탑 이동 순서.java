
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
    public final static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int start = 1;
        int mid = 2;
        int last = 3;
        solution(N, start, mid, last);
        String[] totalLine = sb.toString().split("\n");
        System.out.println(totalLine.length);
        System.out.println(sb);
    }
    public static void solution(int N, int start, int mid, int last){
        if(N == 1){
            sb.append(start + " " + last + "\n");
            return;
        }
        //A->B n-1 개 옮기고
        solution(N-1, start, last, mid);
        //A->C로 1개 옮기고
        sb.append(start +" "+ last + "\n");
        //B->A로 n-1개 옮기고
        solution(N-1, mid, start, last);
    }
}
