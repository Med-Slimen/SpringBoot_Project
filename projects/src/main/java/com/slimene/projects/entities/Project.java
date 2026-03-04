package com.slimene.projects.entities;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
@Entity
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProject;
	@NotNull
	@Size (min = 4,max = 15)
	private String nomProject;
	@NotNull
	@Size (min = 3,max = 15)
	private String nomClient;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent
	private Date dateDeb;
	@ManyToOne
	private Departement departement;
	@Min(value = 10)
	@Max(value = 10000)
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
