package caixamedico.servico;

import caixamedico.entidade.Especialidade;
import java.util.List;

public interface IEspecialidadeService {

    public List<Especialidade> listar();

    public String salvar(Especialidade especialidade);

    public String remover(Integer id);
}
