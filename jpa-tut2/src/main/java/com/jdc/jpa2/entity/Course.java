package com.jdc.jpa2.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Enumerated;
import static javax.persistence.EnumType.STRING;
import javax.persistence.Lob;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.ElementCollection;
import javax.persistence.CollectionTable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
@Table(name = "COURSE")
public class Course implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private int id;
	private String name;
	private int fees;
	private double duration;
	@Lob
	private String description;
	@Enumerated(STRING)
	private Level level;
	
	@OneToMany(mappedBy = "course")
	private List<ClassRoom> rooms;

	@ElementCollection
	@MapKeyColumn(name = "type")
	@CollectionTable(name = "COURSE_DISCOUNT", joinColumns = @JoinColumn(name = "course_id"))
	private Map<DiscountType, Double> discount;

	private SecurityInfo security;

	public List<ClassRoom> getRooms() {
		return rooms;
	}

	public void setRooms(List<ClassRoom> rooms) {
		this.rooms = rooms;
	}

	public SecurityInfo getSecurity() {
		return security;
	}

	public void setSecurity(SecurityInfo security) {
		this.security = security;
	}

	public Map<DiscountType, Double> getDiscount() {
		return discount;
	}

	public void setDiscount(Map<DiscountType, Double> discount) {
		this.discount = discount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getFees() {
		return fees;
	}

	public void setFees(int fees) {
		this.fees = fees;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public enum Level {
		Basic, Intermediate, Advance
	}

	public enum DiscountType {
		EarlyBird, OldStudent, Others
	}
}
