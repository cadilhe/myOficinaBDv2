/*
 * Esta classe DAO é a abordagem do professor Rafael Sakurai
 */
package model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.domain.EntidadeBase;

public class DAO<T extends EntidadeBase> { 
    
    // Fábrica de conexão
    public EntityManager getEM(){
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("myOficinaBDv2PU");
        return factory.createEntityManager();
    }

// MÉTODOS DE PERSISTÊNCIA
    
    public boolean salvarAtualizar(T t) {
        EntityManager em = getEM();
        boolean result = true;

        try {
            em.getTransaction().begin();
            if (t.getId() != null) {
                t = em.merge(t);
            }
            em.persist(t);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.getMessage();
            System.out.println("Erro: Nao foi possível salvar o o objeto");
            em.getTransaction().rollback();
            return false;
        }
        return result;
    }
    
    // Excluir objeto
    public boolean excluir(T t) {
        EntityManager em = getEM();
        boolean result = true;

        try {
            em.getTransaction().begin();
            t = em.merge(t); // Atualizar o estado do objeto
            em.remove(t);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.getMessage();
            System.out.println("Erro: Nao foi possível remover o objeto");
            em.getTransaction().rollback();
            return false;
        }
        return result;
    }
    
    // Listar todos objetos
    // public abstract List<E> findAll();
    
    /* Os métodos abaixo só foram implementados em ServicoDAO, entao ficam só por lá...
    
    // Obter pelo ID
    public abstract E getById(final Long id);
    
    // Remover por ID
    public abstract boolean removeById(final Long id);
    
    */

}
