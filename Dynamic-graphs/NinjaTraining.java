public class NinjaTraining {

    public static int ninjaTraining(int[][]points, int n, int jdx) {
        if( n -1 == 0)
            return points[n -1][jdx];
        
        int length = points[n-1].length;
        
        int result1 = points[n -1][jdx] + ninjaTraining(points, n -1, (jdx + 1) % length);
        int result2 = points[n -1][jdx] + ninjaTraining(points, n -1, (jdx + 2) % length);

        return Math.max(result1, result2);
    }
    public static void main(String[] args) {
        int[][] points = new int[][] {
            {1, 2, 5},
            {3, 1, 1},
            {3, 3, 3}
        };

        int maxi = Integer.MIN_VALUE;

        for( int i = 0; i < points[0].length; i ++) {
            int result = ninjaTraining(points, points.length, i);

            maxi = Math.max(maxi, result);
        }

        System.out.println(maxi);
    }
}
