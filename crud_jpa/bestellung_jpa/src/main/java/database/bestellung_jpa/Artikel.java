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
@Table(name = "artikel")
@CascadeOnDelete
public class Artikel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter
	@Setter
private long id;
	@Getter
	@Setter
private String artikelname;
	@Getter
	@Setter
private double preis;
	@Getter
	@Setter
	@CascadeOnDelete
	@OneToMany(
			cascade={CascadeType.ALL},
			orphanRemoval=true
			)
	private List<Bestellung_Artikel> bestellung1;
	
	public Artikel() {
		super();
	}
	
	public Artikel(String name, double preis) {
		this.artikelname = name;
		this.preis = preis;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((artikelname == null) ? 0 : artikelname.hashCode());
		result = prime * result + ((bestellung1 == null) ? 0 : bestellung1.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		long temp;
		temp = Double.doubleToLongBits(preis);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Artikel other = (Artikel) obj;
		if (artikelname == null) {
			if (other.artikelname != null)
				return false;
		} else if (!artikelname.equals(other.artikelname))
			return false;
		if (bestellung1 == null) {
			if (other.bestellung1 != null)
				return false;
		} else if (!bestellung1.equals(other.bestellung1))
			return false;
		if (id != other.id)
			return false;
		if (Double.doubleToLongBits(preis) != Double.doubleToLongBits(other.preis))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Artikel [id=" + id + ", artikelname=" + artikelname + ", preis=" + preis + ", bestellung1="
				+ bestellung1 + "]";
	}
	
	
	
	
}
