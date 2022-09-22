// Program to print Prime Number from 1-100 using Thread.
class Prime implements Runnable
{
    long j, c;
    Prime()
    {
        super();
        c = 0;
    }
    
    public void run()
    {
        for (long i=0; i<=100; i++)
        {
            for (j=2; j<=i; j++)
            {
                if (i%j == 0)
                {
                    break;
                }
            }
            
            if (j==i)
            {
                c++;
                System.out.println(c+"th "+"Prime number: "+i);
            }
        }
    }
}

class Practical4A
{
    public static void main(String [] args)
    {
        Thread ct = Thread.currentThread();
        System.out.println("Main thread name: "+ct.getName());
        Prime p = new Prime();
        Thread prime = new Thread(p, "Prime");
        prime.start();
        System.out.println("Thread "+prime.getName()+" started.");
    }
}