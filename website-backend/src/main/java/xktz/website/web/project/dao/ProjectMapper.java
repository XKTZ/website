package xktz.website.web.project.dao;

import org.apache.ibatis.annotations.Mapper;
import xktz.website.web.project.domain.Project;

import java.util.List;

@Mapper
public interface ProjectMapper {
    Project selectById(Integer id);

    List<Project> selectAll();

    int insert(Project record);

    int delete(Integer id);

    int update(Project record);
}