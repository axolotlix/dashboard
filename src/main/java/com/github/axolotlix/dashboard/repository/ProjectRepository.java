package com.github.axolotlix.dashboard.repository;

import com.github.axolotlix.dashboard.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}
