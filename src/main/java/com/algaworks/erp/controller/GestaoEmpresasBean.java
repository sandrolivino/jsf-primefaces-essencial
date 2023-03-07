package com.algaworks.erp.controller;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.persistence.Column;

import com.algaworks.erp.model.Empresa;
import com.algaworks.erp.model.TipoEmpresa;

@Named
@ViewScoped
public class GestaoEmpresasBean implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Empresa empresa = new Empresa();
    
    @Column(precision = 10, scale = 2)
    private BigDecimal faturamento;
    

	public BigDecimal getFaturamento() {
		return faturamento;
	}
	
	public void setFaturamento(BigDecimal faturamento) {
		this.faturamento = faturamento;
	}
	
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}


	public void salvar() {
        System.out.println("Razão social: " + empresa.getRazaoSocial()
                + " - Nome fantasia: " + empresa.getNomeFantasia()
                + " - Tipo: " + empresa.getTipo());
    }
    
    public String ajuda() {
        return "AjudaGestaoEmpresas?faces-redirect=true";
    }
    
    
    public Empresa getEmpresa() {
        return empresa;
    }
    
    public TipoEmpresa[] getTiposEmpresa() {
        return TipoEmpresa.values();
    }
}
