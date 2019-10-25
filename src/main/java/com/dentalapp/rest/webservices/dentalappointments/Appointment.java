package com.dentalapp.rest.webservices.dentalappointments;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Appointment {
	@Id
	@GeneratedValue
	private Long id;
	
	private String userName;
	private int dentistId;
	private int patientId;
	private Date startTime;
	private Date endTime;
	
	
	protected Appointment() {
		
	}
	public Appointment(long id, String userName, int dentistId, int patientId,
			Date startTime, Date endTime) {
		super();
		this.id = id;
		this.userName = userName;
		this.dentistId = dentistId;
		this.patientId = patientId;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public long getdentistId() {
		return dentistId;
	}
	public void setdentistId(int dentistId) {
		this.dentistId = dentistId;
	}
	public long getpatientId() {
		return patientId;
	}
	public void setpatientId(int patientId) {
		this.patientId = patientId;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	@Override
	public String toString() {
		return "Appointment [id=" + id + ", username=" + userName
				+ ", dentistId=" + dentistId + ", patientId=" + patientId
				+ ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		Appointment other = (Appointment) obj;
		if (id != other.id)
			return false;
		return true;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}
