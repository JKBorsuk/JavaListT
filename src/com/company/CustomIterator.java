package com.company;

import java.util.Iterator;

class CustomIterator<T> implements Iterator<T>
{
    Integer index = 0;
    Lista<T> l;
    public CustomIterator(Lista<T> ts) {
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