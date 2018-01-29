package controller;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import model.dao.EquipamentoDAO;
import model.domain.Cliente;
import model.domain.Equipamento;
import org.jdesktop.observablecollections.ObservableCollections;
import util.ValidacaoException;

/**
 *
 * @author cadilhe
 */
public final class EquipamentoController {

    private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    private Equipamento equipamentoDigitado;
    private Equipamento equipamentoSelecionado;
    private List<Equipamento> tabelaEquipamentos;
    private EquipamentoDAO equipamentoDAO;

    private List<Cliente> tabelaClientes;
    private Cliente clienteSelecionado;

    // Construtor
    public EquipamentoController() {
        equipamentoDAO = new EquipamentoDAO();
        tabelaEquipamentos = ObservableCollections.observableList(new ArrayList<>());
        tabelaClientes = ObservableCollections.observableList(new ArrayList<>());
        tabelaClientes.addAll(equipamentoDAO.buscarClientes());
        novo();
        pesquisar();
    }

    // Getters e Setters
    public Equipamento getEquipamentoDigitado() {
        return equipamentoDigitado;
    }

    public void setEquipamentoDigitado(Equipamento equipamentoDigitado) {
        Equipamento oldEquipamentoDigitado = this.equipamentoDigitado;
        this.equipamentoDigitado = equipamentoDigitado;
        propertyChangeSupport.firePropertyChange("equipamentoDigitado", oldEquipamentoDigitado, equipamentoDigitado);
    }

    public Equipamento getEquipamentoSelecionado() {
        return equipamentoSelecionado;
    }

    public void setEquipamentoSelecionado(Equipamento equipamentoSelecionado) {
        // Equipamento oldEquipamentoSelecionado = this.equipamentoSelecionado;
        this.equipamentoSelecionado = equipamentoSelecionado;
        if (this.equipamentoSelecionado != null) {
            setEquipamentoDigitado(equipamentoSelecionado);
        }

    }

    public List<Equipamento> getTabelaEquipamentos() {
        return tabelaEquipamentos;
    }

    public void setTabelaEquipamentos(List<Equipamento> tabelaEquipamentos) {
        this.tabelaEquipamentos = tabelaEquipamentos;
    }

    public EquipamentoDAO getEquipamentoDAO() {
        return equipamentoDAO;
    }

    public void setEquipamentoDAO(EquipamentoDAO equipamentoDAO) {
        this.equipamentoDAO = equipamentoDAO;
    }

    // Relacionamento com Cliente
    public List<Cliente> getTabelaClientes() {
        return tabelaClientes;
    }

    public void setTabelaClientes(List<Cliente> tabelaClientes) {
        this.tabelaClientes = tabelaClientes;
    }

    public Cliente getClienteSelecionado() {
        return clienteSelecionado;
    }

    public void setClienteSelecionado(Cliente clienteSelecionado) {
        if (this.clienteSelecionado != null) {
            this.clienteSelecionado = clienteSelecionado;
        }
        this.clienteSelecionado = clienteSelecionado;

    }

    // Métodos de vinculação de beans
    public void addPropertyChangeListener(PropertyChangeListener propertyChangeListener) {
        propertyChangeSupport.addPropertyChangeListener(propertyChangeListener);
    }

    public void removePropertyChangeListener(PropertyChangeListener propertyChangeListener) {
        propertyChangeSupport.removePropertyChangeListener(propertyChangeListener);
    }

    // Métodos para tratamento dos botões
    public void novo() {
        setEquipamentoDigitado(new Equipamento());
    }

    public void salvar() throws ValidacaoException {
        equipamentoDigitado.validar();
        equipamentoDAO.salvarAtualizar(equipamentoDigitado);
        novo();
        pesquisar();
    }

    public void listar() {
        tabelaEquipamentos.clear();
        tabelaEquipamentos.addAll(equipamentoDAO.findAll());
    }

    public void excluir() {
        equipamentoDAO.excluir(equipamentoDigitado);
        novo();
        pesquisar();
    }

    public void pesquisar() {
        tabelaEquipamentos.clear();
        tabelaEquipamentos.addAll(equipamentoDAO.pesquisar(equipamentoDigitado));
    }

    // Tratamento da perisitencia do Equipamento e suas associaçoes;
    public void cadastrarEquipamento(Equipamento equipamento) {

        Cliente cliente = tabelaClientes.set(0, clienteSelecionado);
        setEquipamentoDigitado(new Equipamento());
        equipamento.setCliente(cliente);
        equipamentoDAO.salvarAtualizar(equipamentoDigitado);
    }
    
    /*
    
    private void atualizarTabela(int rowChurrasco) {
        masterTableChurrasco.clearSelection(); // limpa a tabela de churrascos
        if (masterTableChurrasco.getRowCount() > 0) {
            int ultima = masterTableChurrasco.getRowCount() - 1;
            masterTableChurrasco.setRowSelectionInterval(0, 0);
            masterTableChurrasco.setRowSelectionInterval(ultima, ultima);
        }
        // Manter a última linha da tabela selecioanada
        masterTableChurrasco.setRowSelectionInterval(rowChurrasco, rowChurrasco);
    }
    
    */

   
}
