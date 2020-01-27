package database.bestellung_jpa;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "bestellung_artikel")
public class Bestellung_Artikel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter
	@Setter
	private long id;
	@Getter
	@Setter
	@ManyToOne
	//@JoinColumn(name = "Bestellung_id")
	private Bestellung bestellung;
	@Getter
	@Setter
	@ManyToOne
	//@JoinColumn(name = "Artikel_id")
	private Artikel artikel;
	@Getter
	@Setter
	private int menge;

	public Bestellung_Artikel() {
		super();
	}
	
	
	public Bestellung_Artikel(Bestellung bestellung, Artikel artikel, int menge) {
		this.bestellung = bestellung;
		this.artikel = artikel;
		this.menge = menge;
	}
	
	
	

	@Override
	public String toString() {
		return "Bestellung_Artikel [id=" + id + ", menge=" + menge + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((artikel == null) ? 0 : artikel.hashCode());
		result = prime * result + ((bestellung == null) ? 0 : bestellung.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + menge;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bestellung_Artikel other = (Bestellung_Artikel) obj;
		if (artikel == null) {
			if (other.artikel != null)
				return false;
		} else if (!artikel.equals(other.artikel))
			return false;
		if (bestellung == null) {
			if (other.bestellung != null)
				return false;
		} else if (!bestellung.equals(other.bestellung))
			return false;
		if (id != other.id)
			return false;
		if (menge != other.menge)
			return false;
		return true;
	}
	
}
