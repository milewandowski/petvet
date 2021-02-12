package com.lewandowski.controller;

import com.lewandowski.entity.Appointment;
import com.lewandowski.entity.Pet;
import com.lewandowski.service.AppointmentService;
import com.lewandowski.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AppointmentController {

    private final static String VIEW_APPOINTMENT_FORM = "appointment/appointmentForm";
    private final AppointmentService appointmentService;
    private final PetService petService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService, PetService petService) {
        this.appointmentService = appointmentService;
        this.petService = petService;
    }

    @GetMapping("/appointment/list/{id}")
    public String showAppointmentsList(@PathVariable int id, Model model) {
        Pet pet = petService.findById(id);
        List<Appointment> appointments = appointmentService.findAllByPetId(id);
        model.addAttribute("appointments", appointments);
        model.addAttribute("pet", pet);

        return "appointment/appointmentsList";
    }

    @GetMapping("/appointment/delete/{id}/{petId}")
    public String deleteAppointment(@PathVariable int id, @PathVariable int petId, RedirectAttributes redirectAttributes) {
        Appointment appointment = appointmentService.findById(id);
        appointmentService.delete(appointment);
        redirectAttributes.addAttribute("id", petId);

        return "redirect:/appointment/list/{id}";
    }

    @GetMapping("/appointment/new/{id}")
    public String showAppointmentForm(@PathVariable int id, Model model) {
        Pet pet = petService.findById(id);
        Appointment appointment = new Appointment();
        appointment.setPet(pet);
        model.addAttribute("appointment", appointment);

        return VIEW_APPOINTMENT_FORM;
    }

    @PostMapping("/appointment/processAppointmentForm")
    public String processAppointmentForm(
            @Valid @ModelAttribute("appointment") Appointment appointment,
            BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            return VIEW_APPOINTMENT_FORM;
        }

        Pet pet = petService.findById(appointment.getPet().getId());
        appointment.setPet(pet);
        appointmentService.save(appointment);
        return "redirect:/user/profile";
    }

}
