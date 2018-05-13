
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
    private String horaSaida;
    private String horaVolta;
    private funcionario OFuncionario;
    private veiculo OVeiculo;
    private Float Valor;
    private String dataIni;
    private String dataFim;
    private int capacidade;
    private String dataini;
    private String data;
    private ArrayList<cliente> AClientes;

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }
    
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
        this.diaSemana = diaSemana.toUpperCase().substring(0, 3);
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

    public String getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(String horaSaida) {
        this.horaSaida = horaSaida;
    }

    public String getHoraVolta() {
        return horaVolta;
    }

    public void setHoraVolta(String horaVolta) {
        this.horaVolta = horaVolta;
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
}
