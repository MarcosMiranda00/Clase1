/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.Entidades;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author PC
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class Profesor extends Persona {
    
    protected int idProfesor;
    protected String DUI;
    protected String Usuario;
    protected String Passwo;
    
}
