package caixamedico.entidade;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Colaborador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idColaborador", nullable = false)
    private Integer idColaborador;

    @NotNull(message = "Informe o Nome")
    @Column(name = "nome", nullable = false)
    private String nome;

    @NotNull(message = "Informe o CRM")
    @Column(name = "crm", nullable = false)
    private String crm;
   
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "EspecialidadeColaborador",
       joinColumns = @JoinColumn(name="idColaborador"),
       inverseJoinColumns = @JoinColumn(name = "idEspecialidade"))
    private List<Especialidade> especialidades;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idTipoColaborador")
    private TipoColaborador tipoColaborador;
    
    
    @NotNull(message = "Informe o CPF")
    @Column(name = "cpf", nullable = false)
    private String cpf;

    @NotNull(message = "Informe o RG")
    @Column(name = "rg", nullable = false)
    private String rg;

    @NotNull(message = "Informe o Endereço")
    @Column(name = "endereco", nullable = false)
    private String endereco;

    @NotNull(message = "Informe o Usuario")
    @Column(name = "usuario", nullable = false)
    private String usuario;

    @NotNull(message = "Informe a senha")
    @Column(name = "senha", nullable = false)
    private String senha;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
   
    public Integer getIdColaborador() {
        return idColaborador;
    }

    public void setIdColaborador(Integer idColaborador) {
        this.idColaborador = idColaborador;
    }

    public TipoColaborador getTipoColaborador() {
        return tipoColaborador;
    }
    

    public void setTipoColaborador(TipoColaborador tipoColaborador) {
        this.tipoColaborador = tipoColaborador;
    }

    public void setEspecialidades(List<Especialidade> especialidades) {
        this.especialidades = especialidades;
    }

    public List<Especialidade> getEspecialidades() {
        return especialidades;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (this.idColaborador != null ? this.idColaborador.hashCode() : 0);
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
        final Colaborador other = (Colaborador) obj;
        if (this.idColaborador != other.idColaborador && (this.idColaborador == null || !this.idColaborador.equals(other.idColaborador))) {
            return false;
        }
        return true;
    }

  
}
