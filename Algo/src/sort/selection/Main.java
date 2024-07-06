package sort.selection;

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
    // 5 11 9 7 15
    public static int[] solution(int len, int[] arr){
        int[] res = new int[len];
        for(int i=0; i<len-1; i++){
            int idx = i;
            for(int j=i+1; j<len; j++){
                if(arr[j] < arr[idx]) idx = j;
            }
            int tmp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = tmp;
        }
        res = arr;
        return res;
    }
}
