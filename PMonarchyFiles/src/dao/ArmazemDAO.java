/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Armazem;
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

    public boolean insert(Armazem armazem) {
        Connection c = this.getConnection();
        try {
            PreparedStatement ps
                    = c.prepareStatement("INSERT INTO armazem "
                            + "( Rua, Estante, Coluna, Andar )  "
                            + "VALUES ( ?, ?, ?, ?)");
            ps.setString(1, armazem.getRua());
            ps.setString(2, armazem.getEstante());
            ps.setString(3, armazem.getColuna());
            ps.setString(4, armazem.getAndar());

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

    public boolean update(Armazem armazem) {
        Connection c = this.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("UPDATE armazem "
                    + " SET rua = ?, estante = ?, coluna = ?, andar = ? "
                    + " WHERE idArmazem = ?");
            ps.setString(1, armazem.getRua());
            ps.setString(2, armazem.getColuna());
            ps.setString(3, armazem.getEstante());
            ps.setString(4, armazem.getAndar());

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

    public boolean delete(int idArmazem) {
        Connection c = this.getConnection();
        try {
            PreparedStatement ps
                    = c.prepareStatement("DELETE FROM armazem "
                            + "WHERE idArmazem = ?");
            ps.setInt(1, idArmazem);

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

    public List<Armazem> listarArmazem() {
        List<Armazem> lista = new ArrayList<>();
        Connection c = this.getConnection();
        try {
            PreparedStatement ps
                    = c.prepareStatement("SELECT rua, estante, coluna, andar"
                            + "FROM armazem");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Armazem armazem = new Armazem();
                armazem.setRua(rs.getString("Rua"));
                armazem.setEstante(rs.getString("Estante"));
                armazem.setColuna(rs.getString("Coluna"));
                armazem.setAndar(rs.getString("Andar"));

                lista.add(armazem);
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

    public Armazem getArmazemById(int idArmazem) {
        Connection c = this.getConnection();
        Armazem armazem = null;
        try {
            PreparedStatement ps = c.prepareStatement("SELECT idArmazem, "
                    + "rua, estante, coluna, andar "
                    + "FROM armazem WHERE idArmazem = ?");
            ps.setInt(1, idArmazem);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                armazem = new Armazem();
                armazem.setIdArmazem(rs.getInt("idArmazem"));
                armazem.setRua(rs.getString("Rua"));
                armazem.setEstante(rs.getString("Estante"));
                armazem.setColuna(rs.getString("Coluna"));
                armazem.setAndar(rs.getString("Andar"));

            }
            rs.close();
            ps.close();
            return armazem;
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
