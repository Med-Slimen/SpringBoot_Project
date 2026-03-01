package com.slimene.projects;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.slimene.projects.entities.Departement;
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
		Project project=new Project("application mobile","Pop",new Date(),100);
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
	public void testFindByNomProjectContains()
	{
	List<Project> projs=projectRepo.findByNomProjectContains("Dev");
	projs.forEach(p -> {System.out.println(p.toString());
	 });
	/*ou bien
	for (Project p : projs.getContent())
	{
	System.out.println(p);
	} */
	}
	@Test
	public void testfindProjectByNomProject() {
		List<Project> proj=projectRepo.findByNomProject("Dev Web");
		System.out.println(proj);
	}
	@Test
	public void testFindByNomMontant()
	{
	List<Project> projs = projectRepo.findByNomMontant("b", 90.0);
	for (Project p : projs)
	{
	System.out.println(p);
	}
	}
	@Test
	public void testFindByDepartement()
	{
	Departement dep = new Departement();
	dep.setIdDep(2L);
	List<Project> projs = projectRepo.findByDepartement(dep);
	for (Project p : projs)
	{
	System.out.println(p);
	}
	}
	@Test
	public void findByDepartementIdDep()
	{
	List<Project> prods = projectRepo.findByDepartementIdDep(1L);
	for (Project p : prods)
	{
	System.out.println(p);
	}
	 }
	@Test
	public void testfindByOrderByNomProjectAsc()
	{
	List<Project> prods =
			projectRepo.findByOrderByNomProjectAsc();
	for (Project p : prods)
	{
	System.out.println(p);
	}
	}
	@Test
	public void trierProjectsNomsMontant()
	{
	List<Project> prods = projectRepo.trierProjectsNomsMontant();
	for (Project p : prods)
	{
	System.out.println(p);
	}
	}

}
