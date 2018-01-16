package test.test;

public class GetByte {
	
	public static String[] splitLetter(String str) {
		int length = str.length();
		return str.split("");
	}
	
	public static void iterateChar(String str) {
		int length = str.length();
		for(int i=0; i<length; i++) {
			System.out.println(str.charAt(0));
		}
	}
	
	public static void main(String[] args) {
		
		String str = "ສະບາຍດີ";
		
		int length = str.length();
		
		System.out.println(length);
		byte[] bt = str.getBytes();
		System.out.println(bt.length);
		
		char[] ch = str.toCharArray();
		int ix = 0;
		for(char c : ch) {
			System.out.println(c);
			byte[] bts = (c+"").getBytes();
			System.out.println(ix+": "+bts.length);
			ix++;
		}

	}
}
