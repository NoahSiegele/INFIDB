package database.jpa_example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
//@Data --> erzeugt automatisch Getter und Setter für alle Werte
public class Hobby {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter
	@Getter
	private long id;
	@Setter
	@Getter
	private String name;
	@Setter
	@Getter
	private int hoursPerWeek;
	@Setter
	@Getter
	private double expenses;

	public Hobby() {
		super();
	}
	
	public Hobby(String name, int hours, double expenses) {
		this.name = name;
		this.hoursPerWeek = hours;
		this.expenses = expenses;
		
	}

	@Override
	public String toString() {
		return "Hobby [id=" + id + ", name=" + name + ", hoursPerWeek=" + hoursPerWeek + ", expenses=" + expenses + "]";
	}
	
	
}
