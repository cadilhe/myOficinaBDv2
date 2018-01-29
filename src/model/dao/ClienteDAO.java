package model.dao;

import model.domain.Cliente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class ClienteDAO extends DAO<Cliente>{
    
    EntityManager em = getEM();

    // Listar todos objetos    
    public List<Cliente> findAll() {
        return em.createQuery("FROM Cliente").getResultList();
    }

    // Pesquisar Cliente por ID e por Nome    
    public List<Cliente> pesquisar(Cliente cliente) {
        StringBuilder sql = new StringBuilder("from Cliente c " + "where 1 = 1"); // para não ficar verificando se o where foi declarado
        if (cliente.getId() != null) {
            sql.append(" and c.id = :id ");
        }

        if (cliente.getNome() != null && !cliente.getNome().equals("")) {
            sql.append("and c.nome like :nome");
        }
        Query query = em.createQuery(sql.toString());
        if (cliente.getId() != null) {
            query.setParameter("id", cliente.getId());
        }
        if (cliente.getNome() != null && !cliente.getNome().equals("")) {
            query.setParameter("nome", "%" + cliente.getNome() + "%");
        }
        return query.getResultList();
    }
}
