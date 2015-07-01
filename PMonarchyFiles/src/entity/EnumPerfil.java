
package entity;

public enum EnumPerfil {

    ADMINISTRADOR(0, "Administrador"),
    USUARIO(1, "Usuário");

    int id;
    String descricao;

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    
    private EnumPerfil(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }
    
    
    public EnumPerfil getPerfil(int id) {
        for (EnumPerfil enumPerfil : EnumPerfil.values()) {
            if (enumPerfil.getId() == id) {
                return enumPerfil;
            }
        }
        return null;
    }
    
}
