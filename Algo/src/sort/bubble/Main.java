package sort.bubble;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        int[] arr = new int[len];
        for(int i=0; i<len; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(Arrays.toString(solution(len, arr)));
        br.close();
    }
    // 13 5 9 7 15
    public static int[] solution(int len, int[] arr){
        int[] res = new int[len];
        for(int i=0; i<len-1; i++){
            for(int j=0; j<len-i-1; j++){
                if(arr[j] > arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
        res = arr;
        return res;
    }
}
