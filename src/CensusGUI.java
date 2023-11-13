//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.ArrayList;
//import java.util.List;
//
//// Person class represents a generic person with a name, age, and address
//class Person {
//    private String name;
//    private int age;
//    private String address;
//
//    // Constructor
//    public Person(String name, int age, String address) {
//        this.name = name;
//        this.age = age;
//        this.address = address;
//    }
//
//    // Getter and setter methods for attributes
//    public String getName() {
//        return name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//}
//
//// Citizen class represents information about a citizen, inherits from Person
//class Citizen extends Person {
//    private int nationalID;
//    private String occupation;
//
//    // Constructor
//    public Citizen(String name, int age, String address, int nationalID) {
//        super(name, age, address);
//        this.nationalID = nationalID;
//        this.occupation = "";
//    }
//
//    // Getter and setter methods for attributes
//    public int getNationalID() {
//        return nationalID;
//    }
//
//    public String getOccupation() {
//        return occupation;
//    }
//
//    public void setOccupation(String occupation) {
//        this.occupation = occupation;
//    }
//}
//
//// Enumerator class represents an enumerator, inherits from Person
//class Enumerator extends Person {
//    public Enumerator(String name, int age, String address) {
//        super(name, age, address);
//    }
//
//    // Method to collect data from a citizen
//    public void collectData(Citizen citizen) {
//        // Logic for collecting data from a citizen
//        // ...
//    }
//}
//
//// CensusManager class manages the census data
//class CensusManager {
//    private List<Citizen> citizenList;
//
//    // Constructor
//    public CensusManager() {
//        this.citizenList = new ArrayList<>();
//    }
//
//    // Method to add a citizen to the citizen list
//    public void addCitizen(Citizen citizen) {
//        citizenList.add(citizen);
//    }
//
//    // Method to generate a census report
//    public List<Citizen> getCitizenList() {
//        return citizenList;
//    }
//}
//
//// GUI class to interact with the Census Management System
//public class CensusGUI extends JFrame {
//
//    private CensusManager censusManager;
//
//    // GUI components
//    private JTextField nameField, ageField, addressField, idField, occupationField;
//    private JTextArea reportArea;
//
//    public CensusGUI() {
//        // Initialize CensusManager
//        censusManager = new CensusManager();
//
//        // Set up the JFrame
//        setTitle("Census Management System");
//        setSize(600, 400);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLocationRelativeTo(null);
//
//        // Create GUI components
//        nameField = new JTextField(20);
//        ageField = new JTextField(3);
//        addressField = new JTextField(20);
//        idField = new JTextField(9);
//        occupationField = new JTextField(20);
//        reportArea = new JTextArea(10, 40);
//        JButton addButton = new JButton("Add Citizen");
//        JButton reportButton = new JButton("Generate Census Report");
//
//        // Set up the main panel
//        JPanel mainPanel = new JPanel();
//        mainPanel.setLayout(new GridLayout(3, 1));
//
//        // Panel for adding citizens
//        JPanel addPanel = new JPanel();
//        addPanel.add(new JLabel("Name:"));
//        addPanel.add(nameField);
//        addPanel.add(new JLabel("Age:"));
//        addPanel.add(ageField);
//        addPanel.add(new JLabel("Address:"));
//        addPanel.add(addressField);
//        addPanel.add(new JLabel("National ID:"));
//        addPanel.add(idField);
//        addPanel.add(new JLabel("Occupation:"));
//        addPanel.add(occupationField);
//        addPanel.add(addButton);
//
//        // Panel for generating the census report
//        JPanel reportPanel = new JPanel();
//        reportPanel.add(reportButton);
//
//        // Panel for displaying the report
//        JScrollPane reportScrollPane = new JScrollPane(reportArea);
//        JPanel displayPanel = new JPanel();
//        displayPanel.add(reportScrollPane);
//
//        // Add action listeners to buttons
//        addButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                addCitizen();
//            }
//        });
//
//        reportButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                generateReport();
//            }
//        });
//
//        // Add panels to the main panel
//        mainPanel.add(addPanel);
//        mainPanel.add(reportPanel);
//        mainPanel.add(displayPanel);
//
//        // Add the main panel to the JFrame
//        add(mainPanel);
//
//        // Set the JFrame to be visible
//        setVisible(true);
//    }
//
//    private void addCitizen() {
//        // Extract data from GUI fields
//        String name = nameField.getText();
//        int age = Integer.parseInt(ageField.getText());
//        String address = addressField.getText();
//        int id = Integer.parseInt(idField.getText());
//        String occupation = occupationField.getText();
//
//        // Create a new citizen and add to the CensusManager
//        Citizen citizen = new Citizen(name, age, address, id);
//        citizen.setOccupation(occupation);
//        censusManager.addCitizen(citizen);
//
//        // Clear input fields
//        nameField.setText("");
//        ageField.setText("");
//        addressField.setText("");
//        idField.setText("");
//        occupationField.setText("");
//
//        // Notify user
//        JOptionPane.showMessageDialog(this, "Citizen added successfully!");
//    }
//
//    private void generateReport() {
//        // Generate and display the census report in the JTextArea
//        reportArea.setText("Census Report:\n");
//        for (Citizen citizen : censusManager.getCitizenList()) {
//            reportArea.append("Name: " + citizen.getName() + ", Age: " + citizen.getAge() +
//                    ", Address: " + citizen.getAddress() + ", National ID: " + citizen.getNationalID() +
//                    ", Occupation: " + citizen.getOccupation() + "\n");
//        }
//    }
//
//    public static void main(String[] args) {
//        // Run the GUI on the event dispatch thread
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new CensusGUI();
//            }
//        });
//    }
//}
//
////------------------------------
//
////// Main.java
////public class Main {
////    public static void main(String[] args) {
////        // Doctor portal
////        DoctorPortalGUI doctorPortal = new DoctorPortalGUI();
////
////        // Pharmacist portal
////        PharmacistPortalGUI pharmacistPortal = new PharmacistPortalGUI();
////    }
////}
