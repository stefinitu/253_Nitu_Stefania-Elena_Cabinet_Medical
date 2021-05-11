import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class BDClientMajor {
    public void ClMajSelect() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/CabinetMedical?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "stefania");
            System.out.println("Conectarea la baza de date s-a efectuat cu succes!");
            List<List<String>> clientiMaj=new ArrayList<>();
            String sql = "select * from ClientMajor";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()) {
                List<String> clientMaj=new ArrayList<>();
                String cnp = rs.getString(1);
                clientMaj.add(cnp);
                String nume = rs.getString(2);
                clientMaj.add(nume);
                String prenume = rs.getString(3);
                clientMaj.add(prenume);
                String email = rs.getString(4);
                clientMaj.add(email);
                String gen = rs.getString(5);
                clientMaj.add(gen);
                String adresa = rs.getString(6);
                clientMaj.add(adresa);
                Double idCardSanatate = rs.getDouble(7);
                clientMaj.add(idCardSanatate.toString());
                String nrTelefon = rs.getString(8);
                clientMaj.add(nrTelefon);
                clientiMaj.add(clientMaj);
            }
            System.out.println(clientiMaj);
            conn.close();
        } catch (SQLException | ClassNotFoundException var10) {
            var10.printStackTrace();
        }
    }

    public void ClMajInsert() {
        Connection conn = null;
        Statement st = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/CabinetMedical?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "stefania");
            System.out.println("Conectarea la baza de date s-a efectuat cu succes!");
            String sqlInsertMaj="INSERT INTO ClientMajor (cnp, NUME, PRENUME, EMAIL, GEN, ADRESA, ID_CARDSANATATE, NR_TELEFON) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sqlInsertMaj);
            ClientMajor clMaj=new ClientMajor(" ", " ", " ", " ", " ", " ", 0, " ");
            System.out.println("Citire pacient major nou:");
            clMaj.CitireClienti();
            ps.setString(1, clMaj.getCnp());
            ps.setString(2, clMaj.getNume());
            ps.setString(3,clMaj.getPrenume());
            ps.setString(4,clMaj.getEmail());
            ps.setString(5,clMaj.getGen());
            ps.setString(6,clMaj.getAdresa());
            ps.setDouble(7,clMaj.getIdCardSanatate());
            ps.setString(8,clMaj.getNrTelefon());
            ps.executeUpdate();
            System.out.println("S-a inserat un nou client major in baza de date!");
        } catch (SQLException | ClassNotFoundException var10) {
            var10.printStackTrace();
        }

    }

    public void ClMajDelete() {
        Connection conn = null;
        Statement st = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/CabinetMedical?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "stefania");
            System.out.println("Conectarea la baza de date s-a efectuat cu succes!");
            String sqlDeleteMaj="DELETE FROM ClientMajor WHERE cnp=?";
            PreparedStatement ps = conn.prepareStatement(sqlDeleteMaj);
            Scanner sc=new Scanner(System.in);
            String cnpDel;
            System.out.println("Introduceti CNP-ul persoanei pe care doriti sa o stergeti");
            cnpDel=sc.nextLine();
            ps.setString(1,cnpDel);
            int row=ps.executeUpdate();
            System.out.println("S-a sters un client major din baza de date! Randul afectat a fost "+row);
        } catch (SQLException | ClassNotFoundException var10) {
            var10.printStackTrace();
        }

    }

    public void ClMajUpdate() {
        Connection conn = null;
        Statement st = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/CabinetMedical?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "stefania");
            System.out.println("Conectarea la baza de date s-a efectuat cu succes!");
            Scanner sc=new Scanner(System.in);
            System.out.println("Introduceti tipul de data pe care doriti sa o modificati (CNP/NUME/PRENUME/EMAIL/GEN/ADRESA/ID CARD SANATATE/NUMAR DE TELEFON)");
            String text=sc.nextLine();
            switch(text) {
                case "CNP":
                    String sqlUpdateMajCnp="UPDATE ClientMajor SET CNP=? WHERE CNP=?";
                    PreparedStatement ps1 = conn.prepareStatement(sqlUpdateMajCnp);
                    System.out.println("Introduceti vechiul CNP:");
                    String cnpVechi = sc.nextLine();
                    System.out.println("Introduceti noul CNP:");
                    String cnpNou = sc.nextLine();
                    ps1.setString(1, cnpNou);
                    ps1.setString(2, cnpVechi);
                    int row1 = ps1.executeUpdate();
                    System.out.println("S-a actualizat un client major din baza de date! Randul afectat a fost "+row1);
                    break;

                case "NUME":
                    String sqlUpdateMajNume="UPDATE ClientMajor SET NUME=? WHERE NUME=?";
                    PreparedStatement ps2 = conn.prepareStatement(sqlUpdateMajNume);
                    System.out.println("Introduceti vechiul nume:");
                    String numeVechi = sc.nextLine();
                    System.out.println("Introduceti noul nume:");
                    String numeNou = sc.nextLine();
                    ps2.setString(1, numeNou);
                    ps2.setString(2, numeVechi);
                    int row2 = ps2.executeUpdate();
                    System.out.println("S-a actualizat un client major din baza de date! Randul afectat a fost "+row2);
                    break;

                case "PRENUME":
                    String sqlUpdateMajPrenume="UPDATE ClientMajor SET PRENUME=? WHERE PRENUME=?";
                    PreparedStatement ps3 = conn.prepareStatement(sqlUpdateMajPrenume);
                    System.out.println("Introduceti vechiul prenume:");
                    String prenumeVechi = sc.nextLine();
                    System.out.println("Introduceti noul prenume:");
                    String prenumeNou = sc.nextLine();
                    ps3.setString(1, prenumeNou);
                    ps3.setString(2, prenumeVechi);
                    int row3 = ps3.executeUpdate();
                    System.out.println("S-a actualizat un client major din baza de date! Randul afectat a fost "+row3);
                    break;

                case "EMAIL":
                    String sqlUpdateMajEmail="UPDATE ClientMajor SET EMAIL=? WHERE EMAIL=?";
                    PreparedStatement ps4 = conn.prepareStatement(sqlUpdateMajEmail);
                    System.out.println("Introduceti vechiul email:");
                    String emailVechi = sc.nextLine();
                    System.out.println("Introduceti noul email:");
                    String emailNou = sc.nextLine();
                    ps4.setString(1, emailNou);
                    ps4.setString(2, emailVechi);
                    int row4 = ps4.executeUpdate();
                    System.out.println("S-a actualizat un client major din baza de date! Randul afectat a fost "+row4);
                    break;

                case "GEN":
                    String sqlUpdateMajGen="UPDATE ClientMajor SET GEN=? WHERE GEN=?";
                    PreparedStatement ps5 = conn.prepareStatement(sqlUpdateMajGen);
                    System.out.println("Introduceti vechiul gen:");
                    String genVechi = sc.nextLine();
                    System.out.println("Introduceti noul gen:");
                    String genNou = sc.nextLine();
                    ps5.setString(1, genNou);
                    ps5.setString(2, genVechi);
                    int row5 = ps5.executeUpdate();
                    System.out.println("S-a actualizat un client major din baza de date! Randul afectat a fost "+row5);
                    break;

                case "ADRESA":
                    String sqlUpdateMajAdresa="UPDATE ClientMajor SET ADRESA=? WHERE ADRESA=?";
                    PreparedStatement ps6 = conn.prepareStatement(sqlUpdateMajAdresa);
                    System.out.println("Introduceti vechea adresa:");
                    String adresaVeche = sc.nextLine();
                    System.out.println("Introduceti noua adresa:");
                    String adresaNoua = sc.nextLine();
                    ps6.setString(1, adresaNoua);
                    ps6.setString(2, adresaVeche);
                    int row6 = ps6.executeUpdate();
                    System.out.println("S-a actualizat un client major din baza de date! Randul afectat a fost "+row6);
                    break;

                case "ID CARD SANATATE":
                    String sqlUpdateMajCard="UPDATE ClientMajor SET ID_CARDSANATATE=? WHERE ID_CARDSANATATE=?";
                    PreparedStatement ps7 = conn.prepareStatement(sqlUpdateMajCard);
                    System.out.println("Introduceti vechiul id:");
                    Double cardVechi = Double.parseDouble(sc.nextLine());
                    System.out.println("Introduceti noul id:");
                    Double cardNou = Double.parseDouble(sc.nextLine());
                    ps7.setDouble(1, cardNou);
                    ps7.setDouble(2, cardVechi);
                    int row7 = ps7.executeUpdate();
                    System.out.println("S-a actualizat un client major din baza de date! Randul afectat a fost "+row7);
                    break;

                case "NUMAR DE TELEFON":
                    String sqlUpdateMajTelefon="UPDATE ClientMajor SET NR_TELEFON=? WHERE NR_TELEFON=?";
                    PreparedStatement ps8 = conn.prepareStatement(sqlUpdateMajTelefon);
                    System.out.println("Introduceti vechiul numar de telefon:");
                    String telefonVechi = sc.nextLine();
                    System.out.println("Introduceti noul numar de telefon:");
                    String telefonNou = sc.nextLine();
                    ps8.setString(1, telefonNou);
                    ps8.setString(2, telefonVechi);
                    int row8 = ps8.executeUpdate();
                    System.out.println("S-a actualizat un client major din baza de date! Randul afectat a fost "+row8);
                    break;

                default:
                    System.out.println("OPTIUNE INVALIDA! ALEGETI DIN NOU!");
                    break;
            }
        } catch (SQLException | ClassNotFoundException var10) {
            var10.printStackTrace();
        }

    }

    public void ClMajInsertCSV() {
        Connection conn = null;
        Statement st = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/CabinetMedical?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "stefania");
            System.out.println("Conectarea la baza de date s-a efectuat cu succes!");
            String sqlInsertMaj="INSERT IGNORE INTO ClientMajor (cnp, NUME, PRENUME, EMAIL, GEN, ADRESA, ID_CARDSANATATE, NR_TELEFON) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sqlInsertMaj);
            System.out.println("Citire din fisierul CSV ClientMaj:");
            List<List<String>> clMaj=new ArrayList<>();
            SingletonCitire.getInstanceRead().ReadingClientMajor();
            clMaj.addAll(SingletonResult.getInstance().getClmaj());
            for(List <String> data:clMaj)
            {
                ps.setString(1, data.get(0));
                ps.setString(2, data.get(1));
                ps.setString(3,data.get(2));
                ps.setString(4,data.get(3));
                ps.setString(5,data.get(4));
                ps.setString(6,data.get(5));
                ps.setDouble(7,Double.parseDouble(data.get(6)));
                ps.setString(8,data.get(7));
                int row=ps.executeUpdate();
                if(row==1) System.out.println("S-a inserat un nou client major in baza de date!");
            }

        } catch (SQLException | ClassNotFoundException | FileNotFoundException var10) {
            var10.printStackTrace();
        }

    }
}