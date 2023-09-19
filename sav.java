import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class sav {
    public static void main(String[] args) {
        // Créer la fenêtre principale de l'application
        JFrame frame = new JFrame("Service Après-Vente");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // Créer un panneau principal pour organiser les composants
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));

        // Créer un panneau supérieur pour le formulaire
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(4, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createTitledBorder("Formulaire de SAV"));

        // Ajouter des composants pour le formulaire
        JLabel nomLabel = new JLabel("Nom du client:");
        JTextField nomField = new JTextField();
        JLabel numeroLabel = new JLabel("Numéro de téléphone:");
        JTextField numeroField = new JTextField();
        JLabel descriptionLabel = new JLabel("Description du problème:");
        JTextArea descriptionArea = new JTextArea();
        JButton soumettreButton = new JButton("Soumettre");

        // Ajouter les composants au panneau du formulaire
        formPanel.add(nomLabel);
        formPanel.add(nomField);
        formPanel.add(numeroLabel);
        formPanel.add(numeroField);
        formPanel.add(descriptionLabel);
        formPanel.add(descriptionArea);
        formPanel.add(new JLabel());
        formPanel.add(soumettreButton);

        // Créer un modèle de tableau pour stocker les données des clients et de leurs plaintes
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Nom du client");
        tableModel.addColumn("Numéro de téléphone");
        tableModel.addColumn("Description du problème");

        // Créer le tableau en utilisant le modèle
        JTable clientTable = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(clientTable);

        // Ajouter le tableau à un panneau séparé avec un titre
        JPanel tablePanel = new JPanel();
        tablePanel.setLayout(new BorderLayout());
        tablePanel.setBorder(BorderFactory.createTitledBorder("Liste des Demandes de SAV"));
        tablePanel.add(tableScrollPane, BorderLayout.CENTER);

        // Modifier l'action du bouton "Soumettre" pour ajouter une entrée au tableau
        soumettreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomClient = nomField.getText();
                String numeroClient = numeroField.getText();
                String descriptionProbleme = descriptionArea.getText();

                // Ajouter les données dans le modèle du tableau
                tableModel.addRow(new Object[]{nomClient, numeroClient, descriptionProbleme});

                // Réinitialiser les champs après la soumission
                nomField.setText("");
                numeroField.setText("");
                descriptionArea.setText("");

                JOptionPane.showMessageDialog(frame, "Demande de SAV soumise avec succès.");
            }
        });

        // Ajouter le panneau du formulaire en haut et le panneau du tableau en bas
        mainPanel.add(formPanel, BorderLayout.NORTH);
        mainPanel.add(tablePanel, BorderLayout.CENTER);

        // Ajouter le panneau principal à la fenêtre
        frame.add(mainPanel);

        // Centrer la fenêtre sur l'écran
        frame.setLocationRelativeTo(null);

        // Rendre la fenêtre visible
        frame.setVisible(true);
    }
}
