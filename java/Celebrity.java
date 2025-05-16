// import java.util.Stack;

public class Celebrity {
    public static int findCelebs(int[][] celebs){
        int celeb = -1;

        for(int i= 0; i < celebs[0].length; i++){
            boolean isCelebs = true;
            for(int j =0; j< celebs.length; j++){
                if (i != j && celebs[i][j] >0){
                    isCelebs = false;
                    break;
                }
            }
            if(isCelebs){
                celeb = i;
                break;
            }
        }

        for(int i = 0; i< celebs[0].length; i++){
            if(i != celeb && celebs[i][celeb] == 0){
                celeb = -1;
                break;
            }
        }
        return celeb;
    }

    public static void main(String[] args) {
        int[][] pub = {
            {0, 1, 0, 1},
            {0, 1, 0, 0},
            {0, 1, 0, 1},
            {0, 1, 0, 0}
        };

        int celebs = findCelebs(pub);
        System.out.println(celebs);
    }
}
