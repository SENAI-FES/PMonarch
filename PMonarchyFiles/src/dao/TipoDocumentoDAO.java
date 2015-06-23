/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import entity.TipoDocumento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author taynara_muren
 */
public class TipoDocumentoDAO extends MySQL{
    
      public boolean insert(TipoDocumento  tipodocumento) {
        Connection c = this.getConnection();

        try {

            PreparedStatement ps
                    = c.prepareStatement("INSERT INTO tipodocumento "
                            + "(idTipoDocumento,descricao)VALUES (?,?)");
            
            ps.setInt(1, tipodocumento.getIdTipodeDocumento());
            ps.setString(2, tipodocumento.getDescricao());
                            
          
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
    
    public TipoDocumento getDocumentopById(int id) {
        Connection c = this.getConnection();
        TipoDocumento tipodocumento = null;
        try {
            PreparedStatement ps = c.prepareStatement("SELECT idTipoDocumento, "
                    + " descricao FROM equipamento WHERE idTpodeDocumento = ?");
            
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                tipodocumento = new TipoDocumento();
                tipodocumento.setIdTipodeDocumento(rs.getInt("idTipoDocumento"));
                tipodocumento.setDescricao(rs.getString("descricao"));
                
            }
            rs.close();
            ps.close();
            return tipodocumento;
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
        public boolean delete(int id) {
        Connection c = this.getConnection();
        try {
            PreparedStatement ps
                    = c.prepareStatement("DELETE FROM tipodocumento "
                            + "WHERE idTipoDocumento = ?");
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

    public boolean update(TipoDocumento tipodocumento) {
        Connection c = this.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("UPDATE tipodocumento "
                    + "SET descricao = ? WHERE idTipoDocumento = ?");
            
            ps.setInt(1, tipodocumento.getIdTipodeDocumento());
            ps.setString(2, tipodocumento.getDescricao());
                      
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

    public List<TipoDocumento> listarTipoDocumento() {
        List<TipoDocumento> lista = new ArrayList<TipoDocumento>();
        Connection c = this.getConnection();
        try {
            PreparedStatement ps
                    = c.prepareStatement("SELECT idTipoDocumento, descricao "
                            + " FROM tipodocumento");
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                TipoDocumento tipodocumento = new TipoDocumento();
                tipodocumento.setIdTipodeDocumento(rs.getInt("idTipoDocumento"));
                tipodocumento.setDescricao(rs.getString("descricao"));
                

                lista.add(tipodocumento);
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
