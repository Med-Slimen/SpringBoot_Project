package com.slimene.projects;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.slimene.projects.entities.Project;
import com.slimene.projects.repos.ProjectRepository;

@SpringBootTest
class ProjectsApplicationTests {

	@Autowired
	private ProjectRepository projectRepo;
	@Test
	public void testCreateProject() {
		Project project=new Project("Dev Mobile","Med",new Date(),100);
		projectRepo.save(project);
	}
	@Test
	public void testfindProject() {
		Project proj=projectRepo.findById(1L).get();
		System.out.println(proj);
	}
	@Test
	public void testUpdateProj() {
		Project proj=projectRepo.findById(1L).get();
		proj.setMontantProject(100);
		projectRepo.save(proj);
	}
	@Test
	public void testFindAllProjects() {
		System.out.println(projectRepo.findAll());
	}

}
