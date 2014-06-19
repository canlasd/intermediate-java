
public interface MyList<E> {

	// this defines the methods to be used

	public void add(E element);

	// the add method will ad an item to the end of the list

	public void remove(E element);

	// this method will remove item at the specified location on the list
	// moving the item one position to the left
	// @param index the location at which to remove the element

	public E get(int index);

	// this is the get method will return the item specified location in the
	// list
	// @ param index the location of the element to return

	public int size();

	// the size method will return the size of the list

	@Override
	public String toString();

	// The toString method will return a string containing the contents of the
	// list

}
