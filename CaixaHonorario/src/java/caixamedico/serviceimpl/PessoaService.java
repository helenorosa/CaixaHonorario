package caixamedico.serviceimpl;

import caixamedico.entidade.Pessoa;
import caixamedico.servico.IPessoaService;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class PessoaService implements IPessoaService {

    private EntityManager em = Persistence.createEntityManagerFactory("CaixaMedicoPU").createEntityManager();

    @Override
    public List<Pessoa> listar() {
        Query pacientesQuery
                = em.createQuery("select p from Pessoa as p");
        return pacientesQuery.getResultList();
    }

    @Override
    public List<Pessoa> listarPorNome(String nomePessoa) {
        Query pacientesQuery
                = em.createQuery("select p from Pessoa as p where p.nome like :nome");
        pacientesQuery.setParameter("nome", "%" + nomePessoa + "%");
        return pacientesQuery.getResultList();
    }

    @Override
    public String salvar(Pessoa pessoa) {
        try {

            em.getTransaction().begin();
            em.merge(pessoa);
            em.getTransaction().commit();

        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();//o pq de usar o rollback
            return ex.getMessage();
        }

        return null;
    }

    @Override
    public String remover(Integer idPessoa) {
        try {
            em.getTransaction().begin();
            em.remove(em.find(Pessoa.class, idPessoa));
            em.getTransaction().commit();

        } catch (Exception ex) {
            ex.printStackTrace();
            return ex.getMessage();
        }

        return null;
    }

}
