package com.dentalapp.rest.webservices.dentalappointments;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class AppointmentService {

	private static List<Appointment> appointments = new ArrayList<Appointment>();
	
	
	private static long idCounter = 1;
	static {
		appointments.add(new Appointment(idCounter++,"hitenshah",1,1,new Date(), new Date()));
		appointments.add(new Appointment(idCounter++,"hitenshah",1,2,new Date(), new Date()));
		appointments.add(new Appointment(idCounter++,"hitenshah",2,3,new Date(), new Date()));
		appointments.add(new Appointment(idCounter++,"hitenshah",2,4,new Date(), new Date()));
	}
	
	public List<Appointment> findAll() {
		return appointments;
	}
	
	public Appointment save(Appointment appointment){
		if ( appointment.getId() == -1 || appointment.getId() == 0) {
			//appointment.setId(idCounter++);
			appointments.add(appointment);
		} else {
			deleteById(appointment.getId());
			appointments.add(appointment);
		}
		return appointment;
	}
	
	public Appointment deleteById(long id){
		Appointment appointment = findById(id);
		if ( appointment == null) return null;
		appointments.remove(appointment);
		return appointment;
	}

	public Appointment findById(long id) {
		// TODO Auto-generated method stub
		for(Appointment appointment:appointments){
			if ( appointment.getId() == id)
				return appointment;
		}
		return null;
	}

	public List<Appointment> findByUserName(String userName) {
		List<Appointment> listOfAppointments = new ArrayList<Appointment>();
		for(Appointment appointment:appointments){
			if ( appointment.getUserName().equalsIgnoreCase(userName) )
				listOfAppointments.add(appointment);
		}
		return listOfAppointments;
	}

	public List<Appointment> findByDentistId(long dentistId) {
		List<Appointment> listOfAppointments = new ArrayList<Appointment>();
		for(Appointment appointment:appointments){
			if ( appointment.getdentistId() == dentistId)
				listOfAppointments.add(appointment);
		}
		return listOfAppointments;
	}

	public List<Appointment> findByPatientId(long petientId) {
		// TODO Auto-generated method stub
		List<Appointment> listOfAppointments = new ArrayList<Appointment>();
		for(Appointment appointment:appointments){
			if ( appointment.getpatientId() == petientId)
				listOfAppointments.add(appointment);
		}
		return listOfAppointments;
	}

}
