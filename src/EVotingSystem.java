//import javax.swing.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.*;
//import java.util.HashMap;
//import java.util.Map;
//
//class Voter implements Serializable {
//    private String name;
//    private String address;
//    private int age;
//    private String cnic;
//    private String votedParty;
//
//    public Voter(String name, String address, int age, String cnic) {
//        this.name = name;
//        this.address = address;
//        this.age = age;
//        this.cnic = cnic;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public String getCnic() {
//        return cnic;
//    }
//
//    public String getVotedParty() {
//        return votedParty;
//    }
//
//    public void setVotedParty(String votedParty) {
//        this.votedParty = votedParty;
//    }
//}
//
//public class EVotingSystem {
//    private static final String VOTERS_FILE = "voters.dat";
//    private static final String RESULTS_FILE = "results.dat";
//    private static final Map<String, Integer> partyVotes = new HashMap<>();
//
//    public static void main(String[] args) {
//        loadResults();
//        createVotingSystemGUI();
//    }
//
//    private static void loadResults() {
//        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(RESULTS_FILE))) {
//            partyVotes.putAll((Map<String, Integer>) ois.readObject());
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private static void saveResults() {
//        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(RESULTS_FILE))) {
//            oos.writeObject(partyVotes);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private static void createVotingSystemGUI() {
//        JFrame frame = new JFrame("E-Voting System");
//        frame.setSize(400, 300);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        JPanel panel = new JPanel();
//        frame.add(panel);
//        placeComponents(panel);
//
//        frame.setVisible(true);
//    }
//
//    private static void placeComponents(JPanel panel) {
//        panel.setLayout(null);
//
//        JLabel nameLabel = new JLabel("Name:");
//        nameLabel.setBounds(10, 20, 80, 25);
//        panel.add(nameLabel);
//
//        JTextField nameField = new JTextField(20);
//        nameField.setBounds(150, 20, 165, 25);
//        panel.add(nameField);
//
//        JLabel addressLabel = new JLabel("Address:");
//        addressLabel.setBounds(10, 50, 80, 25);
//        panel.add(addressLabel);
//
//        JTextField addressField = new JTextField(20);
//        addressField.setBounds(150, 50, 165, 25);
//        panel.add(addressField);
//
//        JLabel ageLabel = new JLabel("Age:");
//        ageLabel.setBounds(10, 80, 80, 25);
//        panel.add(ageLabel);
//
//        JTextField ageField = new JTextField(20);
//        ageField.setBounds(150, 80, 165, 25);
//        panel.add(ageField);
//
//        JLabel cnicLabel = new JLabel("CNIC:");
//        cnicLabel.setBounds(10, 110, 80, 25);
//        panel.add(cnicLabel);
//
//        JTextField cnicField = new JTextField(20);
//        cnicField.setBounds(150, 110, 165, 25);
//        panel.add(cnicField);
//
//        JComboBox<String> partyComboBox = new JComboBox<>(new String[]{"Party A", "Party B", "Party C"});
//        partyComboBox.setBounds(10, 140, 150, 25);
//        panel.add(partyComboBox);
//
//        JButton voteButton = new JButton("Cast Vote");
//        voteButton.setBounds(10, 170, 150, 25);
//        panel.add(voteButton);
//
//        JTextArea resultTextArea = new JTextArea();
//        resultTextArea.setBounds(220, 20, 150, 175);
//        panel.add(resultTextArea);
//
//        voteButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String name = nameField.getText();
//                String address = addressField.getText();
//                int age = Integer.parseInt(ageField.getText());
//                String cnic = cnicField.getText();
//                String votedParty = (String) partyComboBox.getSelectedItem();
//
//                Voter voter = new Voter(name, address, age, cnic);
//                voter.setVotedParty(votedParty);
//
//                saveVote(voter);
//                updateResults(votedParty);
//                displayResults(resultTextArea);
//            }
//        });
//    }
//
//    private static void saveVote(Voter voter) {
//        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(VOTERS_FILE, true))) {
//            oos.writeObject(voter);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private static void updateResults(String votedParty) {
//        partyVotes.put(votedParty, partyVotes.getOrDefault(votedParty, 0) + 1);
//        saveResults();
//    }
//
//    private static void displayResults(JTextArea resultTextArea) {
//        StringBuilder results = new StringBuilder("Results:\n");
//        for (Map.Entry<String, Integer> entry : partyVotes.entrySet()) {
//            results.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
//        }
//        resultTextArea.setText(results.toString());
//    }
//}

//=======================
