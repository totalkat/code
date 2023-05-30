import java.io.*;
import java.util.*;

public class dfs{
    public static void main(String[] args) throws Exception {
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	int n = Integer.parseInt(in.readLine().trim());
	for(int i=0; i<n; i++){
	    String word = in.readLine();
	    System.out.println(dfs(word));
	}
    }
    public static int dfs(String word){
	HashSet<String> set=new HashSet<String>();
	set.add(word);
	List<AbstractMap.SimpleEntry<String,Integer>> arr = new ArrayList<AbstractMap.SimpleEntry<String,Integer>>();
	arr.add(new AbstractMap.SimpleEntry<String,Integer>(word,0));
	while(arr.size()!=0){
	    AbstractMap.SimpleEntry<String,Integer> pair = arr.get(0);
	    arr.remove(0);
	    String str = pair.getKey();
	    int counter = pair.getValue();
	    if(str.length()<3){
		continue;
	    }
	    if(str.equals("MOO")){
		return counter;
	    }
	    if(str.charAt(0)=='M'){
		StringBuilder sb= new StringBuilder(str);
		sb.setCharAt(0, 'O');
		String x = sb.toString();
		if(!set.contains(x)){
		    arr.add(new AbstractMap.SimpleEntry<String,Integer>(x,counter+1));
		    set.add(x);
		}
	    }
	    else if (str.charAt(0)=='O'){
		StringBuilder sb= new StringBuilder(str);
		sb.setCharAt(0, 'M');
		String x = sb.toString();
		if(!set.contains(x)){
		    arr.add(new AbstractMap.SimpleEntry<String,Integer>(x,counter+1));
		    set.add(x);
		}
	    }
	    if(str.charAt(str.length()-1)=='M'){
		StringBuilder sb= new StringBuilder(str);
		sb.setCharAt(str.length()-1, 'O');
		String x = sb.toString();
		if(!set.contains(x)){
		    arr.add(new AbstractMap.SimpleEntry<String,Integer>(x,counter+1));
		    set.add(x);
		}
	    }
	    else if (str.charAt(str.length()-1)=='O'){
		StringBuilder sb= new StringBuilder(str);
		sb.setCharAt(str.length()-1, 'M');
		String x = sb.toString();
		if(!set.contains(x)){
		    arr.add(new AbstractMap.SimpleEntry<String,Integer>(x,counter+1));
		    set.add(x);
		}
	    }
	    String x1 = str.substring(0,str.length()-1);
	    String x2 = str.substring(1,str.length());
	    if(!set.contains(x1)){
		arr.add(new AbstractMap.SimpleEntry<String,Integer>(x1,counter+1));
		set.add(x1);
	    }
	    if(!set.contains(x2)){
		arr.add(new AbstractMap.SimpleEntry<String,Integer>(x2,counter+1));
		set.add(x2);
	    }
	}
	return -1;
    }
}

