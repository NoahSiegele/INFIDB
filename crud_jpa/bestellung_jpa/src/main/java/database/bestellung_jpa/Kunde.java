package database.bestellung_jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Kunde {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter
	@Setter
	private long id;
	@Getter
	@Setter
	private String titelv;
	@Getter
	@Setter
	private String vorname;
	@Getter
	@Setter
	private String nachname;
	@Getter
	@Setter
	private String titeln;	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	public Kunde() {
		super();
	}
	
	public Kunde(String titelv, String vorname, String nachname, String titeln) {
		this.titeln = titeln;
		this.titelv = titelv;
		this.nachname = nachname;
		this.vorname = vorname;
	}

	@Override
	public String toString() {
		return "Kunde [id=" + id + ", titelv=" + titelv + ", vorname=" + vorname + ", nachname=" + nachname
				+ ", titeln=" + titeln + "]";
	}
	
	

}
