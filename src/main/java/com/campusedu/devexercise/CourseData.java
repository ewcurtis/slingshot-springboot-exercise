package com.campusedu.devexercise;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CourseData {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    @Column(name="advising_requisite_code")
    private String advisingRequisiteCode;

    @Column (name = "core_literature_requirement", nullable = true)
    private String coreLiteratureRequirement;

    @Column (name="course_catalog_text", nullable = true)
    //Since this is a large field the @Lob annotation is being used to make the data smaller in the database
    @Lob
    private String courseCatalogText;

    @Column (name="course_code")
    private String courseCode;

    @Column (name="course_code_number")
    private int courseCodeNumber;

    @Column (name="course_code_prefix")
    private String courseCodePrefix;

    @Column (name="course_code_sanatized")
    private String courseCodeSanitized;

    @Column (name="course_fees")
    private int courseFees;

    @Column (name="course_title")
    private String courseTitle;

    @Column (name="default_credit_hours")
    private int defaultCreditHours;

    @Column (name="division_code")
    private String divisionCode;

    @Column (name="fee_type", nullable = true)
    private String feeType;

    @Column (name="fixed_variable_credit")
    private String fixedVariableCredit;

    @Column (name="max_credit_hours")
    private int maxCreditHours;

    @Column (name="min_credit_hours")
    private int minCreditHours;

    //Required no-arg constructor for JPA
    public CourseData() {};

    //constructor with all args
    public CourseData(String advisingRequisiteCode, String coreLiteratureRequirement, String courseCatalogText,
            String courseCode, int courseCodeNumber, String courseCodePrefix, String courseCodeSanitized, int courseFees,
            String courseTitle, int defaultCreditHours, String divisionCode, String feeType, String fixedVariableCredit,
            int maxCreditHours, int minCreditHours) {
        this.advisingRequisiteCode = advisingRequisiteCode;
        this.coreLiteratureRequirement = coreLiteratureRequirement;
        this.courseCatalogText = courseCatalogText;
        this.courseCode = courseCode;
        this.courseCodeNumber = courseCodeNumber;
        this.courseCodePrefix = courseCodePrefix;
        this.courseCodeSanitized = courseCodeSanitized;
        this.courseFees = courseFees;
        this.courseTitle = courseTitle;
        this.defaultCreditHours = defaultCreditHours;
        this.divisionCode = divisionCode;
        this.feeType = feeType;
        this.fixedVariableCredit = fixedVariableCredit;
        this.maxCreditHours = maxCreditHours;
        this.minCreditHours = minCreditHours;
    }

    //converts String[] array to a CourseData object
    public static CourseData convertStringArray(String[] str) {
        if (str.length != 15) return null;
        String advisingRequisiteCode = str[0];
        String coreLiteratureRequirement = str[1];
        String courseCatalogText = str[2];
        String courseCode = str[3];
        int courseCodeNumber = Integer.parseInt(str[4]);
        String courseCodePrefix = str[5];
        String courseCodeSanitized = str[6];
        int courseFees = Integer.parseInt(str[7]);
        String courseTitle = str[8];
        int defaultCreditHours = Integer.parseInt(str[9]);
        String divisionCode = str[10];
        String feeType = str[11];
        String fixedVariableCredit = str[12];
        int maxCreditHours = Integer.parseInt(str[13]);
        int minCreditHours = Integer.parseInt(str[14]);
        return new CourseData(advisingRequisiteCode, coreLiteratureRequirement, courseCatalogText,
        courseCode, courseCodeNumber, courseCodePrefix, courseCodeSanitized, courseFees, courseTitle, defaultCreditHours,
        divisionCode, feeType, fixedVariableCredit, maxCreditHours, minCreditHours);












    }
}
