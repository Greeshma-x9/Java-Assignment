import java.util.Scanner;
 
public class ElectionTallySystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String[] candidates = {"Candidate A", "Candidate B", "Candidate C"};
        int[] votes = new int[3];
        int totalVoters;
        
        System.out.println("_______Student Council Election Tally System_______");
        System.out.print("Enter total number of voters: ");
        totalVoters = sc.nextInt();
        
        for (int i = 0; i < totalVoters; i++) {
            System.out.println("\nVoter " + (i + 1) + " - Select your choice:");
            for (int j = 0; j < candidates.length; j++) {
                System.out.println((j + 1) + ". " + candidates[j]);
            }
            System.out.print("Enter choice (1-3): ");
            int choice = sc.nextInt();
            
            if (choice >= 1 && choice <= 3) {
                votes[choice - 1]++;
            } else {
                System.out.println("Invalid choice!");
                i--;
            }
        }
        
        System.out.println("______ELECTION RESULTS______");
        int maxVotes = votes[0];
        int winner = 0;
        
        for (int i = 0; i < votes.length; i++) {
            System.out.println(candidates[i] + ": " + votes[i] + " votes");
            if (votes[i] > maxVotes) {
                maxVotes = votes[i];
                winner = i;
            }
        }
        
        System.out.println("\nWinner: " + candidates[winner] + " with " + maxVotes + " votes");

        sc.close();
    }
}