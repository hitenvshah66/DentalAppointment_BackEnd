package com.dentalapp.rest.webservices.dentalappointments;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentJpaRepository extends JpaRepository<Appointment,Long>{

	List<Appointment> findByUserName(String userName);
	List<Appointment> findByDentistId(long dentistId);
	List<Appointment> findByPatientId(long pateintId);
	
}
