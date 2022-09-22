// FCFS(First-In First-OUT) CPU Scheduling Algorithm.
import java.util.*;
class Practical1
{
    public static void main(String [] args) throws Exception
    {
        int n, AT[], WT[], BT[], TAT[], ST[], FT[];
        float AWT = 0, AVGTAT = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of processes: ");
        n = sc.nextInt();
        BT = new int[n];
        FT = new int[n];
        TAT = new int[n];
        ST = new int[n];
        AT = new int[n];
        WT = new int[n];
        
        System.out.println("---------------------------------------------");
        for (int i=0; i<n; i++)
        {
            System.out.println("Enter Burst time of process "+(i+1)+" : ");
            BT[i] = sc.nextInt();
        }
        
        System.out.println("---------------------------------------------");
        for (int i=0; i<n; i++)
        {
            System.out.println("Enter Arrival time of process "+(i+1)+" : ");
            AT[i] = sc.nextInt();
        }
        
        WT[0] = 0;
        
        for (int i=1; i<n; i++)
        {
            ST[i] = ST[i-1] + BT[i-1];
            WT[i] = ST[i] - AT[i];
        }
        
        for (int i=0; i<n; i++)
        {
            FT[i] = ST[i] + BT[i];
            TAT[i] = FT[i] + AT[i];
            AWT = AWT + WT[i];
            AVGTAT = AVGTAT + TAT[i];
        }
        
        System.out.println("---------------------------------------------");
        System.out.println("PR\tBT\tST\tFT\tWT\tTAT");
        for (int i=0; i<n; i++)
        {
            System.out.println(i+"	"+BT[i]+"	"+ST[i]+"	"+FT[i]+"	"+WT[i]+"	"+TAT[i]);
        }
        
        AWT = AWT/n;
        AVGTAT = AVGTAT/n;
        System.out.println("Avg Waiting time: "+AWT);
        System.out.println("Avg Turn Around Time: "+AVGTAT);
        
    }
}