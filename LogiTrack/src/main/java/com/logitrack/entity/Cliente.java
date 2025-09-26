package com.logitrack.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "CLIENTI")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "RAGIONE_SOCIALE", nullable = false)
    private String ragioneSociale;

    @Column(name = "EMAIL", nullable = false, unique = true)
    private String email;

    @Column(name = "PARTITA_IVA", nullable = false, unique = true, length = 16)
    private String partitaIva;

    public Cliente() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getRagioneSociale() { return ragioneSociale; }
    public void setRagioneSociale(String ragioneSociale) { this.ragioneSociale = ragioneSociale; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPartitaIva() { return partitaIva; }
    public void setPartitaIva(String partitaIva) { this.partitaIva = partitaIva; }
}
