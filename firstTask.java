import java.util.ArrayList;
import java.util.*;

public class firstTask {

    static void calculateMatchesPlayed(List<String> lines){

            HashMap<String, Integer> hsmap = new HashMap<>();
            for(String s : lines){
                List<String> str = new ArrayList<>(Arrays.asList(s.split(",")));
                if(hsmap.containsKey(str.get(1))){
                    int value = hsmap.get(str.get(1));
                    hsmap.put(str.get(1),value+1);
                }
                else {
                    hsmap.put(str.get(1),1);
                }
            }
            System.out.println(hsmap);
    }
}
