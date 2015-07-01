/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Contato;
import entity.Empresa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author elder_benites
 */
public class ContatoDao extends MySQL {

public boolean insert(Contato contato) {
        Connection c = this.getConnection();

        try {
            PreparedStatement ps = c.prepareStatement("insert into contato (nome,"
                    + " cargo, telefone, ramal, email, idEmpresa) values( ? , ? , ?, ?, ?, ?)");
            
            ps.setString(1, contato.getNome());
            ps.setString(2, contato.getCargo());
            ps.setString(3, contato.getTelefone());
            ps.setString(4, contato.getRamal());
            ps.setString(5, contato.getEmail());
            ps.setInt(6, contato.getEmpresa().getIdEmpresa());
            
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
 public boolean update(Contato contato) {
        Connection c = this.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("UPDATE contato "
                    + "SET nome = ?, cargo = ?, telefone = ?, ramal = ?, email = ?, "
                    + " idEmpresa = ? WHERE idContato = ?");
            ps.setString(1, contato.getNome());
            ps.setString(2, contato.getCargo());
            ps.setString(3, contato.getTelefone());
            ps.setString(4, contato.getRamal());
            ps.setString(5, contato.getEmail());
            ps.setInt(6, contato.getEmpresa().getIdEmpresa());
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

    public boolean delete(int idContato) {
        Connection c = this.getConnection();
        try {
            PreparedStatement ps
                    = c.prepareStatement("DELETE FROM contato "
                            + "WHERE idContato = ?");
            ps.setInt(1, idContato);

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
    public List<Contato> listarContato() {
        Connection c = this.getConnection();
        List<Contato> listaContatos = new ArrayList<Contato>();
        try {
            PreparedStatement ps = c.prepareStatement(" select idContato,"
                    + " nome, cargo, telefone, ramal, email, idEmpresa"
                    + " from contato");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Contato contato = new Contato();
                contato.setIdContato(rs.getInt("idContato"));
                contato.setNome(rs.getString("nome"));
                contato.setCargo(rs.getString("cargo"));
                contato.setTelefone(rs.getString("telefone"));
                contato.setRamal(rs.getString("ramal"));
                contato.setEmail(rs.getString("email"));
                EmpresaDAO empresaDAO = new EmpresaDAO();
                Empresa empresa = empresaDAO.getEmpresaById(rs.getInt("idEmpresa"));
                contato.setEmpresa(empresa);
                
                listaContatos.add(contato);
            }
            rs.close();
            ps.close();
            return listaContatos;

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
    
    public List<Contato> getContratoById(int id) {
        Connection c = this.getConnection();
        List<Contato> listaContatos = new ArrayList<Contato>();
        try {
            PreparedStatement ps = c.prepareStatement("SELECT idContato,"
                    + " nome, cargo, telefone, ramal, email"
                    + " FROM contato WHERE idEmpresa = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Contato contato = new Contato();
                contato.setIdContato(rs.getInt("idContato"));
                contato.setNome(rs.getString("nome"));
                contato.setCargo(rs.getString("cargo"));
                contato.setTelefone(rs.getString("telefone"));
                contato.setRamal(rs.getString("ramal"));
                contato.setEmail(rs.getString("email"));
                listaContatos.add(contato);
            }
            
            rs.close();
            ps.close();
            return listaContatos;
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

}
