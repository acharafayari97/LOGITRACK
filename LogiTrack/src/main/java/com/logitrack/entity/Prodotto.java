package com.logitrack.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "PRODOTTI")
public class Prodotto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name = "CODICE", nullable = false, unique = true)
    private String codice;

    @Column(name = "PREZZO_UNITARIO", nullable = false, precision = 13, scale = 2)
    private BigDecimal prezzoUnitario;

    @Column(name = "QUANTITA_DISPONIBILE", nullable = false)
    private Integer quantitaDisponibile;

    public Prodotto() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCodice() { return codice; }
    public void setCodice(String codice) { this.codice = codice; }

    public BigDecimal getPrezzoUnitario() { return prezzoUnitario; }
    public void setPrezzoUnitario(BigDecimal prezzoUnitario) { this.prezzoUnitario = prezzoUnitario; }

    public Integer getQuantitaDisponibile() { return quantitaDisponibile; }
    public void setQuantitaDisponibile(Integer quantitaDisponibile) { this.quantitaDisponibile = quantitaDisponibile; }
}
