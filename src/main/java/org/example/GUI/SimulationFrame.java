package org.example.GUI;

import org.example.Logic.Scheduler.SelectionPolicy;
import org.example.Logic.SimulationManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class SimulationFrame extends JFrame {
    private JPanel prepareTextFields;
    private JTextField numberOfClients;
    private JTextField numberofQueues;
    private JTextField simulationInterval;
    private JTextField minArrivalTime;
    private JTextField maxArrivalTime;
    private JTextField minServiceTime;
    private JTextField maxServiceTime;
    private JComboBox<String> policyComboBox;
    private JButton generateSimulation;

    public SimulationFrame(String name) {
        super(name);
        prepareGui();
    }

    private void prepareGui() {
        setSize(500, 300);
        prepareTextFields();
        add(prepareTextFields);
    }

    private void prepareTextFields() {
        prepareTextFields = new JPanel();
        prepareTextFields.setLayout(new GridLayout(9, 2));
        JLabel numberClients = new JLabel("Number of Clients: ");
        numberOfClients = new JTextField();
        JLabel numberQueues = new JLabel("Number of Queues: ");
        numberofQueues = new JTextField();
        JLabel SimulationInterval = new JLabel("Simulation Interval: ");
        simulationInterval = new JTextField();
        JLabel minArrival = new JLabel("Minimum Arrival Time: ");
        minArrivalTime = new JTextField();
        JLabel maxArrival = new JLabel("Maximum Arrival Time: ");
        maxArrivalTime = new JTextField();
        JLabel minService = new JLabel("Minimum Service Time: ");
        minServiceTime = new JTextField();
        JLabel maxService = new JLabel("Maximum Service Time: ");
        maxServiceTime = new JTextField();
        JLabel policyLabel = new JLabel("Selection Policy: ");
        String[] policyOptions = { "Shortest Time", "Shortest Queue" };
        policyComboBox = new JComboBox<>(policyOptions);
        generateSimulation = new JButton("Generate Simulation");
        generateSimulation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int numClients = getNumberOfClients();
                int numQueues = getNumberOfQueues();
                int simInterval = getSimulationInterval();
                int minArrival = getMinArrivalTime();
                int maxArrival = getMaxArrivalTime();
                int minService = getMinServiceTime();
                int maxService = getMaxServiceTime();
                SelectionPolicy selectedPolicy = getSelectedPolicy();
                // Pass the selected policy to SimulationManager
                SimulationManager simulationManager = null;
                try {
                    simulationManager = new SimulationManager(simInterval, maxService, minService, minArrival, maxArrival, numQueues, numClients, selectedPolicy);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                simulationManager.run();
            }
        });
        prepareTextFields.add(numberClients);
        prepareTextFields.add(numberOfClients);
        prepareTextFields.add(numberQueues);
        prepareTextFields.add(numberofQueues);
        prepareTextFields.add(SimulationInterval);
        prepareTextFields.add(simulationInterval);
        prepareTextFields.add(minArrival);
        prepareTextFields.add(minArrivalTime);
        prepareTextFields.add(maxArrival);
        prepareTextFields.add(maxArrivalTime);
        prepareTextFields.add(minService);
        prepareTextFields.add(minServiceTime);
        prepareTextFields.add(maxService);
        prepareTextFields.add(maxServiceTime);
        prepareTextFields.add(policyLabel);
        prepareTextFields.add(policyComboBox);
        prepareTextFields.add(generateSimulation);
    }

    public int getNumberOfClients() {
        String text = numberOfClients.getText();
        if (text.isEmpty()) {
            return 0; // or another default value as needed
        } else {
            return Integer.parseInt(text);
        }
    }

    public int getNumberOfQueues() {
        String text = numberofQueues.getText();
        if (text.isEmpty()) {
            return 0; // or another default value as needed
        } else {
            return Integer.parseInt(text);
        }
    }

    public int getSimulationInterval() {
        String text = simulationInterval.getText();
        if (text.isEmpty()) {
            return 0; // or another default value as needed
        } else {
            return Integer.parseInt(text);
        }
    }

    public int getMinArrivalTime() {
        String text = minArrivalTime.getText();
        if (text.isEmpty()) {
            return 0; // or another default value as needed
        } else {
            return Integer.parseInt(text);
        }
    }

    public int getMaxArrivalTime() {
        String text = maxArrivalTime.getText();
        if (text.isEmpty()) {
            return 0; // or another default value as needed
        } else {
            return Integer.parseInt(text);
        }
    }

    public int getMinServiceTime() {
        String text = minServiceTime.getText();
        if (text.isEmpty()) {
            return 0; // or another default value as needed
        } else {
            return Integer.parseInt(text);
        }
    }

    public int getMaxServiceTime() {
        String text = maxServiceTime.getText();
        if (text.isEmpty()) {
            return 0; // or another default value as needed
        } else {
            return Integer.parseInt(text);
        }
    }

    public SelectionPolicy getSelectedPolicy() {
        String selectedPolicy = (String) policyComboBox.getSelectedItem();
        if (selectedPolicy.equals("Shortest Time")) {
            return SelectionPolicy.SHORTEST_TIME;
        } else {
            return SelectionPolicy.SHORTEST_QUEUE;
        }
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            SimulationFrame frame = new SimulationFrame("Simulation Frame");
            frame.setVisible(true);
        });
    }
}
