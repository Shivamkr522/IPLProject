import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class fourthTask {
    static void topEconomicalBowler2015(List<String> linesMatches , List<String> linesDeliveries){
            List<String> listSerial = new ArrayList<>();
            for (String s : linesMatches){
                List<String> str= new ArrayList<>(Arrays.asList(s.split(",")));
                if(str.get(1).equals("2015")){
                    listSerial.add(str.get(0));
                }
            }
            HashMap<String,Integer> storeBallerCount = new HashMap<>();
            HashMap<String,Integer> storeBallerRun = new HashMap<>();
            for(String s : linesDeliveries){
                List<String> str = new ArrayList<>(Arrays.asList(s.split(",")));
                if(listSerial.contains(str.get(0))){
                    if(storeBallerCount.containsKey(str.get(8))){
                        int value = storeBallerCount.get(str.get(8));
                        storeBallerCount.put(str.get(8),value+1);
                    }
                    else{
                        storeBallerCount.put(str.get(8),1);
                    }
                    if(storeBallerRun.containsKey(str.get(8))){
                        int value = storeBallerRun.get(str.get(8));
                        storeBallerRun.put(str.get(8), value+Integer.parseInt(str.get(17)));
                    }
                    else{
                        storeBallerRun.put(str.get(8),Integer.parseInt(str.get(17)));
                    }
                }
            }

            HashMap<String,Double> economicalBowler = new HashMap<>();
            HashMap<String,Double> reducedOverForBowler = new HashMap<>();
            for(Map.Entry storeOver : storeBallerCount.entrySet()){
                int findOver = (int)(storeOver.getValue());
                int findRestBalls = findOver%6;
                double findOvers = (double)findOver/6;
                double precisionNumber = (double)findRestBalls/6;
                findOvers+=precisionNumber;
                double finalOver = BigDecimal.valueOf(findOvers).setScale(2, RoundingMode.HALF_UP).doubleValue();
                reducedOverForBowler.put((String) storeOver.getKey(),finalOver);
            }
            for(Map.Entry finalStore : storeBallerRun.entrySet()){
                double over = reducedOverForBowler.get(finalStore.getKey());
                int runs = (int) finalStore.getValue();
                double economy = runs/over;
                economicalBowler.put((String) finalStore.getKey(),economy);
            }
            double maximum = Collections.min(economicalBowler.values());
            for(Map.Entry mp : economicalBowler.entrySet()){
                if(mp.getValue().equals(maximum))
                    System.out.println(mp.getKey()+ " "+ maximum);
            }
    }
}
