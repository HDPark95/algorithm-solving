import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N, K;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 센서의 개수와 집중국의 개수를 입력받음
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        // 센서 위치 입력 및 정렬
        int[] sensors = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        Arrays.sort(sensors);

        // 만약 집중국의 수가 센서 수보다 많거나 같으면, 모든 센서를 커버 가능
        if (K >= N) {
            System.out.println(0);
            return;
        }

        // 인접한 센서들 간의 거리 차이를 계산하여 배열에 저장
        int[] distances = new int[N - 1];
        for (int i = 0; i < N - 1; i++) {
            distances[i] = sensors[i + 1] - sensors[i];
        }

        // 거리 차이 배열을 내림차순으로 정렬
        Arrays.sort(distances);

        // 가장 큰 거리 차이들 중 K-1개를 제외한 나머지 거리의 합을 계산
        int totalDistance = 0;
        for (int i = 0; i < N - K; i++) {
            totalDistance += distances[i];
        }

        // 최소 수신 가능 영역의 합 출력
        System.out.println(totalDistance);
    }
}