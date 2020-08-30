public class LinkedListDeque<T> {
    public class listNode {
        public listNode prev;
        public T item;
        public listNode next;

        public listNode(T i) {
            prev = null;
            item = i;
            next = null;
        }

        public listNode(listNode prevNode, T i, listNode nextNode) {
            prev = prevNode;
            item = i;
            next = nextNode;
        }


    }
    private listNode sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new listNode(null);
        sentinel.next = sentinel.prev = sentinel;
        size = 0;
    }

    /**
     * add item to the front of the Deque
     * @param item
     */
    public void addFirst(T item) {
        sentinel.next = new listNode(sentinel, item, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size++;
    }

    /**
     * add item to the end of the LinkedListDeque
      * @param item
     */
    public void addLast(T item) {
        sentinel.prev = new listNode(sentinel.prev, item, sentinel);
        sentinel.prev.prev.next = sentinel.prev;
        size++;
    }

    /**
     * check if the Deque is empty or not
     * return true if empty, false otherwise
     */
    public boolean isEmpty() {
        return (sentinel.next == sentinel && sentinel.prev == sentinel);
    }

    /**
     *
     * @return : the size of the array
     */
    public int size() {
        return size;
    }

    /**
     * print out each element of the Deque
     */
    public void printDeque() {
        listNode temp = sentinel.next;
        while (temp.item != null) {
            System.out.print(temp.item);
            if (temp.next != temp) {
                System.out.print(" ");
            }
            temp = temp.next;
        }
        System.out.println();
    }

    /**
     * remove the fist element
      * @return the element removed
     */
    public T removeFirst() {
        listNode temp = sentinel.next;
        if(temp.item == null) {
            return null;
        }
        T reVal = temp.item;
        size--;
        sentinel.next = temp.next;
        temp.next.prev = sentinel;
        return reVal;
    }

    /**
     * remove the last element in Deque
     * @return the element been removed
     */
    public T removeLast() {
        listNode temp = sentinel.prev;
        if(temp.item == null) {
            return null;
        }
        T reVal = temp.item;
        size--;
        sentinel.prev = temp.prev;
        temp.prev.next = sentinel;
        return reVal;
    }

    public T get(int index) {
        if(index < size && index >= 0) {
            listNode temp = sentinel;
            if (index <= size / 2) {
                for (int i = 0; i <= index; i++) {
                    temp = temp.next;
                }
                return temp.item;
            } else {
                for (int i = 0; i < size - index; i++) {
                    temp = temp.prev;
                }
                return temp.item;
            }
        }
        return null;
    }

    /**
     *
     * @param index
     * @return the element in the given index recursively, if no such element, return null
     */
    public T getRecursive(int index) {
            if(index >= size || index < 0) {
                return null;
            }
            if(index <= size /2) {
                listNode current = getRecursive(index, sentinel.next);
                return current.item;
            } else {
                listNode current = getRecursive(index, sentinel.prev);
                return current.item;
            }
    }
    private listNode getRecursive(int index, listNode cur) {
        if(index == 0 || index == size-1) {
            return cur;
        }
        if (index <= size /2) {
            return getRecursive(index - 1, cur.next);
        } else {
            return getRecursive(index + 1, cur.prev);
        }
    }


}
