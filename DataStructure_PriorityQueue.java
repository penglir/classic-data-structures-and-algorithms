import java.util.*;

public class DataStructure_PriorityQueue {
    public static void priorityQueueTest() {
        // 1st way to create a PriorityQueue with custom comparator
        Comparator<Integer> comparator = new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2); // ascending 升序
            }
        };
        Queue<Integer> queue1 = new PriorityQueue<>(comparator);

        // 2nd way to create a PriorityQueue with custom comparator
        Queue<Integer> queue2 = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1); // descending 降序
            }
        });


        for (int i = 1; i <= 10; i++) {
            queue1.offer(i);
            queue2.offer(i);
        }
        while (!queue1.isEmpty()) {
            System.out.print(queue1.poll() + " ");
        }
        System.out.println();
        while (!queue2.isEmpty()) {
            System.out.print(queue2.poll() + " ");
        }
    }
    public static void main(String[] args) {
        priorityQueueTest();
    }
}
