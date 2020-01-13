package database.bestellung_jpa;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Bestellung_Artikel {
	@Id
	@Getter
	@Setter
	private long bestell_id;
	@Id
	@Getter
	@Setter
	private long artikel_id;
	@Getter
	@Setter
	private int menge;

	public Bestellung_Artikel() {
		super();
	}
	
	public Bestellung_Artikel(long bestell_id, long artikel_id, int menge) {
		this.bestell_id = bestell_id;
		this.artikel_id = artikel_id;
		this.menge = menge;
	}

	@Override
	public String toString() {
		return "Bestellung_Artikel [bestell_id=" + bestell_id + ", artikel_id=" + artikel_id + ", menge=" + menge + "]";
	}
	
	
}
