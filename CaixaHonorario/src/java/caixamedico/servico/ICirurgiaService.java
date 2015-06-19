package caixamedico.servico;

import caixamedico.entidade.Cirurgia;
import java.util.List;


public interface ICirurgiaService {
    
    public List<Cirurgia> listar();
    
    public List<Cirurgia> listarPorCirurgia(String nomeCirurgia);

    public String salvar(Cirurgia cirurgia);

    public String remover(Integer id);
}
