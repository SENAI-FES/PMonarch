/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.util.Date;

/**
 *
 * @author ricardo_jose_santana
 */
public class Documento {
   private int idDocumento;
    private int Protocolo;
    private TipoDocumento tipo;
    private Date dataCadatroDoc;
    private int quantidadeDeFolhas;
    private int formatoDoPapel;
    private boolean Sigilo;
    private String Descricao;

    public int getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(int idDocumento) {
        this.idDocumento = idDocumento;
    }

    public int getProtocolo() {
        return Protocolo;
    }

    public void setProtocolo(int Protocolo) {
        this.Protocolo = Protocolo;
    }

    public TipoDocumento getTipo() {
        return tipo;
    }

    public void setTipo(TipoDocumento tipo) {
        this.tipo = tipo;
    }

    public Date getDataCadatroDoc() {
        return dataCadatroDoc;
    }

    public void setDataCadatroDoc(Date dataCadatroDoc) {
        this.dataCadatroDoc = dataCadatroDoc;
    }

    public int getQuantidadeDeFolhas() {
        return quantidadeDeFolhas;
    }

    public void setQuantidadeDeFolhas(int quantidadeDeFolhas) {
        this.quantidadeDeFolhas = quantidadeDeFolhas;
    }

    public int getFormatoDoPapel() {
        return formatoDoPapel;
    }

    public void setFormatoDoPapel(int formatoDoPapel) {
        this.formatoDoPapel = formatoDoPapel;
    }

    public boolean isSigilo() {
        return Sigilo;
    }

    public void setSigilo(boolean Sigilo) {
        this.Sigilo = Sigilo;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }
    
}
