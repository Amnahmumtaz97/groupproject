import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Person {
    private String name;
    private int age;
    private String address;

    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }
}

class Citizen extends Person {
    private int nationalID;
    private String occupation;

    public Citizen(String name, int age, String address, int nationalID) {
        super(name, age, address);
        this.nationalID = nationalID;
        this.occupation = "";
    }

    public int getNationalID() {
        return nationalID;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
}

class Candidate extends Person {
    private String party;
    private int voteCount;

    public Candidate(String name, int age, String address, String party) {
        super(name, age, address);
        this.party = party;
        this.voteCount = 0;
    }

    public String getParty() {
        return party;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void incrementVoteCount() {
        this.voteCount++;
    }
}

class Voter extends Person {
    private boolean hasVoted;

    public Voter(String name, int age, String address) {
        super(name, age, address);
        this.hasVoted = false;
    }

    public boolean hasVoted() {
        return hasVoted;
    }

    public void setHasVoted(boolean hasVoted) {
        this.hasVoted = hasVoted;
    }
}

class ElectionManager {
    private List<Voter> voterList;
    private List<Candidate> candidateList;

    public ElectionManager() {
        this.voterList = new ArrayList<>();
        this.candidateList = new ArrayList<>();
    }

    public void addVoter(Voter voter) {
        voterList.add(voter);
    }

    public void addCandidate(Candidate candidate) {
        candidateList.add(candidate);
    }

    public void vote(Voter voter, Candidate candidate) {
        if (!voter.hasVoted()) {
            candidate.incrementVoteCount();
            voter.setHasVoted(true);
        }
    }

    public List<Candidate> getElectionResults() {
        return candidateList;
    }

    // Provide access to voterList
    public List<Voter> getVoterList() {
        return voterList;
    }

    // Provide access to candidateList
    public List<Candidate> getCandidateList() {
        return candidateList;
    }
}

class FileHandler {
    private static final String VOTERS_FILE = "voters.txt";
    private static final String CANDIDATES_FILE = "candidates.txt";
    private static final String RESULTS_FILE = "results.txt";

    public static void writeVoters(List<Voter> voters) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(VOTERS_FILE))) {
            for (Voter voter : voters) {
                writer.println(voter.getName() + "," + voter.getAge() + "," + voter.getAddress());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Voter> readVoters() {
        List<Voter> voters = new ArrayList<>();
        try (Scanner scanner = new Scanner(new FileReader(VOTERS_FILE))) {
            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().split(",");
                String name = parts[0];
                int age = Integer.parseInt(parts[1]);
                String address = parts[2];
                voters.add(new Voter(name, age, address));
            }
        } catch (FileNotFoundException e) {
            // File doesn't exist, no need to handle for now
        }
        return voters;
    }

    public static void writeCandidates(List<Candidate> candidates) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(CANDIDATES_FILE))) {
            for (Candidate candidate : candidates) {
                writer.println(candidate.getName() + "," + candidate.getAge() + "," +
                        candidate.getAddress() + "," + candidate.getParty());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Candidate> readCandidates() {
        List<Candidate> candidates = new ArrayList<>();
        try (Scanner scanner = new Scanner(new FileReader(CANDIDATES_FILE))) {
            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().split(",");
                String name = parts[0];
                int age = Integer.parseInt(parts[1]);
                String address = parts[2];
                String party = parts[3];
                candidates.add(new Candidate(name, age, address, party));
            }
        } catch (FileNotFoundException e) {
            // File doesn't exist, no need to handle for now
        }
        return candidates;
    }

    public static void writeResults(List<Candidate> results) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(RESULTS_FILE))) {
            for (Candidate candidate : results) {
                writer.println(candidate.getName() + " from " + candidate.getParty() +
                        " received " + candidate.getVoteCount() + " votes.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class ElectionSystem {
    public static void main(String[] args) {
        // Initialize ElectionManager
        ElectionManager electionManager = new ElectionManager();

        // Load existing voters and candidates from files
        List<Voter> existingVoters = FileHandler.readVoters();
        List<Candidate> existingCandidates = FileHandler.readCandidates();

        // Add existing voters and candidates to the ElectionManager
        for (Voter existingVoter : existingVoters) {
            electionManager.addVoter(existingVoter);
        }

        for (Candidate existingCandidate : existingCandidates) {
            electionManager.addCandidate(existingCandidate);
        }

        // For demonstration purposes, add a new voter and candidate
        Voter newVoter = new Voter("John Doe", 25, "123 Main St");
        Candidate newCandidate = new Candidate("Jane Smith", 40, "456 Oak St", "Independent");

        electionManager.addVoter(newVoter);
        electionManager.addCandidate(newCandidate);

        // Simulate a vote
        electionManager.vote(newVoter, newCandidate);

        // Display election results
        List<Candidate> electionResults = electionManager.getElectionResults();
        for (Candidate candidate : electionResults) {
            System.out.println(candidate.getName() + " from " + candidate.getParty() +
                    " received " + candidate.getVoteCount() + " votes.");
        }

        // Save voters and candidates to files
        FileHandler.writeVoters(electionManager.getVoterList());
        FileHandler.writeCandidates(electionManager.getCandidateList());

        // Save election results to file
        FileHandler.writeResults(electionResults);
    }
}
