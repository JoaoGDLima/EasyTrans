package model;

import dao.clienteDAO;
import java.sql.Date;
import java.util.ArrayList;

public class Contrato {
    private int codigo;
    private cliente OCliente;
    private String dataIni;
    private String dataFim;
    private Boolean inativo;
    private String viagens;
    private ArrayList<parcela> AParcelas;

    public Contrato(int pCodigo, int pCliente, String pDataini, String pDatafim, ArrayList<parcela> parcelas) {
        this.codigo = pCodigo;
        this.OCliente = new clienteDAO().consultarId(pCliente);
        this.dataIni = Formatacao.ajustaDataDMA(pDataini);
        this.dataFim = Formatacao.ajustaDataDMA(pDatafim);
        this.AParcelas = parcelas;
    }

    public String getViagens() {
        return viagens;
    }

    public void setViagens(String viagens) {
        this.viagens = viagens;
    }

    public Contrato() {
       
    }

    public int getCodigo() {
        return codigo;
    }

    public ArrayList<parcela> getAParcelas() {
        return AParcelas;
    }

    public void setAParcelas(ArrayList<parcela> AParcelas) {
        this.AParcelas = AParcelas;
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
