public class LinkedListDeque<T> {
    public class ListNode {
        private ListNode prev;
        private T item;
        private ListNode next;

        public ListNode(T i) {
            prev = null;
            item = i;
            next = null;
        }

        public ListNode(ListNode prevNode, T i, ListNode nextNode) {
            prev = prevNode;
            item = i;
            next = nextNode;
        }


    }
    private ListNode sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new ListNode(null);
        sentinel.next = sentinel.prev = sentinel;
        size = 0;
    }

    /**
     * add item to the front of the Deque
     * @param item
     */
    public void addFirst(T item) {
        sentinel.next = new ListNode(sentinel, item, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size++;
    }

    /**
     * add item to the end of the LinkedListDeque
      * @param item
     */
    public void addLast(T item) {
        sentinel.prev = new ListNode(sentinel.prev, item, sentinel);
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
        ListNode temp = sentinel.next;
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
        ListNode temp = sentinel.next;
        if (temp.item == null) {
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
        ListNode temp = sentinel.prev;
        if (temp.item == null) {
            return null;
        }
        T reVal = temp.item;
        size--;
        sentinel.prev = temp.prev;
        temp.prev.next = sentinel;
        return reVal;
    }

    public T get(int index) {
        if (index < size && index >= 0) {
            ListNode temp = sentinel;
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
     * @return the element in the given index recursively, if no such element,
     * return null
    */
    public T getRecursive(int index) {
        if (index <= 0) {
            return null;
        }
        ListNode firstNode = sentinel.next;
        return getRecursiveHelper(index, firstNode);
    }

    private T getRecursiveHelper(int index, ListNode current) {
        if (index <= 0) {
            return current.item;
        } else if (current == sentinel) {
            /** Returns null if index is out of bound */
            return null;
        }
        return getRecursiveHelper(index - 1, current.next);   /* better */
    }



}
