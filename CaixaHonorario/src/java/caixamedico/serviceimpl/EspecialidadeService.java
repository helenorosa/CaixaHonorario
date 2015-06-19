package caixamedico.serviceimpl;

import caixamedico.entidade.Especialidade;
import caixamedico.servico.IEspecialidadeService;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class EspecialidadeService implements IEspecialidadeService{
    
    private EntityManager em = Persistence.createEntityManagerFactory("CaixaMedicoPU").createEntityManager();

   
    @Override
    public List<Especialidade> listar() {
              Query especialidadeQuery =

                em.createQuery("select e from Especialidade as e");
       return especialidadeQuery.getResultList();
    }

    @Override
    public String salvar(Especialidade especialidade) {
        try {
          
            em.getTransaction().begin();
            em.merge(especialidade);
            em.getTransaction().commit();

        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
            return ex.getMessage();
        }

        return null;
    }

    @Override
    public String remover(Integer idEspecialidade) {
        try {
           em.getTransaction().begin();
           em.remove(em.find(Especialidade.class, idEspecialidade));
           em.getTransaction().commit();

        } catch (Exception ex) {
            ex.printStackTrace();
            return ex.getMessage();
        }

        return null;
    }
}
