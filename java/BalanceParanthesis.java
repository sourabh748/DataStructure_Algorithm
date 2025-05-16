import java.util.Stack;

public class BalanceParanthesis {
    public static void main(String[] args) {
        Stack<Character> p = new Stack<>();

        String s = args[0];

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if( c == '(' || c == '[' || c == '{' ){
                p.add(c);
            } else {
                if(
                    !p.isEmpty() &&
                    ((p.peek() == '(' && c == ')') ||
                     (p.peek() == '{' && c == '}') ||
                     (p.peek() == '[' && c == ']'))
                ){
                    p.pop();
                    continue;
                }
                System.out.println("Given pairs of string is not balanced");
                return;
            }
        }
        if (!p.isEmpty()){
            System.out.println("Given pairs of string is not balanced");
            return;
    }
        System.out.println("Given Paranthesis is balanced");
    }
}
