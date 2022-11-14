import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class fifth {
    public static void main(String[] args) {
        try{
            BufferedReader read = new BufferedReader(new FileReader("/home/shivam/Project1/matches.csv"));
            List<String> lineMatches = new ArrayList<>();
            String lineM ;
            while((lineM = read.readLine())!=null){
                lineMatches.add(lineM);
            }
            lineMatches.remove(0);
            for(String s : lineMatches){
                List<String> str = new ArrayList<>(Arrays.asList(s.split(",")));
                if(str.get(8).equals("tie")){
                    System.out.println(str.get(1)+ " " + str.get(4) + " " + str.get(5) + " " +str.get(8));
                }
            }
        }
        catch(Exception e){
            e.getStackTrace();
        }
    }
}
