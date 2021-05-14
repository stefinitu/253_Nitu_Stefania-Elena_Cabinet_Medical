import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class BDProgramareMin {
    public void PrMinSelect() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/CabinetMedical?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "stefania");
            System.out.println("Conectarea la baza de date s-a efectuat cu succes!");
            List<List<String>> programariMin = new ArrayList<>();
            String sql = "select * from programare_clientminor";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                List<String> progr = new ArrayList<>();
                Double idProg = rs.getDouble(1);
                progr.add(idProg.toString());
                Double codBilet = rs.getDouble(2);
                progr.add(codBilet.toString());
                String cnpClient = rs.getString(3);
                progr.add(cnpClient);
                int ziProg = rs.getInt(4);
                progr.add(String.valueOf(ziProg));
                int lunaProg = rs.getInt(5);
                progr.add(String.valueOf(lunaProg));
                int anProg = rs.getInt(6);
                progr.add(String.valueOf(anProg));
                int ziPlan = rs.getInt(7);
                progr.add(String.valueOf(ziPlan));
                int lunaPlan = rs.getInt(8);
                progr.add(String.valueOf(lunaPlan));
                int anPlan = rs.getInt(9);
                progr.add(String.valueOf(anPlan));
                String sectie = rs.getString(10);
                progr.add(sectie);
                programariMin.add(progr);
            }
            System.out.println(programariMin);
            conn.close();
        } catch (SQLException | ClassNotFoundException var10) {
            var10.printStackTrace();
        }
    }

    public void ProgMinInsert() {
        Connection conn = null;
        Statement st = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/CabinetMedical?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "stefania");
            System.out.println("Conectarea la baza de date s-a efectuat cu succes!");
            String sqlInsertPrMin = "INSERT INTO programare_clientmajor (ID_PROGRAMARE, COD_BILET, CNP, ZI_PROGRAMARE, LUNA_PROGRAMARE, AN_PROGRAMARE, ZI_PLANIFICARE, LUNA_PLANIFICARE, AN_PLANIFICARE, SECTIE) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sqlInsertPrMin);
            ClientMinor clMin=new ClientMinor(" ", " ", " ", " ", " ", " ", " ", " ", " ");
            Programare prog=new Programare(0,0,clMin,0,0,0,0,0,0," ");
            System.out.println("Citire programare pentru client minor noua:");
            prog.CitireProg();
            ps.setDouble(1, prog.getIdProgramare());
            ps.setDouble(2, prog.getCodBiletTrimitere());
            ps.setString(3, prog.getClient().getCnp());
            ps.setInt(4, prog.getZiProgramare());
            ps.setInt(5, prog.getLunaProgramare());
            ps.setInt(6, prog.getAnProgramare());
            ps.setInt(7, prog.getZiPlanificare());
            ps.setInt(8, prog.getLunaPlanificare());
            ps.setInt(9, prog.getAnPlanificare());
            ps.setString(10, prog.getSectia());
            int row = ps.executeUpdate();
            System.out.println("S-a inserat o noua programare in baza de date!");
        } catch (SQLException | ClassNotFoundException var10) {
            var10.printStackTrace();
        }

    }

    public void PrMinUpdate() {
        Connection conn = null;
        Statement st = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/CabinetMedical?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "stefania");
            System.out.println("Conectarea la baza de date s-a efectuat cu succes!");
            Scanner sc = new Scanner(System.in);
            System.out.println("Introduceti tipul de data pe care doriti sa o modificati (ID PROGRAMARE/COD BILET TRIMITERE/CNP/ZIUA PROGRAMARII/LUNA PROGRAMARII/ANUL PROGRAMARII/ZIUA PLANIFICARII/LUNA PLANIFICARII/ANUL PLANIFICARII/SECTIA)");
            String text = sc.nextLine();
            switch (text) {
                case "ID PROGRAMARE":
                    String sqlUpdatePrMinID = "UPDATE programare_clientminor SET ID_PROGRAMARE=? WHERE ID_PROGRAMARE=?";
                    PreparedStatement ps1 = conn.prepareStatement(sqlUpdatePrMinID);
                    System.out.println("Introduceti vechiul ID:");
                    String idVechi = sc.nextLine();
                    System.out.println("Introduceti noul ID:");
                    String idNou = sc.nextLine();
                    ps1.setDouble(1, Double.parseDouble(idNou));
                    ps1.setDouble(2, Double.parseDouble(idVechi));
                    int row1 = ps1.executeUpdate();
                    System.out.println("S-a actualizat o programare din baza de date! Randul afectat a fost " + row1);
                    break;

                case "COD BILET TRIMITERE":
                    String sqlUpdatePrMinCod = "UPDATE programare_clientminor SET COD_BILET=? WHERE ID_PROGRAMARE=?";
                    PreparedStatement ps2 = conn.prepareStatement(sqlUpdatePrMinCod);
                    System.out.println("Introduceti ID-ul programarii:");
                    String id2 = sc.nextLine();
                    System.out.println("Introduceti noul cod:");
                    String codNou = sc.nextLine();
                    ps2.setDouble(1, Double.parseDouble(codNou));
                    ps2.setDouble(2, Double.parseDouble(id2));
                    int row2 = ps2.executeUpdate();
                    System.out.println("S-a actualizat o programare din baza de date! Randul afectat a fost " + row2);
                    break;

                case "CNP":
                    String sqlUpdatePrMinCnp = "UPDATE programare_clientminor SET CNP=? WHERE ID_PROGRAMARE=?";
                    PreparedStatement ps3 = conn.prepareStatement(sqlUpdatePrMinCnp);
                    System.out.println("Introduceti ID-ul programarii:");
                    String id3 = sc.nextLine();
                    System.out.println("Introduceti noul CNP:");
                    String cnpNou = sc.nextLine();
                    ps3.setString(1, cnpNou);
                    ps3.setString(2, id3);
                    int row3 = ps3.executeUpdate();
                    System.out.println("S-a actualizat o programare din baza de date! Randul afectat a fost " + row3);
                    break;


                case "ZIUA PROGRAMARII":
                    String sqlUpdatePrMinZiProg = "UPDATE programare_clientminor SET ZI_PROGRAMARE=? WHERE ID_PROGRAMARE=?";
                    PreparedStatement ps4 = conn.prepareStatement(sqlUpdatePrMinZiProg);
                    System.out.println("Introduceti ID-ul programarii:");
                    String id4 = sc.nextLine();
                    System.out.println("Introduceti noua zi:");
                    int ziNoua = Integer.parseInt(sc.nextLine());
                    ps4.setInt(1, ziNoua);
                    ps4.setString(2, id4);
                    int row4 = ps4.executeUpdate();
                    System.out.println("S-a actualizat o programare din baza de date! Randul afectat a fost " + row4);
                    break;

                case "LUNA PROGRAMARII":
                    String sqlUpdatePrMinLunaProg = "UPDATE programare_clientminor SET LUNA_PROGRAMARE=? WHERE ID_PROGRAMARE=?";
                    PreparedStatement ps5 = conn.prepareStatement(sqlUpdatePrMinLunaProg);
                    System.out.println("Introduceti ID-ul programarii:");
                    String id5 = sc.nextLine();
                    System.out.println("Introduceti noua luna:");
                    int lunaNoua = Integer.parseInt(sc.nextLine());
                    ps5.setInt(1, lunaNoua);
                    ps5.setString(2, id5);
                    int row5 = ps5.executeUpdate();
                    System.out.println("S-a actualizat o programare din baza de date! Randul afectat a fost " + row5);
                    break;

                case "ANUL PROGRAMARII":
                    String sqlUpdatePrMinAnProg = "UPDATE programare_clientminor SET AN_PROGRAMARE=? WHERE ID_PROGRAMARE=?";
                    PreparedStatement ps6 = conn.prepareStatement(sqlUpdatePrMinAnProg);
                    System.out.println("Introduceti ID-ul programarii:");
                    String id6 = sc.nextLine();
                    System.out.println("Introduceti noul an:");
                    int anNou = Integer.parseInt(sc.nextLine());
                    ps6.setInt(1, anNou);
                    ps6.setString(2, id6);
                    int row6 = ps6.executeUpdate();
                    System.out.println("S-a actualizat o programare din baza de date! Randul afectat a fost " + row6);
                    break;

                case "ZIUA PLANIFICARII":
                    String sqlUpdatePrMinZiPlan = "UPDATE programare_clientminor SET ZI_PLANIFICARE=? WHERE ID_PROGRAMARE=?";
                    PreparedStatement ps7 = conn.prepareStatement(sqlUpdatePrMinZiPlan);
                    System.out.println("Introduceti ID-ul programarii:");
                    String id7 = sc.nextLine();
                    System.out.println("Introduceti noua zi:");
                    int ziNouaPlan = Integer.parseInt(sc.nextLine());
                    ps7.setInt(1, ziNouaPlan);
                    ps7.setString(2, id7);
                    int row7 = ps7.executeUpdate();
                    System.out.println("S-a actualizat o programare din baza de date! Randul afectat a fost " + row7);
                    break;

                case "LUNA PLANIFICARII":
                    String sqlUpdatePrMinLunaPlan = "UPDATE programare_clientminor SET LUNA_PLANIFICARE=? WHERE ID_PROGRAMARE=?";
                    PreparedStatement ps8 = conn.prepareStatement(sqlUpdatePrMinLunaPlan);
                    System.out.println("Introduceti ID-ul programarii:");
                    String id8 = sc.nextLine();
                    System.out.println("Introduceti noua luna:");
                    int lunaNouaPlan = Integer.parseInt(sc.nextLine());
                    ps8.setInt(1, lunaNouaPlan);
                    ps8.setString(2, id8);
                    int row8 = ps8.executeUpdate();
                    System.out.println("S-a actualizat o programare din baza de date! Randul afectat a fost " + row8);
                    break;

                case "ANUL PLANIFICARII":
                    String sqlUpdatePrMinAnPlan = "UPDATE programare_clientminor SET AN_PLANIFICARE=? WHERE ID_PROGRAMARE=?";
                    PreparedStatement ps9 = conn.prepareStatement(sqlUpdatePrMinAnPlan);
                    System.out.println("Introduceti ID-ul programarii:");
                    String id9 = sc.nextLine();
                    System.out.println("Introduceti noul an:");
                    int anNouPlan = Integer.parseInt(sc.nextLine());
                    ps9.setInt(1, anNouPlan);
                    ps9.setString(2, id9);
                    int row9 = ps9.executeUpdate();
                    System.out.println("S-a actualizat o programare din baza de date! Randul afectat a fost " + row9);
                    break;

                case "SECTIE":
                    String sqlUpdatePrMinSectie = "UPDATE programare_clientminor SET SECTIE=? WHERE ID_PROGRAMARE=?";
                    PreparedStatement ps10 = conn.prepareStatement(sqlUpdatePrMinSectie);
                    System.out.println("Introduceti ID-ul programarii:");
                    String id10 = sc.nextLine();
                    System.out.println("Introduceti noua sectie:");
                    String sectieNoua = sc.nextLine();
                    ps10.setString(1, sectieNoua);
                    ps10.setString(2, id10);
                    int row10 = ps10.executeUpdate();
                    System.out.println("S-a actualizat o programare din baza de date! Randul afectat a fost " + row10);
                    break;

                default:
                    System.out.println("OPTIUNE INVALIDA! ALEGETI DIN NOU!");
                    break;
            }
        } catch (SQLException | ClassNotFoundException var10) {
            var10.printStackTrace();
        }

    }

    public void PrMinDelete() {
        Connection conn = null;
        Statement st = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/CabinetMedical?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "stefania");
            System.out.println("Conectarea la baza de date s-a efectuat cu succes!");
            String sqlDeletePrMin="DELETE FROM programare_clientminor WHERE id_programare=?";
            PreparedStatement ps = conn.prepareStatement(sqlDeletePrMin);
            Scanner sc=new Scanner(System.in);
            String cnpDel;
            System.out.println("Introduceti ID-ul programarii pe care doriti sa o stergeti");
            cnpDel=sc.nextLine();
            ps.setString(1,cnpDel);
            int row=ps.executeUpdate();
            System.out.println("S-a sters o programare din baza de date! Randul afectat a fost "+row);
        } catch (SQLException | ClassNotFoundException var10) {
            var10.printStackTrace();
        }

    }
}