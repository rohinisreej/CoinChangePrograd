import java.util.Scanner;
public class Main {

    public static int mincoins(int coins[],int len,int amount)
    {
        if(amount==0)
        {
            return 0;
        }
        int table[] = new int[amount + 1];
        table[0] = 0;
        for (int i = 1; i <= amount; i++)
        {
            table[i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i <= amount; i++)
        {
            // Go through all coins smaller than i
            for (int j = 0; j < len; j++)
                if (coins[j] <= i)
                {
                    int sub_res = table[i - coins[j]];
                    if (sub_res != Integer.MAX_VALUE
                            && sub_res + 1 < table[i])
                        table[i] = sub_res + 1;


                }

        }
        if(table[amount]==Integer.MAX_VALUE)
            return -1;

        return table[amount];
    }

    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter n");
        int n=scanner.nextInt();
        System.out.println("Enter coins");
        int A[]=new int[n];
        for(int i=0;i<n;i++)
        {
            A[i]=scanner.nextInt();
        }
        System.out.println("Enter amt: ");
        int amt=scanner.nextInt();
        System.out.println(mincoins(A,n,amt));




    }
}