package caixamedico.controller;

import caixamedico.entidade.Colaborador;
import caixamedico.serviceimpl.ColaboradorService;
import caixamedico.servico.IColaboradorService;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name="colaboradorManagedBean")
@RequestScoped
public class ColaboradorManagedBean {
    
    private Colaborador colaborador;
    
    private IColaboradorService colaboradorService = new ColaboradorService();
    
    public ColaboradorManagedBean() {
        colaborador = new Colaborador();
    } 
    
     public List<Colaborador> getListaColaborador() {
        return colaboradorService.listar();
    }
     
      public List<Colaborador> getListaColaboradorPorNome(String nomeColaborador) {
        return colaboradorService.listarPorColaborador(nomeColaborador);
    }
     
      public void salvar() {
        String erro = colaboradorService.salvar(colaborador);
        if (erro == null) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Colaborador Salvo com Sucesso", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    erro, null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }
        colaborador = new Colaborador();
    }
      public void excluir(Colaborador colaboradorSelecionado){
        String erro = colaboradorService.remover(colaboradorSelecionado.getIdColaborador());
        if (erro == null) {
            FacesMessage fm
                    = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Colaborador excluido com Sucesso", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else {
            FacesMessage fm
                    = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    erro, null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }
    }
      
      public void editar(Colaborador colaboradorSelecionado){
       colaborador = colaboradorSelecionado;
    }

    public Colaborador getColaborador() {
        return colaborador;
    }

    public void setColaborador(Colaborador colaboradorSelecionado) {
        this.colaborador = colaborador;
    }

    public IColaboradorService getColaboradorService() {
        return colaboradorService;
    }

    public void setColaboradorService(IColaboradorService colaboradorService) {
        this.colaboradorService = colaboradorService;
    }
      
}
