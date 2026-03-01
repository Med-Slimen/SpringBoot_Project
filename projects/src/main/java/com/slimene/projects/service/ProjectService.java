package com.slimene.projects.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.slimene.projects.entities.Departement;
import com.slimene.projects.entities.Project;

public interface ProjectService {
	Project saveProject(Project p);
	Project updateProject(Project p);
	void deleteProject(Project p);
	void deleteProjectById(Long id);
	Project getProject(Long id);
	Page<Project> getAllProjectsParPage(int page, int size);
	List<Project> getAllProjects();
	List<Project> findByNomProject(String nom);
	List<Project> findByNomProjectContains(String nom);
	List<Project> findByNomMontant (@Param("nom") String nom,@Param("montant") Double montant);
	List<Project> findByDepartement (Departement departement);
	List<Project> findByDepartementIdDep(Long id);
	List<Project> findByOrderByNomProjectAsc();
	List<Project> trierProjectsNomsMontant ();
}
