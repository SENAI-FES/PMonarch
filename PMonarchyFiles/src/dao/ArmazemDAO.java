/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


    
    package dao;

import entity.Caixa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Matheus_santos_fraga
 */
public class ArmazemDAO extends MySQL {

    public boolean insert(Caixa caixa) {
        Connection c = this.getConnection();
        try {
            PreparedStatement ps
                    = c.prepareStatement("INSERT INTO caixa "
                            + "( Rua, Estante, Coluna, Andar )  "
                            + "VALUES ( ?, ?, ?, ?)");
            ps.setString(1, caixa.getRua());
            ps.setString(2, caixa.getEstante());
            ps.setString(3, caixa.getColuna());
            ps.setString(4, caixa.getAndar());

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

    public boolean update(Caixa caixa) {
        Connection c = this.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("UPDATE caixa "
                    + " SET rua = ?, estante = ?, coluna = ?, andar = ? "
                    + " WHERE idCaixa = ?");
            ps.setString(1, caixa.getRua());
            ps.setString(2, caixa.getColuna());
            ps.setString(3, caixa.getEstante());
            ps.setString(4, caixa.getAndar());

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

    public boolean delete(int idCaixa) {
        Connection c = this.getConnection();
        try {
            PreparedStatement ps
                    = c.prepareStatement("DELETE FROM caixa "
                            + "WHERE idCaixa = ?");
            ps.setInt(1, idCaixa);

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

    public List<Caixa> listarCaixas() {
        List<Caixa> lista = new ArrayList<>();
        Connection c = this.getConnection();
        try {
            PreparedStatement ps
                    = c.prepareStatement("SELECT rua, estante, coluna, andar"
                            + "FROM caixa");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Caixa caixa = new Caixa();
                caixa.setRua(rs.getString("Rua"));
                caixa.setEstante(rs.getString("Estante"));
                caixa.setColuna(rs.getString("Coluna"));
                caixa.setAndar(rs.getString("Andar"));

                lista.add(caixa);
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

    public Caixa getCaixaById(int idCaixa) {
        Connection c = this.getConnection();
        Caixa caixa = null;
        try {
            PreparedStatement ps = c.prepareStatement("SELECT idCaixa, "
                    + "rua, estante, coluna, andar "
                    + "FROM caixa WHERE idCaixa = ?");
            ps.setInt(1, idCaixa);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                caixa = new Caixa();
                caixa.setIdCaixa(rs.getInt("idCaixa"));
                caixa.setRua(rs.getString("Rua"));
                caixa.setEstante(rs.getString("Estante"));
                caixa.setColuna(rs.getString("Coluna"));
                caixa.setAndar(rs.getString("Andar"));

            }
            rs.close();
            ps.close();
            return caixa;
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
