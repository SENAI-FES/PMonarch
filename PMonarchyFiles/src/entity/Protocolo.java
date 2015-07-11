/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *
 * @author VDISOO0219
 */
public class Protocolo {
    private int quantidadeDocumento;
    private String cpf;
    private String responsavelEntrega;
    private Empresa empresa;
    private Usuario responsavelCadastro;
    private Usuario responsavelSeparacao;
    private Usuario responsavelEstocagem;
    private TipoDocumento tipoDocumento;
    private int tipoProtocolo;
    private Date dataHora;
    private int numeroProtocolo;

    public int getQuantidadeDocumento() {
        return quantidadeDocumento;
    }

    public void setQuantidadeDocumento(int quantidadeDocumentos) {
        this.quantidadeDocumento = quantidadeDocumentos;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getResponsavelEntrega() {
        return responsavelEntrega;
    }

    public void setResponsavelEntrega(String responsavelEntrega) {
        this.responsavelEntrega = responsavelEntrega;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Usuario getResponsavelCadastro() {
        return responsavelCadastro;
    }

    public void setResponsavelCadastro(Usuario responsavelCadastro) {
        this.responsavelCadastro = responsavelCadastro;
    }

    public Usuario getResponsavelSeparacao() {
        return responsavelSeparacao;
    }

    public void setResponsavelSeparacao(Usuario responsavelSeparacao) {
        this.responsavelSeparacao = responsavelSeparacao;
    }

    public Usuario getResponsavelEstocagem() {
        return responsavelEstocagem;
    }

    public void setResponsavelEstocagem(Usuario responsavelEstocagem) {
        this.responsavelEstocagem = responsavelEstocagem;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public int getTipoProtocolo() {
        return tipoProtocolo;
    }

    public void setTipoProtocolo(int tipoProtocolo) {
        this.tipoProtocolo = tipoProtocolo;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    
    public int getNumeroProtocolo() {
        return numeroProtocolo;
    }

    public void setNumeroProtocolo(int numeroProtocolo) {
        this.numeroProtocolo = numeroProtocolo;
    }

 
    
}
