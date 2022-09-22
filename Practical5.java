// Program to demonstrate Producer-Consumer problem using Semaphore.
import java.util.concurrent.Semaphore;
class Queue
{
    int item;
    static Semaphore semCon = new Semaphore(0);
    static Semaphore semProd = new Semaphore(1);
    
    void get()
    {
        try
        {
                semCon.acquire();
        }
        catch(InterruptedException e)
        {
            System.out.println("InterruptedException caught");
        }
        System.out.println("Consumer consumed item: "+item);
        semProd.release();
    }
    
    void put(int item)
    {
        try
        {
            semProd.acquire();
        }
        catch(InterruptedException e)
        {
            System.out.println("InterruptedException caught");
        }
        this.item=item;
        System.out.println("Producer produced item: "+item);
        semCon.release();
    }
}

class Producer implements Runnable
{
    Queue q;
    Producer(Queue q)
    {
        this.q = q;
        new Thread(this, "Producer").start();
    }
    
    public void run()
    {
        for(int i=0; i<5; i++)
        {
            q.put(i);
        }
    }
}

class Consumer implements Runnable
{
    Queue q;
    Consumer(Queue q)
    {
    this.q = q;
    new Thread(this, "Consumer").start();
    }
    
    public void run()
    {
        for(int i=0; i<5; i++)
        {
            q.get();
        }
    }
}

class Practical5
{
    public static void main(String args [])
    {
        Queue q = new Queue();
        new Consumer(q);
        new Producer(q);
    }
}