package com.slimene.projects.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.slimene.projects.entities.Project;

public interface ProjectService {
	Project saveProject(Project p);
	Project updateProject(Project p);
	void deleteProject(Project p);
	void deleteProjectById(Long id);
	Project getProject(Long id);
	Page<Project> getAllProjectsParPage(int page, int size);
	List<Project> getAllProjects();
}
