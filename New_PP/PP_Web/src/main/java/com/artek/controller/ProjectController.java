package com.artek.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.artek.model.ProjectDTO;
import com.artek.service.ProjectService;
import com.artek.validator.ProjectValidator;

@Controller
public class ProjectController {

	private static Logger logger = LoggerFactory.getLogger(ProjectController.class);

	@Autowired
	ProjectService projectservice;
	List list;
	@Autowired
	ProjectValidator projectValidator;

	@RequestMapping(value = "/projectmanagement", method = { RequestMethod.GET, RequestMethod.POST })
	public String projectManagmentForm(@ModelAttribute("ProjectMgmt") ProjectDTO projectDTO,
			BindingResult bindingResult, ModelMap modelMap, HttpServletRequest request,
			RedirectAttributes redirectAttributes) {

	
		if (request.getMethod().equals("GET")) {
			
			System.err.println(modelMap.keySet());
			//modelMap.put(BindingResult.MODEL_KEY_PREFIX+"test", modelMap.get("errors"));
			modelMap.addAttribute("org.springframework.validation.BindingResult.ProjectMgmt", modelMap.get("Error"));
			list = projectservice.getServiceProject();

		} else {
			projectValidator.validate(projectDTO, bindingResult);
			if (!bindingResult.hasErrors()) {
				projectservice.projectOnService(projectDTO);
				return "redirect:/projectmanagement.do";
			} else {
				
				redirectAttributes.addFlashAttribute("Error", bindingResult);
				redirectAttributes.addFlashAttribute("ProjectMgmt", projectDTO);
				return "redirect:/projectmanagement.do";
			}
		}
		modelMap.put("list", list);
		return "projectmanagement";
	}

	@RequestMapping(value = "/update", method = { RequestMethod.GET, RequestMethod.POST })
	public String showUpdate(@ModelAttribute("ProjectUpdate") ProjectDTO dto, BindingResult bindingResult,
			ModelMap modelMap, HttpServletRequest request) {
		if (request.getMethod().equals("GET")) {
			modelMap.put("ProjectUpdate", new ProjectDTO());
			list = projectservice.getProjectInfo(Integer.valueOf(request.getParameter("id")));
		} else {
			projectValidator.validate(dto, bindingResult);
			if (!bindingResult.hasErrors()) {
				projectservice.updateInfo(dto);
				return "redirect:/projectmanagement.do";
			}

		}
		modelMap.put("list", list);
		return "updateProject";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String deleteInfo(HttpServletRequest request) {
		/*
		 * projectservice.deleteProject(Integer.valueOf(request.getParameter(
		 * "id")));
		 */
		if (request.getParameterValues("delete") != null)
			projectservice.deleteProject(request.getParameterValues("delete"));
		return "redirect:/projectmanagement.do";
	}
}
