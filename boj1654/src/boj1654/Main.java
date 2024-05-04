// package boj1654;

import java.io.*;
import java.util.stream.Stream;

public class Main {
   public static void main(String[] args) throws Exception {
       // 표준 입력 사용 시 아래 주석 해제
       // System.setIn(new FileInputStream("src/input.txt"));

       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       // 첫 번째 줄에서 K와 N 입력받기
       int[] arr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
       int K = arr[0]; // 가지고 있는 랜선의 개수
       int N = arr[1]; // 필요한 랜선의 개수

       int[] A = new int[K]; // 랜선의 길이를 저장할 배열
       for (int i = 0; i < K; i++) {
           A[i] = Integer.parseInt(br.readLine()); // 랜선의 길이 입력받기
       }

       br.close(); // 입력 스트림 닫기

       long s = 1; // 랜선의 길이는 자연수이므로 1부터 시작
       long e = Integer.MAX_VALUE; // 랜선의 최대 길이로 초기화

       while (s <= e) {
           long mid = (s + e) / 2; // 중간 길이 계산
           long result = 0; // 랜선 개수 합산 변수

           for (int a : A) {
               result += a / mid; // 각 랜선을 중간 길이로 나눈 개수 누적
           }

           if (result >= N) {
               s = mid + 1; // 더 긴 길이 탐색
           } else {
               e = mid - 1; // 더 짧은 길이 탐색
           }
       }

       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       bw.write(Long.toString(e)); // 정답 출력 (최대 랜선 길이)
       bw.flush(); // 출력 버퍼 비우기
       bw.close(); // 출력 스트림 닫기
   }
}