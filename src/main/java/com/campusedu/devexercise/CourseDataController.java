package com.campusedu.devexercise;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@RestController
class CourseDataController {
    private final CourseDataRepository courseDataRepository;
    
    CourseDataController(CourseDataRepository courseDataRepository) {
        this.courseDataRepository = courseDataRepository;
    }
    @GetMapping("/CourseData")
    List<CourseData> all() {
        return courseDataRepository.findAll();
    }

    @PostMapping("/CourseData")
    CourseData newCourse(@RequestBody CourseData newCourseData) {
        return courseDataRepository.save(newCourseData);
    }

    //Retrieves data from CourseData table based on nullable course code number and course prefix parameters.
    @GetMapping("/CourseData/courseDataCode")
    List<CourseData> findCourseData( 
        @RequestParam (value="courseDataCodeNumber", required = false) Optional<Integer> courseDataCodeNumber, 
        @RequestParam (value = "courseDataPrefix", required = false) Optional<String> courseDataPrefix) {
        //If both paramaters are present
        if (courseDataCodeNumber.isPresent() && courseDataPrefix.isPresent()) {
            return courseDataRepository.findCourseDataByCourseCodeNumberAndCourseCodePrefix(courseDataCodeNumber,
         courseDataPrefix);
        //If only courseDataPrefix is present
        } else if (!courseDataCodeNumber.isPresent() && courseDataPrefix.isPresent()) {
            return courseDataRepository.findByCourseCodePrefix(courseDataPrefix);
        //If only courseDataCodeNumber is present
        } else if (courseDataCodeNumber.isPresent() && !courseDataPrefix.isPresent()) {
            return courseDataRepository.findByCourseCodeNumber(courseDataCodeNumber);
        }
        //If neither of the paramaters are present
        else {
            return courseDataRepository.findAll();
        }
        

    }
}
