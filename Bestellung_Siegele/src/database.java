import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class database {
	
	public static void main(String[] args) throws SQLException {
	start();
		
	}
	
	public static void start() throws SQLException {
		Scanner s = new Scanner(System.in);
		System.out.println("Bitte geben Sie CREATE, READ, UPDATE oder DELETE ein: ");
		String method = s.next();
		if(method.equalsIgnoreCase("CREATE")) {
		System.out.println("Bitte geben Sie BESTELLUNG, BESTELLUNG_ARTIKEL, ARTIKEL, ADRESSE oder KUNDE ein: ");
		String x = s.next();
		if(x.equalsIgnoreCase("BESTELLUNG")) {
			System.out.println("KundenID: ");
			int kundenID = s.nextInt();
			System.out.println("LieferadresseID: ");
			int lieferID = s.nextInt();
			System.out.println("RechnungsadresseID: ");
			int rechnungID = s.nextInt();
			createOrder(kundenID, lieferID, rechnungID);
		}
		else if(x.equalsIgnoreCase("BESTELLUNG_ARTIKEL")) {
			System.out.println("BestellID: ");
			int bestellID = s.nextInt();
			System.out.println("ArtikelID: ");
			int artikelID = s.nextInt();
			System.out.println("Menge: ");
			int menge = s.nextInt();
			createOrderArtikel(bestellID, artikelID, menge);
		}
		else if(x.equalsIgnoreCase("ARTIKEL")) {
			System.out.println("Name: ");
			String name = s.next();
			System.out.println("Preis: ");
			double preis = s.nextDouble();
			createArtikel(name, preis);
		}
		else if(x.equalsIgnoreCase("Adresse: ")) {
			System.out.println("Stadt: ");
			String stadt = s.next();
			System.out.println("Strasse: ");
			String strasse = s.next();
			System.out.println("PLZ: ");
			int plz = s.nextInt();
			System.out.println("Hausnummer: ");
			String hnr = s.next();
			createAdresse(stadt, strasse, plz, hnr);
		}
		else if(x.equalsIgnoreCase("KUNDE")) {
		System.out.println("Vorname:  ");
		String vorname = s.next();
		System.out.println("Nachname:  ");
		String nachname = s.next();
		try {
			createCustomer(vorname, nachname);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		System.out.println("Möchten Sie eine weitere Aktion durchführen? (JA/NEIN)");
		String choice = s.next();
		if(choice.equalsIgnoreCase("JA")) {
			start();
		}
		else {
			s.close();
		}
		}
		else if(method.equalsIgnoreCase("DELETE")) {
			System.out.println("Bitte geben Sie BESTELLUNG, BESTELLUNG_ARTIKEL, ARTIKEL, ADRESSE oder KUNDE ein: ");
			String x = s.next();
			if(x.equalsIgnoreCase("BESTELLUNG")) {
				System.out.println("ID: ");
				int id = s.nextInt();
				deleteOrder(id);
			}
			else if(x.equalsIgnoreCase("BESTELLUNG_ARTIKEL")) {
				System.out.println("BestellID: ");
				int bestellID = s.nextInt();
				System.out.println("ArtikelID: ");
				int artikelID = s.nextInt();
				deleteOrderArtikel(bestellID, artikelID);
			}
			else if(x.equalsIgnoreCase("ARTIKEL")) {
				System.out.println("ID: ");
				int id = s.nextInt();
				deleteArtikel(id);
			}
			else if(x.equalsIgnoreCase("Adresse: ")) {
				System.out.println("ID: ");
				int id = s.nextInt();
				deleteAdresse(id);
			}
			else if(x.equalsIgnoreCase("KUNDE")) {
			System.out.println("ID:  ");
			int id = s.nextInt();
			try {
				deleteCustomer(id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			System.out.println("Möchten Sie eine weitere Aktion durchführen? (JA/NEIN)");
			String choice = s.next();
			if(choice.equalsIgnoreCase("JA")) {
				start();
			}
			else {
				s.close();
			}
		}
		else if(method.equalsIgnoreCase("UPDATE")) {
			System.out.println("Bitte geben Sie BESTELLUNG, BESTELLUNG_ARTIKEL, ARTIKEL, ADRESSE oder KUNDE ein: ");
			String x = s.next();
			if(x.equalsIgnoreCase("BESTELLUNG")) {
				System.out.println("ID: ");
				int id = s.nextInt();
				System.out.println("KundenID: ");
				int kundenID = s.nextInt();
				System.out.println("LieferadresseID: ");
				int lieferID = s.nextInt();
				System.out.println("RechnungsadresseID: ");
				int rechnungID = s.nextInt();
				updateOrder(id, kundenID, lieferID, rechnungID);
			}
			else if(x.equalsIgnoreCase("BESTELLUNG_ARTIKEL")) {
				System.out.println("BestellID: ");
				int bestellID = s.nextInt();
				System.out.println("ArtikelID: ");
				int artikelID = s.nextInt();
				System.out.println("Menge: ");
				int menge = s.nextInt();
				updateOrderArtikel(bestellID, artikelID, menge);
			}
			else if(x.equalsIgnoreCase("ARTIKEL")) {
				System.out.println("ID: ");
				int id = s.nextInt();
				System.out.println("Name: ");
				String name = s.next();
				System.out.println("Preis: ");
				double preis = s.nextDouble();
				updateArtikel(id, name, preis);
			}
			else if(x.equalsIgnoreCase("Adresse: ")) {
				System.out.println("ID: ");
				int id = s.nextInt();
				System.out.println("Stadt: ");
				String stadt = s.next();
				System.out.println("Strasse: ");
				String strasse = s.next();
				System.out.println("PLZ: ");
				int plz = s.nextInt();
				System.out.println("Hausnummer: ");
				String hnr = s.next();
				updateAdresse(id, stadt, strasse, plz, hnr);
			}
			else if(x.equalsIgnoreCase("KUNDE")) {
			System.out.println("ID: ");
			int id = s.nextInt();
			System.out.println("Vorname:  ");
			String vorname = s.next();
			System.out.println("Nachname:  ");
			String nachname = s.next();
			try {
				updateCustomer(id, vorname, nachname);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			System.out.println("Möchten Sie eine weitere Aktion durchführen? (JA/NEIN)");
			String choice = s.next();
			if(choice.equalsIgnoreCase("JA")) {
				start();
			}
			else {
				s.close();
			}
		}
		else if(method.equalsIgnoreCase("READ")) {
			System.out.println("Bitte geben Sie BESTELLUNG, BESTELLUNG_ARTIKEL, ARTIKEL, ADRESSE oder KUNDE ein: ");
			String x = s.next();
			if(x.equalsIgnoreCase("BESTELLUNG")) {
				System.out.println("ID: ");
				int id = s.nextInt();
				readOrder(id);
			}
			else if(x.equalsIgnoreCase("BESTELLUNG_ARTIKEL")) {
				System.out.println("BestellID: ");
				int bestellID = s.nextInt();
				System.out.println("ArtikelID: ");
				int artikelID = s.nextInt();
				readOrderArtikel(bestellID, artikelID);
			}
			else if(x.equalsIgnoreCase("ARTIKEL")) {
				System.out.println("ID: ");
				int id = s.nextInt();
				readArtikel(id);
			}
			else if(x.equalsIgnoreCase("Adresse: ")) {
				System.out.println("ID: ");
				int id = s.nextInt();
				readAdresse(id);
			}
			else if(x.equalsIgnoreCase("KUNDE")) {
			System.out.println("ID:  ");
			int id = s.nextInt();
			try {
				readCustomer(id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			System.out.println("Möchten Sie eine weitere Aktion durchführen? (JA/NEIN)");
			String choice = s.next();
			if(choice.equalsIgnoreCase("JA")) {
				start();
			}
			else {
				s.close();
			}
			
		}
		
	}
	
	public static void createCustomer(String Vorname, String Nachname) throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/order_db", "postgres", "noah2000");
		String sql = "Insert into kunde(vorname, nachname) values (?,?)";
		PreparedStatement stm = conn.prepareStatement(sql);
		stm.setString(1, Vorname);
		stm.setString(2, Nachname);
		stm.executeUpdate();
		stm.close();
	}
	
	public static void deleteCustomer(int kundeID) throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/order_db", "postgres", "noah2000");
		String sql = "Delete from kunde where ID = " + kundeID;
		PreparedStatement stm = conn.prepareStatement(sql);
		stm.executeUpdate();
		stm.close();
	}
	
	public static void updateCustomer(int kundeID, String Vorname, String Nachname) throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/order_db", "postgres", "noah2000");
		String sql = "Update kunde set vorname = ?, nachname = ? where ID = " + kundeID; 
		PreparedStatement stm = conn.prepareStatement(sql);
		stm.setString(1, Vorname);
		stm.setString(2, Nachname);
		stm.executeUpdate();
		stm.close();
	}
	
	public static void readCustomer(int kundeID) throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/order_db", "postgres", "noah2000");
		String sql = "Select * from Kunde where ID = " + kundeID; 
		PreparedStatement stm = conn.prepareStatement(sql);
		ResultSet rs = stm.executeQuery();
		while(rs.next()) {
			int id = rs.getInt("ID");
			String vorname = rs.getString("vorname");
			String nachname = rs.getString("nachname");
			
			System.out.println(id);
			System.out.println(vorname);
			System.out.println(nachname);
			
		}
		stm.close();
	}
	
	public static void createAdresse(String stadt, String strasse, int plz, String hnr) throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/order_db", "postgres", "noah2000");
		String sql = "Insert into adresse(stadt, strasse, plz, hnr) values (?,?,?,?)";
		PreparedStatement stm = conn.prepareStatement(sql);
		stm.setString(1, stadt);
		stm.setString(2, strasse);
		stm.setInt(3, plz);
		stm.setString(4, hnr);
		stm.executeUpdate();
		stm.close();
	}
	
	public static void readAdresse(int adresseID) throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/order_db", "postgres", "noah2000");
		String sql = "Select * from adresse where ID = " + adresseID; 
		PreparedStatement stm = conn.prepareStatement(sql);
		ResultSet rs = stm.executeQuery();
		while(rs.next()) {
			int id = rs.getInt("ID");
			String stadt = rs.getString("stadt");
			String strasse = rs.getString("strasse");
			int plz = rs.getInt("plz");
			String hnr = rs.getString("hnr");
			
			System.out.println(id);
			System.out.println(stadt);
			System.out.println(strasse);
			System.out.println(plz);
			System.out.println(hnr);
		}
		stm.close();
	}
	
	public static void deleteAdresse(int adresseID) throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/order_db", "postgres", "noah2000");
		String sql = "Delete from adresse where ID = " + adresseID;
		PreparedStatement stm = conn.prepareStatement(sql);
		stm.executeUpdate();
		stm.close();
	}
	
	public static void updateAdresse(int adresseID, String stadt, String strasse, int plz, String hnr) throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/order_db", "postgres", "noah2000");
		String sql = "Update adresse set stadt = ?, strasse = ?, plz = ?, hnr = ? where ID = " + adresseID; 
		PreparedStatement stm = conn.prepareStatement(sql);
		stm.setString(1, stadt);
		stm.setString(2, strasse);
		stm.setInt(3, plz);
		stm.setString(4, hnr);
		stm.executeUpdate();
		stm.close();
	}
	
	public static void createArtikel(String name, double preis) throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/order_db", "postgres", "noah2000");
		String sql = "Insert into artikel(artikelname, preis) values (?,?)";
		PreparedStatement stm = conn.prepareStatement(sql);
		stm.setString(1, name);
		stm.setDouble(2, preis);
		stm.executeUpdate();
		stm.close();
	}
	
	public static void readArtikel(int artikelID) throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/order_db", "postgres", "noah2000");
		String sql = "Select * from artikel where ID = " + artikelID; 
		PreparedStatement stm = conn.prepareStatement(sql);
		ResultSet rs = stm.executeQuery();
		while(rs.next()) {
			int id = rs.getInt("ID");
			String name = rs.getString("artikelname");
			double preis = rs.getDouble("preis");
			
			System.out.println(id);
			System.out.println(name);
			System.out.printf(preis + "€");
			System.out.println();
		}
		stm.close();
	}
	
	public static void deleteArtikel(int artikelID) throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/order_db", "postgres", "noah2000");
		String sql = "Delete from artikel where ID = " + artikelID;
		PreparedStatement stm = conn.prepareStatement(sql);
		stm.executeUpdate();
		stm.close();
	}
	
	public static void updateArtikel(int adresseID, String name, double preis) throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/order_db", "postgres", "noah2000");
		String sql = "Update artikel set artikelname = ?, preis = ? where ID = " + adresseID; 
		PreparedStatement stm = conn.prepareStatement(sql);
		stm.setString(1, name);
		stm.setDouble(2, preis);
		stm.executeUpdate();
		stm.close();
	}
	
	public static void createOrder(int KundeID, int adresseLieferId, int adresseRechnungId) throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/order_db", "postgres", "noah2000");
		String sql = "Insert into bestellung_v3(kunde_id, adresse_liefer_id, adresse_rechnung_id) values (?,?,?)";
		PreparedStatement stm = conn.prepareStatement(sql);
		stm.setInt(1, KundeID);
		stm.setInt(2, adresseLieferId);
		stm.setInt(3, adresseRechnungId);
		stm.executeUpdate();
		stm.close();
	}
	
	public static void readOrder(int orderID) throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/order_db", "postgres", "noah2000");
		String sql = "Select * from bestellung_v3 where ID = " + orderID; 
		PreparedStatement stm = conn.prepareStatement(sql);
		ResultSet rs = stm.executeQuery();
		while(rs.next()) {
			int id = rs.getInt("ID");
			int kunde = rs.getInt("kunde_id");
			int lieferAdr = rs.getInt("adresse_liefer_id");
			int rechnAdr = rs.getInt("adresse_rechnung_id");
			
			System.out.println(id);
			System.out.println(kunde);
			System.out.println(lieferAdr);
			System.out.println(rechnAdr);
		}
		stm.close();
	}
	
	public static void deleteOrder(int orderID) throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/order_db", "postgres", "noah2000");
		String sql = "Delete from bestellung_v3 where ID = " + orderID;
		PreparedStatement stm = conn.prepareStatement(sql);
		stm.executeUpdate();
		stm.close();
	}
	
	public static void updateOrder(int orderID, int kundeID, int adresseLieferId, int adresseRechnungId) throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/order_db", "postgres", "noah2000");
		String sql = "Update bestellung_v3 set kunde_id = ?, adresse_liefer_id = ?, adresse_rechnung_id = ? where ID = " + orderID; 
		PreparedStatement stm = conn.prepareStatement(sql);
		stm.setInt(1, kundeID);
		stm.setInt(2, adresseLieferId);
		stm.setInt(3, adresseRechnungId);
		stm.executeUpdate();
		stm.close();
	}
	
	public static void createOrderArtikel(int orderID, int artikelID, int menge) throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/order_db", "postgres", "noah2000");
		String sql = "Insert into bestellung_artikel(bestell_id, artikel_id, menge) values (?,?,?)";
		PreparedStatement stm = conn.prepareStatement(sql);
		stm.setInt(1, orderID);
		stm.setInt(2, artikelID);
		stm.setInt(3, menge);
		stm.executeUpdate();
		stm.close();
	}
	
	public static void readOrderArtikel(int order_id, int artikel_id) throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/order_db", "postgres", "noah2000");
		String sql = "Select * from bestellung_artikel where bestell_id = ? and artikel_id = ?"; 
		PreparedStatement stm = conn.prepareStatement(sql);
		stm.setInt(1, order_id);
		stm.setInt(2, artikel_id);
		ResultSet rs = stm.executeQuery();
		while(rs.next()) {
			int bestellID = rs.getInt("bestell_id");
			int artikelID = rs.getInt("artikel_id");
			int menge = rs.getInt("menge");
			
			System.out.println(bestellID);
			System.out.println(artikelID);
			System.out.println(menge);
		}
		stm.close();
	}
	
	public static void deleteOrderArtikel(int order_id, int artikel_id) throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/order_db", "postgres", "noah2000");
		String sql = "Delete from bestellung_artikel where bestell_id = ? and artikel_id = ?";
		PreparedStatement stm = conn.prepareStatement(sql);
		stm.setInt(1, order_id);
		stm.setInt(2, artikel_id);
		stm.executeUpdate();
		stm.close();
	}
	
	public static void updateOrderArtikel(int order_id, int artikel_id, int menge) throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/order_db", "postgres", "noah2000");
		String sql = "Update bestellung_artikel set bestell_id = ?, artikel_id = ?, menge = ? where bestell_id = ? and artikel_id = ?"; 
		PreparedStatement stm = conn.prepareStatement(sql);
		stm.setInt(1, order_id);
		stm.setInt(2, artikel_id);
		stm.setInt(3, menge);
		stm.setInt(4, order_id);
		stm.setInt(5, artikel_id);
		stm.executeUpdate();
		stm.close();
	}

}
