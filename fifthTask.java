import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class fifthTask {
    static void matchesTiedInYearsInBetweenTeams(List<String> lineMatches){

            for(String s : lineMatches){
                List<String> str = new ArrayList<>(Arrays.asList(s.split(",")));
                if(str.get(8).equals("tie")){
                    System.out.println(str.get(1)+ " " + str.get(4) + " " + str.get(5) + " " +str.get(8));
                }
            }
    }
}
