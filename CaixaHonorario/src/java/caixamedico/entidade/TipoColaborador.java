package caixamedico.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class TipoColaborador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTipoColaborador", nullable = false)
    private Integer IdTipoColaborador;

    @NotNull(message = "Informe a Função")
    @Column(name = "descricao", nullable = false)
    private String descricao;

    public Integer getIdTipoColaborador() {
        return IdTipoColaborador;
    }

    public void setIdTipoColaborador(Integer IdTipoColaborador) {
        this.IdTipoColaborador = IdTipoColaborador;
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
        hash = 31 * hash + (this.IdTipoColaborador != null ? this.IdTipoColaborador.hashCode() : 0);
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
        final TipoColaborador other = (TipoColaborador) obj;
        if (this.IdTipoColaborador != other.IdTipoColaborador && (this.IdTipoColaborador == null || !this.IdTipoColaborador.equals(other.IdTipoColaborador))) {
            return false;
        }
        return true;
    }

}
