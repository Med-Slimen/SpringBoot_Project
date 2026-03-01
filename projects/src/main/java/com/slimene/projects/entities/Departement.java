package com.slimene.projects.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Departement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDep;
	private String nomDep;
	private String descriptionDep;
	@OneToMany (mappedBy = "departement")
	private List<Project> projects;
	public Departement() {
		super();
	}
	public Long getIdDep() {
		return idDep;
	}
	public void setIdDep(Long idDep) {
		this.idDep = idDep;
	}
	public String getNomDep() {
		return nomDep;
	}
	public void setNomDep(String nomDep) {
		this.nomDep = nomDep;
	}
	public String getDescriptionDep() {
		return descriptionDep;
	}
	public void setDescriptionDep(String descriptionDep) {
		this.descriptionDep = descriptionDep;
	}
	public List<Project> getProjects() {
		return projects;
	}
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	
}
