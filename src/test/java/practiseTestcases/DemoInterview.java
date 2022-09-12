package practiseTestcases;

public class DemoInterview {
	public static void main(String[] args) {
		String str="58951223";
		String s=str.substring(0, 1).toUpperCase();
		for(int i=0;i<str.length();i++)
		{

			if(str.substring(0, 1).equals(s) && str.length()==8)
			{
				char ch = str.charAt(i);
				if((ch<='9' && ch>='0')||(ch>='a'||ch<='z'||ch<='Z'||ch>='A')||(!((ch<='9'&&ch>='0')||ch>='a'||ch<='z'||ch<='Z'||ch>='A')))
				{
					System.out.println("welcome");					
				}
			}
		}
	}

}
