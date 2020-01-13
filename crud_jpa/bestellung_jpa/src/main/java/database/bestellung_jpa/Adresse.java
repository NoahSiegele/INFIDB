package database.bestellung_jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Adresse {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter
	@Setter
private long id;
	@Getter
	@Setter
private String stadt;
	@Getter
	@Setter
private String strasse;
	@Getter
	@Setter
private int plz;
	@Getter
	@Setter
private String hnr;
	
	public Adresse() {
		super();
	}
	
	public Adresse(long id, String stadt, String strasse, int plz, String hnr) {
		this.id = id;
		this.stadt = stadt;
		this.strasse = strasse;
		this.plz = plz;
		this.hnr = hnr;
	}

	@Override
	public String toString() {
		return "Adresse [id=" + id + ", stadt=" + stadt + ", strasse=" + strasse + ", plz=" + plz + ", hnr=" + hnr
				+ "]";
	}
	
	
}
