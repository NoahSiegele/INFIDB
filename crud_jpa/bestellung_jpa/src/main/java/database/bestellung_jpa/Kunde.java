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
@Table(name = "kunde")
@CascadeOnDelete
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
	@Getter
	@Setter
	@CascadeOnDelete
	@OneToMany(
			cascade={CascadeType.ALL},
			orphanRemoval=true
			
			)
	private List<Bestellung> bestellung1;
	
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bestellung1 == null) ? 0 : bestellung1.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((nachname == null) ? 0 : nachname.hashCode());
		result = prime * result + ((titeln == null) ? 0 : titeln.hashCode());
		result = prime * result + ((titelv == null) ? 0 : titelv.hashCode());
		result = prime * result + ((vorname == null) ? 0 : vorname.hashCode());
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
		Kunde other = (Kunde) obj;
		if (bestellung1 == null) {
			if (other.bestellung1 != null)
				return false;
		} else if (!bestellung1.equals(other.bestellung1))
			return false;
		if (id != other.id)
			return false;
		if (nachname == null) {
			if (other.nachname != null)
				return false;
		} else if (!nachname.equals(other.nachname))
			return false;
		if (titeln == null) {
			if (other.titeln != null)
				return false;
		} else if (!titeln.equals(other.titeln))
			return false;
		if (titelv == null) {
			if (other.titelv != null)
				return false;
		} else if (!titelv.equals(other.titelv))
			return false;
		if (vorname == null) {
			if (other.vorname != null)
				return false;
		} else if (!vorname.equals(other.vorname))
			return false;
		return true;
	}
	
	

}
