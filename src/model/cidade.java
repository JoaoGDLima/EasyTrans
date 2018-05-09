package model;

public class cidade {
    private int codigo;
    private estado estadoO;
    private String nome;
    private String cep;
    private boolean inativo;

    public cidade(int pCodigo, estado pEstado, String pNome, String pCep, String pInativo) {
        this.codigo = pCodigo;
        this.estadoO = pEstado;
        this.nome = pNome;
        this.cep = pCep;
        
        this.inativo = false;
        
        if (pInativo.equals("V")) {
            this.inativo = true;
        }
    }

    public cidade() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public estado getEstadoO() {
        return estadoO;
    }

    public void setEstadoO(estado estadoO) {
        this.estadoO = estadoO;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public boolean isInativo() {
        return inativo;
    }

    public void setInativo(boolean inativo) {
        this.inativo = inativo;
    }
}
