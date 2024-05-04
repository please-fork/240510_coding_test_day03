// package boj2805;

import java.io.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws Exception {
        // System.setIn(new FileInputStream("src/input.txt")); // 입력 파일 경로 설정
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력 버퍼 생성
        
        int[] arr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray(); // 첫 줄 입력 받기
        int N = arr[0]; // 나무의 수
        int M = arr[1]; // 필요한 나무의 길이
        
        int[] A = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray(); // 나무의 높이 배열 입력 받기
        
        br.close(); // 입력 버퍼 닫기
        
        // System.out.println(Arrays.toString(A)); // 디버깅용 출력
        
        int s = 0; // 시작 높이
        int e = Integer.MAX_VALUE; // 끝 높이
        
        while (s <= e) { // 이분 탐색 수행
            int mid = (s + e) / 2; // 중간 높이 계산
            long cut = 0; // 잘린 나무의 길이
            
            for (int a : A) { // 나무 높이 배열 순회
                if (a > mid) { // 나무 높이가 중간 높이보다 크면
                    cut += a - mid; // 잘린 나무의 길이 누적
                }
            }
            
            if (cut < M) { // 잘린 나무의 길이가 필요한 길이보다 작으면
                e = mid - 1; // 끝 높이를 중간 높이 - 1로 변경
            } else { // 잘린 나무의 길이가 필요한 길이보다 크거나 같으면
                s = mid + 1; // 시작 높이를 중간 높이 + 1로 변경
            }
        }
        
        // System.out.println(e); // 디버깅용 출력
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력 버퍼 생성
        bw.write(Integer.toString(e)); // 결과 출력
        bw.flush(); // 출력 버퍼 비우기
        bw.close(); // 출력 버퍼 닫기
    }
}