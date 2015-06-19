
package caixamedico.entidade;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
public class Pagamento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPagamento", nullable = false)
    private Integer idPagamento;
        
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPessoa")
    private Colaborador colaborador;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idMovimentacao")
    private Movimentacao movimentacao;
    
    @NotNull(message = "Informe o Valor")
    @Column(name = "valor", nullable = false)
    private double Valor;
    
    //@NotNull(message = "Informe a Data")
    @Column(name = "Data", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date Data;
    
    //@NotNull(message = "Informe a DataBaixa")
    @Column(name = "DataBaixa", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date DataBaixa;

    public Integer getIdPagamento() { 
        return idPagamento;
    }

    public void setIdPagamento(Integer idPagamento) {
        this.idPagamento = idPagamento;
    }

    public double getValor() {
        return Valor;
    }

    public void setValor(double Valor) {
        this.Valor = Valor;
    }

    public Date getData() {
        return Data;
    }

    public void setData(Date Data) {
        this.Data = Data;
    }

    public Date getDataBaixa() {
        return DataBaixa;
    }

    public void setDataBaixa(Date DataBaixa) {
        this.DataBaixa = DataBaixa;
    }

    public Colaborador getColaborador() {
        return colaborador;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }

    public Movimentacao getMovimentacao() {
        return movimentacao;
    }

    public void setMovimentacao(Movimentacao movimentacao) {
        this.movimentacao = movimentacao;
    }
    
    
}
