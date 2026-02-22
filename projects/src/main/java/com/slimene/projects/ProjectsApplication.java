package com.slimene.projects;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.slimene.projects.entities.Project;
import com.slimene.projects.service.ProjectService;

@SpringBootApplication
public class ProjectsApplication implements CommandLineRunner {
	@Autowired
	ProjectService projectService;
	public static void main(String[] args) {
		SpringApplication.run(ProjectsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*
		projectService.saveProject(new Project("site ecommerce","moez",new Date(),120));
		projectService.saveProject(new Project("simple site","badr",new Date(),300));
		projectService.saveProject(new Project("site vitrine","ramzi",new Date(),230));*/
		
	}

}
