package com.example.demo.controller;

import com.example.demo.Persona;
import com.example.demo.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/crud")
public class PersonaController {
    @Autowired
    private PersonaService service;
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/addperson")
    public Persona addPersona(@RequestBody Persona persona){
        return service.savePersona(persona);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/addPersons")
    public List<Persona> addPersonas(@RequestBody List<Persona> personas){
        return service.savePersonas(personas);
    }
    @GetMapping("/personas")
    public List<Persona> findAllPerson(){
        return service.getPersonas();
    }
    @GetMapping("/personas/{name}")
    public Persona findPersonByName(@PathVariable String name){
        return service.getPersonByName(name);
    }
    @GetMapping("/personas/{id}")
    public Persona findPersonById(@PathVariable int id){
        return service.getPersonaById(id);
    }
    @PutMapping("/update")
    public Persona uodatePersona(@RequestBody Persona persona){
        return service.updatePerson(persona);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id){
        return service.deletePerson(id);
    }
}
