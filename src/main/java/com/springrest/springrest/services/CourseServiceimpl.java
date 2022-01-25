package com.springrest.springrest.services;

import java.util.ArrayList;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.Dao.CourseDao;
import com.springrest.springrest.entities.Course;
//To know this is service class
@Service
public class CourseServiceimpl implements CourseService {
	
	/*
	List<Course> list;
	public CourseServiceimpl()
	{
		list =new ArrayList<>();
		list.add(new Course(145,"Java Core","Basics of Java"));
		list.add(new Course(195,"Spring Boot","Basics of Spring"));
		
	}
	
	@Override
	public List<Course> getCourses() {

		return list;
	}

	
	@Override
	public Course getCourse(long courseId) {
		Course c=null;
		for(Course course:list)
		{
			if(course.getId()==courseId)
			{
				c=course;
				break;
			}
		}
		return c;
		
	}

	@Override
	public Course addCourse(Course course) {
		
		list.add(course);
		return course;
		
	}


	@Override
	public Course updateCourse(Course course) {
//		long cid=course.getId();
//			for(Course course1:list)
//			{
//				if(course1.getId()==cid)
//				{
//					int index = list.indexOf(course1);
//					list.set(index,course);
//				}
//			}
//			
			//Or
			list.forEach(e -> {
				if(e.getId()==course.getId()) {
					e.setTitle(course.getTitle());
					e.setDescription(course.getDescription());
				}
			});
		return course;
		
	}

	
	@Override
	public void deleteCourse(long courseId) {
//		for(Course course1:list)
//		{
//			if(course1.getId()==courseId)
//			{
//				int index = list.indexOf(course1);
//				list.remove(index);
//			}
//		}
//		//return course;
//		//return (Course) list;
//		return null;
//		
		//Or
		list=this.list.stream().filter(e -> e.getId()!=courseId).collect(Collectors.toList());
		//return null;
		
	}
	
	*/
	
	///To Update Data in DB
	
	
	@Autowired
	private CourseDao courseDao;

	public CourseServiceimpl()
	{

	}
	
	@Override
	public List<Course> getCourses() {
		return courseDao.findAll();
	}

	@SuppressWarnings("deprecation")
	@Override
	public Course getCourse(long courseId) {

		return courseDao.getOne(courseId);
	}

	@Override
	public Course addCourse(Course course) {
		
		courseDao.save(course);
		return course;
	}


	@Override
	public Course updateCourse(Course course) {

		courseDao.save(course);
		return course;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void deleteCourse(long courseId) {

		Course entity= courseDao.getOne(courseId);
		courseDao.delete(entity);
	}
	
	

}
