import java.util.Stack;

public class QueueUsingTwoStacks {
    private Stack<Integer> q1 = new Stack<>();
    private Stack<Integer> q2 = new Stack<>();

    public void enqueue(int item){
        this.q1.add(item);
    }

    public int dequeue(){
        if (this.q2.isEmpty()){
            while (!this.q1.isEmpty()) {
                this.q2.push(this.q1.pop());
            }
        }
        return this.q2.pop();
    }

    public static void main(String[] args) {
        
    }
}
