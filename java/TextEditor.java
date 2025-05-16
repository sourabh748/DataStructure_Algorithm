import java.util.Stack;

public class TextEditor {

    public static void main(String[] args) {
        Stack<Character> u = new Stack<>();
        Stack<Character> r = new Stack<>();

        String s = args[0];
        String operation = args[1];

        for(int i= 0; i < s.length(); i++){
            u.add(s.charAt(i));
        }

        for(int i= 0; i < operation.length(); i++){
            if(operation.charAt(i) == 'u'){
                if(!u.isEmpty()){
                    char c = u.pop();
                    r.add(c);
                    continue;
                }
            } else if (operation.charAt(i) == 'r'){
                if(!r.isEmpty()){
                    char c = r.pop();
                    u.add(c);
                }
            }
        }

        String result = "";

        while (!u.isEmpty()) {
            result = u.pop() + result;
        }
        System.out.println(result);

    }
}
