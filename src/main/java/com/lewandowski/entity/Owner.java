package com.lewandowski.entity;

import jakarta.validation.constraints.NotEmpty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "owner")
public class Owner extends Person {

    @Column(name = "address")
    @NotEmpty
    private String address;

    @Column(name = "city")
    @NotEmpty
    private String city;

    @Column(name = "phone_number")
    @NotEmpty
    private String phoneNumber;

    @OneToMany(mappedBy = "owner", cascade = {CascadeType.ALL})
    private Set<Pet> pets;

    public void addPet(Pet pet) {

        if(pets == null) {
            pets = new HashSet<>();
        }

        pets.add(pet);
        pet.setOwner(this);
    }

    public Set<Pet> getPets() {
        if(pets == null) {
            pets = new HashSet<>();
        }
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
