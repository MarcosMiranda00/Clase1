/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.DAO;

import com.unab.edu.Entidades.Profesor;
import com.unab.edu.conexionmysql.ConexionBd;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class ClsProfesor {

    ConexionBd conectarclase = new ConexionBd();
    Connection conectar = conectarclase.retornarConexion();

    public boolean LoguinProfesor(String usuario, String Pass) {
        ArrayList<Profesor> ListaUsuarios = new ArrayList<>();
        ArrayList<Profesor> ListarContra = new ArrayList<>();
        try {
            CallableStatement st = conectar.prepareCall("call SP_S_LOGUINPROFESOR(?,?)");

            st.setString("PUsuario", usuario);
            st.setString("PPasswo", Pass);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Profesor es = new Profesor();
                es.setUsuario(rs.getNString("Usuario"));
                es.setPasswo(rs.getNString("Passwo"));
                ListaUsuarios.add(es);
            }
            String usuariodebasedatos = null;
            String passdebasededatos = null;
            for (var iterador : ListaUsuarios) {
                usuariodebasedatos = iterador.getUsuario();
                passdebasededatos = iterador.getPasswo();

            }

            CallableStatement st2 = conectar.prepareCall("call SP_S_CRIPPROF(?)");
            st2.setString("PcripContra", Pass);
            ResultSet rs2 = st2.executeQuery();
            while (rs2.next()) {
                Profesor escrip = new Profesor();

                escrip.setPasswo(rs2.getNString("crip"));
                ListarContra.add(escrip);
            }

            String passcrip = null;
            for (var iterador : ListarContra) {

                passcrip = iterador.getPasswo();

                Pass = passcrip;

            }

            if (usuariodebasedatos != null && passdebasededatos != null) {
                if (usuariodebasedatos.equals(usuario) && passdebasededatos.equals(Pass)) {
                    return true;
                }
            }
            conectar.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e);
        }
        return false;
    }

}
