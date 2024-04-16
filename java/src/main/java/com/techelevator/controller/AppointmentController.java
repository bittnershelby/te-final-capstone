package com.techelevator.controller;
import com.techelevator.dao.AppointmentDao;
import com.techelevator.model.Appointment;
import com.techelevator.model.Doctor;
import com.techelevator.model.Patient;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;


@PreAuthorize("permitAll")
@RestController
@CrossOrigin
public class AppointmentController {

    private AppointmentDao appointmentDao;

    public AppointmentController(AppointmentDao appointmentDao) {
        this.appointmentDao = appointmentDao;
    }

    @RequestMapping(path = "/appointments/{patientId}", method = RequestMethod.GET)
    public List<Appointment> getAppointmentByPatientIdController(@PathVariable int patientId) {
        List<Appointment> result = new ArrayList<>();
        Patient patient;
        try {
            result = appointmentDao.getAppointmentListByPatientId(patientId);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return result;
    }
    @RequestMapping(path = "/appointments/{doctorId}", method = RequestMethod.GET)
    public List<Appointment> getAppointmentByDoctorIdController(@PathVariable int doctorId) {
        List<Appointment> result = new ArrayList<>();
        Doctor doctor;
        try {
            result = appointmentDao.getAppointmentListByDoctorId(doctorId);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return result;
    }

    public Appointment scheduleAppointmentByPatientId(Appointment patientId, int id) {
//        patientId.setPatientId(id);
        try {
            return appointmentDao.scheduleAppointmentByPatientId(patientId);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //TODO: Get patientAppointments by patientId
    //TODO: Get patientAppointments by patientId, date
    //TODO: Get doctorAppointments by doctorId
    //TODO: Get doctorAppointments by doctorId, Date

}
