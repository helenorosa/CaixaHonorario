
package caixamedico.serviceimpl;

import caixamedico.entidade.Pagamento;
import caixamedico.servico.IPagamentoService;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class PagamentoService implements IPagamentoService{
   
    
    private EntityManager em = Persistence.createEntityManagerFactory("CaixaMedicoPU").createEntityManager();

    
    @Override
    public List<Pagamento> listar() {
              Query pagamentosQuery =

                em.createQuery("select p from Pagamento as p");
       return pagamentosQuery.getResultList();
    }

    @Override
    public String salvar(Pagamento pagamento) {
        try {
            em.getTransaction().begin();
            em.merge(pagamento);
            em.getTransaction().commit();

        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
            return ex.getMessage();
        }

        return null;
    }

    @Override
    public String remover(Integer idPagamento) {
        try {
           em.getTransaction().begin();
           em.remove(em.find(Pagamento.class, idPagamento));
           em.getTransaction().commit();

        } catch (Exception ex) {
            ex.printStackTrace();
            return ex.getMessage();
        }

        return null;
    }

    
}
