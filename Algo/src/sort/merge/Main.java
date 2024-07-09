package sort.merge;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        int[] arr = new int[len];
        for(int i=0; i<len; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        printArray(arr);
        sort(arr, 0, len-1);
        printArray(arr);
        br.close();
    }
	
	public static void printArray(int[]arr) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i]+ " ");
        System.out.println();
    }
	
	public static void sort(int[] arr, int left, int right) {
		if(left < right) {
			int mid = (right+left) / 2;
			
			sort(arr, left, mid); // arr,0,2 - arr,0,1
			sort(arr, mid+1, right); //arr,3,5 - arr,5,5
			
			merge(arr, left, mid, right);
		}
	}

	private static void merge(int[] arr, int left, int mid, int right) {
		// TODO Auto-generated method stub
		int leftLen = mid-left+1;
		int rightLen = right-mid;
		
		int[] leftArr = new int[leftLen];
		int[] rightArr = new int[rightLen];
		
		for(int i=0; i<leftLen; i++) leftArr[i] = arr[left+i];
		for(int j=0; j<rightLen; j++) rightArr[j] = arr[mid+1+j];
		
		int i = 0, j = 0;
		int idx = left;
		
		while(i < leftLen && j < rightLen) {
			if(leftArr[i] <= rightArr[j]) {
				arr[idx++] = leftArr[i++];
			} else {
				arr[idx++] = rightArr[j++];
			}
		}
		
		while(i < leftLen) arr[idx++] = leftArr[i++];
		while(j < rightLen) arr[idx++] = rightArr[j++];
	}
}
