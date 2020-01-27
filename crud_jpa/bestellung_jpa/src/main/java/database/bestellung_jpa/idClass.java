package database.bestellung_jpa;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;

import lombok.Getter;
import lombok.Setter;

@Embeddable
public class idClass implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JoinColumn(name = "Artikel_id")
	private Artikel artikel;
	@JoinColumn(name = "Bestellung_id")
	private Bestellung bestellung;

	
	
	
	
	public Artikel getArtikel() {
		return artikel;
	}




	public void setArtikel(Artikel artikel) {
		this.artikel = artikel;
	}




	public Bestellung getBestellung() {
		return bestellung;
	}




	public void setBestellung(Bestellung bestellung) {
		this.bestellung = bestellung;
	}




	public idClass() {
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((artikel == null) ? 0 : artikel.hashCode());
		result = prime * result + ((bestellung == null) ? 0 : bestellung.hashCode());
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
		idClass other = (idClass) obj;
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
		return true;
	}
	
	

	
	

}
