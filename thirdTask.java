import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class thirdTask {
    public static void main(String[] args) {
        try{
            BufferedReader readDeliveries = new BufferedReader(new FileReader("/home/shivam/Project1/deliveries.csv"));
            BufferedReader readMatches = new BufferedReader(new FileReader("/home/shivam/Project1/matches.csv"));
            List<String> linesDeliveries = new ArrayList<>();
            List<String> linesMatches = new ArrayList<>();
            String lineD,lineM;
            while((lineD = readDeliveries.readLine())!= null){
                linesDeliveries.add(lineD);
            }
            while((lineM = readMatches.readLine())!=null){
                linesMatches.add(lineM);
            }
            linesDeliveries.remove(0);
            linesMatches.remove(0);
            List<String> listSerial = new ArrayList<>();
            for (String s : linesMatches){
                List<String> str= new ArrayList<>(Arrays.asList(s.split(",")));
                if(str.get(1).equals("2016")){
                    listSerial.add(str.get(0));
                }
            }
            HashMap<String,Integer> tryMethod = new HashMap<>();
            for(String s : linesDeliveries){
                List<String> str = new ArrayList<>(Arrays.asList(s.split(",")));
                if(listSerial.contains(str.get(0))){
                    if(tryMethod.containsKey(str.get(2))){
                        int value = tryMethod.get(str.get(2));
                        tryMethod.put(str.get(2),value+Integer.parseInt(str.get(16)));
                    }
                    else{
                        tryMethod.put(str.get(2),Integer.parseInt(str.get(16)));
                    }
                }
            }
            for(Map.Entry m: tryMethod.entrySet()){
                System.out.println(m.getKey()+" "+m.getValue());
            }
        }
        catch(Exception e){
            e.getStackTrace();
        }
    }
}