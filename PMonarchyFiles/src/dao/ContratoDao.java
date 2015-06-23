package dao;

import entity.Contrato;
import entity.Empresa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @mauricio
 */
public class ContratoDao extends MySQL{
   public boolean insert(Contrato contrato) {
        Connection c = this.getConnection();

        try {
            PreparedStatement ps = c.prepareStatement("insert into contrato (tipoContrato,"
                    + " dataInicial, idEmpresa) values( ? , ? , ?)");
                    
            
            ps.setString(1, contrato.getTipoContrato());
            ps.setString(2, contrato.getDataInicial().toString());//é tipo Date
            ps.setInt(3, contrato.getEmpresa().getIdEmpresa());

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
 public boolean update(Contrato contrato) {
        Connection c = this.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("UPDATE contrato "
                    + "SET tipoContrato = ?, dataInicial = ?, idEmpresa = ? WHERE idContrato = ?");
            ps.setString(1, contrato.getTipoContrato());
            ps.setString(2, contrato.getDataInicial().toString());
            ps.setInt(3, contrato.getEmpresa().getIdEmpresa());
            ps.setInt(4, contrato.getIdContrato());
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

    public boolean delete(int idContrato) {
        Connection c = this.getConnection();
        try {
            PreparedStatement ps
                    = c.prepareStatement("DELETE FROM contrato "
                            + "WHERE idContrato = ?");
            ps.setInt(1, idContrato);

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
    public java.util.List<Contrato> listarContrato() {
        Connection c = this.getConnection();
        java.util.List<Contrato> listaContratos = new ArrayList<Contrato>();
        try {
            PreparedStatement ps = c.prepareStatement(" select idContrato, tipoContrato, dataInicial, "
                    + "idEmpresa from contrato");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Contrato contrato = new Contrato();

                contrato.setIdContrato(rs.getInt("idContrato"));
                contrato.setTipoContrato(rs.getString("tipoContrato"));
                contrato.setDataInicial(rs.getDate("dataInicial"));
                EmpresaDAO empresaDAO = new EmpresaDAO();
                Empresa empresa = empresaDAO.getEmpresaById(rs.getInt("idEmpresa"));
                contrato.setEmpresa(empresa);
                
                listaContratos.add(contrato);
            }
            rs.close();
            ps.close();
            return listaContratos;

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
}}
