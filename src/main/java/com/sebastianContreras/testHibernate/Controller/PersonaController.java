/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sebastianContreras.testHibernate.Controller;

import com.sebastianContreras.testHibernate.model.Persona;
import com.sebastianContreras.testHibernate.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sebastian
 */
@RestController
public class PersonaController {
    @Autowired
    private IPersonaService interPersona;
    
    @GetMapping("persona/traer")
    public List<Persona> getPersonas(){
        return interPersona.getPersonas();
    }
    
    @PostMapping("persona/crear")
    public String createPersona(@RequestBody Persona per){
        interPersona.savePersona(per);
        return "La persona se creo correctamente";
    }
    @DeleteMapping("persona/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
        interPersona.deletePersona(id);
        return "La persona de borro correctamente";
    }
    @PutMapping("persona/editar/{id}")
    public Persona editPersona(@PathVariable Long id,
                               @RequestParam String nombre,
                               @RequestParam String apellido,
                               @RequestParam int edad){
        Persona per = interPersona.findPersona(id);
        per.setNombre(nombre);
        per.setApellido(apellido);
        per.setEdad(edad);
        interPersona.savePersona(per);
        return per;
    }
}
