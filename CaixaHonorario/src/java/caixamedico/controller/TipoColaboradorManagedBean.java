package caixamedico.controller;

import caixamedico.entidade.TipoColaborador;
import caixamedico.serviceimpl.TipoColaboradorService;
import caixamedico.servico.ITipoColaboradorService;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "tipoColaboradorManagedBean")
@RequestScoped
public class TipoColaboradorManagedBean {

    private TipoColaborador tipoColaborador;

    @EJB
    private ITipoColaboradorService tipoColaboradorService = new TipoColaboradorService();


    public TipoColaboradorManagedBean (){
        tipoColaborador = new TipoColaborador();
    } 
    
     public List<TipoColaborador> getListaTipoColaboradores() {
        return tipoColaboradorService.listar();
    }

    public void salvar() {
        String erro = tipoColaboradorService.salvar(tipoColaborador);
        if (erro == null) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Colaborador Salvo com Sucesso", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    erro, null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }
        tipoColaborador = new TipoColaborador();
    }
    
    public void excluir(TipoColaborador tipoColaboradorSelecionado){
        String erro = tipoColaboradorService.remover(tipoColaboradorSelecionado.getIdTipoColaborador());
        if (erro == null) {
            FacesMessage fm
                    = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Colaborador excluido com sucesso", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else {
            FacesMessage fm
                    = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    erro, null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }
    }
    
    public void editar(TipoColaborador tipoColaboradorSelecionado){
        tipoColaborador = tipoColaboradorSelecionado;
    }

    public TipoColaborador getTipoColaborador() {
        return tipoColaborador;
    }

    public void setTipoColaborador(TipoColaborador tipoColaborador) {
        this.tipoColaborador = tipoColaborador;
    }

}
