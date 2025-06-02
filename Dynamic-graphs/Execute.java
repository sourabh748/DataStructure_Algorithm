import java.util.ArrayList;
import java.util.List;

public class Execute {

    public static int execute(int index, int nextPerson, List<Integer>position) {
        if( position.size() == 0) return 1;
        if( position.size() == 1 ) return position.get(0);

        index = (index + nextPerson -1) % position.size();

        position.remove(index);

        return execute(index, nextPerson, position);
    }

    public static int execute(int noOfPerson, int nextPerson) {
        List<Integer> position = new ArrayList<>(noOfPerson);

        for( int i=0; i < noOfPerson; i++)
            position.add(i + 1);

        return execute(0, nextPerson, position);
    }
    public static void main(String[] args) {
        System.out.println(execute(14, 2));
    }
}
