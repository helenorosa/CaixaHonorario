package caixamedico.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Cirurgia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCirurgia", nullable = false)
    private Integer IdCirurgia;
 
    @NotNull(message = "Informe a Cirurgia")
    @Column(name = "descricao", nullable = false)
    private String descricao;

    public Integer getIdCirurgia() {
        return IdCirurgia;
    }

    public void setIdCirurgia(Integer IdCirurgia) {
        this.IdCirurgia = IdCirurgia;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + (this.IdCirurgia != null ? this.IdCirurgia.hashCode() : 0);
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
        final Cirurgia other = (Cirurgia) obj;
        if (this.IdCirurgia != other.IdCirurgia && (this.IdCirurgia == null || !this.IdCirurgia.equals(other.IdCirurgia))) {
            return false;
        }
        return true;
    }
    
}
