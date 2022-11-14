import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
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
            System.out.println();
            firstTask.calculateMatchesPlayed(linesMatches);
            System.out.println();
            secondTask.matchesWonByTeamOverYears(linesMatches);
            System.out.println();
            thirdTask.extraRunsPerTeamIn2016(linesMatches,linesDeliveries);
            System.out.println();
            fourthTask.topEconomicalBowler2015(linesMatches,linesDeliveries);
            System.out.println();
            fifthTask.matchesTiedInYearsInBetweenTeams(linesMatches);
        }
        catch(Exception e){
            e.getStackTrace();
        }

    }
}
