package database.bestellung_jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Bestellung {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter
	@Setter
private long id;
	@Getter
	@Setter
private long kunde_id;
	@Getter
	@Setter
private long adresse_rechnung_id;
	@Getter
	@Setter
private long adresse_liefer_id;
	
	public Bestellung() {
		super();
	}
	
	public Bestellung(long id, long kunde_id, long adresse_rechnung_id, long adresse_liefer_id) {
		this.id = id;
		this.kunde_id = kunde_id;
		this.adresse_rechnung_id = adresse_rechnung_id;
		this.adresse_liefer_id = adresse_liefer_id;
	}

	@Override
	public String toString() {
		return "Bestellung [id=" + id + ", kunde_id=" + kunde_id + ", adresse_rechnung_id=" + adresse_rechnung_id
				+ ", adresse_liefer_id=" + adresse_liefer_id + "]";
	}
	
	
}
