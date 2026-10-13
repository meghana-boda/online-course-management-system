
package com.onlinecourse.coursemanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.onlinecourse.coursemanagement.entity.Course;
import com.onlinecourse.coursemanagement.entity.Enrollment;
import com.onlinecourse.coursemanagement.entity.User;
import com.onlinecourse.coursemanagement.repository.CourseRepository;
import com.onlinecourse.coursemanagement.repository.EnrollmentRepository;
import com.onlinecourse.coursemanagement.repository.UserRepository;

@Service
public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;

    public EnrollmentService(
            EnrollmentRepository enrollmentRepository,
            UserRepository userRepository,
            CourseRepository courseRepository) {

        this.enrollmentRepository = enrollmentRepository;
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
    }

    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }

    public Enrollment saveEnrollment(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }

    public Enrollment getEnrollmentById(Long id) {
        return enrollmentRepository.findById(id)
                .orElseThrow(() ->
                    new RuntimeException(
                        "Enrollment not found with id: " + id));
    }

    public Enrollment enrollUser(Long userId, Long courseId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                    new RuntimeException(
                        "User not found with id: " + userId));

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() ->
                    new RuntimeException(
                        "Course not found with id: " + courseId));

        Enrollment enrollment = new Enrollment();
        enrollment.setUser(user);
        enrollment.setCourse(course);

        return enrollmentRepository.save(enrollment);
    }

    public List<Enrollment> getEnrollmentsByUser(Long userId) {
        return enrollmentRepository.findByUserId(userId);
    }

    public List<Enrollment> getEnrollmentsByCourse(Long courseId) {
        return enrollmentRepository.findByCourseId(courseId);
    }

    public void deleteEnrollment(Long id) {
        if (!enrollmentRepository.existsById(id)) {
            throw new RuntimeException(
                    "Enrollment not found with id: " + id);
        }

        enrollmentRepository.deleteById(id);
    }
}
