import java.util.*;

/**
 * Created by matthew on 1/6/15.
 */
public class Consecutive {

    int[] findConsecutiveRuns(int[] unorderedArray){
        HashSet<Integer> indiciesOfRuns;
        if(unorderedArray != null && unorderedArray.length >=3) {
            indiciesOfRuns = new HashSet<Integer>();
            for (int index = 0; index < unorderedArray.length - 3; index++) {
                if (unorderedArray[index] == unorderedArray[index + 1] - 1 && unorderedArray[index] == unorderedArray[index + 2] - 2) {
                   indiciesOfRuns.add(index);
                }
                if (unorderedArray[index] == unorderedArray[index + 1] +1  && unorderedArray[index] == unorderedArray[index + 2] + 2) {
                    indiciesOfRuns.add(index);
                }
            }
            if (indiciesOfRuns != null) {
                int[] arrayIndicidesOfRuns = new int[indiciesOfRuns.size()];
                int index =0;
                for(int position : indiciesOfRuns){
                    arrayIndicidesOfRuns[index]=position;
                    index++;
                }
                return arrayIndicidesOfRuns;
            }

        }
        return null;
    }
}
