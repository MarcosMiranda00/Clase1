/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.DAO;

import com.unab.edu.Entidades.Estudiante;
import com.unab.edu.conexionmysql.ConexionBd;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class ClsEstudiante {

    ConexionBd conectarclase = new ConexionBd();
    Connection conectar = conectarclase.retornarConexion();

    public boolean LoguinEstudiante(String usuario, String pass) {
        ArrayList<Estudiante> ListaUsuariosPass = new ArrayList<>();

        try {
            CallableStatement Statement = conectar.prepareCall("call SP_S_LOGUINESTUDIANTE(?,?)");
            Statement.setString("pusuario", usuario);
            Statement.setString("ppass", pass);
            ResultSet resultadoDeConsulta = Statement.executeQuery();
            while (resultadoDeConsulta.next()) {
                Estudiante es = new Estudiante();
                es.setUsu(resultadoDeConsulta.getString("USU"));
                es.setPass(resultadoDeConsulta.getString("PASS"));
                ListaUsuariosPass.add(es);

            }
            String usuariodebasededatos = null;
            String passdebasededatos = null;
            for (var iterador : ListaUsuariosPass) {
                usuariodebasededatos = iterador.getUsu();
                passdebasededatos = iterador.getPass();
            }
            if (usuariodebasededatos.equals(usuario) && passdebasededatos.equals(pass)) {
                return true;
            }
            conectar.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return false;
    }

    public ArrayList<Estudiante> MostrarEstudiante() {
        ArrayList<Estudiante> Estudiante = new ArrayList<>();
        try {
            CallableStatement Statement = conectar.prepareCall("call SP_S_ESTUDIANTE()");
            ResultSet resultadoDeConsulta = Statement.executeQuery();

            while (resultadoDeConsulta.next()) {
                Estudiante est = new Estudiante();
                est.setID(resultadoDeConsulta.getInt("idestudiante"));
                est.setMatricula(resultadoDeConsulta.getInt("matricula"));
                est.setIdPersona(resultadoDeConsulta.getInt("idPersona"));
                est.setNombre(resultadoDeConsulta.getNString("Nombre"));
                est.setUsu(resultadoDeConsulta.getNString("USU"));
                est.setPass(resultadoDeConsulta.getNString("PASS"));
                est.setNIE(resultadoDeConsulta.getInt("NIE"));

                Estudiante.add(est);
            }
            conectar.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return Estudiante;
    }

    public void AgregarEst(Estudiante Est) {
        try {
            CallableStatement Statement = conectar.prepareCall(" call SP_I_ESTUDIANTES(?,?,?,?,?)");
            Statement.setInt("pmatricula", Est.getMatricula());
            Statement.setInt("pidPersona", Est.getIdPersona());
            Statement.setString("PUsu", Est.getUsu());
            Statement.setString("pPass", Est.getPass());
            Statement.setInt("pNIE", Est.getNIE());
            Statement.executeQuery();
            JOptionPane.showMessageDialog(null, "ESTUDIANTE GUARDADO");
            conectar.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void BorrarEstudiante(Estudiante Est) {
        try {
            CallableStatement Statement = conectar.prepareCall("call SP_D_ESTUDIANTES(?)");
            Statement.setInt("pidestudiante", Est.getID());
            Statement.execute();
            JOptionPane.showMessageDialog(null, "ESTUDIANTE ELIMINADO");
            conectar.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void ActualizarEstudiante(Estudiante Est) {
        try {
            CallableStatement Statement = conectar.prepareCall(" call SP_U_ESTUDIANTES(?,?,?,?,?,?)");
            Statement.setInt("pidestudiante", Est.getID());
            Statement.setInt("pmatricula", Est.getMatricula());
            Statement.setInt("pidPersona", Est.getIdPersona());
            Statement.setString("PUsu", Est.getUsu());
            Statement.setString("pPass", Est.getPass());
            Statement.setInt("pNIE", Est.getNIE());
            Statement.execute();
            JOptionPane.showMessageDialog(null, "ESTUDIANTE ACTUALIZADO");
            conectar.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

}
