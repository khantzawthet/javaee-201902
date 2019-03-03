package com.jdc.jpa2.entity;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.util.Date;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;

@Entity
@Table(name = "CLASS_ROOM")
public class ClassRoom implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ClassRoomPK id;

	@ManyToOne
	@JoinColumn(insertable = false, updatable = false)
	private Course course;

	@Column(name = "end_date")
	private Date endDate;
	
	@ManyToOne
	private Teacher teacher;
	
	@ManyToMany
	private List<Student> students;

	@ElementCollection
	@CollectionTable(name = "CLASS_DAYS", joinColumns = {
			@JoinColumn(name = "start_date", referencedColumnName = "start_date"),
			@JoinColumn(name = "course_id", referencedColumnName = "course_id") })
	private List<DayOfWeek> days;

	private SecurityInfo security;

	public SecurityInfo getSecurity() {
		return security;
	}

	public void setSecurity(SecurityInfo security) {
		this.security = security;
	}

	public List<DayOfWeek> getDays() {
		return days;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public void setDays(List<DayOfWeek> days) {
		this.days = days;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public ClassRoomPK getId() {
		return id;
	}

	public void setId(ClassRoomPK id) {
		this.id = id;
	}

}
