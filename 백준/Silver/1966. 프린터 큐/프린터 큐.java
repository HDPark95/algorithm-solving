import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static class Document {
        int index;
        int priority;
        
        Document(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            Queue<Document> queue = new LinkedList<>();
            
            for (int i = 0; i < n; i++) {
                queue.offer(new Document(i, sc.nextInt()));
            }
            
            int printCount = 0;
            while (!queue.isEmpty()) {
                Document current = queue.poll();
                boolean hasHigherPriority = false;
                
                // 큐 내에 current보다 높은 우선순위를 가진 문서가 있는지 확인
                for (Document doc : queue) {
                    if (doc.priority > current.priority) {
                        hasHigherPriority = true;
                        break;
                    }
                }
                
                if (hasHigherPriority) {
                    queue.offer(current);
                } else {
                    printCount++;
                    if (current.index == m) {
                        System.out.println(printCount);
                        break;
                    }
                }
            }
        }
        sc.close();
    }
}
