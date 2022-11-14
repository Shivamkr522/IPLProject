import java.util.*;

public class thirdTask {
    static void extraRunsPerTeamIn2016(List<String> linesMatches, List<String> linesDeliveries){
            List<String> listSerial = new ArrayList<>();
            for (String s : linesMatches){
                List<String> str= new ArrayList<>(Arrays.asList(s.split(",")));
                if(str.get(1).equals("2016")){
                    listSerial.add(str.get(0));
                }
            }
            HashMap<String,Integer> extraRuns = new HashMap<>();
            for(String s : linesDeliveries){
                List<String> str = new ArrayList<>(Arrays.asList(s.split(",")));
                if(listSerial.contains(str.get(0))){
                    if(extraRuns.containsKey(str.get(2))){
                        int value = extraRuns.get(str.get(2));
                        extraRuns.put(str.get(2),value+Integer.parseInt(str.get(16)));
                    }
                    else{
                        extraRuns.put(str.get(2),Integer.parseInt(str.get(16)));
                    }
                }
            }
            for(Map.Entry m: extraRuns.entrySet()){
                System.out.println(m.getKey()+" "+m.getValue());
            }
    }
}