// SJF(Shortest Job First) CPU Scheduling Algorithm.
import java.util.*;
class Practical2
{
    public static void main(String [] args)
    {
        int n, AT[], BT[], WT[], TAT[], ST[], FT[];
        float AWT = 0, AVGTAT = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of processes: ");
        n = sc.nextInt();
        AT = new int[n];
        BT = new int[n];
        WT = new int[n];
        TAT = new int[n];
        ST = new int[n];
        FT = new int[n];
        
        System.out.println("----------------------------------");
        for (int i=0; i<n; i++)
        {
            System.out.println("Enter Burst time of process "+(i+1)+" : ");
            BT[i] = sc.nextInt();
        }
        
        for (int i=0; i<n; i++)
        {
            WT[i] = 0;
            AT[i] = 0;
            TAT[i] = 0;
        }
        
        int temp, temp1;
        for (int i=0; i<n; i++)
        {
            for (int j=0; j<n-1; j++)
            {
                if (BT[j] > BT[j+1])
                {
                    temp = BT[j];
                    BT[j] = BT[j+1];
                    BT[j+1] = temp;
                }
            }
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
            TAT[i] = FT[i] - AT[i];
            AWT = AWT + WT[i];
            AVGTAT = AVGTAT + TAT[i];
        }
        
        System.out.println("----------------------------------");
        System.out.println("PR\tBT\tST\tFT\tWT\tTAT");
        for (int i=0; i<n; i++)
        {
            System.out.println(i+"\t"+BT[i]+"\t"+ST[i]+"\t"+FT[i]+"\t"+WT[i]+"\t"+TAT[i]);
        }
        
	System.out.println("--------------------------------------");
        AWT = AWT/n;
        AVGTAT = AVGTAT/n;
        System.out.println("Avg. Waiting Time: "+AWT);
        System.out.println("Avg. Turn Around Time: "+AVGTAT); 
    }
}