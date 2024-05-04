// package boj2512;

import java.io.*;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws Exception {
        // 입력 파일에서 데이터 읽기 (테스트용)
        // System.setIn(new FileInputStream("src/input.txt"));
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 지방의 수 N 입력받기
        int N = Integer.parseInt(br.readLine());
        
        // 각 지방의 예산요청 A 입력받기
        int[] A = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        // 총 예산 M 입력받기
        int M = Integer.parseInt(br.readLine());
        
        br.close();
        
        // 이분 탐색 범위 설정
        int s = 1;
        int e = Arrays.stream(A).max().getAsInt() + 1;
        
        // 이분 탐색 수행
        while (s < e) {
            int mid = (s + e) / 2;
            
            // 상한액이 mid일 때 총 예산 계산
            int totalBudget = getTotalBudget(A, mid);
            
            if (totalBudget <= M) {
                s = mid + 1;
            } else {
                e = mid;
            }
        }
        
        // 결과 출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(Integer.toString(e - 1));
        bw.flush();
        bw.close();
    }
    
    // 상한액이 limit일 때 총 예산 계산 메서드
    private static int getTotalBudget(int[] budgets, int limit) {
        int total = 0;
        for (int budget : budgets) {
            total += Math.min(budget, limit);
        }
        return total;
    }
}