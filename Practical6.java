// Program to print EvenOddd numbers and Reverse of a string using MultiThreading.
import java.util.*;
class test1 extends Thread
{
	String name;
	test1(String threadname) 
	{
		name=threadname;
	}
	public void run()
	{ 
		evenOdd();
	}
	public void evenOdd()
	{
		System.out.println(name);
		try
		{
			for (int i=0;i<=10;i++)
			{
			    if(i%2==0)
				{ 
				    System.out.println(i+" Even");
				}
				else
				{ 
			    	System.out.println(i+" Odd");
				}
				this.sleep(1000);
				}
		}
		catch(Exception e){}
	}
}

class test2 extends Thread
{
	String name;
	test2(String threadname) 
	{
		name = threadname;
	}
	public void run()
	{ 
		reverse();
	}
	public void reverse()
	{
		System.out.println(name);
		System.out.println("Enter Friend name: ");
		Scanner sc = new Scanner(System.in);
		String friendname = sc.next();
		StringBuffer sb = new StringBuffer(friendname);
		System.out.println("Friend name reverse is: "+sb.reverse());

	}
}

class Practical6
{ 
	public static void main(String args[])
	{
	    try
	    {
			test1 t1 = new test1 ("Thread One: Even Odd");
			t1.start();
			t1.join();
			
			test2 t2 = new test2 ("Thread Two: Friend Name Reverse");
			t2.start();
			t2.join();
		}
		catch(Exception e)
		{ 
			System.out.println(e);
		}
	}
}