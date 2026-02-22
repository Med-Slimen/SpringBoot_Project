package com.slimene.projects.service;

import java.util.List;

import com.slimene.projects.entities.Project;

public interface ProjectService {
	Project saveProject(Project p);
	Project updateProject(Project p);
	void deleteProject(Project p);
	 void deleteProjectById(Long id);
	 Project getProject(Long id);
	List<Project> getAllProjects();
}
