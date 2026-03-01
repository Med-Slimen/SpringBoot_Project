package com.slimene.projects.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
@Entity
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProject;
	private String nomProject;
	private String nomClient;
	private Date dateDeb;
	@ManyToOne
	private Departement departement;
	private int montantProject;
	public Project() {
		super();
	}
	public Project(String nomProject, String nomClient, Date dateDeb, int montantProject) {
		super();
		this.nomProject = nomProject;
		this.nomClient = nomClient;
		this.dateDeb = dateDeb;
		this.montantProject = montantProject;
	}
	public Long getIdProject() {
		return idProject;
	}
	public void setIdProject(Long idProject) {
		this.idProject = idProject;
	}
	public String getNomProject() {
		return nomProject;
	}
	public void setNomProject(String nomProject) {
		this.nomProject = nomProject;
	}
	public String getNomClient() {
		return nomClient;
	}
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}
	public Date getDateDeb() {
		return dateDeb;
	}
	public void setDateDeb(Date dateDeb) {
		this.dateDeb = dateDeb;
	}
	public int getMontantProject() {
		return montantProject;
	}
	public void setMontantProject(int montantProject) {
		this.montantProject = montantProject;
	}
	@Override
	public String toString() {
		return "Project [idProject=" + idProject + ", nomProject=" + nomProject + ", nomClient=" + nomClient
				+ ", dateDeb=" + dateDeb + ", montantProject=" + montantProject + "]";
	}
	public Departement getDepartement() {
		return departement;
	}
	public void setDepartement(Departement departement) {
		this.departement = departement;
	}
}
