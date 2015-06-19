package caixamedico.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
//Especialidade
@Entity
public class Especialidade {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEspecialidade", nullable = false)
    private Integer IdEspecialidade;
 
    @NotNull(message = "Informe a Especialidade")
    @Column(name = "descricao", nullable = false)
    private String descricao;

    public Integer getIdEspecialidade() {
        return IdEspecialidade;
    }

    public void setIdEspecialidade(Integer IdEspecialidade) {
        this.IdEspecialidade = IdEspecialidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (this.IdEspecialidade != null ? this.IdEspecialidade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Especialidade other = (Especialidade) obj;
        if (this.IdEspecialidade != other.IdEspecialidade && (this.IdEspecialidade == null || !this.IdEspecialidade.equals(other.IdEspecialidade))) {
            return false;
        }
        return true;
    }
    
    
}
