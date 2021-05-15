import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.Scanner;

public class GUIOp8 {
    public void GUI()
    {
        JPanel panel=new JPanel();
        JDialog dialog = new JDialog();

        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/CabinetMedical?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "stefania");
            System.out.println("Conectarea la baza de date s-a efectuat cu succes!");
            Scanner sc=new Scanner(System.in);
            String output="Introduceti tipul de data pe care doriti sa o modificati (CNP/NUME/PRENUME/EMAIL/GEN/ADRESA/NUME INSOTITOR/PRENUME INSOTITOR/NUMAR DE TELEFON INSOTITOR)";
            JLabel outputLabel = new JLabel(output);
            panel.add(outputLabel);
            dialog.add(panel);
            dialog.pack();
            dialog.setVisible(true);
            String text=JOptionPane.showInputDialog("DATA");
            switch(text) {
                case "CNP":
                    String sqlUpdateMinCnp="UPDATE ClientMinor SET CNP=? WHERE CNP=?";
                    PreparedStatement ps1 = conn.prepareStatement(sqlUpdateMinCnp);
                    String cnpVechi =JOptionPane.showInputDialog("CNP vechi");
                    String cnpNou = JOptionPane.showInputDialog("CNP nou");
                    ps1.setString(1, cnpNou);
                    ps1.setString(2, cnpVechi);
                    int row1 = ps1.executeUpdate();
                    JOptionPane.showMessageDialog(null,"S-a actualizat un client minor din baza de date! Randul afectat a fost "+row1);
                    break;

                case "NUME":
                    String sqlUpdateMinNume="UPDATE ClientMinor SET NUME=? WHERE CNP=?";
                    PreparedStatement ps2 = conn.prepareStatement(sqlUpdateMinNume);
                    String cnp2 = JOptionPane.showInputDialog("CNP");
                    String numeNou = JOptionPane.showInputDialog("Nume nou");
                    ps2.setString(1, numeNou);
                    ps2.setString(2, cnp2);
                    int row2 = ps2.executeUpdate();
                    JOptionPane.showMessageDialog(null,"S-a actualizat un client minor din baza de date! Randul afectat a fost "+row2);
                    break;

                case "PRENUME":
                    String sqlUpdateMinPrenume="UPDATE ClientMinor SET PRENUME=? WHERE CNP=?";
                    PreparedStatement ps3 = conn.prepareStatement(sqlUpdateMinPrenume);
                    String cnp3 = JOptionPane.showInputDialog("CNP");
                    String prenumeNou = JOptionPane.showInputDialog("Prenumele nou");
                    ps3.setString(1, prenumeNou);
                    ps3.setString(2, cnp3);
                    int row3 = ps3.executeUpdate();
                    JOptionPane.showMessageDialog(null,"S-a actualizat un client minor din baza de date! Randul afectat a fost "+row3);
                    break;

                case "EMAIL":
                    String sqlUpdateMinEmail="UPDATE ClientMinor SET EMAIL=? WHERE CNP=?";
                    PreparedStatement ps4 = conn.prepareStatement(sqlUpdateMinEmail);
                    String cnp4 = JOptionPane.showInputDialog("CNP");
                    String emailNou = JOptionPane.showInputDialog("Email nou");
                    ps4.setString(1, emailNou);
                    ps4.setString(2, cnp4);
                    int row4 = ps4.executeUpdate();
                    JOptionPane.showMessageDialog(null,"S-a actualizat un client minor din baza de date! Randul afectat a fost "+row4);
                    break;

                case "GEN":
                    String sqlUpdateMinGen="UPDATE ClientMinor SET GEN=? WHERE GEN=?";
                    PreparedStatement ps5 = conn.prepareStatement(sqlUpdateMinGen);
                    String cnp5 = JOptionPane.showInputDialog("CNP");
                    String genNou = JOptionPane.showInputDialog("Gen nou");
                    ps5.setString(1, genNou);
                    ps5.setString(2, cnp5);
                    int row5 = ps5.executeUpdate();
                    JOptionPane.showMessageDialog(null,"S-a actualizat un client minor din baza de date! Randul afectat a fost "+row5);
                    break;

                case "ADRESA":
                    String sqlUpdateMinAdresa="UPDATE ClientMinor SET ADRESA=? WHERE CNP=?";
                    PreparedStatement ps6 = conn.prepareStatement(sqlUpdateMinAdresa);
                    String cnp6 = JOptionPane.showInputDialog("CNP");
                    String adresaNoua = JOptionPane.showInputDialog("Adresa noua");
                    ps6.setString(1, adresaNoua);
                    ps6.setString(2, cnp6);
                    int row6 = ps6.executeUpdate();
                    JOptionPane.showMessageDialog(null,"S-a actualizat un client minor din baza de date! Randul afectat a fost "+row6);
                    break;

                case "NUME INSOTITOR":
                    String sqlUpdateMinNumeIn="UPDATE ClientMinor SET NUME_INSOTITOR=? WHERE CNP=?";
                    PreparedStatement ps7 = conn.prepareStatement(sqlUpdateMinNumeIn);
                    String cnp7 = JOptionPane.showInputDialog("CNP");
                    String numeInNou = JOptionPane.showInputDialog("Nume insotitor nou");
                    ps7.setString(1, numeInNou);
                    ps7.setString(2, cnp7);
                    int row7 = ps7.executeUpdate();
                    JOptionPane.showMessageDialog(null,"S-a actualizat un client minor din baza de date! Randul afectat a fost "+row7);
                    break;

                case "PRENUME INSOTITOR":
                    String sqlUpdateMinPrenumeIn="UPDATE ClientMinor SET PRENUME_INSOTITOR=? WHERE CNP=?";
                    PreparedStatement ps8 = conn.prepareStatement(sqlUpdateMinPrenumeIn);
                    String cnp8 = JOptionPane.showInputDialog("CNP");
                    String prenumeInNou = JOptionPane.showInputDialog("Prenume insotitor nou");
                    ps8.setString(1, prenumeInNou);
                    ps8.setString(2, cnp8);
                    int row8 = ps8.executeUpdate();
                    JOptionPane.showMessageDialog(null,"S-a actualizat un client minor din baza de date! Randul afectat a fost "+row8);
                    break;

                case "NUMAR DE TELEFON INSOTITOR":
                    String sqlUpdateMinTelefonIn="UPDATE ClientMinor SET NR_TELEFON_INSOTITOR=? WHERE CNP=?";
                    PreparedStatement ps9 = conn.prepareStatement(sqlUpdateMinTelefonIn);
                    String cnp9 = JOptionPane.showInputDialog("CNP");
                    String telefonNou = JOptionPane.showInputDialog("Numar de telefon insotitor nou");
                    ps9.setString(1, telefonNou);
                    ps9.setString(2, cnp9);
                    int row9 = ps9.executeUpdate();
                    JOptionPane.showMessageDialog(null,"S-a actualizat un client minor din baza de date! Randul afectat a fost "+row9);
                    break;

                default:
                    JOptionPane.showMessageDialog(null,"OPTIUNE INVALIDA! ALEGETI DIN NOU!");
                    break;
            }
        } catch (SQLException | ClassNotFoundException var10) {
            var10.printStackTrace();
        }
}
}
