package caixamedico.serviceimpl;

import caixamedico.entidade.Movimentacao;
import caixamedico.entidade.Pagamento;
import caixamedico.servico.IMovimentacaoService;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class MovimentacaoService implements IMovimentacaoService {

    private EntityManager em = Persistence.createEntityManagerFactory("CaixaMedicoPU").createEntityManager();

    @Override
    public List<Movimentacao> listar() {
        Query movimentacoesQuery
                = em.createQuery("select mo from Movimentacao as mo");
        return movimentacoesQuery.getResultList();
    }

            //for todas os pagamentos dentro da movimentação
            // valor de cada pagamento e somar em uma variavel.
            //atualiza a data cada pagamento set data.
            //converter a data
    @Override
    public String salvar(Movimentacao movimentacao) {
        try {

            em.getTransaction().begin();
            
            double somar = 0;
            
            for( Pagamento p: movimentacao.getPagamentos()){
                p.setData(movimentacao.getData());
                p.setMovimentacao(movimentacao);
                somar += p.getValor();
            }
            
            movimentacao.setValor(somar);
                        
            em.merge(movimentacao);
            em.getTransaction().commit();

        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
            return ex.getMessage();
        }

        return null;
    }



    @Override
    public String remover(Integer idMovimentacao) {
        try {
            em.getTransaction().begin();
            em.remove(em.find(Movimentacao.class, idMovimentacao));
            em.getTransaction().commit();

        } catch (Exception ex) {
            ex.printStackTrace();
            return ex.getMessage();
        }

        return null;
    }
}
