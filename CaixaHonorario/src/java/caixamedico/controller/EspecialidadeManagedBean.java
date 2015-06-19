package caixamedico.controller;

import caixamedico.entidade.Especialidade;
import caixamedico.serviceimpl.EspecialidadeService;
import caixamedico.servico.IEspecialidadeService;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "especialidadeManagedBean")
@RequestScoped
public class EspecialidadeManagedBean {

    private Especialidade especialidade;

   @EJB
    private IEspecialidadeService especialidadeService = new EspecialidadeService();

    public EspecialidadeManagedBean() {
        especialidade = new Especialidade();
    }

    public List<Especialidade> getListaEspecialidade() {
        return especialidadeService.listar();
    }

    public void salvar() {
        String erro = especialidadeService.salvar(especialidade);
        if (erro == null) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Especialidade Salvo com Sucesso", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    erro, null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }
        especialidade = new Especialidade();
    }

    public void excluir(Especialidade especialidadeSelecionado) {
        String erro = especialidadeService.remover(especialidadeSelecionado.getIdEspecialidade());
        if (erro == null) {
            FacesMessage fm
                    = new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Especialidade excluida com sucesso", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else {
            FacesMessage fm
                    = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            erro, null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }
    }

    public void editar(Especialidade especialidadeSelecionado) {
        especialidade = especialidadeSelecionado;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public IEspecialidadeService getEspecialidadeService() {
        return especialidadeService;
    }

    public void setEspecialidadeService(IEspecialidadeService especialidadeService) {
        this.especialidadeService = especialidadeService;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

}
