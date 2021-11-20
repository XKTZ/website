package xktz.website.web.blog.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Util for blogs
 */
@Component
public class BlogIO {


    @Value("${websiteConfig.resource.blog}")
    private String contentPathPrefix;


    /**
     * Get the blog setting file
     *
     * @param id the id
     * @return the path
     */
    public String getBlogFilePathById(int id) {
        return contentPathPrefix + id;
    }

    /**
     * Get the blog content
     *
     * @param id the id
     * @return the blog content
     * @throws IOException
     */
    public synchronized String getBlogContent(int id) throws IOException {
        var path = Path.of(getBlogFilePathById(id));
        return Files.readString(path);
    }

    /**
     * Update a blog
     */
    public synchronized void updateBlogContent(int id, String content) throws IOException {
        var path = Path.of(getBlogFilePathById(id));
        if (Files.exists(path)) {
            removeBlogContent(id);
        }
        Files.createFile(path);
        Files.writeString(path, content, StandardCharsets.UTF_8);
    }

    /**
     * Remove a blog
     *
     * @param id the id of blog
     */
    public synchronized void removeBlogContent(int id) throws IOException {
        var path = getBlogFilePathById(id);
        Files.delete(Path.of(path));
    }
}
