import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class fourthTask {
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
            for(Map.Entry m : storeBallerCount.entrySet()){
                System.out.println(m.getKey()+" "+m.getValue());
            }

            HashMap<String,Double> economicalBowler = new HashMap<>();
            HashMap<String,Double> reducedOverForBowler = new HashMap<>();
            //System.out.println(storeBallerCount.size());

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
//                if(economicalBowler.containsKey(finalStore.getKey())){
//
//                }
//                else{
//
//                }
                double over = reducedOverForBowler.get(finalStore.getKey());
                int runs = (int) finalStore.getValue();
                double economy = runs/over;
                economicalBowler.put((String) finalStore.getKey(),economy);
            }
            double maximum = Collections.min(economicalBowler.values());

//            for(Map.Entry mp : economicalBowler.entrySet()){
//                if(mp.getValue().equals(maximum)){
//                    System.out.println(mp.getKey() + " " + mp.getValue());
//                }
//            }

        }
        catch(Exception e){
            e.getStackTrace();
        }
    }
}
