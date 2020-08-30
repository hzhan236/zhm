public class ArrayDequeTest {
    public static void main(String[] args) {
        ArrayDeque<Integer> test1 = new ArrayDeque();
        for(int i = 0; i < 15; i++) {
            test1.addLast(i);
        }
        for (int i =0; i < 10;i++) {
            test1.removeFirst();
        }

        for (int i =0; i < 15;i++) {
            test1.addFirst(i);
        }

        for (int i =0; i < 10;i++) {
            test1.removeLast();
        }

        System.out.println(test1.size());
        test1.printDeque();
    }



}
