package com.projetoweb.pagrn.model;

import javax.persistence.*;

@Entity(name="Deficiencia")
public class Deficiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Long id;
    private boolean fisica;
    private boolean visual;
    private boolean auditiva;
    private boolean mental;
    private boolean intelectual;
    @Column(nullable = false)
    private String denominacao;

    //@ManyToMany(mappedBy = "deficiencias")
    //Set<Pessoa> pessoas;

    public Deficiencia(boolean fisica, boolean visual, boolean auditiva, boolean mental, boolean intelectual, String denominacao) {
        this.fisica = fisica;
        this.visual = visual;
        this.auditiva = auditiva;
        this.mental = mental;
        this.intelectual = intelectual;
        this.denominacao = denominacao;
    }

    public Deficiencia(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isFisica() {
        return fisica;
    }

    public void setFisica(boolean fisica) {
        this.fisica = fisica;
    }

    public boolean isVisual() {
        return visual;
    }

    public void setVisual(boolean visual) {
        this.visual = visual;
    }

    public boolean isAuditiva() {
        return auditiva;
    }

    public void setAuditiva(boolean auditiva) {
        this.auditiva = auditiva;
    }

    public boolean isMental() {
        return mental;
    }

    public void setMental(boolean mental) {
        this.mental = mental;
    }

    public boolean isIntelectual() {
        return intelectual;
    }

    public void setIntelectual(boolean intelectual) {
        this.intelectual = intelectual;
    }

    public String getDenominacao() {
        return denominacao;
    }

    public void setDenominacao(String denominacao) {
        this.denominacao = denominacao;
    }
}
