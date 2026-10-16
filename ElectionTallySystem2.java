import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

class Candidate { 
    String name;

    Candidate(String name) {
        this.name = name; 
    }
}

public class ElectionTallySystem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 

        String[] candidates = {"Candidate A", "Candidate B", "Candidate C"};
        int[] votes = new int[3];

        System.out.println("Student Council Election Tally System");
        System.out.print("Enter total number of voters: ");
        int totalVoters = sc.nextInt();

        for (int i = 0; i < totalVoters; i++) { 
            System.out.println("\nVoter " + (i + 1) + " - Select your choice:");
            for (int j = 0; j < candidates.length; j++)
                System.out.println((j + 1) + ". " + candidates[j]);

            System.out.print("Enter choice (1-3): ");
            int choice = sc.nextInt();

            if (choice >= 1 && choice <= 3)
                votes[choice - 1]++;
            else {
                System.out.println("Invalid choice!");
                i--;
            }
        }

        System.out.println("\nELECTION RESULTS");
        int maxVotes = votes[0], winner = 0;
        List<Candidate> results = new ArrayList<>(); 

        for (int i = 0; i < votes.length; i++) {
            Candidate c = new Candidate(candidates[i]);
            results.add(c);
            System.out.println(c.name + ": " + votes[i] + " votes");

            if (votes[i] > maxVotes) {
                maxVotes = votes[i];
                winner = i;
            }
        }

        System.out.println("\nWinner: " + candidates[winner]
                + " with " + maxVotes + " votes");

        String[] sorted = candidates.clone();   // sort a copy, keep original order
        Arrays.sort(sorted);
        System.out.println("\nCandidates in sorted order:");
        for (String name : sorted)
            System.out.println(name);

        System.out.println("\nCandidates who received votes:");
        results.stream()
            .filter(c -> votes[Arrays.asList(candidates).indexOf(c.name)] > 0)
            .forEach(c -> System.out.println(c.name));

        sc.close();
    }
}