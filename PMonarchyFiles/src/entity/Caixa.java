package entity;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author gabriel_pereira
 */
public class Caixa {

    private int idCaixa;
    private String colunaInicio;
    private String colunaFim;
    private String coluna;
    private String rua;
    private String andar;
    private String estante;

    public int getIdCaixa() {
        return idCaixa;
    }

    public void setIdCaixa(int idCaixa) {
        this.idCaixa = idCaixa;
    }

    public String getColunaInicio() {
        return colunaInicio;
    }

    public void setColunaInicio(String colunaInicio) {
        this.colunaInicio = colunaInicio;
    }

    public String getColunaFim() {
        return colunaFim;
    }

    public void setColunaFim(String colunaFim) {
        this.colunaFim = colunaFim;
    }

    public String getColuna() {
        return coluna;
    }

    public void setColuna(String coluna) {
        this.coluna = coluna;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getAndar() {
        return andar;
    }

    public void setAndar(String andar) {
        this.andar = andar;
    }

    public String getEstante() {
        return estante;
    }

    public void setEstante(String estante) {
        this.estante = estante;
    }

}
