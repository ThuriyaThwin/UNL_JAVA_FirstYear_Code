package unl.cse.strings;

public class ComparisonDemo {

	public static void main(String args[]) {
		String strs[] = {"foo", "bar", "baz", "abba", "aaa", "aaaa"};
		
		for(int i=0; i<strs.length; i++) {
			for(int j=i+1; j<strs.length; j++) {
				System.out.printf("%6s %6s %d\n", strs[i], strs[j], strs[i].compareTo(strs[j]));
			}
		}
	}
}
