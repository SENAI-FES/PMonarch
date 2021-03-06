package entity;

public class Armazem {

    private int idArmazem;
    private String colunaInicio;
    private String colunaFim;
    private String coluna;
    private String rua;
    private String andar;
    private String estante;
    private boolean ativo;
    

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public int getIdArmazem() {
        return idArmazem;
    }

    public void setIdArmazem(int idArmazem) {
        this.idArmazem = idArmazem;
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
