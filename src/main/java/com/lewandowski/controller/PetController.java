package com.lewandowski.controller;

import com.lewandowski.entity.Pet;
import com.lewandowski.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PetController {

    private final PetService petService;

    @Autowired
    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping("/pet/delete/{id}")
    public String deletePet(@PathVariable int id) {
        Pet pet = petService.findById(id);
        petService.delete(pet);

        return "redirect:/user/profile";
    }

    @GetMapping("/pet/new")
    public String showPetForm() {
        return "pet/createOrUpdateForm";
    }
}
