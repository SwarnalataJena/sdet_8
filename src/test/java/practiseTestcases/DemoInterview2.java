package practiseTestcases;

public class DemoInterview2 {
	public static void main(String[] args) {
		String str="pavan123";
	    int count=0;
	    String s="";
	    for(int i=0;i<str.length();i++)
	    {
	    	char ch = str.charAt(i);
	    	if(ch<='9' && ch>='0')
	    	{
	    		s=s+ch;
	    		count++;
	    	}
	    	System.out.println(s);
	    }
	    System.out.println(count);
	   
	    
	}

}
