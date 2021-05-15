import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.sql.*;

public class GUIOp13 {
    public void GUI() {
        JPanel panel = new JPanel();
        JDialog dialog = new JDialog();

        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/CabinetMedical?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "stefania");
            System.out.println("Conectarea la baza de date s-a efectuat cu succes!");

            String output="Introduceti tipul de data pe care doriti sa o modificati (CNP/NUME/PRENUME/SECTIE/GEN/ZIUA ANGAJARII/LUNA ANGAJARII/ANUL ANGAJARII/SALARIU/NUMAR DE TELEFON/EMAIL/COD PARAFA/SPECIALIZARE/REZIDENT/GARDA)";
            JLabel outputLabel = new JLabel(output);
            panel.add(outputLabel);
            dialog.add(panel);
            dialog.pack();
            dialog.setVisible(true);
            String text=JOptionPane.showInputDialog("DATA");
            switch (text) {
                case "CNP":
                    String sqlUpdateMedicCnp = "UPDATE medic SET CNP=? WHERE CNP=?";
                    PreparedStatement ps1 = conn.prepareStatement(sqlUpdateMedicCnp);
                    String cnpVechi =JOptionPane.showInputDialog("CNP vechi");
                    String cnpNou = JOptionPane.showInputDialog("CNP nou");
                    ps1.setString(1, cnpNou);
                    ps1.setString(2, cnpVechi);
                    int row1 = ps1.executeUpdate();
                    JOptionPane.showMessageDialog(null,"S-a actualizat un medic din baza de date! Randul afectat a fost " + row1);
                    break;

                case "NUME":
                    String sqlUpdateMedicNume = "UPDATE medic SET NUME=? WHERE CNP=?";
                    PreparedStatement ps2 = conn.prepareStatement(sqlUpdateMedicNume);
                    String cnp2 =JOptionPane.showInputDialog("CNP");
                    String numeNou = JOptionPane.showInputDialog("Nume nou");
                    ps2.setString(1, numeNou);
                    ps2.setString(2, cnp2);
                    int row2 = ps2.executeUpdate();
                    JOptionPane.showMessageDialog(null,"S-a actualizat un medic din baza de date! Randul afectat a fost " + row2);
                    break;

                case "PRENUME":
                    String sqlUpdateMedicPrenume = "UPDATE medic SET PRENUME=? WHERE CNP=?";
                    PreparedStatement ps3 = conn.prepareStatement(sqlUpdateMedicPrenume);
                    String cnp3 =JOptionPane.showInputDialog("CNP");
                    String prenumeNou = JOptionPane.showInputDialog("Prenume nou");
                    ps3.setString(1, prenumeNou);
                    ps3.setString(2, cnp3);
                    int row3 = ps3.executeUpdate();
                    JOptionPane.showMessageDialog(null,"S-a actualizat un medic din baza de date! Randul afectat a fost " + row3);
                    break;

                case "SECTIE":
                    String sqlUpdateMedicSectie = "UPDATE medic SET SECTIE=? WHERE CNP=?";
                    PreparedStatement ps4 = conn.prepareStatement(sqlUpdateMedicSectie);
                    String cnp4 =JOptionPane.showInputDialog("CNP");
                    String sectieNoua= JOptionPane.showInputDialog("Sectie noua");
                    ps4.setString(1, sectieNoua);
                    ps4.setString(2, cnp4);
                    int row4 = ps4.executeUpdate();
                    JOptionPane.showMessageDialog(null,"S-a actualizat un medic din baza de date! Randul afectat a fost " + row4);
                    break;

                case "ZIUA ANGAJARII":
                    String sqlUpdateMedicZi = "UPDATE medic SET ZI_ANGAJARE=? WHERE CNP=?";
                    PreparedStatement ps5 = conn.prepareStatement(sqlUpdateMedicZi);
                    String cnp5 =JOptionPane.showInputDialog("CNP");
                    String ziAngString= JOptionPane.showInputDialog("Zi angajare noua");
                    int ziNoua=Integer.parseInt(ziAngString);
                    ps5.setInt(1, ziNoua);
                    ps5.setString(2, cnp5);
                    int row5 = ps5.executeUpdate();
                    JOptionPane.showMessageDialog(null,"S-a actualizat un medic din baza de date! Randul afectat a fost " + row5);
                    break;

                case "LUNA ANGAJARII":
                    String sqlUpdateMedicLuna = "UPDATE medic SET LUNA_ANGAJARE=? WHERE CNP=?";
                    PreparedStatement ps6 = conn.prepareStatement(sqlUpdateMedicLuna);
                    String cnp6 =JOptionPane.showInputDialog("CNP");
                    String lunaAngString= JOptionPane.showInputDialog("Luna angajare noua");
                    int lunaNoua=Integer.parseInt(lunaAngString);
                    ps6.setInt(1, lunaNoua);
                    ps6.setString(2, cnp6);
                    int row6 = ps6.executeUpdate();
                    JOptionPane.showMessageDialog(null,"S-a actualizat un medic din baza de date! Randul afectat a fost " + row6);
                    break;

                case "ANUL ANGAJARII":
                    String sqlUpdateMedicAn = "UPDATE medic SET AN_ANGAJARE=? WHERE CNP=?";
                    PreparedStatement ps7 = conn.prepareStatement(sqlUpdateMedicAn);
                    String cnp7 =JOptionPane.showInputDialog("CNP");
                    String anAngString= JOptionPane.showInputDialog("An angajare nou");
                    int anNou=Integer.parseInt(anAngString);
                    ps7.setInt(1, anNou);
                    ps7.setString(2, cnp7);
                    int row7 = ps7.executeUpdate();
                    JOptionPane.showMessageDialog(null,"S-a actualizat un medic din baza de date! Randul afectat a fost " + row7);
                    break;

                case "SALARIU":
                    String sqlUpdateMedicSalariu = "UPDATE medic SET SALARIU=? WHERE CNP=?";
                    PreparedStatement ps8 = conn.prepareStatement(sqlUpdateMedicSalariu);
                    String cnp8 =JOptionPane.showInputDialog("CNP");
                    String salariuString= JOptionPane.showInputDialog("Salariu nou");
                    Double salariuNou=Double.parseDouble(salariuString);
                    ps8.setDouble(1, salariuNou);
                    ps8.setString(2, cnp8);
                    int row8 = ps8.executeUpdate();
                    JOptionPane.showMessageDialog(null,"S-a actualizat un medic din baza de date! Randul afectat a fost " + row8);
                    break;

                case "NUMAR DE TELEFON":
                    String sqlUpdateMedicTelefon = "UPDATE medic SET NR_TELEFON=? WHERE CNP=?";
                    PreparedStatement ps9 = conn.prepareStatement(sqlUpdateMedicTelefon);
                    String cnp9 =JOptionPane.showInputDialog("CNP");
                    String telefonNou= JOptionPane.showInputDialog("Numar de telefon nou");
                    ps9.setString(1, telefonNou);
                    ps9.setString(2, cnp9);
                    int row9 = ps9.executeUpdate();
                    JOptionPane.showMessageDialog(null,"S-a actualizat un medic din baza de date! Randul afectat a fost " + row9);
                    break;

                case "EMAIL":
                    String sqlUpdateMedicEmail = "UPDATE medic SET EMAIL=? WHERE EMAIL=?";
                    PreparedStatement ps10 = conn.prepareStatement(sqlUpdateMedicEmail);
                    String cnp10 =JOptionPane.showInputDialog("CNP");
                    String emailNou= JOptionPane.showInputDialog("Email nou");
                    ps10.setString(1, emailNou);
                    ps10.setString(2, cnp10);
                    int row10 = ps10.executeUpdate();
                    JOptionPane.showMessageDialog(null,"S-a actualizat un medic din baza de date! Randul afectat a fost " + row10);
                    break;

                case "COD PARAFA":
                    String sqlUpdateMedicCod = "UPDATE medic SET COD_PARAFA=? WHERE CNP=?";
                    PreparedStatement ps11 = conn.prepareStatement(sqlUpdateMedicCod);
                    String cnp11 =JOptionPane.showInputDialog("CNP");
                    String codNouString= JOptionPane.showInputDialog("Cod parafa nou");
                    Double codNou=Double.parseDouble(codNouString);
                    ps11.setDouble(1, codNou);
                    ps11.setString(2, cnp11);
                    int row11 = ps11.executeUpdate();
                    JOptionPane.showMessageDialog(null,"S-a actualizat un medic din baza de date! Randul afectat a fost " + row11);
                    break;

                case "SPECIALIZARE":
                    String sqlUpdateMedicSp = "UPDATE medic SET SPECIALIZARE=? WHERE CNP=?";
                    PreparedStatement ps12 = conn.prepareStatement(sqlUpdateMedicSp);
                    String cnp12 =JOptionPane.showInputDialog("CNP");
                    String specializareNoua= JOptionPane.showInputDialog("Specializare noua");
                    ps12.setString(1, specializareNoua);
                    ps12.setString(2, cnp12);
                    int row12 = ps12.executeUpdate();
                    JOptionPane.showMessageDialog(null,"S-a actualizat un medic din baza de date! Randul afectat a fost " + row12);
                    break;

                case "REZIDENT":
                    String sqlUpdateMedicRez = "UPDATE medic SET REZIDENT=? WHERE CNP=?";
                    PreparedStatement ps13 = conn.prepareStatement(sqlUpdateMedicRez);
                    String cnp13 =JOptionPane.showInputDialog("CNP");
                    String rezidentString= JOptionPane.showInputDialog("Valoare noua rezident");
                    Boolean rezidentNou=Boolean.parseBoolean(rezidentString);
                    ps13.setBoolean(1, rezidentNou);
                    ps13.setString(2, cnp13);
                    int row13 = ps13.executeUpdate();
                    JOptionPane.showMessageDialog(null,"S-a actualizat un medic din baza de date! Randul afectat a fost " + row13);
                    break;

                case "GARDA":
                    String sqlUpdateMedicGarda = "UPDATE medic SET GARDA=? WHERE CNP=?";
                    PreparedStatement ps14 = conn.prepareStatement(sqlUpdateMedicGarda);
                    String cnp14 =JOptionPane.showInputDialog("CNP");
                    String gardaString= JOptionPane.showInputDialog("Valoare noua medic de garda");
                    Boolean gardaNou=Boolean.parseBoolean(gardaString);
                    ps14.setBoolean(1, gardaNou);
                    ps14.setString(2, cnp14);
                    int row14 = ps14.executeUpdate();
                    JOptionPane.showMessageDialog(null,"S-a actualizat un medic din baza de date! Randul afectat a fost " + row14);
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
