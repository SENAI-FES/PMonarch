/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Empresa;
import entity.Protocolo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ricardo_jose_santana
 */
public class ProtocoloDAO extends MySQL {

    public boolean insert(Protocolo protocolo) {

        java.sql.Date dt = new java.sql.Date(protocolo.getDataHora().getTime());
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
            ps.setInt(8, protocolo.getTipoDocumento().getIdTipodeDocumento());
            ps.setInt(9, protocolo.getTipoProtocolo());
            ps.setInt(10, protocolo.getNumeroProtocolo());
            ps.setDate(11, (java.sql.Date) protocolo.getDataHora());

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
        java.sql.Date dt = new java.sql.Date(objProtocolo.getDataHora().getTime());
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
                ps.setDate(11, dt);

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

    public List<Protocolo> listarProtocolos(long protocolo, Date inicio, Date fim, Empresa empresa) {
        String sql = "";
        if (protocolo != 0) {
            sql += " WHERE numeroProtocolo = ?";
        } else if (empresa != null) {
            sql += " WHERE idEmpresa = ?";
        } else if (inicio != null) {
            sql += " WHERE dataHora BETWEEN ? AND ?";
        }
        List<Protocolo> listaProtocolos = new ArrayList<Protocolo>();
        Connection c = this.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("SELECT idProtocolo, idEmpresa, "
                    + "idResponsavelCadastro, idResponsavelSeparacao, "
                    + "idResponsavelEstocagem, idTipoDocumento, numeroProtocolo, cpf, responsavelEntrega, tipoProtocolo, dataHora"
                    + " FROM protocolo " + sql);
            if (protocolo != 0) {
                ps.setLong(1, protocolo);
            } else if (empresa != null) {
                ps.setInt(1, empresa.getIdEmpresa());
            } else if (inicio != null) {
                fim = fim == null ? new Date() : fim;
                ps.setDate(1, new java.sql.Date(inicio.getTime()));
                ps.setDate(2, new java.sql.Date(fim.getTime()));
            }
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                EmpresaDAO daoEmpresa = new EmpresaDAO();
                Protocolo objProtocolo = new Protocolo();

                //objProtocolo.setQuantidadeDocumentos(rs.getInt("quantidadeDocumentos"));
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
