package com.abc.ds.integer;

/**
 * An array-backed implementation of the {@link IntDSSack} interface.
 */
public class ArrayIntDSSack implements IntDSSack {
    private static final int NOT_FOUND_INDEX = -1;
    
    private int[] slots;
    private int count;
    
    public ArrayIntDSSack() {
        slots = new int[1000];
        count = 0;
    }

    @Override
    public int count() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public void clear() {
        count = 0;
    }

    @Override
    public boolean add(int value) {
        slots[count] = value;
        count++;
        return true;
    }
    
    private int firstIndexOf(int value) {
        for ( int i = 0; i < count; i++ ) {
            if ( slots[i] == value ) {
                return i;
            }
        }
        return NOT_FOUND_INDEX;
    }
    
    @Override
    public boolean contains(int value) {
        return firstIndexOf(value) >= 0;
        //return firstIndexOf(value) != NOT_FOUND_INDEX;
    }

    @Override
    public boolean remove(int value) {
        int firstIndexOf = firstIndexOf(value);
        if ( firstIndexOf == NOT_FOUND_INDEX ) {
            return false;
        }
        
        for ( int i = firstIndexOf; i < count; i++ ) {
            slots[i] = slots[i + 1];
        }
        count--;
        
        return true;
    }
    
    @Override
    public IntDSIterator createIterator() {
        return new Iterator();
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for ( int i = 0; i < count; i++ ) {
            if ( i > 0 ) {
                sb.append(", ");
            }
            sb.append(slots[i]);
        }
        return sb.toString();
    }
    
    private class Iterator implements IntDSIterator {
        private int currentIndex;
        
        public Iterator() {
            currentIndex = -1;
        }
        
        @Override
        public boolean hasNext() {
            return (currentIndex + 1) < count;
        }
        
        @Override
        public int next() {
            currentIndex++;
            return slots[currentIndex];
        }
    } // class Iterator
}
