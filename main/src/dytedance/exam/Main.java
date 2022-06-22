package dytedance.exam;

import javax.swing.text.html.HTML;
import java.util.*;

/*

 */
public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
//        test3();
//        test4();
//        test5();
//        test6();
//        test7();
       test08();
    }

    /**
     * 二维n*n行列式：第一行表示行数
     */
    static void test1() {
        int height = sc.nextInt();
        int width = height;
        int[][] myArray = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                myArray[i][j] = sc.nextInt();
            }
        }
        System.out.println();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(myArray[i][j] + " ");
            }
            System.out.println();

        }


    }

    static void test2() {
        String strings = sc.nextLine();
        String[] split = strings.split(" ");
        int[] spiltInt = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            spiltInt[i] = Integer.parseInt(split[i]);
        }
        System.out.println(Arrays.toString(spiltInt));
    }

    static void test3() {
        int row = sc.nextInt();

        int[] arr = new int[row];
        for (int i = 0; i < row; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");

        }
    }

    /**
     * 第一行表示：输入数组的长度
     * 第二行表示数组的元素，用空格隔开
     */
    static void test4() {
        int len = sc.nextInt();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < len; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static void test5() {

        int len = sc.nextInt();

        String[] str = new String[len];
        String s = sc.nextLine();//开启下一行
        //s==null;
        for (int i = 0; i < str.length; i++) {
            str[i] = sc.nextLine();
        }
        for (int i = 0; i < str.length; i++) {
            System.out.print(str[i] + " ");
        }

    }

    static void test6() {
        int N = sc.nextInt();
        int D = sc.nextInt();

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static void test7() {
        //输入数组和n
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();//开启下一行
        int T = Integer.parseInt(line);
        int Max = 1000;//？
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < T; i++) {//T组测试数据
            Queue1 queue = new Queue1(Max);//一个队列反复操作 则需要环形队列
            String line1 = sc.nextLine();
            int Q = Integer.parseInt(line1);//Q次操作
            for (int j = 0; j < Q; j++) {//Q次操作   把需要打印的操作的结果存放到一个数组res中 最后轮流换行打印输出
                String s = sc.nextLine();
                String[] s1 = s.split(" ");
                switch (s1[0]) {
                    case "PUSH": //插入队尾元素无返回
                        queue.push(s1[1]);
                        break;
                }
                switch (s1[0]) {
                    case "SIZE": //队列大小
                        res.add(queue.size());
                        break;
                }
                switch (s1[0]) {
                    case "TOP": //队列首元素查询
                        res.add(queue.top());
                        break;
                }
                switch (s1[0]) {
                    case "POP": //删除队首元素
                        if (queue.pop() != null) {
                            res.add(queue.pop());
                        }
                        break;
                }
                switch (s1[0]) {
                    case "CLEAR":
                        queue.clear();//清空队列 无返回
                        break;
                }
            }


        }
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
static void  test08(){
    HTML html = new HTML();

    System.out.println( html);
}

}

class Queue1 {

    private int Maxsize;
    private int front;//指向队首
    private int rear;//指向队尾元素的后一个位置 初值为0
    private int[] arr;//存放数据

    public Queue1(int maxsize) {
        Maxsize = maxsize;
        arr = new int[Maxsize];//数组不初始化，就是null 也无索引也无0
        front = 0;
        rear = 0;
    }

    public void push(String s) {
        int x = Integer.parseInt(s);
        arr[rear] = x;
        rear = (rear + 1) % Maxsize;
    }

    public Integer size() {
        return (rear - front + Maxsize) % Maxsize;
    }

    public Integer top() {
        if (rear == front) {//为空无法取出
            return -1;
        }
        return arr[front];
    }

    public Integer pop() {
        if (rear == front) { //为空无法删除
            return -1;
        }
        front = (front + 1) % Maxsize;//注意是加1取模  不改变arr 这就算删除队列一个元素了
        return null;
    }

    public void clear() {
        rear = front;//清空队列？？
    }

}

