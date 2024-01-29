// Create a simple console-based calculator
// that can perform basic mathematical operations like addition,
// subtraction, multiplication, and division. Allow users to input
// numbers and choose the operation they want to perform.
import java.util.*;
public class calculator {
    public static Scanner sc=new Scanner(System.in);
    public static int Total;
    public static int n1;
    public static int n2;
    public static String symbol;
    public static ArrayList<Object> demo = new ArrayList<Object>();

    public static ArrayList<Object> op= new ArrayList<Object>();
    public static ArrayList<Integer> ans = new ArrayList<Integer>();
    public static ArrayList<String> sy = new ArrayList<String>();

    public static void push()
    {

        demo.add(n1);
        demo.add(n2);
        op.addAll(demo);
        sy.add(symbol);
        demo.clear();
        ans.add(Total);
    }

    public static void addition(int n1,int n2)
    {
        Total=n1+n2;
        symbol="+";
        push();
        
        System.out.println("Addition="+Total);    
    }
    public static void sub(int n1,int n2)
    {
        Total=n1-n2;
        symbol="-";
        push();
        
        System.out.println("Subtraction="+Total);    
    }
    public static void mulp(int n1,int n2)
    {
        Total=n1*n2;
        symbol="*";
        push();
        
        System.out.println("Muplication="+Total);
    }
    public static void div(int n1,int n2)
    {
        Total=n1/n2;
        symbol="/";
        push();
        
        System.out.println("Division="+Total);
    }
    public static void input()
    {
        System.out.println("Enter the First number:");
            n1=sc.nextInt();
            System.out.println("Enter the Second number");
            n2=sc.nextInt();
    }
    public static void clear()
    {
        op.clear();
        ans.clear();
        sy.clear();
    }

    public static void history()
    {
        if(op.size()>0)
        {
        int a=0;
        int b=0;
        for(int i=b;i<ans.size();i++)
        {
            int z=0;
            int count=0;
            for(int j=a;j<op.size();j++)
            {
                if(count<=1)
                {
                System.out.print(op.get(j)+ ""  );
                if(z<1)
                {
                    System.out.print(sy.get(i));
                    z++;
                }
                a=j;
                count++;
                }
                else{
                    a=a+1;
                    break;
                }
            }
            System.out.println("="+ans.get(i));
        }
    }
    else{
        System.out.println("Data is Cleared Already      -----------");
    }
    }

    public static void main(String[] args) throws IndexOutOfBoundsException {
        int ch;
        do {
            
            System.out.println("--------------------------------");
            System.out.println("1.Addition");
            System.out.println("2.Subtraction");
            System.out.println("3.Muplication");
            System.out.println("4.Division");
            System.out.println("5.Restore History");
            System.out.println("6:Clear the Histroy");
            System.out.println("7:Exit");
            System.out.println("Enter the Choice");
            ch=sc.nextInt();
            
            switch (ch) {
                case 1:
                    input();
                    addition(n1,n2);
                    break;
                case 2:
                    input();
                    sub(n1,n2);
                    break;
                case 3:
                    input();
                    mulp(n1,n2);
                    break;
                case 4:
                    input();
                    div(n1,n2);
                    break;
                case 5:
                    history();
                    break;
                
                case 6:
                    clear();
                    break;
                
            
                default:
                    break;
            }
        } while (ch<=6);
        
    }
    
}
