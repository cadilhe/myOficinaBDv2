package model.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import util.ValidacaoException;

/**
 *
 * @author cadilhe
 */

@Entity
@Table(name = "equipamento")
@NamedQueries({
    @NamedQuery(name = "Equipamento.findAll", query = "SELECT e FROM Equipamento e")})

public class Equipamento implements EntidadeBase, Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_equipamento")
    private Long id;

    @Column
    private String nome;

    /* Relacionamento equipamento-cliente: N:1. 
     * A cascata é seletiva porque a remoçao do equipamento nao implica na exclusao do cliente. 
     * Remove apenas a associaçao entre equipamento e cliente - CascadeType.DETACH
     */ 
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "cliente_id", referencedColumnName = "id_cliente")    
    private Cliente cliente;

// Relacionamento equipamento-serviço: N:M
//    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//    @JoinTable(name = "equipamento_servico",
//            joinColumns = {
//                @JoinColumn(name = "equipamento_id", referencedColumnName = "id_equipamento")},
//            inverseJoinColumns = {
//                @JoinColumn(name = "servico_id", referencedColumnName = "id_servico")}
//    )
//    private List<Servico> servicos;

// CONSTRUTOR    
    public Equipamento() {
    }

    // MÉTODOS
    // Getters e Setters    
    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    

// SERVIÇOS
//    public List<Servico> getServicos() {
//        return servicos;
//    }
//
//    public void setServicos(List<Servico> servicos) {
//        this.servicos = servicos;
//    }
//
//    // Métodos convenientes para adicionar e remover serviços em equipamentos   
//    public void addServico(Servico itemServico) {
//        if (servicos == null) {
//            servicos = new ArrayList<>();
//        }
//        servicos.add(itemServico);
//    }
//
//    public void removeServico(Servico servico) {
//        servicos.remove(servico);
//        servico.getEquipamentos().remove(this);
//    }
//
//    public void remove() {
//        for (Servico servico : new ArrayList<>(servicos)) {
//            removeServico(servico);
//        }
//    }
    
    
// HASHCODE, EQUALS
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Equipamento other = (Equipamento) obj;
        return Objects.equals(this.id, other.id);
    }

    // TO STRING: Nome do equipamento e referencia ao dono
    @Override
    public String toString() {
        return "Equipamento{" + "nome=" + nome + ", cliente=" + cliente + '}';
    }

   // Método de validação de campos
    public void validar() throws ValidacaoException {
        if (this.nome == null || this.nome.equals("")) {
            throw new ValidacaoException("Campo nome deve ser preenchido!");
        }
    }

    public void removeCliente(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
