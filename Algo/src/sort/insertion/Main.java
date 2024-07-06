package sort.insertion;

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
        for(int i=1; i<len; i++){
            int tmp = arr[i], j;
            for(j=i-1; j>=0; j--){
                if(tmp < arr[j])arr[j+1] = arr[j];
                else break;
            }
            arr[j+1] = tmp;
        }
        return arr;
    }
}
