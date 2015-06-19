package caixamedico.controller;

import caixamedico.entidade.Pagamento;
import caixamedico.serviceimpl.PagamentoService;
import caixamedico.servico.IPagamentoService;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "pagamentoManagedBean")
@RequestScoped
public class PagamentoManagedBean {

    private Pagamento pagamento;

    private IPagamentoService pagamentoService = new PagamentoService();

    public PagamentoManagedBean() {
        pagamento = new Pagamento();
    }

    public List<Pagamento> getListaPagamento() {
        return pagamentoService.listar();
        
    }

    public void salvar() {
        String erro = pagamentoService.salvar(pagamento);
        if (erro == null) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Pagamento Salvo com Sucesso", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    erro, null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }
        pagamento = new Pagamento();
    }

    public void excluir(Pagamento pagamentoSelecionado) {
        String erro = pagamentoService.remover(pagamentoSelecionado.getIdPagamento());
        if (erro == null) {
            FacesMessage fm
                    = new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Pagamento excluido com sucesso", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else {
            FacesMessage fm
                    = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            erro, null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }
    }
    
    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public IPagamentoService getPagamentoService() {
        return pagamentoService;
    }

    public void setPagamentoService(IPagamentoService pagamentoService) {
        this.pagamentoService = pagamentoService;
    }

}
