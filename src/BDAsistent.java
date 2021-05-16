import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class BDAsistent {
    public void AsistentSelect() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/CabinetMedical?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "stefania");
            System.out.println("Conectarea la baza de date s-a efectuat cu succes!");
            List<List<String>> asistenti = new ArrayList<>();
            String sql = "select * from asistent";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                List<String> asistent = new ArrayList<>();
                String cnp = rs.getString(1);
                asistent.add(cnp);
                String nume = rs.getString(2);
                asistent.add(nume);
                String prenume = rs.getString(3);
                asistent.add(prenume);
                String sectie = rs.getString(4);
                asistent.add(sectie);
                int ziAng = rs.getInt(5);
                asistent.add(String.valueOf(ziAng));
                int lunaAng = rs.getInt(6);
                asistent.add(String.valueOf(lunaAng));
                int anAng = rs.getInt(7);
                asistent.add(String.valueOf(anAng));
                Double salariu = rs.getDouble(8);
                asistent.add(salariu.toString());
                String nrTelefon = rs.getString(9);
                asistent.add(nrTelefon);
                String email = rs.getString(10);
                asistent.add(email);
                int nrSaloane=rs.getInt(11);
                asistent.add(String.valueOf(nrSaloane));
                asistenti.add(asistent);
            }
            System.out.println(asistenti);
            conn.close();
        } catch (SQLException | ClassNotFoundException var10) {
            var10.printStackTrace();
        }
    }

    public void AsistentInsert() {
        Connection conn = null;
        Statement st = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/CabinetMedical?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "stefania");
            System.out.println("Conectarea la baza de date s-a efectuat cu succes!");
            String sqlInsertAsistent = "INSERT INTO ASISTENT (cnp, NUME, PRENUME, SECTIE, ZI_ANGAJARE, LUNA_ANGAJARE, AN_ANGAJARE, SALARIU, NR_TELEFON, EMAIL, NR_SALOANE) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sqlInsertAsistent);
            InfoAngajare infoAng = new InfoAngajare(" ", 0, 0, 0, 0.0);
            Asistent asist = new Asistent(" ", " ", " ", infoAng, " ", " ", 0);
            System.out.println("Citire asistent nou:");
            asist.CitirePersonal();
            ps.setString(1, asist.getCnp());
            ps.setString(2, asist.getNume());
            ps.setString(3, asist.getPrenume());
            ps.setString(4, asist.getInfoAngajare().getSectie());
            ps.setInt(5, asist.getInfoAngajare().getZiAngajare());
            ps.setInt(6, asist.getInfoAngajare().getLunaAngajare());
            ps.setInt(7, asist.getInfoAngajare().getAnAngajare());
            ps.setDouble(8, asist.getInfoAngajare().getSalariu());
            ps.setString(9, asist.getNrTelefon());
            ps.setString(10, asist.getEmail());
            ps.setInt(11, asist.getNrSaloaneAtribuite());
            int row = ps.executeUpdate();
            System.out.println("S-a inserat un nou asistent in baza de date!");
        } catch (SQLException | ClassNotFoundException var10) {
            var10.printStackTrace();
        }

    }

    public void AsistentUpdate() {
        Connection conn = null;
        Statement st = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Cabinetasistental?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "stefania");
            System.out.println("Conectarea la baza de date s-a efectuat cu succes!");
            Scanner sc = new Scanner(System.in);
            System.out.println("Introduceti tipul de data pe care doriti sa o modificati (CNP/NUME/PRENUME/SECTIE/GEN/ZIUA ANGAJARII/LUNA ANGAJARII/ANUL ANGAJARII/SALARIU/NUMAR DE TELEFON/EMAIL/NUMAR SALOANE ATRIBUITE)");
            String text = sc.nextLine();
            switch (text) {
                case "CNP":
                    String sqlUpdateAsistentCnp = "UPDATE asistent SET CNP=? WHERE CNP=?";
                    PreparedStatement ps1 = conn.prepareStatement(sqlUpdateAsistentCnp);
                    System.out.println("Introduceti vechiul CNP:");
                    String cnpVechi = sc.nextLine();
                    System.out.println("Introduceti noul CNP:");
                    String cnpNou = sc.nextLine();
                    ps1.setString(1, cnpNou);
                    ps1.setString(2, cnpVechi);
                    int row1 = ps1.executeUpdate();
                    System.out.println("S-a actualizat un asistent din baza de date! Randul afectat a fost " + row1);
                    break;

                case "NUME":
                    String sqlUpdateAsistentNume = "UPDATE asistent SET NUME=? WHERE NUME=?";
                    PreparedStatement ps2 = conn.prepareStatement(sqlUpdateAsistentNume);
                    System.out.println("Introduceti vechiul nume:");
                    String numeVechi = sc.nextLine();
                    System.out.println("Introduceti noul nume:");
                    String numeNou = sc.nextLine();
                    ps2.setString(1, numeNou);
                    ps2.setString(2, numeVechi);
                    int row2 = ps2.executeUpdate();
                    System.out.println("S-a actualizat un asistent din baza de date! Randul afectat a fost " + row2);
                    break;

                case "PRENUME":
                    String sqlUpdateAsistentPrenume = "UPDATE asistent SET PRENUME=? WHERE PRENUME=?";
                    PreparedStatement ps3 = conn.prepareStatement(sqlUpdateAsistentPrenume);
                    System.out.println("Introduceti vechiul prenume:");
                    String prenumeVechi = sc.nextLine();
                    System.out.println("Introduceti noul prenume:");
                    String prenumeNou = sc.nextLine();
                    ps3.setString(1, prenumeNou);
                    ps3.setString(2, prenumeVechi);
                    int row3 = ps3.executeUpdate();
                    System.out.println("S-a actualizat un asistent din baza de date! Randul afectat a fost " + row3);
                    break;

                case "SECTIE":
                    String sqlUpdateAsistentSectie = "UPDATE asistent SET SECTIE=? WHERE CNP=?";
                    PreparedStatement ps4 = conn.prepareStatement(sqlUpdateAsistentSectie);
                    System.out.println("Introduceti CNP-ul asistentului:");
                    String cnp4 = sc.nextLine();
                    System.out.println("Introduceti noua sectie:");
                    String sectieNoua = sc.nextLine();
                    ps4.setString(1, sectieNoua);
                    ps4.setString(2, cnp4);
                    int row4 = ps4.executeUpdate();
                    System.out.println("S-a actualizat un asistent din baza de date! Randul afectat a fost " + row4);
                    break;

                case "ZIUA ANGAJARII":
                    String sqlUpdateAsistentZi = "UPDATE asistent SET ZI_ANGAJARE=? WHERE CNP=?";
                    PreparedStatement ps5 = conn.prepareStatement(sqlUpdateAsistentZi);
                    System.out.println("Introduceti CNP-ul asistentului:");
                    String cnp5 = sc.nextLine();
                    System.out.println("Introduceti noua zi:");
                    int ziNoua = Integer.parseInt(sc.nextLine());
                    ps5.setInt(1, ziNoua);
                    ps5.setString(2, cnp5);
                    int row5 = ps5.executeUpdate();
                    System.out.println("S-a actualizat un asistent din baza de date! Randul afectat a fost " + row5);
                    break;

                case "LUNA ANGAJARII":
                    String sqlUpdateAsistentLuna = "UPDATE asistent SET LUNA_ANGAJARE=? WHERE CNP=?";
                    PreparedStatement ps6 = conn.prepareStatement(sqlUpdateAsistentLuna);
                    System.out.println("Introduceti CNP-ul asistentului:");
                    String cnp6 = sc.nextLine();
                    System.out.println("Introduceti noua luna:");
                    int lunaNoua = Integer.parseInt(sc.nextLine());
                    ps6.setInt(1, lunaNoua);
                    ps6.setString(2, cnp6);
                    int row6 = ps6.executeUpdate();
                    System.out.println("S-a actualizat un asistent din baza de date! Randul afectat a fost " + row6);
                    break;

                case "ANUL ANGAJARII":
                    String sqlUpdateAsistentAn = "UPDATE asistent SET AN_ANGAJARE=? WHERE CNP=?";
                    PreparedStatement ps7 = conn.prepareStatement(sqlUpdateAsistentAn);
                    System.out.println("Introduceti CNP-ul asistentului");
                    String cnp7 = sc.nextLine();
                    System.out.println("Introduceti noul an:");
                    int anNou = Integer.parseInt(sc.nextLine());
                    ps7.setInt(1, anNou);
                    ps7.setString(2, cnp7);
                    int row7 = ps7.executeUpdate();
                    System.out.println("S-a actualizat un asistent din baza de date! Randul afectat a fost " + row7);
                    break;

                case "SALARIU":
                    String sqlUpdateAsistentSalariu = "UPDATE asistent SET SALARIU=? WHERE CNP=?";
                    PreparedStatement ps8 = conn.prepareStatement(sqlUpdateAsistentSalariu);
                    System.out.println("Introduceti CNP-ul asistentului");
                    String cnp8 = sc.nextLine();
                    System.out.println("Introduceti noul salariu:");
                    Double salariuNou = Double.parseDouble(sc.nextLine());
                    ps8.setDouble(1, salariuNou);
                    ps8.setString(2, cnp8);
                    int row8 = ps8.executeUpdate();
                    System.out.println("S-a actualizat un asistent din baza de date! Randul afectat a fost " + row8);
                    break;

                case "NUMAR DE TELEFON":
                    String sqlUpdateAsistentTelefon = "UPDATE asistent SET NR_TELEFON=? WHERE CNP=?";
                    PreparedStatement ps9 = conn.prepareStatement(sqlUpdateAsistentTelefon);
                    System.out.println("Introduceti CNP-ul asistentului:");
                    String cnp9 = sc.nextLine();
                    System.out.println("Introduceti noul numar de telefon:");
                    String telefonNou = sc.nextLine();
                    ps9.setString(1, telefonNou);
                    ps9.setString(2, cnp9);
                    int row9 = ps9.executeUpdate();
                    System.out.println("S-a actualizat un asistent din baza de date! Randul afectat a fost " + row9);
                    break;

                case "EMAIL":
                    String sqlUpdateAsistentEmail = "UPDATE asistent SET EMAIL=? WHERE CNP=?";
                    PreparedStatement ps10 = conn.prepareStatement(sqlUpdateAsistentEmail);
                    System.out.println("Introduceti CNP-ul asistentului:");
                    String cnp10 = sc.nextLine();
                    System.out.println("Introduceti noul email:");
                    String emailNou = sc.nextLine();
                    ps10.setString(1, emailNou);
                    ps10.setString(2, cnp10);
                    int row10 = ps10.executeUpdate();
                    System.out.println("S-a actualizat un asistent din baza de date! Randul afectat a fost " + row10);
                    break;


                case "NUMAR SALOANE ATRIBUITE":
                    String sqlUpdateasistentSal = "UPDATE asistent SET NR_SALOANE=? WHERE CNP=?";
                    PreparedStatement ps12 = conn.prepareStatement(sqlUpdateasistentSal);
                    System.out.println("Introduceti CNP-ul asistentului:");
                    String cnp12 = sc.nextLine();
                    System.out.println("Introduceti noul numar de saloane atribuite:");
                    int nrSalNou = Integer.parseInt(sc.nextLine());
                    ps12.setInt(1, nrSalNou);
                    ps12.setString(2, cnp12);
                    int row12 = ps12.executeUpdate();
                    System.out.println("S-a actualizat un asistent din baza de date! Randul afectat a fost " + row12);
                    break;


                default:
                    System.out.println("OPTIUNE INVALIDA! ALEGETI DIN NOU!");
                    break;
            }
        } catch (SQLException | ClassNotFoundException var10) {
            var10.printStackTrace();
        }

    }

    public void AsistentDelete() {
        Connection conn = null;
        Statement st = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Cabinetasistental?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "stefania");
            System.out.println("Conectarea la baza de date s-a efectuat cu succes!");
            String sqlDeleteAsistent="DELETE FROM asistent WHERE cnp=?";
            PreparedStatement ps = conn.prepareStatement(sqlDeleteAsistent);
            Scanner sc=new Scanner(System.in);
            String cnpDel;
            System.out.println("Introduceti CNP-ul asistentului pe care doriti sa il stergeti");
            cnpDel=sc.nextLine();
            ps.setString(1,cnpDel);
            int row=ps.executeUpdate();
            System.out.println("S-a sters un asistent din baza de date! Randul afectat a fost "+row);
        } catch (SQLException | ClassNotFoundException var10) {
            var10.printStackTrace();
        }

    }

    public void AsistentInsertCSV() {
        Connection conn = null;
        Statement st = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Cabinetasistental?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "stefania");
            System.out.println("Conectarea la baza de date s-a efectuat cu succes!");
            String sqlInsertasistent = "INSERT IGNORE INTO asistent (cnp, NUME, PRENUME, SECTIE, ZI_ANGAJARE, LUNA_ANGAJARE, AN_ANGAJARE, SALARIU,NR_TELEFON, EMAIL, NR_SALOANE) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sqlInsertasistent);
            System.out.println("Citire din fisierul CSV asistent:");
            List<List<String>> asistenti = new ArrayList<>();
            SingletonCitire.getInstanceRead().ReadingAsistent();
            asistenti.addAll(SingletonResult.getInstance().getA());
            for (List<String> data : asistenti) {
                ps.setString(1, data.get(0));
                ps.setString(2, data.get(1));
                ps.setString(3, data.get(2));
                ps.setString(4, data.get(3));
                ps.setInt(5, Integer.parseInt(data.get(4)));
                ps.setInt(6, Integer.parseInt(data.get(5)));
                ps.setInt(7, Integer.parseInt(data.get(6)));
                ps.setDouble(8, Double.parseDouble(data.get(7)));
                ps.setString(9, data.get(8));
                ps.setString(10, data.get(9));
                ps.setInt(11, Integer.parseInt(data.get(11)));
                int row = ps.executeUpdate();
                if (row == 1) System.out.println("S-a inserat un nou asistent in baza de date!");
            }

        } catch (SQLException | ClassNotFoundException | FileNotFoundException var10) {
            var10.printStackTrace();
        }
    }
}