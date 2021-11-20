package xktz.website.web.blog.dao;

import org.apache.ibatis.annotations.Mapper;
import xktz.website.web.blog.domain.BlogComment;

import java.util.List;

@Mapper
public interface BlogCommentMapper {

    BlogComment selectById(Long id);

    List<BlogComment> selectByBlog(Integer blog);

    int deleteById(Long id);

    int deleteByBlogId(Integer id);

    int insert(BlogComment record);

    int updateById(BlogComment record);

    int updateByIdSelective(BlogComment record);

}