package caixamedico.entidade;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
public class Movimentacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMovimentacao", nullable = false)
    private Integer IdMovimentacao;

    @NotNull(message = "Informe o Numero do Atendimento")
    @Column(name = "numeroAtendimento", nullable = false)
    private Integer numeroAtendimento;

    @NotNull(message = "Informe a Data")
    @Column(name = "Data", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date Data;
    
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "movimentacao", cascade = CascadeType.ALL)
    private List<Pagamento> pagamentos;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPessoa")
    private Pessoa pessoa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCirurgia")
    private Cirurgia cirurgia;

    @NotNull(message = "Informe o Valor")
    @Column(name = "Valor", nullable = false)
    private double Valor;

    public Integer getIdMovimentacao() {
        return IdMovimentacao;
    }

    public void setIdMovimentacao(Integer IdMovimentacao) {
        this.IdMovimentacao = IdMovimentacao;
    }

    public Integer getNumeroAtendimento() {
        return numeroAtendimento;
    }

    public void setNumeroAtendimento(Integer numeroAtendimento) {
        this.numeroAtendimento = numeroAtendimento;
    }

    public Date getData() {
        return Data;
    }

    public void setData(Date Data) {
        this.Data = Data;
    }
    
     public List<Pagamento> getPagamentos() {
        return pagamentos;
    }
    


    public void setPagamentos(List<Pagamento> pagamentos) {
        this.pagamentos = pagamentos;
    }

    
    public Cirurgia getCirurgia() {
        return cirurgia;
    }

    public void setCirurgia(Cirurgia cirurgia) {
        this.cirurgia = cirurgia;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public double getValor() {
        return Valor;
    }

    public void setValor(double Valor) {
        this.Valor = Valor;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (this.IdMovimentacao != null ? this.IdMovimentacao.hashCode() : 0);
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
        final Movimentacao other = (Movimentacao) obj;
        if (this.IdMovimentacao != other.IdMovimentacao && (this.IdMovimentacao == null || !this.IdMovimentacao.equals(other.IdMovimentacao))) {
            return false;
        }
        return true;
    }    
}
