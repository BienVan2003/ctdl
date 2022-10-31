import java.util.*;
public class inputFraction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int soLuong = 0;
        try{
            System.out.println("Vui long nhap so luong phan so: ");
            soLuong = sc.nextInt();
        }
        catch(Exception e){};
        MyStack<Fraction> listStack = new MyStack<>();
        MyQueue<Fraction> listQueue = new MyQueue<>();
        for(int i = 0; i < soLuong; i++){
            System.out.println("Vui long nhap tu so thu " + (i+1));
            int tuso = sc.nextInt();
            System.out.println("Vui long nhap mau so thu " + (i+1));
            int mauso = sc.nextInt();

            Fraction phanSo = new Fraction(tuso, mauso);
            if(phanSo.getMau() == 0){
                phanSo = null;
            }else{
                phanSo.toiGianPhanSo();
            }
            listStack.push(phanSo);
            listQueue.enQueue(phanSo);
        }
        System.out.println("List Stack Fraction is: ");
        listStack.print();
        System.out.println("List Queue Fraction is: ");
        listQueue.print();
    }
}
