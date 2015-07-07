/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Documento;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author taynara_muren
 */
public class DocumentoDAO extends MySQL {

    public boolean insert(Documento documento) {
        Connection c = this.getConnection();
        try {
            PreparedStatement ps
                    = c.prepareStatement("INSERT INTO Documento "
                            + "(  idProtocologo , idTipoDocumento"
                            + " data, qtdeFolha, formatoPapel,descricao  )  "
                            + "VALUES ( ?, ?, ?, ?, ?, ?, )");

            ps.setInt(1, documento.getProtocolo());
            ps.setInt(2, documento.getTipo().getIdTipodeDocumento());
            ps.setDate(3, (Date) documento.getDataCadatroDoc());
            ps.setInt(4, documento.getQuantidadeDeFolhas());
            ps.setInt(5, documento.getFormatoDoPapel());
            ps.setString(6, documento.getDescricao());

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

    public boolean update(Documento documento) {
        Connection c = this.getConnection();
        
        try {
            PreparedStatement ps = c.prepareStatement("UPDATE Documento "
                    + " idProtocologo = ? , idTipoDocumento = ?"
                    + "  data = ? , qtdeFolha = ? , formatoPapel = ? ,descricao + ?  "
                    + " WHERE idDocumento = ?");
            ps.setInt(1, documento.getProtocolo());
            ps.setInt(2, documento.getTipo().getIdTipodeDocumento());
            ps.setDate(3, (Date) documento.getDataCadatroDoc());
            ps.setInt(4, documento.getQuantidadeDeFolhas());
            ps.setInt(5, documento.getFormatoDoPapel());
            ps.setString(6, documento.getDescricao());

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
                    = c.prepareStatement("DELETE FROM Documento "
                            + "WHERE idDocumento = ?");
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

    public Documento getMarcadorById(int id) {
        Connection c = this.getConnection();
        Documento documento = null;
        try {
            PreparedStatement ps = c.prepareStatement("SELECT idDocumento, "
                    + "idProtocologo , idTipoDocumento"
                    + " data, qtdeFolha, formatoPapel,descricao  "
                    + "FROM documento WHERE idDocumento = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
              TipoDocumentoDAO dao = new TipoDocumentoDAO();
            while (rs.next()) {

                documento = new Documento();
                documento.setIdDocumento(rs.getInt("idDocumento"));
                documento.setProtocolo(rs.getInt("idProtocologo"));
                documento.setTipo(dao.getDocumentopById(rs.getInt("idTipoDocumento")));
                documento.setDataCadatroDoc(rs.getDate("data"));
                documento.setQuantidadeDeFolhas(rs.getInt("qtdeFolha"));
                documento.setFormatoDoPapel(rs.getInt("formatoPapel"));
                documento.setDescricao(rs.getString("descricao"));

            }
            rs.close();
            ps.close();
            return documento;
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

    public List<Documento> listarDocumento() {
        List<Documento> lista = new ArrayList<Documento>();
        Connection I = this.getConnection();
        try {
            PreparedStatement ps
                    = I.prepareStatement("SELECT idDocumento,idProtocologo , idTipoDocumento"
                            + " data, qtdeFolha, formatoPapel,descricao   "
                            + "FROM Documento");
            ResultSet rs = ps.executeQuery();
            TipoDocumentoDAO dao = new TipoDocumentoDAO();
            while (rs.next()) {

                Documento objDocumento = new Documento();
                objDocumento.setIdDocumento(rs.getInt("idDocumento"));
                objDocumento.setProtocolo(rs.getInt("idprotocologo"));
                objDocumento.setTipo(dao.getDocumentopById(rs.getInt("idTipoDocumento")));
                objDocumento.setDataCadatroDoc(rs.getDate("data"));
                objDocumento.setQuantidadeDeFolhas(rs.getInt("qtdeFolha"));
                objDocumento.setFormatoDoPapel(rs.getInt("formatopapel"));
                objDocumento.setDescricao(rs.getString("descricao"));

                lista.add(objDocumento);
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
