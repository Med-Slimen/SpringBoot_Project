package com.slimene.projects.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.slimene.projects.entities.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}
