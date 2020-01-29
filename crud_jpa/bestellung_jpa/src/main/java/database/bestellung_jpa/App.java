package database.bestellung_jpa;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App {
	static EntityManagerFactory f = Persistence.createEntityManagerFactory("MyUnit");
	static EntityManager m = f.createEntityManager();

	public static void main(String[] args) throws SQLException {
		start();
	}

	public static void start() throws SQLException {
		Scanner s = new Scanner(System.in);
		System.out.println("Bitte geben Sie CREATE, READ, UPDATE oder DELETE ein: ");
		String method = s.next();
		if (method.equalsIgnoreCase("CREATE")) {
			System.out.println("Bitte geben Sie BESTELLUNG, BESTELLUNG_ARTIKEL, ARTIKEL, ADRESSE oder KUNDE ein: ");
			String x = s.next();
			if (x.equalsIgnoreCase("BESTELLUNG")) {
				System.out.println("KundenID: ");
				long kundenID = s.nextInt();
				Kunde a = m.find(Kunde.class, kundenID);
				System.out.println("LieferadresseID: ");
				long lieferID = s.nextInt();
				Adresse b = m.find(Adresse.class, lieferID);
				System.out.println("RechnungsadresseID: ");
				long rechnungID = s.nextInt();
				Adresse c = m.find(Adresse.class, rechnungID);
				Bestellung d = new Bestellung(a, b, c);
				m.getTransaction().begin();
				m.persist(d);
				m.getTransaction().commit();
			} else if (x.equalsIgnoreCase("BESTELLUNG_ARTIKEL")) {
				System.out.println("BestellID: ");
				long bestellID = s.nextInt();
				Bestellung a = m.find(Bestellung.class, bestellID);
				System.out.println("ArtikelID: ");
				long artikelID = s.nextInt();
				Artikel b = m.find(Artikel.class, artikelID);
				System.out.println("Menge: ");
				int menge = s.nextInt();
				Bestellung_Artikel c = new Bestellung_Artikel(a, b, menge);
				m.getTransaction().begin();
				m.persist(c);
				m.getTransaction().commit();

			} else if (x.equalsIgnoreCase("ARTIKEL")) {
				System.out.println("Name: ");
				String name = s.next();
				System.out.println("Preis: ");
				double preis = s.nextDouble();
				Artikel a = new Artikel(name, preis);
				m.getTransaction().begin();
				m.persist(a);
				m.getTransaction().commit();
			} else if (x.equalsIgnoreCase("ADRESSE")) {
				System.out.println("Stadt: ");
				String stadt = s.next();
				System.out.println("Strasse: ");
				String strasse = s.next();
				System.out.println("PLZ: ");
				int plz = s.nextInt();
				System.out.println("Hausnummer: ");
				String hnr = s.next();
				Adresse b = new Adresse(stadt, strasse, plz, hnr);
				m.getTransaction().begin();
				m.persist(b);
				m.getTransaction().commit();
			} else if (x.equalsIgnoreCase("KUNDE")) {
				System.out.println("Vorname:  ");
				String vorname = s.next();
				System.out.println("Nachname:  ");
				String nachname = s.next();
				Kunde a = new Kunde("", vorname, nachname, "");
				m.getTransaction().begin();
				m.persist(a);
				m.getTransaction().commit();
			}
			System.out.println("Möchten Sie eine weitere Aktion durchführen? (JA/NEIN)");
			String choice = s.next();
			if (choice.equalsIgnoreCase("JA")) {
				start();
			} else {
				s.close();
			}
		} else if (method.equalsIgnoreCase("DELETE")) {
			System.out.println("Bitte geben Sie BESTELLUNG, BESTELLUNG_ARTIKEL, ARTIKEL, ADRESSE oder KUNDE ein: ");
			String x = s.next();
			if (x.equalsIgnoreCase("BESTELLUNG")) {
				List<Bestellung> z = m.createQuery("SELECT a FROM Bestellung a", Bestellung.class).getResultList();
				for (int i = 0; i < z.size(); i++) {
					System.out.println(z.get(i));
				}
				System.out.println("ID: ");
				long id = s.nextInt();
				Bestellung a = m.find(Bestellung.class, id);
				m.getTransaction().begin();
				m.remove(a);
				m.getTransaction().commit();
			} else if (x.equalsIgnoreCase("BESTELLUNG_ARTIKEL")) {
				List<Bestellung_Artikel> z = m
						.createQuery("SELECT a FROM Bestellung_Artikel a", Bestellung_Artikel.class).getResultList();
				for (int i = 0; i < z.size(); i++) {
					System.out.println(z.get(i));
				}
				System.out.println("Bestellung_Artikel_ID: ");
				long id = s.nextInt();
				Bestellung_Artikel a = m.find(Bestellung_Artikel.class, id);
				m.getTransaction().begin();
				m.remove(a);
				m.getTransaction().commit();
			} else if (x.equalsIgnoreCase("ARTIKEL")) {
				List<Artikel> z = m.createQuery("SELECT a FROM Artikel a", Artikel.class).getResultList();
				for (int i = 0; i < z.size(); i++) {
					System.out.println(z.get(i));
				}
				System.out.println("ID: ");
				long id = s.nextInt();
				Artikel a = m.find(Artikel.class, id);
				m.getTransaction().begin();
				m.remove(a);
				m.getTransaction().commit();
			} else if (x.equalsIgnoreCase("ADRESSE")) {
				List<Adresse> z = m.createQuery("SELECT a FROM Adresse a", Adresse.class).getResultList();
				for (int i = 0; i < z.size(); i++) {
					System.out.println(z.get(i));
				}
				System.out.println("ID: ");
				long id = s.nextInt();
				Adresse a = m.find(Adresse.class, id);
				m.getTransaction().begin();
				m.remove(a);
				m.getTransaction().commit();
			} else if (x.equalsIgnoreCase("KUNDE")) {
				List<Kunde> z = m.createQuery("SELECT a FROM Kunde a", Kunde.class).getResultList();
				for (int i = 0; i < z.size(); i++) {
					System.out.println(z.get(i));
				}
				System.out.println("ID:  ");
				long id = s.nextInt();
				Kunde a = m.find(Kunde.class, id);
				m.getTransaction().begin();
				m.remove(a);
				m.getTransaction().commit();
			}
			System.out.println("Möchten Sie eine weitere Aktion durchführen? (JA/NEIN)");
			String choice = s.next();
			if (choice.equalsIgnoreCase("JA")) {
				start();
			} else {
				s.close();
			}
		} else if (method.equalsIgnoreCase("UPDATE")) {
			System.out.println("Bitte geben Sie BESTELLUNG, BESTELLUNG_ARTIKEL, ARTIKEL, ADRESSE oder KUNDE ein: ");
			String x = s.next();
			if (x.equalsIgnoreCase("BESTELLUNG")) {
				List<Bestellung> z = m.createQuery("SELECT a FROM Bestellung a", Bestellung.class).getResultList();
				for(int i = 0; i < z.size(); i++) {
					System.out.println(z.get(i));
				}
				System.out.println("ID: ");
				long id = s.nextInt();
				System.out.println("KundenID: ");
				long kundenID = s.nextInt();
				System.out.println("LieferadresseID: ");
				long lieferID = s.nextInt();
				System.out.println("RechnungsadresseID: ");
				long rechnungID = s.nextInt();
				Bestellung a = m.find(Bestellung.class, id);
				m.getTransaction().begin();
				Kunde b = m.find(Kunde.class, kundenID);
				a.setKunde(b);
				Adresse liefer = m.find(Adresse.class, lieferID);
				Adresse rechnung = m.find(Adresse.class, rechnungID);
				a.setLiefer(liefer);
				a.setRechnung(rechnung);
				m.getTransaction().commit();
			} else if (x.equalsIgnoreCase("BESTELLUNG_ARTIKEL")) {
				List<Bestellung_Artikel> z = m.createQuery("SELECT a FROM Bestellung_Artikel a", Bestellung_Artikel.class).getResultList();
				for(int i = 0; i < z.size(); i++) {
					System.out.println(z.get(i));
				}
				System.out.println("Bestellung_Artikel_ID: ");
				long ba_id = s.nextInt();
				System.out.println("BestellID: ");
				long bestellID = s.nextInt();
				System.out.println("ArtikelID: ");
				long artikelID = s.nextInt();
				System.out.println("Menge: ");
				int menge = s.nextInt();
				Bestellung_Artikel a = m.find(Bestellung_Artikel.class, ba_id);
				m.getTransaction().begin();
				Bestellung b = m.find(Bestellung.class, bestellID);
				Artikel c = m.find(Artikel.class, artikelID);
				a.setArtikel(c);
				a.setBestellung(b);
				a.setMenge(menge);
				m.getTransaction().commit();
			} else if (x.equalsIgnoreCase("ARTIKEL")) {
				List<Artikel> z = m.createQuery("SELECT a FROM Artikel a", Artikel.class).getResultList();
				for(int i = 0; i < z.size(); i++) {
					System.out.println(z.get(i));
				}
				System.out.println("ID: ");
				long id = s.nextInt();
				System.out.println("Name: ");
				String name = s.next();
				System.out.println("Preis: ");
				double preis = s.nextDouble();
				Artikel a = m.find(Artikel.class, id);
				m.getTransaction().begin();
				a.setArtikelname(name);
				a.setPreis(preis);
				m.getTransaction().commit();
			} else if (x.equalsIgnoreCase("ADRESSE")) {
				List<Adresse> z = m.createQuery("SELECT a FROM Adresse a", Adresse.class).getResultList();
				for(int i = 0; i < z.size(); i++) {
					System.out.println(z.get(i));
				}
				System.out.println("ID: ");
				long id = s.nextInt();
				System.out.println("Stadt: ");
				String stadt = s.next();
				System.out.println("Strasse: ");
				String strasse = s.next();
				System.out.println("PLZ: ");
				int plz = s.nextInt();
				System.out.println("Hausnummer: ");
				String hnr = s.next();
				Adresse a = m.find(Adresse.class, id);
				m.getTransaction().begin();
				a.setStadt(stadt);
				a.setStrasse(strasse);
				a.setPlz(plz);
				a.setHnr(hnr);
				m.getTransaction().commit();
			} else if (x.equalsIgnoreCase("KUNDE")) {
				List<Kunde> z = m.createQuery("SELECT a FROM Kunde a", Kunde.class).getResultList();
				for(int i = 0; i < z.size(); i++) {
					System.out.println(z.get(i));
				}
				System.out.println("ID: ");
				long id = s.nextInt();
				System.out.println("Vorname:  ");
				String vorname = s.next();
				System.out.println("Nachname:  ");
				String nachname = s.next();
				Kunde a = m.find(Kunde.class, id);
				m.getTransaction().begin();
				a.setVorname(vorname);
				a.setNachname(nachname);
				m.getTransaction().commit();
			}
			System.out.println("Möchten Sie eine weitere Aktion durchführen? (JA/NEIN)");
			String choice = s.next();
			if (choice.equalsIgnoreCase("JA")) {
				start();
			} else {
				s.close();
			}
		} else if (method.equalsIgnoreCase("READ")) {
			System.out.println("Bitte geben Sie BESTELLUNG, BESTELLUNG_ARTIKEL, ARTIKEL, ADRESSE oder KUNDE ein: ");
			String x = s.next();
			if (x.equalsIgnoreCase("BESTELLUNG")) {
				List<Bestellung> z = m.createQuery("SELECT a FROM Bestellung a", Bestellung.class).getResultList();
				for(int i = 0; i < z.size(); i++) {
					System.out.println(z.get(i));
				}
				System.out.println("ID: ");
				long id = s.nextInt();
				Bestellung a = m.find(Bestellung.class, id);
				System.out.println(a.toString());
			} else if (x.equalsIgnoreCase("BESTELLUNG_ARTIKEL")) {
				List<Bestellung_Artikel> z = m.createQuery("SELECT a FROM Bestellung_Artikel a", Bestellung_Artikel.class).getResultList();
				for(int i = 0; i < z.size(); i++) {
					System.out.println(z.get(i));
				}
				System.out.println("Bestellung_Artikel_ID: ");
				long ba_id = s.nextInt();
				Bestellung_Artikel a = m.find(Bestellung_Artikel.class, ba_id);
				System.out.println(a.toString());
			} else if (x.equalsIgnoreCase("ARTIKEL")) {
				List<Artikel> z = m.createQuery("SELECT a FROM Artikel a", Artikel.class).getResultList();
				for(int i = 0; i < z.size(); i++) {
					System.out.println(z.get(i));
				}
				System.out.println("ID: ");
				long id = s.nextInt();
				Artikel a = m.find(Artikel.class, id);
				System.out.println(a.toString());
			} else if (x.equalsIgnoreCase("ADRESSE")) {
				List<Adresse> z = m.createQuery("SELECT a FROM Adresse a", Adresse.class).getResultList();
				for(int i = 0; i < z.size(); i++) {
					System.out.println(z.get(i));
				}
				System.out.println("ID: ");
				long id = s.nextInt();
				Adresse a = m.find(Adresse.class, id);
				System.out.println(a.toString());
			} else if (x.equalsIgnoreCase("KUNDE")) {
				List<Kunde> z = m.createQuery("SELECT a FROM Kunde a", Kunde.class).getResultList();
				for(int i = 0; i < z.size(); i++) {
					System.out.println(z.get(i));
				}
				System.out.println("ID:  ");
				long id = s.nextInt();
				Kunde a = m.find(Kunde.class, id);
				System.out.println(a.toString());
			}
			System.out.println("Möchten Sie eine weitere Aktion durchführen? (JA/NEIN)");
			String choice = s.next();
			if (choice.equalsIgnoreCase("JA")) {
				start();
			} else {
				s.close();
			}

		}

	}
}
