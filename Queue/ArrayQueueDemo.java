package 算法.Queue;

import java.util.Scanner;
//用数组模拟队列
public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue arrqueue=new ArrayQueue(3);
        Scanner input=new Scanner(System.in);
        String n;
        boolean loop=true;
        while (loop){
            System.out.println("s(show)：显示所有数据");
            System.out.println("a(add)：向队列中添加一个数据");
            System.out.println("g(get)：取出队列头");
            System.out.println("h(head)：查看队列头");
            System.out.println("e(exit)：退出");
            n=input.next();
            switch (n){
                case "s":
                    arrqueue.showQueue();
                    break;
                case "a":
                    System.out.println("请输入一个数");
                    int value=input.nextInt();
                    arrqueue.addQueue(value);
                    break;
                case "g":
                    try {
                        int res=arrqueue.getQueue();
                        System.out.println("取出的数据是:"+res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "h":
                    try {
                        int res=arrqueue.headQueue();
                        System.out.println("队列的头数据为:"+res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "e":
                    input.close();
                    loop=false;
                    break;
                default:
                    break;
            }
        }

        System.out.println("程序退出");
    }
}

//用数组模拟队列
class ArrayQueue{
    private int maxSize;//表示数组最大容量
    private int front;//队列头
    private int rear;//队列尾
    private int[] arr;//该数组用于存储数据，模拟队列

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.arr=new int[maxSize];
        this.front = -1;
        this.rear = -1;
    }

    public boolean isEmpty(){//判断队列是否为空
        return front==rear;
    }

    public  boolean isFull(){//判断队列是否已满
        return rear==maxSize-1;
    }

    public void addQueue(int value){//向队列中添加一个数据
        if(isFull()){
            System.out.println("队列已满");
            return;
        }
        arr[++rear]=value;
    }

    public int getQueue(){//取出队列头
        if(isEmpty()){
            throw new RuntimeException("队列为空，不能取数据");
        }
        return arr[++front];
    }

    public void showQueue(){//显示所有数据
        if(isEmpty()){
            System.out.println("队列为空，没有数据");
            return;
        }
        for (int i=0;i<arr.length;i++){
            System.out.println("arr["+i+"]="+arr[i]);
        }
    }

    public int headQueue(){//查看队列头
        if(isEmpty()){
            throw new RuntimeException("队列为空，不能无头数据");
        }
        return arr[front+1];
    }


}

