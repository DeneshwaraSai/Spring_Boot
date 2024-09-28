
package com.pharmacy.code.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pharmacy.code.dto.PatientHeaderContext;
import com.pharmacy.code.dto.PatientSearchDto;
import com.pharmacy.code.entity.Patient;
import com.pharmacy.code.service.PatientService;

@CrossOrigin
@RestController
public class PatientController {

	private PatientService patientService;

	@Autowired
	public PatientController(PatientService patientService) {
		this.patientService = patientService;
	}

	@GetMapping(path="/patient/list")
	public List<Patient> findAllPatients() {
		return patientService.findAll();
	}

	@PostMapping(path="/patient/save")
	public Patient savePatient(@RequestBody Patient patient) {
		return patientService.save(patient);
	}

	@GetMapping(path="/patient/{patientId}")
	public Patient getPatientById(@PathVariable(name = "patientId", required = true) Integer patientId ) {
		return patientService.findById(patientId);
	}

	@PutMapping(path="/patient/update")
	public Patient updatePatient(@RequestBody Patient patient) {
		return patientService.save(patient);
	}

	@GetMapping(path="/patient/search/{name}")
	public List<PatientSearchDto> searchpatients(@PathVariable(name = "name", required=true) String name) {
		return patientService.searchpatients(name);
	}

	@GetMapping(path = "/patient/uhid/{uhid}")
	public PatientHeaderContext findPatientByUhid(@PathVariable(name = "uhid", required=true) Integer uhid) {
		return patientService.findPatientByUhid(uhid);
	}
}
