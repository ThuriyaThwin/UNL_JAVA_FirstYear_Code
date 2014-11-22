package unl.cse.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ArrayHeap<T> implements Heap<T> {

	private T[] arr;
	private int size;
	private final Comparator<T> cmp;

	@SuppressWarnings("unchecked")
	public ArrayHeap(Comparator<T> comparator) {
		this.cmp = comparator;
		this.arr = (T[]) new Object[1024];
		this.size = 0;
	}
	
	@Override
	public T peekTop() {
		return this.arr[size];
	}

	@Override
	public T getTop() {
		if(this.size == 0) {
			return null;
		}

		//save the top
		T result = arr[1];
		
		//promote the last element
		arr[1] = arr[size];
		arr[size] = null;
		size--;
		
		//heapify
		int i = 1;
		while(i <= size) {
			int minChildIndex = 2*i;
			if( (2*i+1) <= this.size 
				&& this.cmp.compare(this.arr[2*i], this.arr[2*i+1]) > 0) {
				//the right child exists and is lesser, so use it
				minChildIndex = 2*i + 1;
			}
			if(minChildIndex <= size) {
				//swap min child and current
				T tmp = arr[i];
				arr[i] = arr[minChildIndex];
				arr[minChildIndex] = tmp;
			}
			i = minChildIndex;
		}

		
		return result;
	}
	
	public void insert(T item) {
		if(item == null)
			throw new IllegalArgumentException("This Heap implementation does not allow null values");
		
		//add to the end of the list:
		if(this.arr.length == this.size + 1) {
			this.arr = Arrays.copyOf(this.arr, this.arr.length * 2);
		}
		this.arr[size + 1] = item;
		this.size++;

		//heapify
		int i = this.size;
		int parent = i/2;

		while(parent >= 1 && this.cmp.compare(arr[i], arr[parent]) < 0) {
			T tmp = arr[i];
			arr[i] = arr[parent];
			arr[parent] = tmp;
			i = parent;
			parent = i/2;
		}
	}
	
	public List<T> breadthFirstSearch() {
		List<T> l = new ArrayList<T>();
		if(this.size > 0) {
			Deque<Integer> q = new LinkedList<Integer>();
			q.addLast(1);
			while(!q.isEmpty()) {
				int index = q.pollFirst();
				T item = this.arr[index];
				if( (index * 2) <= this.size ) {
					q.addLast(index * 2);
				}
				if( (index * 2 + 1) <= this.size ) {
					q.addLast(index * 2 + 1);
				}
				l.add(item);
			}
		}
		return l;
	}
	
	@Override
	public String toString() {
		return this.breadthFirstSearch().toString();
	}
	
    public String toTikzString() {
    	
        StringBuilder sb = new StringBuilder();
        sb.append("\\begin{tikzpicture}[level distance=1cm,level/.style={sibling distance=2cm/#1}]\n");
        if(this.size == 0) {
        	sb.append("\\node{\\texttt{null}};");
        } else {
        	sb.append("\\node{"+this.arr[1].toString()+"}\n");
        	this.toTikzStringRec(2, sb);
        	this.toTikzStringRec(3, sb);
        	sb.append(";\n");
        }
        sb.append("\\end{tikzpicture}\n\n");
        return sb.toString();
    }
    
    private void toTikzStringRec(int i, StringBuilder sb) {
    	if(i > this.size) {
    		sb.append("child[draw opacity=0.0] {}\n");
    	} else {
    		sb.append("child {node {"+this.arr[i].toString()+"} \n");
    		this.toTikzStringRec(2*i, sb);
    		this.toTikzStringRec(2*i+1, sb);
    		sb.append("}\n");
    	}
    }

}
