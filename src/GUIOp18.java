import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GUIOp18 {
    public void GUI() {
        JPanel panel = new JPanel();
        JDialog dialog = new JDialog();

        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/CabinetMedical?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "stefania");
            System.out.println("Conectarea la baza de date s-a efectuat cu succes!");
            String output="Introduceti tipul de data pe care doriti sa o modificati (ID PROGRAMARE/COD BILET TRIMITERE/CNP/ZIUA PROGRAMARII/LUNA PROGRAMARII/ANUL PROGRAMARII/ZIUA PLANIFICARII/LUNA PLANIFICARII/ANUL PLANIFICARII/SECTIA)";
            String text = JOptionPane.showInputDialog("DATA");
            switch (text) {
                case "ID PROGRAMARE":
                    String sqlUpdatePrMajID = "UPDATE programare_clientmajor SET ID_PROGRAMARE=? WHERE ID_PROGRAMARE=?";
                    PreparedStatement ps1 = conn.prepareStatement(sqlUpdatePrMajID);
                    String idVechi =JOptionPane.showInputDialog("ID vechi");
                    String idNou = JOptionPane.showInputDialog("ID nou");
                    ps1.setDouble(1, Double.parseDouble(idNou));
                    ps1.setDouble(2, Double.parseDouble(idVechi));
                    int row1 = ps1.executeUpdate();
                    JOptionPane.showMessageDialog(null,"S-a actualizat o programare din baza de date! Randul afectat a fost " + row1);
                    break;

                case "COD BILET TRIMITERE":
                    String sqlUpdatePrMajCod = "UPDATE programare_clientmajor SET COD_BILET=? WHERE ID_PROGRAMARE=?";
                    PreparedStatement ps2 = conn.prepareStatement(sqlUpdatePrMajCod);
                    String idString =JOptionPane.showInputDialog("ID");
                    Double id2=Double.parseDouble(idString);
                    String codString = JOptionPane.showInputDialog("Cod nou");
                    Double codNou=Double.parseDouble(codString);
                    ps2.setDouble(1, codNou);
                    ps2.setDouble(2, id2);
                    int row2 = ps2.executeUpdate();
                    JOptionPane.showMessageDialog(null,"S-a actualizat o programare din baza de date! Randul afectat a fost " + row2);
                    break;

                case "CNP":
                    String sqlUpdatePrMajCnp = "UPDATE programare_clientmajor SET CNP=? WHERE ID_PROGRAMARE=?";
                    PreparedStatement ps3 = conn.prepareStatement(sqlUpdatePrMajCnp);
                    String id3 =JOptionPane.showInputDialog("ID");
                    String cnpNou = JOptionPane.showInputDialog("CNP nou");
                    ps3.setString(1, cnpNou);
                    ps3.setString(2, id3);
                    int row3 = ps3.executeUpdate();
                    JOptionPane.showMessageDialog(null,"S-a actualizat o programare din baza de date! Randul afectat a fost " + row3);
                    break;


                case "ZIUA PROGRAMARII":
                    String sqlUpdatePrMajZiProg = "UPDATE programare_clientmajor SET ZI_PROGRAMARE=? WHERE ID_PROGRAMARE=?";
                    PreparedStatement ps4 = conn.prepareStatement(sqlUpdatePrMajZiProg);
                    String id4 =JOptionPane.showInputDialog("ID");
                    String ziProgString = JOptionPane.showInputDialog("Zi programare noua");
                    int ziNoua = Integer.parseInt(ziProgString);
                    ps4.setInt(1, ziNoua);
                    ps4.setString(2, id4);
                    int row4 = ps4.executeUpdate();
                    JOptionPane.showMessageDialog(null,"S-a actualizat o programare din baza de date! Randul afectat a fost " + row4);
                    break;

                case "LUNA PROGRAMARII":
                    String sqlUpdatePrMajLunaProg = "UPDATE programare_clientmajor SET LUNA_PROGRAMARE=? WHERE ID_PROGRAMARE=?";
                    PreparedStatement ps5 = conn.prepareStatement(sqlUpdatePrMajLunaProg);
                    String id5 =JOptionPane.showInputDialog("ID");
                    String lunaProgString = JOptionPane.showInputDialog("Luna programare noua");
                    int lunaNoua = Integer.parseInt(lunaProgString);
                    ps5.setInt(1, lunaNoua);
                    ps5.setString(2, id5);
                    int row5 = ps5.executeUpdate();
                    JOptionPane.showMessageDialog(null,"S-a actualizat o programare din baza de date! Randul afectat a fost " + row5);
                    break;

                case "ANUL PROGRAMARII":
                    String sqlUpdatePrMajAnProg = "UPDATE programare_clientmajor SET AN_PROGRAMARE=? WHERE ID_PROGRAMARE=?";
                    PreparedStatement ps6 = conn.prepareStatement(sqlUpdatePrMajAnProg);
                    String id6 =JOptionPane.showInputDialog("ID");
                    String anProgString = JOptionPane.showInputDialog("An programare nou");
                    int anNou = Integer.parseInt(anProgString);
                    ps6.setInt(1, anNou);
                    ps6.setString(2, id6);
                    int row6 = ps6.executeUpdate();
                    JOptionPane.showMessageDialog(null,"S-a actualizat o programare din baza de date! Randul afectat a fost " + row6);
                    break;

                case "ZIUA PLANIFICARII":
                    String sqlUpdatePrMajZiPlan = "UPDATE programare_clientmajor SET ZI_PLANIFICARE=? WHERE ID_PROGRAMARE=?";
                    PreparedStatement ps7 = conn.prepareStatement(sqlUpdatePrMajZiPlan);
                    String id7 =JOptionPane.showInputDialog("ID");
                    String ziPlanString = JOptionPane.showInputDialog("Zi planificare noua");
                    int ziNouaPlan = Integer.parseInt(ziPlanString);
                    ps7.setInt(1, ziNouaPlan);
                    ps7.setString(2, id7);
                    int row7 = ps7.executeUpdate();
                    JOptionPane.showMessageDialog(null,"S-a actualizat o programare din baza de date! Randul afectat a fost " + row7);
                    break;

                case "LUNA PLANIFICARII":
                    String sqlUpdatePrMajLunaPlan = "UPDATE programare_clientmajor SET LUNA_PLANIFICARE=? WHERE ID_PROGRAMARE=?";
                    PreparedStatement ps8 = conn.prepareStatement(sqlUpdatePrMajLunaPlan);
                    String id8 =JOptionPane.showInputDialog("ID");
                    String lunaPlanString = JOptionPane.showInputDialog("Luna planificare noua");
                    int lunaNouaPlan = Integer.parseInt(lunaPlanString);
                    ps8.setInt(1, lunaNouaPlan);
                    ps8.setString(2, id8);
                    int row8 = ps8.executeUpdate();
                    JOptionPane.showMessageDialog(null,"S-a actualizat o programare din baza de date! Randul afectat a fost " + row8);
                    break;

                case "ANUL PLANIFICARII":
                    String sqlUpdatePrMajAnPlan = "UPDATE programare_clientmajor SET AN_PLANIFICARE=? WHERE ID_PROGRAMARE=?";
                    PreparedStatement ps9 = conn.prepareStatement(sqlUpdatePrMajAnPlan);
                    String id9 =JOptionPane.showInputDialog("ID");
                    String anPlanString = JOptionPane.showInputDialog("An planificare nou");
                    int anNouPlan = Integer.parseInt(anPlanString);
                    ps9.setInt(1, anNouPlan);
                    ps9.setString(2, id9);
                    int row9 = ps9.executeUpdate();
                    JOptionPane.showMessageDialog(null,"S-a actualizat o programare din baza de date! Randul afectat a fost " + row9);
                    break;

                case "SECTIE":
                    String sqlUpdatePrMajSectie = "UPDATE programare_clientmajor SET SECTIE=? WHERE ID_PROGRAMARE=?";
                    PreparedStatement ps10 = conn.prepareStatement(sqlUpdatePrMajSectie);
                    String id10 =JOptionPane.showInputDialog("ID");
                    String sectieNoua = JOptionPane.showInputDialog("Sectie noua");
                    ps10.setString(1, sectieNoua);
                    ps10.setString(2, id10);
                    int row10 = ps10.executeUpdate();
                    JOptionPane.showMessageDialog(null,"S-a actualizat o programare din baza de date! Randul afectat a fost " + row10);
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