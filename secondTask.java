import java.util.*;

public class secondTask {
    static void matchesWonByTeamOverYears(List<String> lines){

            HashMap<String,Integer> teamWonOverYears = new HashMap<>();
            for( String s : lines){
                List<String> str = new ArrayList<>(Arrays.asList(s.split(",")));
                if(teamWonOverYears.containsKey(str.get(1)+" "+str.get(10))){
                    int value = teamWonOverYears.get(str.get(1)+" "+str.get(10));
                    teamWonOverYears.put(str.get(1)+" "+str.get(10),value+1);
                }
                else{
                    teamWonOverYears.put(str.get(1)+" "+str.get(10),1);
                }
            }
            for(Map.Entry m : teamWonOverYears.entrySet()){
                System.out.println(m.getKey()+" "+m.getValue());
            }

    }
}
