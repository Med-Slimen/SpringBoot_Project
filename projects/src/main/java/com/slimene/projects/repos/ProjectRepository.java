package com.slimene.projects.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.slimene.projects.entities.Departement;
import com.slimene.projects.entities.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {
	List<Project> findByNomProject(String nom);
	List<Project> findByNomProjectContains(String nom);
	/*
	@Query("select p from Project p where p.nomProject like %?1 and p.montantProject > ?2")
	List<Project> findByNomMontant (String nom, Double prix);*/
	@Query("select p from Project p where p.nomProject like %:nom and p.montantProject > :montant")
	List<Project> findByNomMontant (@Param("nom") String nom,@Param("montant") Double montant);
	@Query("select p from Project p where p.departement = ?1")
	List<Project> findByDepartement (Departement departement);
	List<Project> findByDepartementIdDep(Long id);
	List<Project> findByOrderByNomProjectAsc();
	@Query("select p from Project p order by p.nomProject ASC, p.montantProject DESC")
	List<Project> trierProjectsNomsMontant ();

}
