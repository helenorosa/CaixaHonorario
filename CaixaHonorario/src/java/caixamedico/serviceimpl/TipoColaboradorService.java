package caixamedico.serviceimpl;

import caixamedico.entidade.TipoColaborador;
import caixamedico.servico.ITipoColaboradorService;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class TipoColaboradorService implements ITipoColaboradorService{
    
 private EntityManager em = Persistence.createEntityManagerFactory("CaixaMedicoPU").createEntityManager();

   
    @Override
    public List<TipoColaborador> listar() {
              Query tipoColaboradoresQuery =

                em.createQuery("select t from TipoColaborador as t");
       return tipoColaboradoresQuery.getResultList();
    }

    @Override
    public String salvar(TipoColaborador tipoColaborador) {
        try {
            em.getTransaction().begin();
            em.merge(tipoColaborador);
            em.getTransaction().commit();

        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
            return ex.getMessage();
        }

        return null;
    }

    @Override
    public String remover(Integer idTipoColaborador) {
        try {
           em.getTransaction().begin();
           em.remove(em.find(TipoColaborador.class, idTipoColaborador));
           em.getTransaction().commit();

        } catch (Exception ex) {
            ex.printStackTrace();
            return ex.getMessage();
        }

        return null;
    }

}


