drop table if exists CourseData;
CREATE TABLE CourseData (
    id int primary key auto_increment,
    advising_requisite_code varchar(25) NOT NULL,
    core_literature_requirement varchar(10),
    course_catalog_text varchar(65535),
    course_code varchar(25) NOT NULL,
    course_code_number int NOT NULL,
    course_code_prefix varchar(25) NOT NULL,
    course_code_sanitized varchar(25) NOT NULL,
    course_fees int NOT NULL,
    course_title varchar(255) NOT NULL,
    default_credit_hours int NOT NULL,
    division_code varchar(10) NOT NULL,
    fee_type varchar(10),
    fixed_variable_credit varchar(10) NOT NULL,
    max_credit_hours int NOT NULL,
    min_credit_hours int NOT NULL
);