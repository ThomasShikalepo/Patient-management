package com.patient_service.patient_service.repository.service.mapper;

import com.patient_service.patient_service.dto.PatientRequestDTO;
import com.patient_service.patient_service.dto.PatientResponseDTO;
import com.patient_service.patient_service.model.Patient;

import java.time.LocalDate;

/**
 * PatientMapper is a utility class that converts a Patient entity
 * into a PatientResponseDTO.
 *
 * This is typically used when sending patient data as a response
 * (e.g., in a REST API) so that only the required fields are exposed
 * in a structured format.
 */
public class PatientMapper {

    /**
     * Converts a Patient entity object into a PatientResponseDTO.
     *
     * @param patient the Patient entity retrieved from the database
     * @return a PatientResponseDTO with mapped values from the entity
     */
    public static PatientResponseDTO toDTO(Patient patient) {
        // Create a new DTO object to hold the mapped data
        PatientResponseDTO patientDTO = new PatientResponseDTO();

        // Map fields from the Patient entity to the DTO
        patientDTO.setpatientId(patient.getPatientId().toString()); // Convert ID to String
        patientDTO.setFullname(patient.getFullname());
        patientDTO.setEmail(patient.getEmail());
        patientDTO.setAddress(patient.getAddress());
        patientDTO.setPhoneNumber(patient.getPhoneNumber());
        patientDTO.setGender(patient.getGender());
        patientDTO.setDateOfBirth(patient.getDateOfBirth().toString()); // Convert date to String

        // Return the mapped DTO
        return patientDTO;
    }

    public static Patient toEntity(PatientRequestDTO patientRequestDTO) {
        Patient patient = new Patient();

        patient.setFullname(patientRequestDTO.getFullName());
        patient.setEmail(patientRequestDTO.getEmail());
        patient.setAddress(patientRequestDTO.getAddress());
        patient.setPhoneNumber(patientRequestDTO.getPhoneNumber());
        patient.setGender(patientRequestDTO.getGender());
        patient.setDateOfBirth(LocalDate.parse(patientRequestDTO.getDateOfBirth()));
        patient.setRegisterDate(LocalDate.parse(patientRequestDTO.getRegisteredDate()));

        return patient;
    }
}
