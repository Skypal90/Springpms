package com.artek.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.artek.model.ProjectDTO;
import com.artek.repository.ProjectRepository;  

@Service
public class ProjectService {

	@Autowired ProjectRepository projectRepository;
	
	public List getServiceProject()
	{
		return projectRepository.getProject();
	}
	
	public void projectOnService(ProjectDTO projectDTO)
	{
		projectRepository.projectSubmit(projectDTO);
	}
	
	public List getProjectInfo(Integer id) {
		return projectRepository.geProjectInfo(id);
	}
	
	public void updateInfo(ProjectDTO dto)
	{
	projectRepository.updateInfo(dto);
	}
	
	public void deleteProject(String[] id)
	{
		projectRepository.deleteProject(id);
	}
}
