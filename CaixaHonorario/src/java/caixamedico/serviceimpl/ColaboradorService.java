package caixamedico.serviceimpl;

import caixamedico.entidade.Colaborador;
import caixamedico.servico.IColaboradorService;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class ColaboradorService implements IColaboradorService {
    
     private EntityManager em = Persistence.createEntityManagerFactory("CaixaMedicoPU").createEntityManager();
   
    @Override
    public List<Colaborador> listar() {
              Query colaboradoresQuery =
                em.createQuery("select c from Colaborador as c");
       return colaboradoresQuery.getResultList();
    }
    
    @Override
    public List<Colaborador> listarPorColaborador(String nomeColaborador) {
        Query colaboradoresQuery
                = em.createQuery("select c from Colaborador as c where c.nome like :nome");
        colaboradoresQuery.setParameter("nome", "%" + nomeColaborador + "%");
        return colaboradoresQuery.getResultList();
    }

    @Override
    public String salvar(Colaborador colaborador) {
        try {
            em.getTransaction().begin(); System.out.println(colaborador.getEspecialidades().size());
            em.merge(colaborador);
            em.getTransaction().commit();

        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
            return ex.getMessage();
        }

        return null;
    }

    @Override
    public String remover(Integer idColaborador) {
        try {
           em.getTransaction().begin();
           em.remove(em.find(Colaborador.class, idColaborador));
           em.getTransaction().commit();

        } catch (Exception ex) {
            ex.printStackTrace();
            return ex.getMessage();
        }

        return null;
    }
    
    public Colaborador obter(Integer idColaborador){
        return em.find(Colaborador.class, idColaborador);
    } 
}

