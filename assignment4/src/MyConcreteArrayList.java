import java.util.ArrayList;
public class MyConcreteArrayList<E>
    extends MyAbstractList<E>
    implements MyList<E>
{
    private ArrayList<E> myList;

    public MyConcreteArrayList()
    {
        myList = new ArrayList<E>(100);
    }

    public MyConcreteArrayList(int size)
    {
        myList = new ArrayList<E>(size);
    }

    public void add(E element)
    {
        myList.add(element);
        listSize++;
    }

    public void remove(int index)
    {
        listSize--;
        myList.remove(index);
    }

    public E get(int index)
    {
        return myList.get(index);
    }

	@Override
	public void remove(E element) {
		// TODO Auto-generated method stub
		
	}
}