package com.campusedu.devexercise;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

//Creating this interface should allow us to perform CRUD operations on the CourseData database
public interface CourseDataRepository extends JpaRepository<CourseData, Long> {
    List<CourseData> findByCourseCodePrefix(Optional<String> courseCodePrefix);
    List<CourseData> findByCourseCodeNumber(Optional<Integer> courseCodeNumber);
    List<CourseData> findCourseDataByCourseCodeNumberAndCourseCodePrefix(Optional<Integer> courseCodeNumber,
     Optional<String> courseCodePrefix);
}
