package JianZhiOffer;

/**
 * @ClassName Queue
 * @Description TODO
 * @Author Zhang Peixin
 * @Date 2021/11/12 20:21
 * @Version 1.0
 */
public class Queue {
    public static void main(String[] args) {
        QueueArr queue = new QueueArr(10);
        for (int i = 0; i < 10; i++) {
            queue.add(i + 1);
        }

        //System.out.println(queue.size());
        queue.show();
        System.out.println("==========");

        queue.show();
        System.out.println(queue.get() + "\t" + queue.get() + "\t" + queue.get());
        queue.show();
        System.out.println(queue.size());
    }

}

//创建一个数组来模拟队列
/*
    队列里面需要包括头指针front，尾指针rear，数组arr，数组的大小maxSize
 */
class QueueArr {
    private int front;
    private int rear;
    private int[] arr;
    private int maxSzize;

    //构造器，初始化队列信息
    public QueueArr(int maxSzize) {
        this.maxSzize = maxSzize;//传递一个数组的长度
        front = -1;
        rear = -1;
        arr = new int[maxSzize];//定义数组的长度
    }

    //1.判空
    public boolean isEmpty() {
        return rear == front;
    }

    //2.判满
    public boolean isFull() {
        return rear == maxSzize - 1;
    }
    //3.添加数据

    /**
     * 添加数据的时候，需要对队列进行判断，判断是否已经满了，满了就返回
     * 没有满就进行数据添加，添加数据的原则是rear移动，front不动
     *
     * @param data 表示想要添加到队列的的数据
     */
    public void add(int data) {
        //添加数据之前，判断碎队列是否已满
        if (isFull()) {
            System.out.println("队列已满");
            return;
        }
        //如果没有满，就让rear指针移动一位，在进行添加
        rear++;
        arr[rear] = data;
    }

    /**
     * 取出数据操作：
     * 1.先判断队列是否为空，为空就返回
     * 如果不为空就可以取数据
     * 取数据的时候是rear指针不动，front指针移动
     */
    //4.取出数据
    public int get() {
        //判断队列是否为空
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        //不为空的话，就进行取数据
        front++;
        return arr[front];
    }

    //5.显示队列中的有效个数
    public int size() {
        return (rear - front + maxSzize) % maxSzize;
    }

    //6.显示队列
    public void show() {
        //对队列进行遍历,遍历的范围是头指针到尾指针
        if (!isEmpty()) {
            for (int i = front + 1/*front + 1*/; i < rear + 1 /*front+1+size()*/; i++) {//两种写法
                System.out.println("arr[" + i + "]=" + arr[i]);
            }
        } else {
            System.out.println("队列为空！");
            return;
        }
    }
}
