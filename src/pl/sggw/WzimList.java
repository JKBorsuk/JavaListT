package pl.sggw;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

class WzimList<T> implements List<T>, Iterable<T>
{
    private T[] array;
    private Integer Length = 0;

    public WzimList()
    {
        array = (T[]) new Object[0];
    }
    public WzimList(T[] array)
    {
        this.array = array;
    }
    @Override
    public int size() {
        return Length;
    }

    @Override
    public boolean isEmpty() {
        return size() > 0 ? false : true;
    }

    @Override
    public boolean contains(Object o) {
        for(Integer j = 0; j < size(); j++)
        {
            if(o == array[j])
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new CustomIterator<>(this);
    }

    @Override
    public Object[] toArray() {
        return array;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) { // ??
        return a;
    }

    @Override
    public boolean add(T t) {
        array = Arrays.copyOf(array, Length + 1);
        array[Length] = t;
        Length = array.length;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if(this.isEmpty())  return false;

        int index = Integer.MAX_VALUE;
        for(Integer j = 0; j < Length; j++) {
            if (o == array[j]) index = j;
        }
        if(index == Integer.MAX_VALUE) return false;

        remove(index);
        Length = array.length;

        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for(int j = 0; j < c.toArray().length; j++)
        {
            if(!this.contains((Object)(c.toArray())[j])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        array = Arrays.copyOf(array, size() + c.toArray().length);
        for(int j = 0; j < c.toArray().length; j++)
        {
            this.add((T)c.toArray()[j]);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        Integer pom = size() + c.size();
        T[] pom1 = Arrays.copyOf(array,index);
        T[] pom2 = Arrays.copyOfRange(array,index,size());

        array = pom1;
        Length = array.length;

        for(int j = 0; j < c.toArray().length; j++)
        {
            this.add((T)c.toArray()[j]);
        }
        for(int j = 0; j < pom2.length; j++)
        {
            this.add(pom2[j]);
        }

        Length = array.length;
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {

        for(int j = 0; j < c.toArray().length; j++)
        {
            if(!this.remove(c.toArray()[j])) {
                System.out.println(c.toArray()[j] + " does not exist in the List or the List is empty" + '\n');
            }
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) { // czesc wspolna
        WzimList<T> pom = new WzimList<T>();
        for(int j = 0; j < c.toArray().length; j++)
        {
            if(contains(c.toArray()[j])) {
                pom.add((T)c.toArray()[j]);
            }
        }
        array = (T[]) pom.toArray();
        Length = array.length;
        return true;
    }

    @Override
    public void clear() {
        array = Arrays.copyOf(array,0);
    }

    @Override
    public T get(int index) {
        return array[index];
    }

    @Override
    public T set(int index, T element) {
        T pom = array[index];
        array[index] = element;
        return pom;
    }

    @Override
    public void add(int index, T element) {
        T[] pom1 = Arrays.copyOf(array,size());

        T[] pom2 = Arrays.copyOf(array,index);
        array = pom2;
        add(element);

        for(Integer j = index + 1; j < size(); j++)
        {
            add(pom1[j]);
        }
        Length = array.length;
    }

    @Override
    public T remove(int index) {
        T pom = array[index];
        if(index == 0)
        {
            array = Arrays.copyOfRange(array,1,Length);
            return pom;
        }
        else if (index == Length - 1)
        {
            array = Arrays.copyOfRange(array,0,Length-1);
            return pom;
        }
        else {
            T[] pom1 = Arrays.copyOfRange(array, 0, index);
            T[] pom2 = Arrays.copyOfRange(array, index + 1, Length);

            array = pom1;
            Length = array.length;

            for (int j = 0; j < pom2.length; j++) {
                add(pom2[j]);
            }
            Length = array.length;
        }
        return pom;
    }

    @Override
    public int indexOf(Object o) {
        for(Integer j = 0; j < size(); j++)
        {
            if(o.equals(array[j])) return j;
        }
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        Integer pom = 0;
        for(Integer j = 0; j < size(); j++)
        {
            if(o == array[j]) pom = j;
        }
        return pom;
    }

    @Override
    public ListIterator<T> listIterator() {
        return new CustomListIterator<T>(listIterator());
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return new CustomListIterator<T>(this.listIterator(index));
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        WzimList<T> lista = new WzimList<T>(Arrays.copyOfRange(array,fromIndex,toIndex + 1));
        return (List<T>)lista;
    }

}