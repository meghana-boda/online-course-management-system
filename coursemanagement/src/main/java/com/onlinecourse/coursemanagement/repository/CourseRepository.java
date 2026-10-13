package com.onlinecourse.coursemanagement.repository;

import com.onlinecourse.coursemanagement.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository
        extends JpaRepository<Course, Long>{

}
