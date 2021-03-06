package unl.cse.heap;

public class TreeNode<T> {

    private T value;
    private TreeNode<T> leftChild;
    private TreeNode<T> rightChild;
    private TreeNode<T> parent;

    public TreeNode(T value) {
        this(value, null);
    }

    public TreeNode(T value, TreeNode<T> parent) {
        this.value = value;
        this.parent = parent;
        this.rightChild = null;
        this.leftChild = null;
    }

    public void setParent(TreeNode<T> parent) {
        this.parent = parent;
    }

    public TreeNode<T> getParent() {
        return this.parent;
    }
    
    public boolean hasParent() {
    	return this.parent != null;
    }

    public void setLeftChild(TreeNode<T> leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode<T> getLeftChild() {
        return this.leftChild;
    }
    
    public boolean hasLeftChild() {
    	return (this.leftChild != null);
    }

    public void setRightChild(TreeNode<T> rightChild) {
        this.rightChild = rightChild;
    }

    public TreeNode<T> getRightChild() {
        return this.rightChild;
    }
    
    public boolean hasRightChild() {
    	return (this.rightChild != null);
    }

    public T getValue() {
        return this.value;
    }
    
    public void setValue(T item) {
    	this.value = item;
    }
    
    @Override
    public String toString() {
    	return "(" + this.value + ")";
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((leftChild == null) ? 0 : leftChild.hashCode());
		result = prime * result + ((parent == null) ? 0 : parent.hashCode());
		result = prime * result
				+ ((rightChild == null) ? 0 : rightChild.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TreeNode other = (TreeNode) obj;
		if (leftChild == null) {
			if (other.leftChild != null)
				return false;
		} else if (!leftChild.equals(other.leftChild))
			return false;
		if (parent == null) {
			if (other.parent != null)
				return false;
		} else if (!parent.equals(other.parent))
			return false;
		if (rightChild == null) {
			if (other.rightChild != null)
				return false;
		} else if (!rightChild.equals(other.rightChild))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
    

}
