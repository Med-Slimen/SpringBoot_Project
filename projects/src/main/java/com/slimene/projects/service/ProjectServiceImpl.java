package com.slimene.projects.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.slimene.projects.entities.Departement;
import com.slimene.projects.entities.Project;
import com.slimene.projects.repos.ProjectRepository;
@Service
public class ProjectServiceImpl implements ProjectService{
	@Autowired
	private ProjectRepository projectRepo;
	@Override
	public Project saveProject(Project p) {
		return projectRepo.save(p);
	}

	@Override
	public Project updateProject(Project p) {
		return projectRepo.save(p);
	}

	@Override
	public void deleteProject(Project p) {
		projectRepo.delete(p);
		
	}

	@Override
	public void deleteProjectById(Long id) {
		 projectRepo.deleteById(id);
		
	}

	@Override
	public Project getProject(Long id) {
		return projectRepo.findById(id).get();
	}

	@Override
	public List<Project> getAllProjects() {
		return projectRepo.findAll();
	}

	@Override
	public Page<Project> getAllProjectsParPage(int page, int size) {
		return projectRepo.findAll(PageRequest.of(page, size));
	}

	@Override
	public List<Project> findByNomProject(String nom) {
		return projectRepo.findByNomProject(nom);
	}

	@Override
	public List<Project> findByNomProjectContains(String nom) {
		// TODO Auto-generated method stub
		return projectRepo.findByNomProjectContains(nom);
	}

	@Override
	public List<Project> findByNomMontant(String nom, Double montant) {
		// TODO Auto-generated method stub
		return projectRepo.findByNomMontant(nom, montant);
	}

	@Override
	public List<Project> findByDepartement(Departement departement) {
		// TODO Auto-generated method stub
		return projectRepo.findByDepartement(departement);
	}

	@Override
	public List<Project> findByDepartementIdDep(Long id) {
		// TODO Auto-generated method stub
		return projectRepo.findByDepartementIdDep(id);
	}

	@Override
	public List<Project> findByOrderByNomProjectAsc() {
		// TODO Auto-generated method stub
		return projectRepo.findByOrderByNomProjectAsc();
	}

	@Override
	public List<Project> trierProjectsNomsMontant() {
		// TODO Auto-generated method stub
		return projectRepo.trierProjectsNomsMontant();
	}
	
}
