package pl.sggw;

import java.util.ListIterator;

class CustomListIterator<T> implements ListIterator<T>
{

    private ListIterator<T> underlying;

    public CustomListIterator(ListIterator<T> underlying) {
        this.underlying = underlying;
    }

    @Override
    public boolean hasNext() {
        return underlying.hasNext();
    }

    @Override
    public T next() {
        return underlying.next();
    }

    @Override
    public boolean hasPrevious() {
        return underlying.hasPrevious();
    }

    @Override
    public T previous() {
        return underlying.previous();
    }

    @Override
    public int nextIndex() {
        return underlying.nextIndex();
    }

    @Override
    public int previousIndex() {
        return underlying.previousIndex();
    }

    @Override
    public void remove() {
        underlying.remove();
    }

    @Override
    public void set(T t) {
        if (t == null) {return;}
        underlying.set(t);
    }

    @Override
    public void add(T t) {
        if (t == null) {return;}
        underlying.add(t);
    }
}
