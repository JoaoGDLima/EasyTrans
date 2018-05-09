
package model;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class viagem {
    private int codigo;
    private universidade OUniversidade;
    private String diaSemana;
    private Time horaSaida;
    private Time horaVolta;
    private funcionario OFuncionario;
    private veiculo OVeiculo;
    private Float Valor;
    private Date dataIni;
    private Date dataFim;
    private ArrayList<cliente> AClientes;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public universidade getOUniversidade() {
        return OUniversidade;
    }

    public void setOUniversidade(universidade OUniversidade) {
        this.OUniversidade = OUniversidade;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public Time getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(Time horaSaida) {
        this.horaSaida = horaSaida;
    }

    public Time getHoraVolta() {
        return horaVolta;
    }

    public void setHoraVolta(Time horaVolta) {
        this.horaVolta = horaVolta;
    }

    public funcionario getOFuncionario() {
        return OFuncionario;
    }

    public void setOFuncionario(funcionario OFuncionario) {
        this.OFuncionario = OFuncionario;
    }

    public veiculo getOVeiculo() {
        return OVeiculo;
    }

    public void setOVeiculo(veiculo OVeiculo) {
        this.OVeiculo = OVeiculo;
    }

    public Float getValor() {
        return Valor;
    }

    public void setValor(Float Valor) {
        this.Valor = Valor;
    }

    public Date getDataIni() {
        return dataIni;
    }

    public void setDataIni(Date dataIni) {
        this.dataIni = dataIni;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public ArrayList<cliente> getAClientes() {
        return AClientes;
    }

    public void setAClientes(ArrayList<cliente> AClientes) {
        this.AClientes = AClientes;
    }
    
    public void AdicionarCliente(cliente pCliente)
    {
        AClientes.add(pCliente);
    }
    
    public void RemoverCliente(cliente pCliente)
    {
        AClientes.remove(pCliente);
    }
}
