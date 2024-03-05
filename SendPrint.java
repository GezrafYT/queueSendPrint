package queuePracticeThing;
import java.util.LinkedList;
import java.util.Queue;
public class SendPrint {

    private int numOfPages, priority;
    private boolean duplex;
    public SendPrint(int numOfPages, boolean duplex, int priority)
    {
        this.numOfPages =  numOfPages;
        this.duplex = duplex;
        this.priority = priority;
    }
    public boolean isPrintQueue(Queue<SendPrint> q)
    {
        if(this.numOfPages > 0)
        {
            if(this.priority >=1 && this.priority <= 255)
            {
                if(q.size() >= 40)
                {
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public void maxHead(Queue<SendPrint> q)
    {
        Queue<SendPrint> temp = new LinkedList<SendPrint>();
        Queue<SendPrint> temp2 = new LinkedList<SendPrint>();
        SendPrint x;
        int max = 0;
        int cutHead = 0;
        int qSize = q.size();
        for(int i = 0; i<qSize; i++)
        {
            x = q.remove();
            temp.add(x);
            temp2.add(x);
        }

        int tempSize = temp.size();
        for(int j = 0; j < tempSize; j++)
        {
            cutHead = temp.remove().priority;
            if(cutHead > max)
            {
                max = cutHead;
            }
        }

        int savedSize = temp2.size();
        for(int j = 0; j<savedSize; j++)
        {
            x = temp2.remove();
            maxHead(q);
            if (x.priority != max)
            {
                temp2.add(q.remove());
            }
        }


        while(!temp2.isEmpty())
        {
            q.add(temp2.remove());
        }
    }

    public void sortPriority(Queue<SendPrint> q)
    {
        Queue<SendPrint> temp = new LinkedList<SendPrint>();
        SendPrint x;
        for (int i = 0; i<q.size(); i++)
        {
            maxHead(q);
            temp.add(q.remove());
        }

    }



}
