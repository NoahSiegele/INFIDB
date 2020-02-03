package database.bestellung_jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.eclipse.persistence.annotations.CascadeOnDelete;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "adresse")
@CascadeOnDelete
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
	@Getter
	@Setter
	@CascadeOnDelete
	@OneToMany(orphanRemoval=true, cascade={CascadeType.ALL})
	private List<Bestellung> bestellung1;
	
	public Adresse() {
		super();
	}
	
	public Adresse(String stadt, String strasse, int plz, String hnr) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bestellung1 == null) ? 0 : bestellung1.hashCode());
		result = prime * result + ((hnr == null) ? 0 : hnr.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + plz;
		result = prime * result + ((stadt == null) ? 0 : stadt.hashCode());
		result = prime * result + ((strasse == null) ? 0 : strasse.hashCode());
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
		Adresse other = (Adresse) obj;
		if (bestellung1 == null) {
			if (other.bestellung1 != null)
				return false;
		} else if (!bestellung1.equals(other.bestellung1))
			return false;
		if (hnr == null) {
			if (other.hnr != null)
				return false;
		} else if (!hnr.equals(other.hnr))
			return false;
		if (id != other.id)
			return false;
		if (plz != other.plz)
			return false;
		if (stadt == null) {
			if (other.stadt != null)
				return false;
		} else if (!stadt.equals(other.stadt))
			return false;
		if (strasse == null) {
			if (other.strasse != null)
				return false;
		} else if (!strasse.equals(other.strasse))
			return false;
		return true;
	}
	
	
	
	
}
