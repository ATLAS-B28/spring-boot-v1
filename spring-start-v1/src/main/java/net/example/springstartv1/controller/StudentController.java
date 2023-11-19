package net.example.springstartv1.controller;

import net.example.springstartv1.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class StudentController {
    //returns a json bean to the client
    @GetMapping("/student-info")
    public ResponseEntity<Student> getStudent(){
        Student std = new Student(
                "John",
                "Doe",
                123456789
        );
        //return new ResponseEntity<>(std, HttpStatus.OK);
        //another method - return ResponseEntity.ok(std)
        return ResponseEntity.ok().header("custom-header", "custom-value").body(std);
    }

    //returns a list of students
    @GetMapping("/student-list")
    public List<Student> getStudentList(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(
                "Aditya",
                "Bhambere",
                123456889
        ));
        students.add(new Student(
                "John",
                "Doe",
                123456789
        ));
        students.add(new Student(
             "Abhijeet",
             "Bhambere",
             123456779
        ));
        return students;
    }

    //api with path variable
    //{id} - uri template variable allows dynamic path variables
    @GetMapping("/student-path-var/{id}")
    public ResponseEntity<Student> studentPathVar(@PathVariable("id") int studentId){
        //it is used on a method argument to bind it to the value
        //of a URI template variable
        Student std =  new Student("Aditya","Bhambere",studentId);
        return ResponseEntity.ok(std);
    }

    //request parameter
    //http://localhost:8080/api/v1/student-param?firstName=Abhijeet&lastName=Bhambere
    @GetMapping("/student-param")
    public Student studentParam(@RequestParam("firstName") String FirstName,
                                @RequestParam("lastName") String LastName){
        return new Student(FirstName,LastName,123456779);
    }

    //handling http post request
    // @PostMapping and @RequestBody
    @PostMapping("/student-post-info")
    @ResponseStatus(HttpStatus.CREATED)
    public Student studentPostInfo(
            @RequestBody Student std){
        //this annotation retrieves the http request body
        //and automatically converts it to java object
        System.out.println(std.getId());
        System.out.println(std.getFirstName());
        System.out.println(std.getLastName());
        return std;
    }

    //PutMapping - used to update a resource
    @PutMapping("/student-update/{id}/update")
    public Student updateStudent(@RequestBody Student std, @PathVariable("id") int id){
        System.out.println(std.getId());
        System.out.println(std.getFirstName());
        System.out.println(std.getLastName());
        return std;
    }

    //DeleteMapping - used to delete a resource
    @DeleteMapping("/student-delete/{id}")
    public String deleteStudent(@PathVariable("id") int id){
        System.out.println(id);
        return "Success";
    }
}
