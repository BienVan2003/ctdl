public class Cau2 {
    public static int recur(int n, int k) {
        if(k==0){
            return 1;
        }
        else{
            int a = n * recur(n, k-1);
            System.out.println(a);

            return a;
        }
    }

    public static void main(String args[]){
		System.out.println(recur(12, 4));
        int a = 'C';
        System.out.println(a);

	}


}