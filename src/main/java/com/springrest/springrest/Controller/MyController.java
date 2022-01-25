package com.springrest.springrest.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entities.Course;
import com.springrest.springrest.services.CourseService;

//To know Springboot this is the controller class so have to add @RESTController
@RestController
public class MyController {
	//To know Sprintboot to get object of implement class using autowired
	@Autowired
	private CourseService courseservice;
	//To know Sprintboot what to call have to add methodtype and its name
	@GetMapping("/home")
	public String getMsg() {
		return "Welcome To Spring Controller";
		
	}
	//get the courses
	@GetMapping("/courses")
	public List<Course> getCourses()
	{
		return this.courseservice.getCourses();
		
	}
	@GetMapping("/courses/{courseId}")
	public Course getCourse(@PathVariable String courseId) {
		return this.courseservice.getCourse(Long.parseLong(courseId));
	}
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course) {
		return this.courseservice.addCourse(course);
		
	}
	
	@PutMapping("/courses")
	public Course updateCourse( @RequestBody Course course)
	{
		return this.courseservice.updateCourse(course);
	}
	
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<HttpStatus> delteCourse(@PathVariable String courseId)
	{
		//return this.courseservice.delteCourse(Long.parseLong(courseId));
		//Or
		try {
			this.courseservice.deleteCourse(Long.parseLong(courseId));
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
