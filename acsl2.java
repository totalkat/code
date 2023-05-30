import java.io.*;
import java.util.*;
 
public class acsl2 {
    public static void main(String[] args) throws Exception {
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	String s = in.readLine().trim();
	String line  ="";
	for(int i=0; i<s.length(); i++){
	    int ascii = (int)s.charAt(i);
	    line+=String.format("%8s", Integer.toBinaryString(ascii)).replaceAll(" ", "0");
	}
	boolean cont = true;
	int counter=0;
	while(cont){
	    String binary = Integer.toBinaryString(counter);
	    System.out.println("count " + counter + " binary " + binary);
	    System.out.println(foundfirst(line,binary) + " " + foundlast(line,binary));
	    if(foundfirst(line,binary)==-1 && foundlast(line,binary)==-1){
		System.out.println(counter-1);
		System.out.println("D");
		cont=false;
		break;
	    }
	    if(foundfirst(line,binary)>-1 && foundfirst(line,binary) == foundlast(line,binary)){
		System.out.println("A");
		remove(line,binary,foundfirst(line,binary));
	    }
	    else{
		if(foundfirst(line,binary)>-1){
		    System.out.println("B");
		    line = remove(line,binary,foundfirst(line,binary));
		}
		if(foundlast(line,binary)>-1){
		    System.out.println("C");
		    line = remove(line,binary,foundlast(line,binary));
		}
	    }
	    counter++;
 	    System.out.println("- "+line);
	}
    }
    public static int foundfirst(String line, String num){
	return line.indexOf(num);
    }
    public static int foundlast(String line, String num){
	return line.lastIndexOf(num);
    }
    public static String remove(String str, String word, int index)
    {
	String a = str.substring(0,index);
	String b= str.substring(index+word.length(),str.length()+1);
	return a+b;
 

    }
}
	
