package com.dentalapp.rest.webservices.dentalappointments;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class DentalAppointmentsResource {


	/*
	 * 
	 * using service layer with hard coded data
	 */
	@Autowired
	private AppointmentService appointmentService;
	
	
	@GetMapping(path="/users/{username}/appointments")
	public List<Appointment> getAllAppointments(@PathVariable String username) {
		 return appointmentService.findAll();
	}

	@GetMapping(path="/users/{username}/appointments/{id}")
	public Appointment getAppointment(@PathVariable String username, @PathVariable long id) {
		 return appointmentService.findById(id);
			 
	}

	@PutMapping(path="/users/{username}/appointments/{id}")
	public ResponseEntity<Appointment> updateAppointment(@PathVariable String username, @PathVariable long id, @RequestBody Appointment appointment) {
		Appointment appointmentUpdated = appointmentService.save(appointment);
		return new ResponseEntity<Appointment>(appointmentUpdated,HttpStatus.OK);
	}
	
	@PostMapping(path="/users/{username}/appointments")
	public ResponseEntity<Appointment> postAppointment(@PathVariable String username, @RequestBody Appointment appointment) {
		Appointment createdAppointment = appointmentService.save(appointment);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(createdAppointment.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}

	@DeleteMapping(path="/users/{username}/appointments/{id}")
	public ResponseEntity<?> deleteAppointment(@PathVariable String username, @PathVariable long id) {
		 Appointment appointment = appointmentService.deleteById(id);
		 if ( appointment != null ) {
			 return ResponseEntity.noContent().build();
		 }
		 return ResponseEntity.noContent().build();
	}
	
	
	/*
	 * Using JPA Repository and in memory database H2
	 * 
	 */

	@Autowired
	private AppointmentJpaRepository appointmentRepository;

	
	@GetMapping(path="/jpa/users/{username}/appointments")
	public List<Appointment> getAllAppointmentsJpa(@PathVariable String username) {
		 return appointmentRepository.findByUserName(username);
	}


	@GetMapping(path="/jpa/users/{username}/appointments/{id}")
	public Appointment getAppointmentJpa(@PathVariable String username, @PathVariable long id) {
		 return appointmentRepository.findById(id).get();
	}

	@PutMapping(path="/jpa/users/{username}/appointments/{id}")
	public ResponseEntity<Appointment> updateAppointmentJpa(@PathVariable String username, @PathVariable long id, @RequestBody Appointment appointment) {
		appointment.setUserName(username);
		Appointment appointmentUpdated = appointmentRepository.save(appointment);
		return new ResponseEntity<Appointment>(appointmentUpdated,HttpStatus.OK);
	}

	@PostMapping(path="/jpa/users/{username}/appointments")
	public ResponseEntity<Appointment> postAppointmentJpa(@PathVariable String username, @RequestBody Appointment appointment) {
		
		appointment.setUserName(username);
		Appointment createdAppointment = appointmentRepository.save(appointment);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(createdAppointment.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}

	@DeleteMapping(path="/jpa/users/{username}/appointments/{id}")
	public ResponseEntity<?> deleteAppointmentJPA(@PathVariable String username, @PathVariable long id) {
		 appointmentRepository.deleteById(id);
		 return ResponseEntity.noContent().build();
	}

}
