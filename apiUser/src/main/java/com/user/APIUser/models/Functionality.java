package com.user.APIUser.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TB_FUNCTIONALITY")
public class Functionality implements Serializable{
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFuncionalidade() {
		return Funcionalidade;
	}
	public void setFuncionalidade(String funcionalidade) {
		Funcionalidade = funcionalidade;
	}
	public String getPerfil() {
		return Perfil;
	}
	public void setPerfil(String perfil) {
		Perfil = perfil;
	}
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String Funcionalidade;
	private String Perfil;
}