import java.util.*;
public class Ex2 {
    public static double P(int n) {
        if (n == 1) return 3;
        if (n == 2) return 11; 
        return Math.pow(2, n) + Math.pow(n, 2) + P(n - 1);
    }
    public static void main(String[] args) {
        
        System.out.println("Nhap n: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Result: " + P(n));
        System.out.println();
        MyStack <Double> stk = new MyStack <Double> ();
        for (int i = n; i >= 1; i--) {
            stk.push(P(i));
        }
        stk.print();
    }
    
}
