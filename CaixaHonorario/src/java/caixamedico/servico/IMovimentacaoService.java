
package caixamedico.servico;

import caixamedico.entidade.Movimentacao;
import java.util.List;

public interface IMovimentacaoService {
    
    public List<Movimentacao> listar();

    public String salvar(Movimentacao movimentacao);

    public String remover(Integer id);
}
