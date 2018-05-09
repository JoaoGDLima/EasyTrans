package model;


public class veiculo {
    private int codigo;
    private String modelo;
    private String descricao;
    private String marca;
    private String placa;
    private int capacidade;
    private int ano;
    private String cor;
    private boolean inativo;

    public veiculo() {
    }

    public veiculo(int pCodigo, String pModelo, String pDescricao, String pMarca, String pPlaca, int pCapacidade, int pAno, String pCor, String pInativo) {
        this.codigo = pCodigo;
        this.modelo = pModelo;
        this.descricao = pDescricao;
        this.marca = pMarca;
        this.placa = pPlaca;
        this.capacidade = pCapacidade;
        this.ano = pAno;
        this.cor = pCor;
        this.inativo = false;
        
        if (pInativo.equals("V")) {
            this.inativo = true;
        }
    }


    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public boolean isInativo() {
        return inativo;
    }

    public void setInativo(boolean inativo) {
        this.inativo = inativo;
    }
    
    
}
