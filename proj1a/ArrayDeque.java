public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;
    private final int rFactor = 3;

    /**
     * Constructor for ArrayDeque()
     */
    public ArrayDeque() {
        items = (T []) new Object[8];
        size = 0;
        nextFirst = 3;
        nextLast = 4;
    }

    /**
     * When array's size reach it's max capacity, then resize the array to the original size * rFactor
     *                   or when the size less than 1/4
     * @param capacity
     */
    private void resizeUp(int capacity) {
        T[] a = (T []) new Object[capacity];
        System.arraycopy(items, nextFirst+1, a, size, size - nextFirst-1);
        System.arraycopy(items, 0, a, 2*size - nextFirst - 1, nextFirst+1);
        items = a;
        nextFirst = size-1;
        nextLast = (rFactor-1)*size;
    }
    private void resizeDown(int capacity) {
            T[] a = (T []) new Object[capacity];
        System.arraycopy(items, nextFirst+1, a, 0,  size);
        items = a;
        nextFirst = items.length-1;
        nextLast = 0;
    }

    public void addFirst(T item) {
        if(size == items.length) {
            resizeUp(size * rFactor);
        }
        items[nextFirst] = item;
        size++;
        if(nextFirst == 0) {
            nextFirst = items.length -1;
        } else {
            nextFirst--;
        }
    }

    public void addLast(T item) {
        if(size == items.length) {
            resizeUp(size * rFactor);
        }
        items[nextLast] = item;
        size++;
        if(nextLast == items.length - 1) {
            nextLast = 0;
        } else {
            nextLast++;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        int tempF = nextFirst+1;
        int tempL = nextLast;
        while(tempF < items.length && items[tempF] != null) {
            System.out.print(items[tempF] + " ");
            tempF ++;
        }
        tempF = 0;
        while(tempF < nextLast) {
            System.out.print(items[tempF]);
            if (tempF != tempL - 1) {
                System.out.print(" ");
            }
            tempF++;
        }
    }

    public T removeFirst() {
        if(size == 0) {
            return null;
        }

        if(size == items.length / rFactor && size > 8) {
            resizeDown(items.length / rFactor);
        }

        if(nextFirst == items.length - 1) {
            nextFirst = 0;
        } else {
            nextFirst++;
        }
        T save = items[nextFirst];
        items[nextFirst] = null;
        size--;
        return save;
    }

    public T removeLast() {
        if(size == 0) {
            return null;
        }

        if(size == items.length / rFactor && size > 8) {
            resizeDown(items.length / rFactor);
        }

        if(nextLast == 0) {
            nextLast = items.length-1;
        } else {
            nextLast--;
        }
        T save = items[nextLast];
        items[nextLast] = null;
        size--;
        return save;
    }

    public T get(int index) {
        if(index < 0 || index >= size) {
            return null;
        }
        return items[index];
    }
}
