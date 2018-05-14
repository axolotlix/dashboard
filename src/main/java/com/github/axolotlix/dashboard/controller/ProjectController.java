package com.github.axolotlix.dashboard.controller;

import com.github.axolotlix.dashboard.exception.ResourceNotFoundException;
import com.github.axolotlix.dashboard.model.Project;
import com.github.axolotlix.dashboard.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProjectController {

    @Autowired
    ProjectRepository projectRepository;

    @GetMapping("/projects")
    public List<Project> getAllProjects(){
        return projectRepository.findAll();
    }

    @PostMapping("/projects")
    public Project createProject(@Valid @RequestBody Project project) {
        return projectRepository.save(project);
    }

    @GetMapping("/projects/{id}")
    public Project getProjectById(@PathVariable(value = "id") Long projectID) {
        return projectRepository.findById(projectID)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", projectID));
    }

    @PutMapping("/projects/{id}")
    public Project updateProject(@PathVariable(value = "id") Long projectId, @Valid @RequestBody Project projectDetails) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new ResourceNotFoundException("Project", "id", projectId));
        project.setPortfolio(projectDetails.getPortfolio());
        project.setProjectName(projectDetails.getProjectName());
        project.setRagStatus(projectDetails.getRagStatus());
        project.setProjectDesc(projectDetails.getProjectDesc());

        Project updatedProject = projectRepository.save(project);

        return updatedProject;
    }

    @DeleteMapping("/projects/{id}")
    public ResponseEntity<?> deleteProject(@PathVariable(value = "id") Long projectId) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new ResourceNotFoundException("Project", "id", projectId));
        projectRepository.delete(project);

        return ResponseEntity.ok().build();
    }
}
