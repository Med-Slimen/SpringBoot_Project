package com.slimene.projects;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.slimene.projects.entities.Project;
import com.slimene.projects.repos.ProjectRepository;
import com.slimene.projects.service.ProjectService;

@SpringBootTest
class ProjectsApplicationTests {

	@Autowired
	private ProjectRepository projectRepo;
	@Autowired
	private ProjectService projectService;
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
	@Test
	public void testFindByNomProduitContains()
	{
	Page<Project> projs = projectService.getAllProjectsParPage(0,2);
	System.out.println(projs.getSize());
	System.out.println(projs.getTotalElements());
	System.out.println(projs.getTotalPages());
	projs.getContent().forEach(p -> {System.out.println(p.toString());
	 });
	/*ou bien
	for (Project p : projs.getContent())
	{
	System.out.println(p);
	} */
	}
}
