
package caixamedico.servico;

import caixamedico.entidade.Pagamento;
import java.util.List;


public interface IPagamentoService {
    public List<Pagamento> listar();

    public String salvar(Pagamento pagamento);

    public String remover(Integer id);
}
