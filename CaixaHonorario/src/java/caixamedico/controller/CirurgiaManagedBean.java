package caixamedico.controller;

import caixamedico.entidade.Cirurgia;
import caixamedico.serviceimpl.CirurgiaService;
import caixamedico.servico.ICirurgiaService;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "cirurgiaManagedBean")
@RequestScoped
public class CirurgiaManagedBean{
    
    private Cirurgia cirurgia;

    
    @EJB
    private ICirurgiaService cirurgiaService = new CirurgiaService();
    
    public CirurgiaManagedBean() {
        cirurgia = new Cirurgia();
    } 
    
     public List<Cirurgia> getListaCirurgia() {
        return cirurgiaService.listar();
    }
     
     public List<Cirurgia> getListaCirurgiaPorNome(String nomeCirurgia) {
        return cirurgiaService.listarPorCirurgia(nomeCirurgia);
    }
     
      public void salvar() {
        String erro = cirurgiaService.salvar(cirurgia);
        if (erro == null) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Cirurgia Salva com Sucesso", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    erro, null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }
        cirurgia = new Cirurgia();
    }
    
      public void excluir(Cirurgia cirurgiaSelecionada){
        String erro = cirurgiaService.remover(cirurgiaSelecionada.getIdCirurgia());
        if (erro == null) {
            FacesMessage fm
                    = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Cirurgia excluida com sucesso", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else {
            FacesMessage fm
                    = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    erro, null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }
    }
      
       public void editar(Cirurgia cirurgiaSelecionada){
        cirurgia = cirurgiaSelecionada;
    }

    public Cirurgia getCirurgia() {
        return cirurgia;
    }

    public void setCirurgia(Cirurgia cirurgia) {
        this.cirurgia = cirurgia;
    }

    public ICirurgiaService getCirurgiaService() {
        return cirurgiaService;
    }

    public void setCirurgiaService(ICirurgiaService cirurgiaService) {
        this.cirurgiaService = cirurgiaService;
    }
       
}
