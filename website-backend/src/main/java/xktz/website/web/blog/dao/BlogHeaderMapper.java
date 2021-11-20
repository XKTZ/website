package xktz.website.web.blog.dao;

import org.apache.ibatis.annotations.Mapper;
import xktz.website.web.blog.domain.BlogHeader;

import java.util.List;

@Mapper
public interface BlogHeaderMapper {
    BlogHeader selectById(Integer id);

    List<BlogHeader> selectAll();

    int deleteById(Integer id);

    int insert(BlogHeader record);

    int updateById(BlogHeader record);

    int updateByIdSelective(BlogHeader record);
}