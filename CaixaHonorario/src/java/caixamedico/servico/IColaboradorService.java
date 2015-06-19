package caixamedico.servico;

import caixamedico.entidade.Colaborador;
import java.util.List;

public interface IColaboradorService {

    public List<Colaborador> listar();
    
     public List<Colaborador> listarPorColaborador(String nomeColaborador);

    public String salvar(Colaborador colaborador);

    public String remover(Integer id);
    
    public Colaborador obter(Integer idColaborador);
}
