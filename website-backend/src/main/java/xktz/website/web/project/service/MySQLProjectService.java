package xktz.website.web.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xktz.website.web.project.domain.Project;
import xktz.website.web.project.dao.ProjectMapper;

import java.util.List;

/**
 * mysql project service
 */
@Service
public class MySQLProjectService implements ProjectService{

    /**
     * Project mapper
     */
    @Autowired
    private ProjectMapper projectMapper;

    @Override
    public List<Project> list() {
        return projectMapper.selectAll();
    }

    @Override
    public Project selectById(Integer id) {
        return projectMapper.selectById(id);
    }

    @Transactional
    @Override
    public int insert(String name, String desc, String url) {
        return projectMapper.insert(new Project(name, desc, url));
    }

    @Override
    public int delete(Integer id) {
        return projectMapper.delete(id);
    }
}
