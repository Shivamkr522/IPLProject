import java.io.*;
import java.util.ArrayList;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try{
            BufferedReader read = new BufferedReader(new FileReader("/home/shivam/Project1/matches.csv"));
            List<String> lines = new ArrayList<>();
            String line;
            while((line= read.readLine())!=null){
                lines.add(line);
            }
            lines.remove(0);
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

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
