/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

/**
 *
 * @author elder_benites
 */
public class TipoDocumento {
    private int idTipodeDocumento;
    private String descricao;

    public int getIdTipodeDocumento() {
        return idTipodeDocumento;
    }

    public void setIdTipodeDocumento(int idTipodeDocumento) {
        this.idTipodeDocumento = idTipodeDocumento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return descricao; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
