package pp.filelocking;

public class Intervall
{
    private int     begin, end;
    private boolean status = false;

    public Intervall(int begin, int end)
    {
        this.begin = begin;
        this.end = end;
        this.status = true;
    }

    public int getBegin()
    {
        return this.begin;
    }

    public int getEnd()
    {
        return this.end;
    }

    public void setStatus(boolean state)
    {
        this.status = state;
    }

    public boolean getStatus()
    {
        return this.status;
    }

    public boolean isOverlapped(Intervall cIntervall)
    {
        return (this.begin <= cIntervall.begin && this.end >= cIntervall.begin)
                || (this.begin <= cIntervall.end && this.end > cIntervall.end);
    }

}
