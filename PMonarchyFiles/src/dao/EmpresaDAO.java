/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import entity.Contato;
import entity.Contrato;
import entity.Empresa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author matheus_santos_fraga
 */
public class EmpresaDAO extends MySQL {
    
        public boolean insert(Empresa empresa) {
        Connection c = this.getConnection();
        try {
            PreparedStatement ps
                    = c.prepareStatement("INSERT INTO empresa "
                            + "(nomeFantasia, razaoSocial, CNPJ, IE, site, logradouro, complemento "
                            + "cidade, CEP, UF )  "
                            + "VALUES (?,?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, empresa.getNomeFantasia());
            ps.setString(2, empresa.getRazaoSocial());
            ps.setString(3, empresa.getCnpj());
            ps.setString(4, empresa.getInscricaoEstadual());
            ps.setString(5, empresa.getSite());
            ps.setString(6, empresa.getLogradouro());
            ps.setString(7, empresa.getComplemento());
            ps.setString(8, empresa.getCidade());
            ps.setString(9, empresa.getCep());
            ps.setString(10, empresa.getUf()+"");
            ps.execute();
            
            ps.executeUpdate();  
            ResultSet rs = ps.getGeneratedKeys();  
            int id = 0;  
            if(rs.next()){  
                id = rs.getInt(1);  
            }
            empresa.setIdEmpresa(id);
            ContatoDao contatoDao = new ContatoDao();
            for (Contato contato : empresa.getContatos()) {
                contato.setEmpresa(empresa);
                contatoDao.insert(contato);
            }
            ContratoDao contratoDao = new ContratoDao();
            Contrato contrato = empresa.getContrato();
            contrato.setEmpresa(empresa);
            contratoDao.insert(contrato);
            
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

    public boolean update(Empresa empresa) {
        Connection c = this.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("UPDATE empresa "
                    + "SET nomeFantasia = ?, razaoSocial = ?, CNPJ = ?, IE = ?, site = ?,"
                    + " logradouro = ?, complemento = ?, cidade = ?, CEP = ?, UF = ? "
                    + " WHERE idEmpresa = ?");
            ps.setString(1, empresa.getNomeFantasia());
            ps.setString(2, empresa.getRazaoSocial());
            ps.setString(3, empresa.getCnpj());
            ps.setString(4, empresa.getInscricaoEstadual());
            ps.setString(5, empresa.getSite());
            ps.setString(6, empresa.getLogradouro());
            ps.setString(7, empresa.getComplemento());
            ps.setString(8, empresa.getCidade());
            ps.setString(9, empresa.getCep());
            ps.setString(10, empresa.getUf()+"");
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
                    = c.prepareStatement("DELETE FROM empresa "
                            + "WHERE idEmpresa = ?");
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

    public List<Empresa> listarEmpresas() {
        List<Empresa> lista = new ArrayList<Empresa>();
        Connection c = this.getConnection();
        try {
            PreparedStatement ps
                    = c.prepareStatement("SELECT idEmpresa, nomeFantasia, "
                            + "razaoSocial, IE, CEP, cidade, CNPJ, complemento, "
                            + "logradouro, site, UF "
                            + "FROM empresa");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Empresa empresa = new Empresa();
                empresa.setIdEmpresa(rs.getInt("idEmpresa"));
                empresa.setNomeFantasia(rs.getString("nomeFantasia"));
                empresa.setRazaoSocial(rs.getString("razaoSocial"));
                empresa.setInscricaoEstadual(rs.getString("IE"));
                empresa.setCep(rs.getString("CEP"));
                empresa.setCidade(rs.getString("cidade"));
                empresa.setCnpj(rs.getString("CNPJ"));
                empresa.setComplemento(rs.getString("complemento"));
                empresa.setLogradouro(rs.getString("logradouro"));
                empresa.setSite(rs.getString("site"));
                empresa.setUf(rs.getString("UF"));
                lista.add(empresa);
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

    public Empresa getEmpresaById(int id) {
        Connection c = this.getConnection();
        Empresa empresa = null;
        try {
            PreparedStatement ps = c.prepareStatement("SELECT idEmpresa, nomeFantasia, "
                    + "razaoSocial, IE, CEP, cidade, CNPJ, complemento, "
                    + "logradouro, site, UF "
                    + "FROM empresa WHERE idEmpresa = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                empresa = new Empresa();
                empresa.setIdEmpresa(rs.getInt("idEmpresa"));
                empresa.setNomeFantasia(rs.getString("nomeFantasia"));
                empresa.setRazaoSocial(rs.getString("razaoSocial"));
                empresa.setInscricaoEstadual(rs.getString("IE"));
                empresa.setCep(rs.getString("CEP"));
                empresa.setCidade(rs.getString("cidade"));
                empresa.setCnpj(rs.getString("CNPJ"));
                empresa.setComplemento(rs.getString("complemento"));
                empresa.setLogradouro(rs.getString("logradouro"));
                empresa.setSite(rs.getString("site"));
                empresa.setUf(rs.getString("UF"));
            }
            rs.close();
            ps.close();
            return empresa;
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
