package pl.sggw;

import java.util.Iterator;

class CustomIterator<T> implements Iterator<T>
{
    Integer index = 0;
    WzimList<T> l;
    public CustomIterator(WzimList<T> ts) {
        l = ts;
    }

    @Override
    public boolean hasNext() {
        return index < l.size();
    }

    @Override
    public T next() {
        index += 1;
        return l.get(index - 1);
    }

    @Override
    public void remove() {
        l.remove(this);
    }
}