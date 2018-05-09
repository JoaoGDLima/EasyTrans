package model;

public class estado {
    private int codigo;
    private String nome;
    private String UF;
    private Boolean inativo;

    public estado(int pCodigo, String pNome, String pUF, String pInativo) {
        this.codigo = pCodigo;
        this.nome = pNome;
        this.UF = pUF;
        
        this.inativo = false;
        
        if (pInativo.equals("V")) {
            this.inativo = true;
        }
    }

    public estado() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }

    public Boolean getInativo() {
        return inativo;
    }

    public void setInativo(Boolean Inativo) {
        this.inativo = Inativo;
    }
}
