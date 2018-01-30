package model.domain;

import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import util.ValidacaoException;

/**
 *
 * @author cadilhe
 */

@Entity
@Table(name = "cliente")
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")})

public class Cliente implements EntidadeBase, Serializable {

    @Transient
    private final PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long id;

    @Column
    private String nome;

    // Ao remover um cliente remove-se todos os equipamentos associados a ele. 
    @OneToMany(mappedBy = "cliente", cascade = {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.REFRESH, CascadeType.DETACH}, fetch = FetchType.EAGER)
     private List<Equipamento> equipamentos;

// CONSTRUTOR
    public Cliente(){
    }

    
// MÉTODOS   
    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        Long oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome;
        changeSupport.firePropertyChange("nome", oldNome, nome);
    }

    public List<Equipamento> getEquipamentos() {
        return equipamentos;
    }

    public void setEquipamentos(List<Equipamento> equipamentos) {
        this.equipamentos = equipamentos;
    }
    
    
    // Métodos convenientes para adicionar e remover equipamentos a clientes
    public void addEquipamento(Equipamento equipamento) {
        if (equipamentos == null) {
            equipamentos = new ArrayList<>();
        }
        equipamentos.add(equipamento);
    }

    public void removeEquipamento(Equipamento equipamento) {
        equipamentos.remove(equipamento);
        equipamento.getCliente().removeEquipamento(equipamento);
    }
    
    // Método de validação de campos
    public void validar() throws ValidacaoException {
        if (this.nome == null || this.nome.equals("")) {
            throw new ValidacaoException("Campo nome deve ser preenchido!");
        }
    }

// HASHCODE, EQUALS, TO STRING

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.id);
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
        final Cliente other = (Cliente) obj;
        return Objects.equals(this.id, other.id);
    }
   
    // TOSTRING: Nome do cliente e sua lista de equipamentos
    @Override
    public String toString() {
        return nome;
    }
}
