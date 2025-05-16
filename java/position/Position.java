package position;
public class Position {
    public int[] cards;
    public int query = 0;

    public static int binarySearch(int start, int end, Test test){
        while (end >= start) {
            int mid = end - (end -start)/2;
            String result = test.condition(mid);
            switch (result) {
                case "found":
                    return mid;
                
                case "right": {
                    start = mid + 1;
                    break;
                }
                default: {
                    end = mid -1;
                }
            }
        }
        return -1;
    }

    public int firstPosition(){
        return binarySearch(0, cards.length -1, (mid) ->{
            if (cards[mid] == query){
                if (mid -1 >= 0 && cards[mid -1] == query)
                    return "left";
                return "found";
            } else if ( cards[mid] > query)
                return "left";
            return "right";
        });
    }

    public int lastPosition(){
        return binarySearch(0, cards.length -1, (mid) ->{
            if (cards[mid] == query){
                if (mid < cards.length -1 && cards[mid +1] == query)
                    return "right";
                return "found";
            } else if ( cards[mid] > query)
                return "left";
            return "right";
        });
    }

    public int countRotation(){

        // Time Complexity is o(logN)

        if (cards.length == 0)
            return -1;

        int result = binarySearch(0, cards.length -1, (mid) -> {
            if (mid -1 >=0 && cards[mid] < cards[mid -1])
                return "found";
            else if (cards[mid] > cards[0])
                return "right";
            return "left";
        });

        if (result == -1)
            return 0;
        return result;
    }

    public int countRotationLinear(){

        // Time Complexity is o(N)
        int position = 0;

        while (position <= cards.length -1) {
            
            if (position -1 >= 0 && cards[position -1] > cards[position])
                return position;
            
            position++;
        }

        return 0;
    }
}
