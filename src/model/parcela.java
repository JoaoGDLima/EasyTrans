package model;

import java.sql.Date;

public class parcela {
    private int seq;
    private String dataVencimento;
    private String dataPagamento;
    private Float valor;
    private String situacao;
    private formaspagamento OFormaPagamento;

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public String getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(String dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public formaspagamento getOFormaPagamento() {
        return OFormaPagamento;
    }

    public void setOFormaPagamento(formaspagamento OFormaPagamento) {
        this.OFormaPagamento = OFormaPagamento;
    }
}
