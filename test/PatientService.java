
package test;

import java.util.List;

public interface PatientService {
    public int savePatient(Patient patient);
    public Patient getPatient(int patientID);
    public int deletePatient(int patientID);
    public int updatePatient(Patient patient);
    public List<Patient> getAllPatients();
    public Patient findPatientByName(String lastName);
}