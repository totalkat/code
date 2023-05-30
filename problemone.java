import java.util.*;
import java.io.*;

public class problemone{
    public static void main(String[] args) throws Exception{
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	Map<Long,Long> used = new HashMap<>();
	long n = Long.parseLong(in.readLine().trim());
	String[] read = in.readLine().trim().split("\\s");
	long[] arr = new long[(int)n];
	long longnum = 1;
	for(int i=0; i<n; i++){
	    arr[i]=Long.parseLong(read[i]);
	    if(used.containsKey(arr[i])){
		used.put(arr[i],used.get(arr[i])+1);
	    }
	    else{

		used.put(arr[i],longnum);
	    }
	}
	Arrays.sort(arr);
	long num=0;
	long maxtuition = 0;
	for(int i=arr.length-1; i>=0; i--){
	    if(used.containsKey(arr[i])){
		long tuition = arr[i];
		int counter = 0;
		used.remove(arr[i]);
		long index = firstocc(arr,tuition,n);
		if((n-index)*tuition >= num*maxtuition){
		    num = n-index;
		    maxtuition = tuition;
		}

	    }
	    
	}
	System.out.println(maxtuition*num + " " + maxtuition);
    }
    public static long firstocc(long[] arr, long tuition, long n){
	long low = 0;
	long high = n-1;
	while(low<=high){
	    int mid = (int)(low+(high-low)/2);
	    if((mid==0 || arr[mid-1] < tuition) && (arr[mid]  == tuition)){
		return mid;
	    }
	    else if(tuition > arr[mid]){
		low = mid+1;
	    }
	    else{
		high = mid-1;
	    }
	}
	return -16512;
    }
}
