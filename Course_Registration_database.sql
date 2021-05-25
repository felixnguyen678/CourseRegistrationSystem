-- root / 12345
create database CourseRegistration;
use CourseRegistration;

create table account(
	username varchar(10) primary key,
    password varchar(10),
    account_name varchar(50)
);
create table class(
	class_id varchar(10) primary key,
    class_name varchar(50)
);
create table student(
	student_id varchar(10) primary key,
    password varchar(10),
    full_name varchar(20),
    gender int,
    birthday date,
    class_id varchar(10) references class(class_id)
);

create table subject(
	subject_id varchar(10) primary key,
    subject_name varchar(50),
    number_of_credit integer
);

create table semester(
	semester_id varchar(10) primary key,
    semester_name varchar(10),
    year int,
    first_day date,
    last_day date,
    is_current boolean
);
create table course_registration_session(
	semester_id varchar(10) primary key references semester(semester_id),
    fist_day date,
    last_day date
);

create table course(
	course_id varchar(10) primary key,
    subject_id varchar(10) references subject(subject_id),
    semester_id varchar(10) references semester(semester_id),
    classroom	varchar(10),
    weekday varchar(10),
    shift integer,
    maximum_number_of_slot integer
);

create table student_course(
	student_id varchar(10) references student(student_id),
	course_id varchar(10) references course(course_id),
    primary key (student_id, course_id)

);