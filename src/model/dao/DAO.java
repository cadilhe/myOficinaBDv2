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
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("myOficinav2PU");
        return factory.createEntityManager();
    }

// MÉTODOS DE PERSISTÊNCIA
    
    public boolean salvarAtualizar(T tipo) {
        EntityManager em = getEM();
        boolean result = true;

        try {
            em.getTransaction().begin();
            if (tipo.getId() != null) {
                tipo = em.merge(tipo);
            }
            em.persist(tipo);
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
    public boolean excluir(T tipo) {
        EntityManager em = getEM();
        boolean result = true;

        try {
            em.getTransaction().begin();
            tipo = em.merge(tipo); // Atualizar o estado do objeto
            em.remove(tipo);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.getMessage();
            System.out.println("Erro: Nao foi possível remover o objeto");
            em.getTransaction().rollback();
            return false;
        }
        return result;
    }

}
