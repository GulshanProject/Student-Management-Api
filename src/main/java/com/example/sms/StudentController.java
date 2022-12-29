package com.example.sms;


import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController   // tell the java application this api contain all end point
public class StudentController {

    HashMap<Integer, Student> studentDB = new HashMap<>();
    // Add user
@PostMapping("/add_student")
    public String addStudent(@RequestBody() Student student){

    // add to it db
    int key= student.id;
    studentDB.put(key,student);
    return "Student add successfully";
}
    // get student by id

    @GetMapping("get_student_by_id")
public Student getStudentById(@RequestParam("id") Integer id){
    return studentDB.get(id);
}

@GetMapping("get_by_path/{id}")

public Student getByPath(@PathVariable("id") Integer id){
    Student student= studentDB.get(id);

    return student;
}

    @GetMapping("/get_student_by_name")
    public Student getStudentByName(@RequestParam("name") String searchName){
   // interate over hashmap
    for(Student s: studentDB.values()){
        if(s.name.equals(searchName)){
   return s;
        }
    }
    // it means student name not found+
        return null;

    }




    // update student
    @PutMapping("/update_student")
    public Student updateStudent(@RequestBody() Student student){
    int key= student.id;
    studentDB.put(key,student);
    return student;
    }

    // delete student
    @DeleteMapping("/delete_student")
    public String deleteStudent(@RequestParam("id") Integer id){
          studentDB.remove(id);
          return "The Student has been remove successfully";
    }


}
