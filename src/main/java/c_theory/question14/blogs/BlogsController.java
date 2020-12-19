package c_theory.question14.blogs;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RequestMapping("blogs")
@RestController
public class BlogsController {

    //for question 14 there are 4 assignments in total
    // Each person has to do only 1. So 2 person team has to do 2 different ones, 3 person - 3, 4 person - 4.
    // Make sure to commit under your user otherwise points won't count.
    // I didn't number these so you can pick your favorite

    //
    // You are creating a rest controller for blogs. Think blog aggregator or blog collection.
    // You need to add necessary annotations and methods to this class.
    // This class should compile.
    // It should run successfully when moved to your application package.
    // Method body is not important and will not be graded.
    // Modifying other classes is unnecessary and will not be graded.

    //add necessary annotations on the class


    //B create a method to query blogs (plural)
    @GetMapping
    Page<Blog> getBlogs(@RequestParam(defaultValue = "1") Integer page,
                        @RequestParam(defaultValue = "20") Integer size,
                        @RequestParam(defaultValue = "views") String sortField,
                        @RequestParam(defaultValue = "DESC") Sort.Direction sortDirection) {
        //Default is to sort by views descending, to sort by time sortField has to be createTime (has to be
        // attached to Blog) and to sort ascending sortDirection has to be "ASC"
        //Should return a Page of Blogs
        return null;
    }

    //C create a method to query single blog
    @GetMapping("/{id}")
    public Blog getBlogById(@PathVariable Long id) {
        return new Blog();
    }

    //D create a method to save a new blog
    @PostMapping
    public Blog addBlog(@RequestBody Blog blog) {
        return new Blog();
    }

    //E create a method to update a bog
    @PutMapping("/{id}")
    public Blog updateBlog(@PathVariable Long id, @RequestBody Blog blog) {
        return new Blog();
    }

    //F create a method to delete a blog
    @DeleteMapping("{id}")
    public void deleteBlog(@PathVariable Long id) {
    }

    //G assuming each blog has only 1 author (one-to-one relation) create a method to query blog's author
    @GetMapping("/{id}/author")
    public Author getBlogAuthor(@PathVariable Long id) {
        return new Author();
    }

    //H create a method to update blog url (and nothing else)
    @PutMapping("/{id}/url")
    public Blog updateBlogUrl(@PathVariable Long id, @RequestBody String url) {
        return new Blog();
    }


    //I-J modify correct method to support pagination, pagination is done by page and size
    //add page (pagination starts at page 1)
    //add size (default page size is 20)

    //K modify correct method to order blogs
    // * by most recent first
    // * by least recent first
    // (you can assume that by default it searches by most popular first)

}
