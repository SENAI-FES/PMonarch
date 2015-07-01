/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.EnumPerfil;
import entity.Usuario;
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
                            + "(matricula, nome, cpf, perfil, email, status, senha )  "
                            + "VALUES ( ?, ?, ?, ?, ?, ?, ? )");
            ps.setInt(1, usuario.getMatricula());
            ps.setString(2, usuario.getNome());
            ps.setString(3, usuario.getCPF());
            ps.setInt(4, usuario.getPerfil().getId());
            ps.setString(5, usuario.getEmail());
            ps.setString(6, usuario.getStatus());
            ps.setString(7, usuario.getSenha());

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

    public void update(Usuario objUsuario) {

        Connection c = this.getConnection();

        try {

            PreparedStatement ps = c.prepareStatement("UPDATE usuario "
                    + "Set nome = ?, cpf = ?, perfil = ?, email= ? "
                    + "WHERE matricula = ? ");

            ps.setString(1, objUsuario.getNome());
            ps.setString(2, objUsuario.getCPF());
            ps.setInt(3, objUsuario.getPerfil().getId());
            ps.setString(4, objUsuario.getEmail());
            ps.setInt(5, objUsuario.getMatricula());

            ps.execute();
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
    }

    public void atualizaStatus(Usuario usuario) {
        Connection c = this.getConnection();

        try {

            PreparedStatement ps = c.prepareStatement("UPDATE usuario "
                    + "Set status = ? "
                    + "WHERE matricula = ? ");

            ps.setString(1, usuario.getStatus());
            ps.setInt(2, usuario.getMatricula());
            ps.execute();
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
    }

    public Usuario getUsuarioById(int matricula) {
        Usuario objUsuario = new Usuario();
        Connection c = this.getConnection();
        try {
            PreparedStatement ps
                    = c.prepareStatement("SELECT matricula, nome, cpf , perfil, email, status "
                            + " FROM usuario"
                            + " WHERE matricula = ?");
            ps.setInt(1, matricula);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                objUsuario.setMatricula(rs.getInt("matricula"));
                objUsuario.setNome(rs.getString("nome"));
                objUsuario.setCPF(rs.getString("cpf"));
                objUsuario.setPerfil(EnumPerfil.ADMINISTRADOR.getPerfil(rs.getInt("perfil")));
                objUsuario.setEmail(rs.getString("email"));
                objUsuario.setStatus(rs.getString("status"));

            }
            rs.close();
            ps.close();
            return objUsuario;

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                c.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }
    
    public Usuario getLogin(String email, String senha) {
        Usuario objUsuario = null;
        Connection c = this.getConnection();
        try {
            PreparedStatement ps
                    = c.prepareStatement("SELECT matricula, nome, cpf , perfil, email, status "
                            + " FROM usuario"
                            + " WHERE email = ? AND senha = ?");
            ps.setString(1, email);
            ps.setString(2, senha);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                objUsuario = new Usuario();
                objUsuario.setMatricula(rs.getInt("matricula"));
                objUsuario.setNome(rs.getString("nome"));
                objUsuario.setCPF(rs.getString("cpf"));
                objUsuario.setPerfil(rs.getInt("perfil"));
                objUsuario.setEmail(rs.getString("email"));
                objUsuario.setStatus(rs.getString("status"));

            }
            rs.close();
            ps.close();
            return objUsuario;

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                c.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    public List<Usuario> listarUsuarios() {
        List<Usuario> listaUsuarios = new ArrayList<Usuario>();
        Connection c = this.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("SELECT matricula, nome, cpf , perfil, email, status "
                    + " FROM usuario");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Usuario objUsuario = new Usuario();

                objUsuario.setMatricula(rs.getInt("matricula"));
                objUsuario.setNome(rs.getString("nome"));
                objUsuario.setCPF(rs.getString("cpf"));
                objUsuario.setPerfil(EnumPerfil.USUARIO.getPerfil(rs.getInt("perfil")));
                objUsuario.setEmail(rs.getString("email"));
                objUsuario.setStatus(rs.getString("status"));

                listaUsuarios.add(objUsuario);

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
        return listaUsuarios;
    }
}
