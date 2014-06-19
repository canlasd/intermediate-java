
public abstract class MyAbstractList<E> implements MyList<E> {

	protected int listSize = 0;

	@Override
	public abstract void add(E element);

	public abstract void remove(int index);

	@Override
	public abstract E get(int index);

	@Override
	public int size() {
		return listSize;
	}

	@Override
	public String toString() {
		String toReturn = "";
		for (int i = 0; i < listSize; i++) {
			toReturn = toReturn + this.get(i).toString();
		}
		return toReturn;
	}

}
