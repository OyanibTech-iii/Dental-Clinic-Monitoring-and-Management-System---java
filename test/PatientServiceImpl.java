package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PatientServiceImpl implements PatientService {
    
    @Override
    public int savePatient(Patient patient) {
        int result = 0;
        try {
            Connection conn = DbConnection.connectToDb();
            String query = "INSERT INTO Patient (FirstName, MiddleName, LastName, Age, Address, Birthdate, ContactNumber, Email) VALUES (?,?,?,?,?,?,?,?)";
            
            PreparedStatement prepStat = conn.prepareStatement(query);
            prepStat.setString(1, patient.getFirstName());
            prepStat.setString(2, patient.getMiddleName());
            prepStat.setString(3, patient.getLastName());
            prepStat.setInt(4, patient.getAge());
            prepStat.setString(5, patient.getAddress());
            prepStat.setDate(6, new java.sql.Date(patient.getBirthdate().getTime()));
            prepStat.setString(7, patient.getContactNumber());
            prepStat.setString(8, patient.getEmail());
            
            result = prepStat.executeUpdate();
            
            // Get the generated ID and set it to the patient object
            if (result > 0) {
                String getIdQuery = "SELECT LAST_INSERT_ID()";
                PreparedStatement idStat = conn.prepareStatement(getIdQuery);
                ResultSet idResult = idStat.executeQuery();
                if (idResult.next()) {
                    patient.setPatientID(idResult.getInt(1));
                }
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        return result;
    }

    @Override
    public Patient getPatient(int patientID) {
        Patient patient = null;
        try {
            Connection conn = DbConnection.connectToDb();
            String query = "SELECT * FROM Patient WHERE PatientID = ?";
            
            PreparedStatement prepStat = conn.prepareStatement(query);
            prepStat.setInt(1, patientID);
            
            ResultSet result = prepStat.executeQuery();
            
            if (result.next()) {
                patient = new Patient();
                patient.setPatientID(result.getInt("PatientID"));
                patient.setFirstName(result.getString("FirstName"));
                patient.setMiddleName(result.getString("MiddleName"));
                patient.setLastName(result.getString("LastName"));
                patient.setAge(result.getInt("Age"));
                patient.setAddress(result.getString("Address"));
                patient.setBirthdate(result.getDate("Birthdate"));
                patient.setContactNumber(result.getString("ContactNumber"));
                patient.setEmail(result.getString("Email"));
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        return patient;
    }

    @Override
    public int deletePatient(int patientID) {
        int result = 0;
        try {
            Connection conn = DbConnection.connectToDb();
            String query = "DELETE FROM Patient WHERE PatientID = ?";
            
            PreparedStatement prepStat = conn.prepareStatement(query);
            prepStat.setInt(1, patientID);
            
            result = prepStat.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        return result;
    }

    @Override
    public int updatePatient(Patient patient) {
        int result = 0;
        try {
            Connection conn = DbConnection.connectToDb();
            String query = "UPDATE Patient SET FirstName = ?, MiddleName = ?, LastName = ?, Age = ?, Address = ?, Birthdate = ?, ContactNumber = ?, Email = ? WHERE PatientID = ?";
            
            PreparedStatement prepStat = conn.prepareStatement(query);
            prepStat.setString(1, patient.getFirstName());
            prepStat.setString(2, patient.getMiddleName());
            prepStat.setString(3, patient.getLastName());
            prepStat.setInt(4, patient.getAge());
            prepStat.setString(5, patient.getAddress());
            prepStat.setDate(6, new java.sql.Date(patient.getBirthdate().getTime()));
            prepStat.setString(7, patient.getContactNumber());
            prepStat.setString(8, patient.getEmail());
            prepStat.setInt(9, patient.getPatientID());
            
            result = prepStat.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        return result;
    }

    @Override
    public List<Patient> getAllPatients() {
        List<Patient> patients = new ArrayList<>();
        try {
            Connection conn = DbConnection.connectToDb();
            String query = "SELECT * FROM Patient";
            
            PreparedStatement prepStat = conn.prepareStatement(query);
            ResultSet result = prepStat.executeQuery();
            
            while (result.next()) {
                Patient patient = new Patient();
                patient.setPatientID(result.getInt("PatientID"));
                patient.setFirstName(result.getString("FirstName"));
                patient.setMiddleName(result.getString("MiddleName"));
                patient.setLastName(result.getString("LastName"));
                patient.setAge(result.getInt("Age"));
                patient.setAddress(result.getString("Address"));
                patient.setBirthdate(result.getDate("Birthdate"));
                patient.setContactNumber(result.getString("ContactNumber"));
                patient.setEmail(result.getString("Email"));
                patients.add(patient);
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        return patients;
    }

    @Override
    public Patient findPatientByName(String lastName) {
        Patient patient = null;
        try {
            Connection conn = DbConnection.connectToDb();
            String query = "SELECT * FROM Patient WHERE LastName LIKE ?";
            
            PreparedStatement prepStat = conn.prepareStatement(query);
            prepStat.setString(1, "%" + lastName + "%");
            
            ResultSet result = prepStat.executeQuery();
            
            if (result.next()) {
                patient = new Patient();
                patient.setPatientID(result.getInt("PatientID"));
                patient.setFirstName(result.getString("FirstName"));
                patient.setMiddleName(result.getString("MiddleName"));
                patient.setLastName(result.getString("LastName"));
                patient.setAge(result.getInt("Age"));
                patient.setAddress(result.getString("Address"));
                patient.setBirthdate(result.getDate("Birthdate"));
                patient.setContactNumber(result.getString("ContactNumber"));
                patient.setEmail(result.getString("Email"));
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        return patient;
    }
}