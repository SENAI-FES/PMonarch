/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ricardo_jose_santana
 */
public class UsuarioDAO extends MySQL {

    public boolean insert(Usuario usuario) {
        Connection c = this.getConnection();
        try {
            PreparedStatement ps
                    = c.prepareStatement("INSERT INTO usuario "
                            + "(matricula, nome, cpf, perfil, email )  "
                            + "VALUES ( ?, ?, ?, ?, ? )");
            ps.setInt(1, usuario.getMatricula());
            ps.setString(2, usuario.getNome());
            ps.setString(3, usuario.getCpf());
            ps.setInt(4, usuario.getPerfil());
            ps.setString(5, usuario.getEmail());

            ps.execute();
            ps.close();
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                c.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }

    public boolean delete(int matricula) {
        Connection c = this.getConnection();
        try {
            PreparedStatement ps
                    = c.prepareStatement("DELETE FROM usurio "
                            + "WHERE matricula = ?");
            ps.setInt(1, matricula);

            ps.execute();

            ps.close();
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                c.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }

    public boolean update(int matricula) {
        Connection c = this.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("UPDATE usuario "
                    + " SET matricula = ?, nome = ?, cpf = ?, perfil = ?, email= ?"
                    + " WHERE matricula = ?");
            ps.setInt(1, usuario.getMatricula());
            ps.setString(2, usuario.getNome());
            ps.setString(3, usuario.getCpf());
            ps.setInt(4, usuario.getPerfil());
            ps.setString(5, usuario.getEmail());

            ps.execute();

            ps.close();
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                c.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }

    public List<Usuarios> listarUsuarios(int matricula) {
        List<Usuario> lista = new ArrayList<>();
        Connection c = this.getConnection();
        try {
            PreparedStatement ps
                    = c.prepareStatement("SELECT matricula, nome, cpf , perfil, email "
                            + " FROM usuario"
                            + " WHERE matricula = ?");
            ps.setDate(1, data);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Usuario objUsuario = new Usuario();
                
                objUsuario.setMatricula(rs.getInt("matricula"));
                objUsuario.setNome(rs.getString("nome"));
                objUsuario.setcpf(rs.getTime("cpf"));
                objUsuario.setPerfil(rs.getString("perfil"));
                objUsuario.setEmail(rs.getString("email"));

                
                lista.add(objUsuario);

            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                c.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return lista;
    }
}
