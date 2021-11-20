package xktz.website.web.project.service;


import xktz.website.web.project.domain.Project;

import java.util.List;

/**
 * Interface of project
 */
public interface ProjectService {

    /**
     * List all projects
     * @return projects
     */
    List<Project> list();

    /**
     * Select by id
     * @param id the id
     * @return the project
     */
    Project selectById(Integer id);

    /**
     * Insert a project
     * @param name the name of project
     * @param desc the description of project
     * @param url the url of project
     * @return the line influenced
     */
    int insert(String name, String desc, String url);

    /**
     * Delete a project
     * @param id the id
     * @return the row influenced
     */
    int delete(Integer id);
}
