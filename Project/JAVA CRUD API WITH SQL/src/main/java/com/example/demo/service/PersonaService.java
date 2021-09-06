package com.example.demo.service;

import com.example.demo.Persona;
import com.example.demo.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService {
    @Autowired
    private PersonaRepository repository;

    public Persona savePersona(Persona persona){
       return repository.save(persona);
    }
    public List<Persona> savePersonas(List<Persona> persona){
        return repository.saveAll(persona);
    }

    public List<Persona> getPersonas(){
        return repository.findAll();
    }
    public Persona getPersonaById(int id ){
        return repository.findById(id).orElse(null);
    }
    public Persona getPersonByName (String name) {
        return repository.findByName(name);
    }

    public String deletePerson(int id){
         repository.deleteById(id);
         return "Person Removed";
    }
    public  Persona updatePerson(Persona persona){
        Persona existingPersona = repository.findById(persona.getId()).orElse(null);
        existingPersona.setName(persona.getName());
        return repository.save(existingPersona);
    }
}
