package model;

public class universidade {
    private int codigo;
    private String nome;
    private boolean inativo;

    public universidade(int pCodigo, String pNome, String pInativo) {
        this.codigo = pCodigo;
        this.nome = pNome;
        
        this.inativo = false;
        
        if (pInativo.equals("V")) {
            this.inativo = true;
        }
    }

    public universidade() {
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

    public boolean isInativo() {
        return inativo;
    }

    public void setInativo(boolean inativo) {
        this.inativo = inativo;
    }
}
