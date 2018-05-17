package model;

public class Contrato {
    private int codigo;
    private cliente OCliente;
    private String dataIni;
    private String dataFim;
    private Boolean inativo;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public cliente getOCliente() {
        return OCliente;
    }

    public void setOCliente(cliente OCliente) {
        this.OCliente = OCliente;
    }

    public String getDataIni() {
        return dataIni;
    }

    public void setDataIni(String dataIni) {
        this.dataIni = dataIni;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public Boolean getInativo() {
        return inativo;
    }

    public void setInativo(Boolean inativo) {
        this.inativo = inativo;
    }
    
    
}
