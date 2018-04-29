package pp.filelocking;

import java.util.LinkedList;
import java.util.List;

public class File extends Thread
{
    // Attribute
    private int             length;
    private List<Intervall> lsIntervall;

    public File(int length)
    {
        if (length < 0)
        {
            throw new IllegalArgumentException("length darf nicht negative sein.");
        }
        this.lsIntervall = new LinkedList<Intervall>();
        this.length = length;
    }

    @Override
    public void run()
    {
    }

    public synchronized void lock(int begin, int end) throws InterruptedException
    {

        if ((begin < 0) || (end < 0) || (begin > end) || (end > this.length - 1) || (begin > this.length - 1))
        {
            throw new IllegalArgumentException("Ungültige Intervall");
        }

        while (isInlsIntervall(begin, end))
        {
            wait();
        }
        lsIntervall.add(new Intervall(begin, end));
        System.out.println("intervall ( " + begin + "," + end + " ) Locked");
    }

    public boolean isInlsIntervall(int begin, int end)
    {
        for (Intervall i : lsIntervall)
        {
            if (begin >= i.getBegin() && begin <= i.getEnd() || end >= i.getBegin() && end <= i.getEnd())
            {
                return true;
            }
        }
        return false;
    }

    public synchronized void unlock(int begin, int end)
    {

        if ((begin < 0) || (end < 0) || (begin > end) || (end > this.length - 1) || (lsIntervall.isEmpty()))

        {
            throw new IllegalArgumentException("Ungültige Intervall");
        }

        for (Intervall cpx : lsIntervall)
        {
            if (cpx.getBegin() == begin && cpx.getEnd() == end)
            {
                if (cpx.getStatus())
                {
                    cpx.setStatus(false);
                    lsIntervall.remove(cpx);
                    System.out.println("intervall ( " + begin + "," + end + " ) UnLocked");
                    notifyAll();
                }
            }
        }
    }
}
