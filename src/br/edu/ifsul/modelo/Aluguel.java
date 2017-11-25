
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;

/**
 * @author Vitor Mateus T
 */
@Entity
@Table(name = "aluguel")
public class Aluguel implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_aluguel", sequenceName = "seq_aluguel_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_aluguel", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @NotNull(message = "O valor deve ser informado")
    @Min(0)
    @Column(name = "valor", nullable = false, columnDefinition = "numeric(10,2)")
    private Double valor;

    @NotNull(message = "O inicio do contrato deve ser informado")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "inicio_contrato", nullable = false)
    private Calendar inicioContrato;

    @NotNull(message = "O fim do contrato deve ser informado")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fim_contrato", nullable = false)
    private Calendar fimContrato;

    @NotNull(message = "O dia do vencimento deve ser informado")
    @Min(0)
    @Column(name = "dia_vencimento", nullable = false)
    private Integer diaVencimento;

    @NotNull(message = "A unidade condominal deve ser informada")
    @ManyToOne
    @JoinColumn(name = "unidade_condominal", referencedColumnName = "id", nullable = false)
    @ForeignKey(name = "fk_unidade_condominal_id")
    private UnidadeCondominal unidadecondominal;

    @NotNull(message = "O locatario deve ser informado")
    @ManyToOne
    @JoinColumn(name = "locatario", referencedColumnName = "id", nullable = false)
    @ForeignKey(name = "fk_locatario_id")
    private Locatario locatario;

    @OneToMany(mappedBy = "aluguel", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Mensalidade> mensalidade = new ArrayList<>();

    public Aluguel() {
    }

    
//    //Parte da 2 etapa. 
//    public void gerarMensalidades() {
//        Calendar dataGerar;
//        dataGerar = (Calendar) this.inicioContrato.clone();
//        while (dataGerar.before(this.fimContrato)) {
//            dataGerar = (Calendar) dataGerar.clone();
//            dataGerar.set(Calendar.DAY_OF_MONTH, diaVencimento);
//            dataGerar.add(Calendar.MONTH, 1);
//            Mensalidade m = new Mensalidade();
//            m.setAluguel(this);
//            m.setDataPagamento(null);
//            m.setValor(valor);
//            m.setValorPagamento(null);
//            m.setVencimento(dataGerar);
//            this.mensalidade.add(m);
//        }
//    }

    public void adicionarMensalidade(Mensalidade obj) {
        obj.setAluguel(this);
        this.mensalidade.add(obj);
    }

    public void removermensalidade(int index) {
        this.mensalidade.remove(index);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Aluguel other = (Aluguel) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Calendar getInicioContrato() {
        return inicioContrato;
    }

    public void setInicioContrato(Calendar inicioContrato) {
        this.inicioContrato = inicioContrato;
    }

    public Calendar getFimContrato() {
        return fimContrato;
    }

    public void setFimContrato(Calendar fimContrato) {
        this.fimContrato = fimContrato;
    }

    public Integer getDiaVencimento() {
        return diaVencimento;
    }

    public void setDiaVencimento(Integer diaVencimento) {
        this.diaVencimento = diaVencimento;
    }

    public UnidadeCondominal getUnidadecondominal() {
        return unidadecondominal;
    }

    public void setUnidadecondominal(UnidadeCondominal unidadecondominal) {
        this.unidadecondominal = unidadecondominal;
    }

    public Locatario getLocatario() {
        return locatario;
    }

    public void setLocatario(Locatario locatario) {
        this.locatario = locatario;
    }

    public List<Mensalidade> getMensalidade() {
        return mensalidade;
    }

    public void setMensalidade(List<Mensalidade> mensalidade) {
        this.mensalidade = mensalidade;
    }

}
