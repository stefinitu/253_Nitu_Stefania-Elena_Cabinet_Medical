import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class GUIOp4 {
    public void GUI()
    {
        JPanel panel=new JPanel();
        JDialog dialog = new JDialog();
        JButton closeButton = new JButton("Close");

        Connection conn = null;
        Statement st = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/CabinetMedical?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "stefania");
            System.out.println("Conectarea la baza de date s-a efectuat cu succes!");
            Scanner sc=new Scanner(System.in);
            String output="Introduceti tipul de data pe care doriti sa o modificati (CNP/NUME/PRENUME/EMAIL/GEN/ADRESA/ID CARD SANATATE/NUMAR DE TELEFON)";
            JLabel outputLabel = new JLabel(output);
            panel.add(outputLabel);
            dialog.add(panel);
            dialog.pack();
            dialog.setVisible(true);

            String text=JOptionPane.showInputDialog("DATA");
            switch(text) {
                case "CNP":
                    String sqlUpdateMajCnp="UPDATE ClientMajor SET CNP=? WHERE CNP=?";
                    PreparedStatement ps1 = conn.prepareStatement(sqlUpdateMajCnp);
                    String cnpVechi =JOptionPane.showInputDialog("CNP vechi");
                    String cnpNou = JOptionPane.showInputDialog("CNP nou");
                    ps1.setString(1, cnpNou);
                    ps1.setString(2, cnpVechi);
                    int row1 = ps1.executeUpdate();
                    JOptionPane.showMessageDialog(null,"S-a actualizat un client major din baza de date! Randul afectat a fost "+row1);
                    break;

                case "NUME":
                    String sqlUpdateMajNume="UPDATE ClientMajor SET NUME=? WHERE CNP=?";
                    PreparedStatement ps2 = conn.prepareStatement(sqlUpdateMajNume);
                    String cnp = JOptionPane.showInputDialog("CNP");
                    String numeNou = JOptionPane.showInputDialog("Nume nou");
                    ps2.setString(1, numeNou);
                    ps2.setString(2, cnp);
                    int row2 = ps2.executeUpdate();
                    JOptionPane.showMessageDialog(null,"S-a actualizat un client major din baza de date! Randul afectat a fost "+row2);
                    break;

                case "PRENUME":
                    String sqlUpdateMajPrenume="UPDATE ClientMajor SET PRENUME=? WHERE CNP=?";
                    PreparedStatement ps3 = conn.prepareStatement(sqlUpdateMajPrenume);
                    String cnp3 = JOptionPane.showInputDialog("CNP");
                    String prenumeNou = JOptionPane.showInputDialog("Prenumele nou");
                    ps3.setString(1, prenumeNou);
                    ps3.setString(2, cnp3);
                    int row3 = ps3.executeUpdate();
                    JOptionPane.showMessageDialog(null,"S-a actualizat un client major din baza de date! Randul afectat a fost "+row3);
                    break;

                case "EMAIL":
                    String sqlUpdateMajEmail="UPDATE ClientMajor SET EMAIL=? WHERE CNP=?";
                    PreparedStatement ps4 = conn.prepareStatement(sqlUpdateMajEmail);
                    String cnp4 = JOptionPane.showInputDialog("CNP");
                    String emailNou = JOptionPane.showInputDialog("Email nou");
                    ps4.setString(1, emailNou);
                    ps4.setString(2, cnp4);
                    int row4 = ps4.executeUpdate();
                    JOptionPane.showMessageDialog(null,"S-a actualizat un client major din baza de date! Randul afectat a fost "+row4);
                    break;

                case "GEN":
                    String sqlUpdateMajGen="UPDATE ClientMajor SET GEN=? WHERE CNP=?";
                    PreparedStatement ps5 = conn.prepareStatement(sqlUpdateMajGen);
                    String cnp5 = JOptionPane.showInputDialog("CNP");
                    String genNou = JOptionPane.showInputDialog("Gen nou");
                    ps5.setString(1, genNou);
                    ps5.setString(2, cnp5);
                    int row5 = ps5.executeUpdate();
                    JOptionPane.showMessageDialog(null,"S-a actualizat un client major din baza de date! Randul afectat a fost "+row5);
                    break;

                case "ADRESA":
                    String sqlUpdateMajAdresa="UPDATE ClientMajor SET ADRESA=? WHERE CNP=?";
                    PreparedStatement ps6 = conn.prepareStatement(sqlUpdateMajAdresa);
                    String cnp6 = JOptionPane.showInputDialog("CNP");
                    String adresaNoua = JOptionPane.showInputDialog("Adresa noua");
                    ps6.setString(1, adresaNoua);
                    ps6.setString(2, cnp6);
                    int row6 = ps6.executeUpdate();
                    JOptionPane.showMessageDialog(null,"S-a actualizat un client major din baza de date! Randul afectat a fost "+row6);
                    break;

                case "ID CARD SANATATE":
                    String sqlUpdateMajCard="UPDATE ClientMajor SET ID_CARDSANATATE=? WHERE CNP=?";
                    PreparedStatement ps7 = conn.prepareStatement(sqlUpdateMajCard);
                    String cnp7=JOptionPane.showInputDialog("CNP");
                    String cardN=JOptionPane.showInputDialog("ID Card Nou");
                    Double cardNou = Double.parseDouble(cardN);
                    ps7.setDouble(1, cardNou);
                    ps7.setString(2, cnp7);
                    int row7 = ps7.executeUpdate();
                    JOptionPane.showMessageDialog(null,"S-a actualizat un client major din baza de date! Randul afectat a fost "+row7);
                    break;

                case "NUMAR DE TELEFON":
                    String sqlUpdateMajTelefon="UPDATE ClientMajor SET NR_TELEFON=? WHERE CNP=?";
                    PreparedStatement ps8 = conn.prepareStatement(sqlUpdateMajTelefon);
                    String cnp8 = JOptionPane.showInputDialog("CNP");
                    String telefonNou = JOptionPane.showInputDialog("Numar de telefon nou");
                    ps8.setString(1, telefonNou);
                    ps8.setString(2, cnp8);
                    int row8 = ps8.executeUpdate();
                    JOptionPane.showMessageDialog(null,"S-a actualizat un client major din baza de date! Randul afectat a fost "+row8);
                    break;

                default:
                    JOptionPane.showMessageDialog(null,"OPTIUNE INVALIDA! ALEGETI DIN NOU!");
                    break;
            }
        } catch (SQLException | ClassNotFoundException var10) {
            var10.printStackTrace();
        }
        dialog.add(closeButton, BorderLayout.SOUTH);
        closeButton.addActionListener(e -> dialog.setVisible(false));

    }
}
