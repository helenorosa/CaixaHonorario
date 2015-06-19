package caixamedico.controller;

import caixamedico.entidade.Pessoa;
import caixamedico.serviceimpl.PessoaService;
import caixamedico.servico.IPessoaService;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "pessoaManagedBean")
@RequestScoped
public class PessoaManagedBean {

    private Pessoa pessoa;

    private IPessoaService pessoaService = new PessoaService();

    public PessoaManagedBean() {
        pessoa = new Pessoa();
    }

    public List<Pessoa> getListaPessoa() {
        return pessoaService.listar();
    }

    public List<Pessoa> getListaPessoaPorNome(String nomePessoa) {
        return pessoaService.listarPorNome(nomePessoa);
    }

    public void salvar() {
        String erro = pessoaService.salvar(pessoa);
        if (erro == null) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Paciente Salvo com Sucesso", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    erro, null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }
        pessoa = new Pessoa();
    }

    public void excluir(Pessoa pessoaSelecionado) {
        String erro = pessoaService.remover(pessoaSelecionado.getIdPessoa());
        if (erro == null) {
            FacesMessage fm
                    = new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Paciente excluido com sucesso", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else {
            FacesMessage fm
                    = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            erro, null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }
    }

    public void editar(Pessoa pessoaSelecionado) {
        pessoa = pessoaSelecionado;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

}
