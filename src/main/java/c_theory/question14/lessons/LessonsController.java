package c_theory.question14.lessons;

import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/lessons")
public class LessonsController {

    //todo for question 14 there are 4 assignments in total
    // Each person has to do only 1. So 2 person team has to do 2 different ones, 3 person - 3, 4 person - 4.
    // Make sure to commit under your user otherwise points won't count.
    // I didn't number these so you can pick your favorite

    //todo
    // You are creating a rest controller for lessons. Think page where you are looking at lessons like echo360.
    // You need to add necessary annotations and methods to this class.
    // This class should compile.
    // It should run successfully when moved to your application package.
    // Method body is not important and will not be graded.
    // Modifying other classes is unnecessary and will not be graded.

    //todo A add necessary annotations on the class

    //B create a method to query lessons (plural)
    Long DEFAULT_YEAR = 2020L;

    @GetMapping(value = {"", "/course/{courseId}", "/year", "/year/{year}", "/most-visited", "least-visited"})
    public List<Lesson> findAll(@PathVariable("courseId") Long courseId, @PathVariable("year") Long year) {
        if (year == null) {
            year = DEFAULT_YEAR;
        }
        return Collections.singletonList(new Lesson());
    }

    //C create a method to query single lesson
    @GetMapping("/{id}")
    public Lesson findById(@PathVariable("id") Long id) {
        return new Lesson();
    }

    //D create a method to save a lesson
    @PostMapping
    public Lesson create(@RequestBody Lesson lesson) {
        return lesson;
    }

    //E create a method to update a lesson
    @PutMapping("/{id}")
    public void update(@PathVariable("id") Long id, @RequestBody Lesson lesson) {
        ;
    }

    //F create a method to delete a lesson
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        ;
    }

    //G assuming each Lesson has students (one-to-many relation) create a method to query lesson's students
    @GetMapping("/{id}/students")
    public List<Student> findStudentsById(@PathVariable("id") Long id) {
        return Collections.singletonList(new Student());
    }

    //H create a method to update lesson's name (and nothing else)
    @PatchMapping("/{id}")
    public void partialUpdateName(@PathVariable("id") Long id, String newName) {
        ;
    }

    //G modify correct method to support searching lessons by course id while keeping original functionality

    //H modify correct method to support searching by year with default being current year (2020)
    // (you can ignore semesters or use year-semester string)


    //K modify correct method to order lessons
    // * by most visitors first
    // * by least visitors first
    // (you can assume that by default it searches by predefined lecturer's order)

}
