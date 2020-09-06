/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.DAO;

import com.unab.edu.Entidades.Estudiante;
import com.unab.edu.conexionmysql.ConexionBd;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class ClsJoinPersonaEstudiante {

    ConexionBd cn = new ConexionBd();
    Connection con = cn.retornarConexion();

    public ArrayList<Estudiante> MostrarJoinEstudiantePersona() {

        ArrayList<Estudiante> lista = new ArrayList<>();

        try {
            CallableStatement st = con.prepareCall("SELECT a.nombre, a.apellido, b.matricula from persona as a\n"
                    + "inner join estudiante as b on a.idPersona = b.idPersona;");

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Estudiante es = new Estudiante();
                es.setNombre(rs.getString("nombre"));
                es.setApellido(rs.getString("apellido"));
                es.setMatricula(rs.getInt("matricula"));

                lista.add(es);

            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "error" + e);
        }
        return lista;
    }

}
