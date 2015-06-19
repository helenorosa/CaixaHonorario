package caixamedico.servico;

import caixamedico.entidade.Pessoa;
import java.util.List;

public interface IPessoaService {

    public List<Pessoa> listar();
    
    public List<Pessoa> listarPorNome(String nomePessoa);

    public String salvar(Pessoa pessoa);

    public String remover(Integer id);
}
