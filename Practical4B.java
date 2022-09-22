// Program to print Fibonacci Series from first 20 numbers using Thread.
class Fib implements Runnable
{
    long a, b, c, n;
    Fib()
    {
        a = c = n =0;
        b = 1;
    }
    
    public void run()
    {
        while(n++<20)
        {
            System.out.println(n+"th "+"Fibonacci number: "+a);
            c = a + b;
            a = b;
            b = c;
            
            try
            {
                if (n==10)
                {
                    System.out.println("Thread fibonacci is put into sleep.");
                    Thread.sleep(5000);
                }
            }
            
            catch (InterruptedException e)
            {
                System.out.println("Error: "+e);
            }
        }
    }
}

class Practical4B
{
    public static void main(String [] args)
    {
        Thread ct = Thread.currentThread();
        System.out.println("Main thread name: "+ct.getName());
        Fib f = new Fib();
        Thread Fib = new Thread(f, "Fibonacci");
        Fib.start();
        System.out.println("Thread "+Fib.getName()+" started.");
    }
}