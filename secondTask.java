
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class secondTask {
    public static void main(String[] args){
        try{
            BufferedReader read = new BufferedReader(new FileReader("/home/shivam/Project1/matches.csv"));
            List<String> lines = new ArrayList<>();
            String line;
            while((line = read.readLine())!=null){
                lines.add(line);
            }
            lines.remove(0);
            //System.out.println(lines);
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
            //System.out.println(teamWonOverYears);
            for(Map.Entry m : teamWonOverYears.entrySet()){
                System.out.println(m.getKey()+" "+m.getValue());
            }
        }
        catch(Exception e){
            e.getStackTrace();
        }

    }
}
