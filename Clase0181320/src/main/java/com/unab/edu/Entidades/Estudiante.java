/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.Entidades;

import lombok.*;


/**
 *
 * @author PC
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class Estudiante extends Persona{
    
private int ID;
private int matricula;
private String Usu;
private String pass;
private int NIE;
}
