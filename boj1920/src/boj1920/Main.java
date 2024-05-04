// package boj1920;

import java.io.*;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws Exception {
        // System.setIn(new FileInputStream("src/input.txt")); // 입력 파일 경로 설정
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력 버퍼 생성
        
        int N = Integer.parseInt(br.readLine()); // 배열 A의 크기 입력 받기
        int[] A = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray(); // 배열 A 입력 받기
        Arrays.sort(A); // 배열 A 오름차순 정렬 - 시간 복잡도: O(n log n)
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력 버퍼 생성
        
        int M = Integer.parseInt(br.readLine()); // 탐색할 정수의 개수 입력 받기
        int[] B = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray(); // 탐색할 정수 배열 B 입력 받기
        
        br.close(); // 입력 버퍼 닫기
        
        for (int i : B) { // 배열 B의 각 원소에 대해 이분 탐색 수행 - 시간 복잡도: O(M log N)
            bw.write(binarySearch(A, i) + "\n"); // 이분 탐색 결과 출력 버퍼에 쓰기
        }
        
        bw.flush(); // 출력 버퍼 비우기
        bw.close(); // 출력 버퍼 닫기
    }
    
    public static String binarySearch(int[] A, int val) { // 이분 탐색 메서드 - 시간 복잡도: O(log N)
        int s = 0; // 시작 인덱스
        int e = A.length - 1; // 끝 인덱스
        
        while (s <= e) { // 시작 인덱스가 끝 인덱스보다 작거나 같을 때까지 반복
            int mid = (s + e) / 2; // 중간 인덱스 계산
            int tmp = A[mid]; // 중간 인덱스의 값
            
            if (tmp == val) { // 중간 인덱스의 값과 찾는 값이 같으면
                return "1"; // 1 반환
            }
            
            if (tmp > val) { // 중간 인덱스의 값이 찾는 값보다 크면
                e = mid - 1; // 끝 인덱스를 중간 인덱스 - 1로 변경
            } else { // 중간 인덱스의 값이 찾는 값보다 작으면
                s = mid + 1; // 시작 인덱스를 중간 인덱스 + 1로 변경
            }
        }
        
        return "0"; // 찾는 값이 없으면 0 반환
    }
}