package c_theory.question14.blogs;

import a_theory.question6.chocolate.Cake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogsService {

    //todo A add necessary annotations on the class
    @Autowired
    BlogsRepository blogsRepository;

    //todo B create a method to query blogs (plural)
    public List<Blog> getBlogs() {
        return blogsRepository.findAll();
    }

    //todo C create a method to query single blog
    public Blog getBlogById(Long id) {
        return null;
    }

    //todo D create a method to save a new blog
    public Blog addBlog(Blog blog) {
        return blog;
    }

    //todo E create a method to update a bog
    public Blog updateBlog(Blog blog) {
        return blog;
    }

    //todo F create a method to delete a blog
    public void deleteBlog() {

    }

    //todo G assuming each blog has only 1 author (one-to-one relation) create a method to query blog's author

    //todo H create a method to update blog url (and nothing else)
    public Blog updateBlogUrl(Blog blog, String url) {
        return blog;
    }

    //todo I-J modify correct method to support pagination, pagination is done by page and size
    //todo I add page (pagination starts at page 1)
    //todo J add size (default page size is 20)

    //todo K modify correct method to order blogs
    // * by most recent first
    // * by least recent first
    // (you can assume that by default it searches by most popular first)


}
