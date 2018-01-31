package model.dao;

import model.domain.Equipamento;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.domain.Cliente;

public class EquipamentoDAO extends DAO {

    EntityManager em = getEM();

    // Listar todos equipamentos
    public List<Equipamento> findAll() {
        return em.createQuery("FROM Equipamento").getResultList();
    }
    
     // Encontrar o equipamento por ID
    public Equipamento getById(final Long id) {
        return em.find(Equipamento.class, id);
    }

    // Encontrar o equipamento por ID e remover
    public boolean removeById(final Long id) {

        boolean result = true;

        try {
            Equipamento equipamento = this.getById(id);
            super.excluir(equipamento);
        } catch (Exception ex) {
            ex.getMessage();
            System.out.println("Erro: Nao foi possível remover o equipamento");
            result = false;
        }
        return result;
    }

   

    // Pesquisar equipamento por Id e por Nome        
    public List<Equipamento> pesquisar(Equipamento equipamento) {
        StringBuilder sql = new StringBuilder("from Equipamento e " + "where 1 = 1"); // para não ficar verificando se o where foi declarado
        if (equipamento.getId() != null) {
            sql.append(" and e.id = :id");
        }

        if (equipamento.getNome() != null && !equipamento.getNome().equals("")) {
            sql.append(" and e.nome like :nome");
        }
        Query query = em.createQuery(sql.toString());
        if (equipamento.getId() != null) {
            query.setParameter("id", equipamento.getId());
        }
        if (equipamento.getNome() != null && !equipamento.getNome().equals("")) {
            query.setParameter("nome", "%" + equipamento.getNome() + "%");
        }
        return query.getResultList();
    }

    // Pesquisar equipamento por Cliente     
    public List<Equipamento> pesquisarPorCliente(Equipamento equipamento) {
        StringBuilder sql = new StringBuilder("from Equipamento e " + "where 1 = 1");
        if (equipamento.getId() != null) {
            sql.append("and e.id = :id");
        }
        if (equipamento.getCliente() != null) {
            sql.append("and e.cliente.id = :id");
        }

        Query query = em.createQuery(sql.toString());
        if (equipamento.getId() != null) {
            query.setParameter("id", equipamento.getId());
        }
        if (equipamento.getCliente() != null) {
            query.setParameter("id", equipamento.getCliente());
        }
        return query.getResultList();
    }

    // Encontrar o dono do equipmento
    public List<Cliente> buscarClientes() {
        ClienteDAO clienteDAO = new ClienteDAO();
        return clienteDAO.pesquisar(new Cliente());
    }

    
}
