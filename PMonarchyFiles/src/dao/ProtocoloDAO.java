/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import entity.Protocolo;
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
public class ProtocoloDAO  extends MySQL{
    public boolean insert (Protocolo protocolo) {
        Connection c = this.getConnection();
        try {
            PreparedStatement ps
                    = c.prepareStatement("INSERT INTO protocolo "
                            + "(quantidadeDocumentos, cpf, responsavelEntrega, empresa, "
                            + "responsavelCadastro, responsavelSeparacao, responsavelEstocagem, "
                            + "tipoDocumento, tipoProtocolo, numeroProtocolo, dataHora)  "
                            + "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )");
            ps.setInt(1, protocolo.getQuantidadeDocumentos());
            ps.setString(2, protocolo.getCpf());
            ps.setString(3, protocolo.getResponsavelEntrega());
            ps.setInt(4, protocolo.getEmpresa().getIdEmpresa());
            ps.setInt(5, protocolo.getResponsavelCadastro().getMatricula());
            ps.setInt(6, protocolo.getResponsavelSeparacao().getMatricula());
            ps.setInt(7, protocolo.getResponsavelEstocagem().getMatricula());
            ps.setInt (8, protocolo.getTipoDocumento().getIdTipodeDocumento());
            ps.setInt (9, protocolo.getTipoProtocolo());
            ps.setInt (10, protocolo.getNumeroProtocolo());
            //ps.setDate(11, protocolo.getDataHora());

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

    public Protocolo getProtocoloById(int numeroProtocolo) {
        Protocolo objProtocolo = new Protocolo();
        Connection c = this.getConnection();
        try {
            PreparedStatement ps
                    = c.prepareStatement("SELECT quantidadeDocumentos, cpf, responsavelEntrega, "
                            + "empresa, responsavelCadastro, responsavelSeparacao, responsavelEstocagem, "
                            + "tipoDocumento, tipoProtocolo, dataHora "
                            + " FROM protocolo"
                            + " WHERE numeroProtocolo = ?");
            ps.setInt(1, numeroProtocolo);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                objProtocolo.setQuantidadeDocumentos(rs.getInt("quantidadeDocumentos"));
                objProtocolo.setCpf(rs.getString("cpf"));
                objProtocolo.setResponsavelEntrega(rs.getString("responsavelEntrega"));
                //objProtocolo.setEmpresa(rs.getInt("empresa"));
                //objProtocolo.setResponsavelCadastro(rs.getUsuario("responsavelCadastro"));
                //objProtocolo.setResponsavelSeparacao(rs.getUsuario("responsavelSeparacao"));
                //objProtocolo.setResponsavelEstocagem(rs.getString("responsavelEstocagem"));
                //objProtocolo.setTipoDocumento(rs.getInt("tipoDocumento"));
                //objProtocolo.setDataHora(rs.get);

            }
            rs.close();
            ps.close();
            return objProtocolo;

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

    public List<Protocolo> listarProtocolos() {
        List<Protocolo> listaProtocolos = new ArrayList<Protocolo>();
        Connection c = this.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("SELECT quantidadeDocumentos, cpf, "
                    + "responsavelEntrega, empresa, responsavelCadastro, responsavelSeparacao, "
                    + "responsavelEstocagem, tipoDocumento, tipoProtocolo, numeroProtocolo, dataHora"
                    + " FROM protocolo");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                EmpresaDAO daoEmpresa = new EmpresaDAO();
                Protocolo objProtocolo = new Protocolo();
                
                objProtocolo.setQuantidadeDocumentos(rs.getInt("quantidadeDocumentos"));
                objProtocolo.setCpf(rs.getString("cpf"));
                objProtocolo.setResponsavelEntrega(rs.getString("responsavelEntrega"));
                objProtocolo.setEmpresa(daoEmpresa.getEmpresaById(rs.getInt("idEmpresa")));
                //objProtocolo.setResponsavelCadastro(rs.getString("responsavelCadastro"));
                //objProtocolo.setStatus(rs.getString("status"));

                listaProtocolos.add(objProtocolo);

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
        return listaProtocolos;
    }
}
    

