package pp.producerconsumer;

public class Buffer
{

    private boolean available = false;
    private int[] data;
    private int size;
    
    public Buffer(int size)
    {
        if(size < 0)
        {
            throw new IllegalArgumentException();
        }
        this.size=size;
    }
    
    public synchronized void put(int[] x)
    {
        while(available)
        {
            try
            {
                wait();
            }
            catch(InterruptedException e)
            {
            }
            
            for(int i=0;i<x.length;i++)
            {
                data[i]= x[i];
            }
            
        
            available = true;
            notify();
        }
        
    }

    public synchronized int[] get()
    {
        while(!available)
        {
            try
            {
                wait();
            }
            catch(InterruptedException e)
            {
            }
        }
        available = false;
        notifyAll();
        return data;
    }
}
