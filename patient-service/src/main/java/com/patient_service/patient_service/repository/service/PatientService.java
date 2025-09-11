package com.patient_service.patient_service.repository.service;

import com.patient_service.patient_service.dto.PatientResponseDTO;
import com.patient_service.patient_service.model.Patient;
import com.patient_service.patient_service.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    private PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository){
        this.patientRepository = patientRepository;
    }

    public List<PatientResponseDTO> getPatients(){
        List<Patient> patients = patientRepository.findAll();

    }
}
