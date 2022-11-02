import java.util.Stack;

public class Cau3 {
    public static int calculate(String[] expression) {
        Stack<Integer> st = new Stack<>();
        for(String i : expression){
            if(isNumber(i)){
                st.push(Integer.parseInt(i));
            }
            if(i.equals("+")){
                int a = st.pop();
                int b = st.pop();
                int c = a+b;
                st.push(c);
            }
            if(i.equals("-")){
                int a = st.pop();
                int b = st.pop();
                int c = b-a;
                st.push(c);
            }
            if(i.equals("*")){
                int a = st.pop();
                int b = st.pop();
                int c = b*a;
                st.push(c);
            }
            if(i.equals("/")){
                int a = st.pop();
                int b = st.pop();
                int c = b/a;
                st.push(c);
            }
        }
        return st.peek();
    }

    public static void main(String args[]){
		System.out.println(calculate(new String[]{"31", "12", "-"}));
        System.out.println(calculate(new String[]{"3","4","+","2","1","+","-"}));
	}
    public static boolean isNumber(String str){
        return str.matches("0|([1-9][0-9]*)");
    }
}