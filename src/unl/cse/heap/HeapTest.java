package unl.cse.heap;

import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class HeapTest {

	public static void main(String args[]) {

		Comparator<Integer> c = new Comparator<Integer>() {
			public int compare(Integer a, Integer b) {
				return a - b;
			}
		};
		TreeHeap<Integer> h1 = new TreeHeap<Integer>(c);
		ArrayHeap<Integer> h2 = new ArrayHeap<Integer>(c);

//		List<Integer> test = Arrays.asList(22, 24, 68, 78, 60, 95);
//		for(Integer i : test) {
//			h1.insert(i);
//			h2.insert(i);
//		}
//		List<Integer> l1 = h1.breadthFirstSearch();
//		List<Integer> l2 = h2.breadthFirstSearch();
//		System.out.println("match?\n\t"+l1+"\n\t"+l2);
//		for(int i=0; i<test.size(); i++) {
//			Integer a = h1.getTop();
//			Integer b = h2.getTop();
//			System.out.println("a, b = " + a + ", " + b);
//			l1 = h1.breadthFirstSearch();
//			l2 = h2.breadthFirstSearch();
//			System.out.println("match?\n\t"+l1+"\n\t"+l2);			
//		}
		
		for(int i=10; i<=100; i+=10) {
			h1.insert(i);
			h2.insert(i);
		}
		for(int i=0; i<10; i++) {
			List<Integer> l1 = h1.breadthFirstSearch();
			List<Integer> l2 = h2.breadthFirstSearch();
			System.out.println("match?\n\t"+l1+"\n\t"+l2);
			h1.getTop();
			h2.getTop();
		}

		//random tests
		int n = 1000;
		Random r = new Random();
		for(int i=0; i<n; i++) {
			double d = r.nextDouble();
			if(d > 0.2) {
				int x = r.nextInt(100);
				h1.insert(x);
				h2.insert(x);
			} else {
				Integer a = h1.getTop();
				Integer b = h2.getTop();
				if(a != b) {
					throw new IllegalStateException("values do not match: "+a + ", " + b);
				}
			}
			List<Integer> l1 = h1.breadthFirstSearch();
			List<Integer> l2 = h2.breadthFirstSearch();
			if(!l1.equals(l2)) {
				throw new IllegalStateException("values do not match: \n\t"+l1+"\n\t"+l2);
			} else {
				System.out.println("match!\n\t"+l1+"\n\t"+l2);
			}
		}
	}
}
