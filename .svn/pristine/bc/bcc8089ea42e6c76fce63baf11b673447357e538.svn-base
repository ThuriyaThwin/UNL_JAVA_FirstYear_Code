package unl.cse.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class TreeHeap<T> implements Heap<T> {
	
	private TreeNode<T> root;
	private TreeNode<T> last;
	private int size;
    private final Comparator<T> cmp;	
	
    public TreeHeap(Comparator<T> cmp) {
    	this.root = null;
    	this.last = null;
    	this.size = 0;
    	this.cmp = cmp;
    }

	@Override
	public T getTop() {
		T item = null;
		if(root == null) { 
			item = null;
		} else if(this.size == 1) {
			item = this.root.getValue();
			this.root = null;
			this.last = null;
			this.size--;
		} else {
			item = this.root.getValue();
			//promote last element:
			this.root.setValue(last.getValue());
			//remove the last element:
			//d = depth of the heap
			int d = (int) Math.floor(Math.log(this.size) * 1.44269504089); //log_2(n)
			if(this.last.getParent().getRightChild() == this.last) {
				//last is a right child, update last to its sibling
				this.last = this.last.getParent().getLeftChild();
				this.last.getParent().setRightChild(null);
				this.size--;
			} else if(this.size == (1 << d)) {
				//the last is the last in level d
				//traverse all the way right
				TreeNode<T> curr = this.root;
				while(curr.hasRightChild()) {
					curr = curr.getRightChild();
				}
				this.last.getParent().setLeftChild(null);
				this.last = curr;
				this.size--;
			} else {
				//TODO: this was the bug: item = this.root.getValue();
				//promote last element:
				this.root.setValue(last.getValue());
				//remove the last (now empty) node:
				last.getParent().setLeftChild(null);
				this.size--;
				//need to find the last
				//m = number of nodes at level d
				int m = this.size - ((1 << d) - 1); // m = n - (2^d - 1);
				//the new last node will necessarily be a right child...
				TreeNode<T> curr = this.root;
				while(curr.hasRightChild()) {
					int half = (1 << (d-1));
					if( m > half) {
						//sub-tree is more than half full, traverse right to 
						//find the new last node:
						curr = curr.getRightChild();
						d--;
						m = m - half;
					} else {
						//sub-tree is half or less than full, traverse left to find the
						//new last node
						curr = curr.getLeftChild();
						d--;
					}
				}
				this.last = curr;
			}
		}
		
		//heapify...
		TreeNode<T> curr = this.root;
		while(curr != null) {
			TreeNode<T> minChild = curr.getLeftChild();
			if(curr.getLeftChild() != null 
				&& curr.getRightChild() != null
				&& this.cmp.compare(curr.getLeftChild().getValue(), curr.getRightChild().getValue()) > 0) {
				minChild = curr.getRightChild();
			}
			if(minChild != null) {
				//swap with the min child
				T tmp = curr.getValue();
				curr.setValue(minChild.getValue());
				minChild.setValue(tmp);
			}
			curr = minChild;
		}

		return item;
	}

	@Override
	public T peekTop() {
		return (this.root == null) ? null : this.root.getValue();
	}

	@Override
	public void insert(T item) {
		
		if(item == null) {
			throw new IllegalArgumentException("heap implementation does not allow null elements");
		}

		TreeNode<T> node = new TreeNode<T>(item);
		if(root == null) {
			this.root = node;
			this.last = node;
		} else if(last == root) {
			this.root.setLeftChild(node);
			node.setParent(this.root);
			this.last = node;
		} else if (last.getParent().getLeftChild() == last){
			//last is a left child; its parent is able to handle node as a right-child
			this.last.getParent().setRightChild(node);
			node.setParent(this.last.getParent());
			this.last = node;
		} else {
			//need to find the last open spot and insert...
			//d = depth of the heap
			int d = (int) Math.floor(Math.log(this.size) * 1.44269504089); //log_2(n)
			if( ((1 << (d+1)) - 1) == this.size) {
				//heap is full, traverse all the way left:
				TreeNode<T> curr = root;
				while(curr.hasLeftChild()) {
					curr = curr.getLeftChild();
				}
				curr.setLeftChild(node);
				node.setParent(curr);
				this.last = node;
			} else {
				//heap is not full, need to find the last element
				//m = number of nodes at level d
				int m = this.size - ((1 << d) - 1); // m = n - (2^d - 1);
				//want to insert at level d (root is at level 0)
				TreeNode<T> curr = this.root;
				while(curr.hasLeftChild()) {
					int half = (1 << (d-1));
					if( m >= half) {
						//sub-tree is more than half full, traverse right:
						curr = curr.getRightChild();
						d--;
						m = m - half;
					} else {
						//sub-tree is less than half full, traverse left:
						curr = curr.getLeftChild();
						d--;
					}
				}
				//insert as left-child of current node
				curr.setLeftChild(node);
				node.setParent(curr);
				this.last = node;
			}
		}

		//Heapify: from the last node up, correct the heap
		TreeNode<T> curr = this.last;
		while(curr.hasParent() && this.cmp.compare(curr.getParent().getValue(), curr.getValue()) > 0) {
			//swap them
			T temp = curr.getValue();
			curr.setValue(curr.getParent().getValue());
			curr.getParent().setValue(temp);
			curr = curr.getParent();
		}
		
		this.size++;
		return;
	}
	
	public List<T> breadthFirstSearch() {
		List<T> l = new ArrayList<T>();
		if(this.root != null) {
			Deque<TreeNode<T>> q = new LinkedList<TreeNode<T>>();
			q.addLast(this.root);
			while(!q.isEmpty()) {
				TreeNode<T> curr = q.pollFirst();
				if(curr.getLeftChild() != null) {
					q.addLast(curr.getLeftChild());
				}
				if(curr.getRightChild() != null) {
					q.addLast(curr.getRightChild());
				}
				l.add(curr.getValue());
			}
		}
		return l;
	}
	
	public String toString() {
		return this.breadthFirstSearch().toString();
	}

    public String toTikzString() {
    	
        StringBuilder sb = new StringBuilder();
        sb.append("\\begin{tikzpicture}[transform shape,scale=0.5,level distance=1cm,level/.style={sibling distance=16cm/#1}]\n");
        if(this.root == null) {
        	sb.append("\\node{\\texttt{null}};");
        } else {
        	sb.append("\\node{"+this.root.getValue()+"}\n");
        	this.toTikzStringRec(this.root.getLeftChild(), sb);
        	this.toTikzStringRec(this.root.getRightChild(), sb);
        	sb.append(";\n");
        }
        sb.append("\\end{tikzpicture}\n\n");
        return sb.toString();
    }
    
    private void toTikzStringRec(TreeNode<T> u, StringBuilder sb) {
    	if(u == null) {
    		sb.append("child[draw opacity=0.0] {}\n");
    	} else {
    		sb.append("child {node {"+u.getValue()+"} \n");
    		this.toTikzStringRec(u.getLeftChild(), sb);
    		this.toTikzStringRec(u.getRightChild(), sb);
    		sb.append("}\n");
    	}
    }

}
