
package caixamedico.serviceimpl;

import caixamedico.entidade.Cirurgia;
import caixamedico.servico.ICirurgiaService;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class CirurgiaService implements ICirurgiaService{
    
    private EntityManager em = Persistence.createEntityManagerFactory("CaixaMedicoPU").createEntityManager();
   
    @Override
    public List<Cirurgia> listar() {
              Query cirurgiasQuery =
                em.createQuery("select c from Cirurgia as c");
       return cirurgiasQuery.getResultList();
    }
    
    @Override
    public List<Cirurgia> listarPorCirurgia(String nomeCirurgia) {
        Query cirurgiasQuery
                = em.createQuery("select c from Cirurgia as c where c.descricao like :descricao");
        cirurgiasQuery.setParameter("descricao", "%" + nomeCirurgia + "%");
        return cirurgiasQuery.getResultList();
    }

    @Override
    public String salvar(Cirurgia cirurgia) {
        try {
          
            em.getTransaction().begin();
            em.merge(cirurgia);
            em.getTransaction().commit();

        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
            return ex.getMessage();
        }

        return null;
    }

    @Override
    public String remover(Integer idCirurgia) {
        try {
           em.getTransaction().begin();
           em.remove(em.find(Cirurgia.class, idCirurgia));
           em.getTransaction().commit();

        } catch (Exception ex) {
            ex.printStackTrace();
            return ex.getMessage();
        }

        return null;
    }
}
