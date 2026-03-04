package com.slimene.projects.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.slimene.projects.entities.Departement;

public interface DepartementRepository extends JpaRepository<Departement, Long> {

}
