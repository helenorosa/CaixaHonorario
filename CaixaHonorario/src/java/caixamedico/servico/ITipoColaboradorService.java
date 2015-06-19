package caixamedico.servico;

import caixamedico.entidade.TipoColaborador;
import java.util.List;

public interface ITipoColaboradorService {

    public List<TipoColaborador> listar();

    public String salvar(TipoColaborador tipoColaborador);

    public String remover(Integer id);
}
