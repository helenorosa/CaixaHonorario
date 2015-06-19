package caixamedico.controller;

import caixamedico.entidade.Colaborador;
import caixamedico.entidade.Movimentacao;
import caixamedico.entidade.Pagamento;
import caixamedico.serviceimpl.ColaboradorService;
import caixamedico.serviceimpl.MovimentacaoService;
import caixamedico.servico.IColaboradorService;
import caixamedico.servico.IMovimentacaoService;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "movimentacaoManagedBean")
@SessionScoped
public class MovimentacaoManagedBean {

    private Movimentacao movimentacao;
    private Pagamento pagamento;
    private IMovimentacaoService movimentacaoService = new MovimentacaoService();
    private IColaboradorService colaboradorService = new ColaboradorService();

    public MovimentacaoManagedBean() {
        movimentacao = new Movimentacao();
        pagamento = new Pagamento();
    }

 
 
    public List<Movimentacao> getListaMovimentacoes() {
        return movimentacaoService.listar();
    }

    public void salvar() {
        String erro = movimentacaoService.salvar(movimentacao);
        if (erro == null) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Movimentação Salva com Sucesso", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    erro, null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }
        movimentacao = new Movimentacao();
    }

    public void excluir(Movimentacao movimentacaoSelecionada) {
        String erro = movimentacaoService.remover(movimentacaoSelecionada.getIdMovimentacao());
        if (erro == null) {
            FacesMessage fm
                    = new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Movimentação excluida com sucesso", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else {
            FacesMessage fm
                    = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            erro, null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }
    }

    public void editar(Movimentacao movimentacaoSelecionado) {
        movimentacao = movimentacaoSelecionado;
    }

    public void adicionar() {//adcionar a lista de medicos
        if (movimentacao.getPagamentos() == null) {
            movimentacao.setPagamentos(new ArrayList<Pagamento>());
        }
        Colaborador colaborador = colaboradorService.obter(pagamento.getColaborador().getIdColaborador());
        pagamento.setColaborador(colaborador);
        movimentacao.getPagamentos().add(pagamento);
        pagamento = new Pagamento();
    }

    public Movimentacao getMovimentacao() {
        return movimentacao;
    }

    public void setMovimentacao(Movimentacao movimentacao) {
        this.movimentacao = movimentacao;
    }

    public IMovimentacaoService getMovimentacaoService() {
        return movimentacaoService;
    }

    public void setMovimentacaoService(IMovimentacaoService movimentacaoService) {
        this.movimentacaoService = movimentacaoService;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

}
