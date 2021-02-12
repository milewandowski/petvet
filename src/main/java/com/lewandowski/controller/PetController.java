package com.lewandowski.controller;

import com.lewandowski.entity.Pet;
import com.lewandowski.service.PetService;
import com.lewandowski.service.SpeciesService;
import com.lewandowski.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class PetController {

    private final static String VIEW_CREATE_OR_UPDATE_FORM = "pet/createPetForm";
    private final PetService petService;
    private final SpeciesService speciesService;
    private final UserService userService;

    @Autowired
    public PetController(PetService petService, SpeciesService speciesService, UserService userService) {
        this.petService = petService;
        this.speciesService = speciesService;
        this.userService = userService;
    }

    @GetMapping("/pet/delete/{id}")
    public String deletePet(@PathVariable int id) {
        Pet pet = petService.findById(id);
        petService.delete(pet);

        return "redirect:/user/profile";
    }

    @GetMapping("/pet/new")
    public String showPetForm(Model model) {
        model.addAttribute("pet", new Pet());
        model.addAttribute("species", speciesService.findAll());

        return VIEW_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/pet/processPetForm")
    public String processPetForm(
            @Valid @ModelAttribute("pet") Pet pet,
            BindingResult bindingResult,
            Authentication auth,
            Model model) {

        if(bindingResult.hasErrors()) {
            return VIEW_CREATE_OR_UPDATE_FORM;
        }

        Pet existing = petService.findByName(pet.getName());

        if(existing != null) {
            model.addAttribute("existsError", "Pet already exists");
            return VIEW_CREATE_OR_UPDATE_FORM;
        }
        pet.setSpecies(speciesService.findById(pet.getSpecies().getId()));
        pet.setUser(userService.findUserByUsername(auth.getName()));
        petService.save(pet);

        return "redirect:/user/profile";
    }
}
