package com.campusedu.devexercise;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReaderBuilder;

import org.springframework.boot.CommandLineRunner;

import java.io.FileReader;
import java.util.List;

//populates database with data from the csv file at runtime using opencsv

@Configuration
public class LoadDatabase {
    @Bean
    CommandLineRunner initDatabase(CourseDataRepository courseDataRepository) {
        return args -> {
            try {
                //Parsing csv file into readable format
                CSVParser csvParser = new CSVParserBuilder().withSeparator('\t').build();
                List<String[]> r = new CSVReaderBuilder(new FileReader("Course-Data.csv"))
                .withCSVParser(csvParser).build().readAll();
                
                int counter = 0;
                //Converting parsed arrays from csv into CourseData objects, then saving them in the database
                for (int i = 1; i < r.size(); i++) {
                    CourseData cd = CourseData.convertStringArray(r.get(i));
                    if (cd == null) counter += 1;
                    courseDataRepository.save(cd);
                }

                System.out.println(counter + " lines couldn't be converted");

            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        };
    }
}
