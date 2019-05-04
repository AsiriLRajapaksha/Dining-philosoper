
package philosopher;
import java.io.*;

public class Philosopher {

    public static void main(String args[])throws IOException
    {
        int j =0;
        
        while(true){
        PhiloPeration d=new PhiloPeration();
        for(int i=j;i<5;i++)
        d.pickupFork(i%5);
        for(int i=j;i<5;i++)
        d.putdownFork(i%5);
        j ++;
        }
}
    
}

class PhiloPeration
{
int state[]=new int[5];
int thinking,eating,hungry;
    void Operations()
    {
        thinking=0;
        eating=1;
        hungry=2;
    }
    public void pickupFork(int a)
    {
        state[a]=2;
        System.out.println("Philosopher " +a+" is hungry");
        check(a);
        if(state[a]==2)
        System.out.println("Philosopher "+a+" is waiting");
    }
    public void putdownFork(int a)
    {
        if(state[a]==1)
        {
            state[a]=0;
            System.out.println("Philosopher "+a+" is thinking");
            check((a+1)%5);
            check((a+5)%5);
        }
    }
    public void check(int a)
    {
        if(state[a]==2 && state[(a+1)%5]!=1 && state[(a+4)%5]!=1)
        {
            state[a]=1;
            System.out.println("philosopher "+a+" is eating");
        }
    }
}
