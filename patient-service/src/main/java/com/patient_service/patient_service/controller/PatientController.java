package com.patient_service.patient_service.controller;

import com.patient_service.patient_service.dto.PatientRequestDTO;
import com.patient_service.patient_service.dto.PatientResponseDTO;
import com.patient_service.patient_service.repository.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * PatientController handles incoming HTTP requests related to patients.
 *
 * It exposes REST API endpoints for:
 *   - Retrieving all patients (GET /patients)
 *   - Creating a new patient (POST /patients)
 *
 * This controller delegates the business logic to PatientService and ensures
 * that data is transferred using DTOs (request/response objects).
 */
@RestController
@RequestMapping("/patients")
public class PatientController {

    // Inject PatientService to delegate business logic
    private final PatientService patientService;

    public PatientController(PatientService patientService){
        this.patientService = patientService;
    }

    /**
     * GET /patients
     *
     * Retrieves a list of all patients.
     *
     * @return HTTP 200 OK with a list of PatientResponseDTO objects in the response body
     */
    @GetMapping
    public ResponseEntity<List<PatientResponseDTO>> getPatient(){
        List<PatientResponseDTO> patients = patientService.getPatients();
        return ResponseEntity.ok().body(patients);
    }

    /**
     * POST /patients
     *
     * Creates a new patient using the data provided in the request body.
     * Uses @Valid to trigger validation on PatientRequestDTO.
     *
     * @param patientRequestDTO validated request body containing patient info
     * @return HTTP 200 OK with the created PatientResponseDTO in the response body
     */
    @PostMapping
    public ResponseEntity<PatientResponseDTO> createPatient(@Valid @RequestBody PatientRequestDTO patientRequestDTO){
        PatientResponseDTO patientResponseDTO = patientService.createPatient(patientRequestDTO);
        return ResponseEntity.ok().body(patientResponseDTO);
    }
}
