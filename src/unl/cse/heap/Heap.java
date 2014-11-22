package unl.cse.heap;

public interface Heap<T> {

	public T getTop();
	public T peekTop();
	public void insert(T item);
}
