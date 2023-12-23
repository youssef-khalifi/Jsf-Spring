package com.entities;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Filiere {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false)
    private int id;
    @Basic
    @Column(name = "CODE", nullable = false, length = 255)
    private String code;
    @Basic
    @Column(name = "LIBELLE", nullable = false, length = 255)
    private String libelle;
    @OneToMany(mappedBy = "filiere" , fetch = FetchType.LAZY)
    private Collection<Etudiant> etudiantsById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Filiere filiere = (Filiere) o;

        if (id != filiere.id) return false;
        if (code != null ? !code.equals(filiere.code) : filiere.code != null) return false;
        if (libelle != null ? !libelle.equals(filiere.libelle) : filiere.libelle != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (libelle != null ? libelle.hashCode() : 0);
        return result;
    }

    public Collection<Etudiant> getEtudiantsById() {
        return etudiantsById;
    }

    public void setEtudiantsById(Collection<Etudiant> etudiantsById) {
        this.etudiantsById = etudiantsById;
    }
}
