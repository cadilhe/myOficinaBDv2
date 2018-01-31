package controller;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import model.dao.ClienteDAO;
import model.domain.Cliente;
import org.jdesktop.observablecollections.ObservableCollections;
import util.ValidacaoException;

/**
 *
 * @author cadilhe
 */
public final class ClienteController {

    private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    private Cliente clienteDigitado;
    private Cliente clienteSelecionado;
    private List<Cliente> tabelaClientes;
    private ClienteDAO clienteDAO;

    // Construtor
    public ClienteController() {
        clienteDAO = new ClienteDAO();
        tabelaClientes = ObservableCollections.observableList(new ArrayList<>());
        novo();
        pesquisar();
    }

    // Getters e Setters
    public Cliente getClienteDigitado() {
        return clienteDigitado;
    }

    public void setClienteDigitado(Cliente clienteDigitado) {
        Cliente oldClienteDigitado = this.clienteDigitado;
        this.clienteDigitado = clienteDigitado;
        propertyChangeSupport.firePropertyChange("clienteDigitado", oldClienteDigitado, clienteDigitado);
    }

    public Cliente getClienteSelecionado() {
        return clienteSelecionado;
    }

    public void setClienteSelecionado(Cliente clienteSelecionado) {
        this.clienteSelecionado = clienteSelecionado;
        if (this.clienteSelecionado != null) {
            setClienteDigitado(clienteSelecionado);
        }
    }

    public List<Cliente> getTabelaClientes() {
        return tabelaClientes;
    }

    public void setTabelaClientes(List<Cliente> tabelaClientes) {
        this.tabelaClientes = tabelaClientes;
    }

    public ClienteDAO getClienteDAO() {
        return clienteDAO;
    }

    public void setClienteDAO(ClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    // Métodos para tratamento dos botões
    public void novo() {
        setClienteDigitado(new Cliente());
    }

    public void salvar() throws ValidacaoException {
        clienteDigitado.validar();
        clienteDAO.salvarAtualizar(clienteDigitado);
        novo();
        pesquisar();
    }

    public void listar() {
        tabelaClientes.clear();
        tabelaClientes.addAll(clienteDAO.findAll());
    }

    public void excluir() {
        clienteDAO.excluir(clienteDigitado);
        novo();
        pesquisar();
    }

    public void pesquisar() {
        tabelaClientes.clear();
        tabelaClientes.addAll(clienteDAO.pesquisar(clienteDigitado));
    }

    // Métodos de vinculação de beans
    public void addPropertyChangeListener(PropertyChangeListener propertyChangeListener) {
        propertyChangeSupport.addPropertyChangeListener(propertyChangeListener);
    }

    public void removePropertyChangeListener(PropertyChangeListener propertyChangeListener) {
        propertyChangeSupport.removePropertyChangeListener(propertyChangeListener);
    }

}
