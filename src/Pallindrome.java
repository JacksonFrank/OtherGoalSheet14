/*
 Jackson Frank
 File: Pallindrome.java
 Purpose: To check if two strings are the same word in opposite order
 */
public class Pallindrome {

	public static void main(String[] args) {
		String s1 = "hello";
		String s2 = "olleH";
		System.out.println(isReverse(s1, s2));

	}
	
	public static boolean isReverse(String _s1, String _s2) {
		String s1 = _s1.toLowerCase();
		String s2 = _s2.toLowerCase();
		
		if(s1.length() == 0 && s2.length() == 0) {
			return true;
		}
		else if(s1.length() == 1 && s2.length() == 1 && s1.equals(s2)) {
			return true;
		}
		else if(s1.charAt(0) == s2.charAt(s2.length()-1) && s1.charAt(s1.length()-1) == s2.charAt(0)) {
			return isReverse(s1.substring(1, s1.length()-1), s2.substring(1, s2.length()-1));
		}
		else {
			return false;
		}
	}

}
