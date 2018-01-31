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
    
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "cliente_id", referencedColumnName = "id_cliente")    
    private Cliente cliente;


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
    
    
    // Método de validação de campos
    public void validarCliente() throws ValidacaoException {
        if (this.getCliente() == null || this.getCliente().equals("")) {
            throw new ValidacaoException("O Cliente deve ser preenchido!");
        }
    }
    
    

 
    
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

    
}
