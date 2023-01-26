/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sebastianContreras.testHibernate.service;

import com.sebastianContreras.testHibernate.model.Persona;
import java.util.List;

/**
 *
 * @author sebastian
 */
public interface IPersonaService {
    public List<Persona> getPersonas();
    public void savePersona(Persona per);
    public void deletePersona(Long id);
    public Persona findPersona(long id);
}
