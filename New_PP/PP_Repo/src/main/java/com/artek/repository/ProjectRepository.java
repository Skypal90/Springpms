package com.artek.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.artek.model.ProjectDTO;

@Repository
public class ProjectRepository {

	@Autowired
	HibernateTemplate hibernateTemplate;

	public void projectSubmit(ProjectDTO projectDTO) {
		hibernateTemplate.save(projectDTO);
	}

	public List getProject() {
		List list = hibernateTemplate.find("from ProjectDTO");
		return list;
	}

	public List geProjectInfo(Integer id) {
		List list = hibernateTemplate.find("from ProjectDTO where pid=?", id);
		return list;
	}

	public void updateInfo(ProjectDTO dto) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		Transaction transactional = session.beginTransaction();
		session.update(dto);
		transactional.commit();
	}

	public void deleteProject(String[] id) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		ProjectDTO dto = new ProjectDTO();
		for (String id1 : id) {
			int id2 = Integer.valueOf(id1);
			dto.setPid(id2);
			Transaction transaction = session.beginTransaction();
			session.delete(dto);
			transaction.commit();
		}
	}
}
