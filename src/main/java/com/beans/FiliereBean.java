package com.beans;

import com.dao.FiliereDao;
import com.dao.impl.FiliereDaoImpl;
import com.entities.Filiere;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.SessionScoped;

import java.io.Serializable;
import java.util.List;

@ManagedBean
@SessionScoped
public class FiliereBean implements Serializable {

    private Filiere filiere;
    private FiliereDao filiereDao;
    private boolean isModify;

    public FiliereBean() {
        this.filiere = new Filiere();
        this.filiereDao = new FiliereDaoImpl();
        this.isModify = false;
    }

    public Filiere getFiliere() {
        return filiere;
    }

    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }

    public boolean isModify() {
        return isModify;
    }

    public void setModify(boolean modify) {
        isModify = modify;
    }

    public List<Filiere> getFiliers(){
        return this.filiereDao.getAll();
    }

    public String getLabel(){
        if (!isModify) {
            return  "Enregistrer";
        } else {
            return "Modifier";
        }
    }
    public void save(){
        this.filiereDao.saveOrUpdate(this.filiere);
        this.filiere = new Filiere();
        this.setModify(false);
    }
    public void modify(Filiere f){
        this.filiere = f;
        this.setModify(true);
    }
    public void delete(Filiere f){
        this.filiereDao.delete(f);
        this.filiere = new Filiere();
    }
}
