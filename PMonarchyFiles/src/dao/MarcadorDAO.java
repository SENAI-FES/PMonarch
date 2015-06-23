/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import entity.Marcador;
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
public class MarcadorDAO extends MySQL{
   
    
     public boolean insert(Marcador marcador) {
        Connection c = this.getConnection();
        try {
            PreparedStatement ps
                    = c.prepareStatement("INSERT INTO Marcador "
                            + "( descricao )  "
                            + "VALUES ( ? )"); 
            ps.setString(1, marcador.getDescricao());
                                 
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
     public boolean update(Marcador marcador) {
        Connection c = this.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("UPDATE Marcador "
                            + "SET descricao = ? "
                   + " WHERE idmarcador = ?");
            ps.setString(1, marcador.getDescricao());
            ps.setInt(2, marcador.getIdMarcador());
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
    
          public boolean delete(int id) {
        Connection c = this.getConnection();
        try {
            PreparedStatement ps
                    = c.prepareStatement("DELETE FROM Marcador "
                            + "WHERE idmarcador = ?");
            ps.setInt(1, id);

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
    
      public Marcador getMarcadorById(int id) {
        Connection c = this.getConnection();
        Marcador marcador = null;
        try {
            PreparedStatement ps = c.prepareStatement("SELECT idMarcador, "
                    + "idMarcador, descricao "
                    + "FROM marcador WHERE idMarcador = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                marcador = new Marcador();
                marcador.setIdMarcador(rs.getInt("idMarcador"));
                marcador.setDescricao(rs.getString("descricao"));
               
      
            }
            rs.close();
            ps.close();
            return marcador;
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
    
      
      public List<Marcador> listarMarcador() {
        List<Marcador> lista = new ArrayList<Marcador>();
        Connection I = this.getConnection();
        try {
            PreparedStatement ps
                    = I.prepareStatement("SELECT idMarcador, descricao "
                            
                            + "FROM marcador");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Marcador objMarcador = new Marcador();
                objMarcador.setIdMarcador(rs.getInt("idMarcador"));
                objMarcador.setDescricao(rs.getString("descricao"));
                                               
                lista.add(objMarcador);
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                I.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return lista;
    }
      
      
    
    
    
}
