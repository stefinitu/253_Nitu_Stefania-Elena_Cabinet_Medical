import javax.swing.*;
import java.sql.*;

public class GUIOp26 {
    public void GUI() {
        JPanel panel = new JPanel();
        JDialog dialog = new JDialog();

        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Cabinetmedical?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "stefania");
            System.out.println("Conectarea la baza de date s-a efectuat cu succes!");

            String output="Introduceti tipul de data pe care doriti sa o modificati (CNP/NUME/PRENUME/SECTIE/GEN/ZIUA ANGAJARII/LUNA ANGAJARII/ANUL ANGAJARII/SALARIU/NUMAR DE TELEFON/EMAIL/NUMAR SALOANE ATRIBUITE)";
            JLabel outputLabel = new JLabel(output);
            panel.add(outputLabel);
            dialog.add(panel);
            dialog.pack();
            dialog.setVisible(true);
            String text=JOptionPane.showInputDialog("DATA");
            switch (text) {
                case "CNP":
                    String sqlUpdateAsistentCnp = "UPDATE asistent SET CNP=? WHERE CNP=?";
                    PreparedStatement ps1 = conn.prepareStatement(sqlUpdateAsistentCnp);
                    String cnpVechi =JOptionPane.showInputDialog("CNP vechi");
                    String cnpNou = JOptionPane.showInputDialog("CNP nou");
                    ps1.setString(1, cnpNou);
                    ps1.setString(2, cnpVechi);
                    int row1 = ps1.executeUpdate();
                    JOptionPane.showMessageDialog(null,"S-a actualizat un asistent din baza de date! Randul afectat a fost " + row1);
                    break;

                case "NUME":
                    String sqlUpdateAsistentNume = "UPDATE asistent SET NUME=? WHERE CNP=?";
                    PreparedStatement ps2 = conn.prepareStatement(sqlUpdateAsistentNume);
                    String cnp2 =JOptionPane.showInputDialog("CNP");
                    String numeNou = JOptionPane.showInputDialog("Nume nou");
                    ps2.setString(1, numeNou);
                    ps2.setString(2, cnp2);
                    int row2 = ps2.executeUpdate();
                    JOptionPane.showMessageDialog(null,"S-a actualizat un asistent din baza de date! Randul afectat a fost " + row2);
                    break;

                case "PRENUME":
                    String sqlUpdateAsistentPrenume = "UPDATE asistent SET PRENUME=? WHERE CNP=?";
                    PreparedStatement ps3 = conn.prepareStatement(sqlUpdateAsistentPrenume);
                    String cnp3 =JOptionPane.showInputDialog("CNP");
                    String prenumeNou = JOptionPane.showInputDialog("Prenume nou");
                    ps3.setString(1, prenumeNou);
                    ps3.setString(2, cnp3);
                    int row3 = ps3.executeUpdate();
                    JOptionPane.showMessageDialog(null,"S-a actualizat un asistent din baza de date! Randul afectat a fost " + row3);
                    break;

                case "SECTIE":
                    String sqlUpdateAsistentSectie = "UPDATE asistent SET SECTIE=? WHERE CNP=?";
                    PreparedStatement ps4 = conn.prepareStatement(sqlUpdateAsistentSectie);
                    String cnp4 =JOptionPane.showInputDialog("CNP");
                    String sectieNoua= JOptionPane.showInputDialog("Sectie noua");
                    ps4.setString(1, sectieNoua);
                    ps4.setString(2, cnp4);
                    int row4 = ps4.executeUpdate();
                    JOptionPane.showMessageDialog(null,"S-a actualizat un asistent din baza de date! Randul afectat a fost " + row4);
                    break;

                case "ZIUA ANGAJARII":
                    String sqlUpdateAsistentZi = "UPDATE asistent SET ZI_ANGAJARE=? WHERE CNP=?";
                    PreparedStatement ps5 = conn.prepareStatement(sqlUpdateAsistentZi);
                    String cnp5 =JOptionPane.showInputDialog("CNP");
                    String ziAngString= JOptionPane.showInputDialog("Zi angajare noua");
                    int ziNoua=Integer.parseInt(ziAngString);
                    ps5.setInt(1, ziNoua);
                    ps5.setString(2, cnp5);
                    int row5 = ps5.executeUpdate();
                    JOptionPane.showMessageDialog(null,"S-a actualizat un asistent din baza de date! Randul afectat a fost " + row5);
                    break;

                case "LUNA ANGAJARII":
                    String sqlUpdateAsistentLuna = "UPDATE asistent SET LUNA_ANGAJARE=? WHERE CNP=?";
                    PreparedStatement ps6 = conn.prepareStatement(sqlUpdateAsistentLuna);
                    String cnp6 =JOptionPane.showInputDialog("CNP");
                    String lunaAngString= JOptionPane.showInputDialog("Luna angajare noua");
                    int lunaNoua=Integer.parseInt(lunaAngString);
                    ps6.setInt(1, lunaNoua);
                    ps6.setString(2, cnp6);
                    int row6 = ps6.executeUpdate();
                    JOptionPane.showMessageDialog(null,"S-a actualizat un asistent din baza de date! Randul afectat a fost " + row6);
                    break;

                case "ANUL ANGAJARII":
                    String sqlUpdateAsistentAn = "UPDATE asistent SET AN_ANGAJARE=? WHERE CNP=?";
                    PreparedStatement ps7 = conn.prepareStatement(sqlUpdateAsistentAn);
                    String cnp7 =JOptionPane.showInputDialog("CNP");
                    String anAngString= JOptionPane.showInputDialog("An angajare nou");
                    int anNou=Integer.parseInt(anAngString);
                    ps7.setInt(1, anNou);
                    ps7.setString(2, cnp7);
                    int row7 = ps7.executeUpdate();
                    JOptionPane.showMessageDialog(null,"S-a actualizat un asistent din baza de date! Randul afectat a fost " + row7);
                    break;

                case "SALARIU":
                    String sqlUpdateAsistentSalariu = "UPDATE asistent SET SALARIU=? WHERE CNP=?";
                    PreparedStatement ps8 = conn.prepareStatement(sqlUpdateAsistentSalariu);
                    String cnp8 =JOptionPane.showInputDialog("CNP");
                    String salariuString= JOptionPane.showInputDialog("Salariu nou");
                    Double salariuNou=Double.parseDouble(salariuString);
                    ps8.setDouble(1, salariuNou);
                    ps8.setString(2, cnp8);
                    int row8 = ps8.executeUpdate();
                    JOptionPane.showMessageDialog(null,"S-a actualizat un asistent din baza de date! Randul afectat a fost " + row8);
                    break;

                case "NUMAR DE TELEFON":
                    String sqlUpdateAsistentTelefon = "UPDATE asistent SET NR_TELEFON=? WHERE CNP=?";
                    PreparedStatement ps9 = conn.prepareStatement(sqlUpdateAsistentTelefon);
                    String cnp9 =JOptionPane.showInputDialog("CNP");
                    String telefonNou= JOptionPane.showInputDialog("Numar de telefon nou");
                    ps9.setString(1, telefonNou);
                    ps9.setString(2, cnp9);
                    int row9 = ps9.executeUpdate();
                    JOptionPane.showMessageDialog(null,"S-a actualizat un asistent din baza de date! Randul afectat a fost " + row9);
                    break;

                case "EMAIL":
                    String sqlUpdateAsistentEmail = "UPDATE asistent SET EMAIL=? WHERE EMAIL=?";
                    PreparedStatement ps10 = conn.prepareStatement(sqlUpdateAsistentEmail);
                    String cnp10 =JOptionPane.showInputDialog("CNP");
                    String emailNou= JOptionPane.showInputDialog("Email nou");
                    ps10.setString(1, emailNou);
                    ps10.setString(2, cnp10);
                    int row10 = ps10.executeUpdate();
                    JOptionPane.showMessageDialog(null,"S-a actualizat un asistent din baza de date! Randul afectat a fost " + row10);
                    break;

                case "NUMAR SALOANE ATRIBUITE":
                    String sqlUpdateAsistentSal = "UPDATE asistent SET NR_SALOANE=? WHERE CNP=?";
                    PreparedStatement ps11 = conn.prepareStatement(sqlUpdateAsistentSal);
                    String cnp11 =JOptionPane.showInputDialog("CNP");
                    String nrNouString= JOptionPane.showInputDialog("Numar nou de saloane");
                    Double nrNou=Double.parseDouble(nrNouString);
                    ps11.setDouble(1, nrNou);
                    ps11.setString(2, cnp11);
                    int row11 = ps11.executeUpdate();
                    JOptionPane.showMessageDialog(null,"S-a actualizat un asistent din baza de date! Randul afectat a fost " + row11);
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
