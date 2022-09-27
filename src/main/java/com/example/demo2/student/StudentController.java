package com.example.demo2.student;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {
    
    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @RequestMapping(value = "/getStudentsRep")
    public List<Student> getStudentsRep(){
        return studentService.getStudentsRep();
    }

    @RequestMapping(value = "/getStudents")
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @RequestMapping(value ="/getStudent2")
    public List<Student> getStudent2(){
        return studentService.getStudent2();
    }

    @RequestMapping(value = "/getStudent3",method=RequestMethod.GET)
    public List<Student> getStudent3(){
        return studentService.getStudent3();
    }
}
