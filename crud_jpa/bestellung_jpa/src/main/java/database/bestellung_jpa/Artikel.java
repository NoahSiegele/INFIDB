package database.bestellung_jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Artikel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter
	@Setter
private long id;
	@Getter
	@Setter
private String name;
	@Getter
	@Setter
private double preis;
	
	public Artikel() {
		super();
	}
	
	public Artikel(long id, String name, double preis) {
		this.name = name;
		this.id = id;
		this.preis = preis;
	}
}
