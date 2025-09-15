package com.patient_service.patient_service.repository.service;

import com.patient_service.patient_service.dto.PatientRequestDTO;
import com.patient_service.patient_service.dto.PatientResponseDTO;
import com.patient_service.patient_service.model.Patient;
import com.patient_service.patient_service.repository.PatientRepository;
import com.patient_service.patient_service.repository.service.mapper.PatientMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * PatientService handles the business logic for managing patients.
 *
 * This service communicates with the PatientRepository (database layer)
 * and uses PatientMapper to convert between entity objects (Patient)
 * and DTOs (PatientRequestDTO / PatientResponseDTO).
 */
@Service
public class PatientService {

    // Repository for interacting with the database
    private PatientRepository patientRepository;

    // Constructor injection of the repository
    public PatientService(PatientRepository patientRepository){
        this.patientRepository = patientRepository;
    }

    /**
     * Retrieves all patients from the database and maps them into
     * a list of PatientResponseDTO objects.
     *
     * @return a list of DTOs containing patient data
     */
    public List<PatientResponseDTO> getPatients(){
        // Fetch all patient entities from the database
        List<Patient> patients = patientRepository.findAll();

        // Convert entities to DTOs using the mapper
        List<PatientResponseDTO> patientResponseDTOs = patients.stream()
                .map(PatientMapper::toDTO) // map each Patient → PatientResponseDTO
                .toList();

        return patientResponseDTOs;
    }

    /**
     * Creates and saves a new patient in the database using data from a DTO.
     *
     * @param patientRequestDTO DTO containing input data from client (e.g. API request body)
     * @return a PatientResponseDTO containing the saved patient's data
     */
    public PatientResponseDTO createPatient(PatientRequestDTO patientRequestDTO){
        // Convert the incoming request DTO to an entity object
        Patient newPatient = patientRepository.save(PatientMapper.toEntity(patientRequestDTO));

        // Convert the saved entity back to a response DTO
        return PatientMapper.toDTO(newPatient);
    }
}
