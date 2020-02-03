package database.bestellung_jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.eclipse.persistence.annotations.CascadeOnDelete;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "bestellung_v3")
@CascadeOnDelete
public class Bestellung {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter
	@Setter
private long id;
	@ManyToOne(cascade=CascadeType.ALL)
	@Getter
	@Setter
	//@JoinColumn(name = "Kunde_id")
	@CascadeOnDelete
private Kunde kunde;
	@Getter
	@Setter
	@ManyToOne(cascade=CascadeType.ALL)
	//@JoinColumn(name = "Rechnung_id")
	@CascadeOnDelete
private Adresse rechnung;
	@Getter
	@Setter
	@ManyToOne(cascade=CascadeType.ALL)
	//@JoinColumn(name = "Liefer_id")
	@CascadeOnDelete
private Adresse liefer;
	@Getter
	@Setter
	@CascadeOnDelete
	@OneToMany(
			cascade={CascadeType.ALL},
			orphanRemoval=true
			)
	private List<Bestellung_Artikel> bestellung1;
	
	public Bestellung() {
		super();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((kunde == null) ? 0 : kunde.hashCode());
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
		Bestellung other = (Bestellung) obj;
		if (kunde == null) {
			if (other.kunde != null)
				return false;
		} else if (!kunde.equals(other.kunde))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Bestellung [id=" + id + ", kunde=" + kunde + ", rechnung=" + rechnung + ", liefer=" + liefer + "]";
	}


	public Bestellung(Kunde kunde, Adresse rechnung, Adresse liefer) {
		this.kunde = kunde;
		this.rechnung = rechnung;
		this.liefer = liefer;
	}


	
	
}
