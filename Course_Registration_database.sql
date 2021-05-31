-- root / 12345
create database CourseRegistration;
use CourseRegistration;

create table account(
	username varchar(10) primary key,
    password varchar(10),
    account_name varchar(50),
    email varchar(20),
    phone_number varchar(20)
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
    email varchar(20),
    phone_number varchar(20),
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
    fist_day datetime,
    last_day datetime
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

create table registration(
    registration_id varchar(20) primary key ,
    student_id varchar(10) references student(student_id),
    course_id varchar(10) references course(course_id),
    registration_time datetime
);

insert into account values('root', '12345', 'Root User', 'root@gmail.com', '0862510512');
insert into account values('abc', '123', 'ABC User', 'abc@gmail.com', '0872510512');
insert into account values('giaovu', '123', 'Giáo vụ', 'giaovu@hcmus.edu.vn', '0898210512');

insert into class values('17CTT1', 'Công nghệ thông tin chính quy 1 khóa 17');
insert into class values('17CTT2', 'Công nghệ thông tin chính quy 2 khóa 17');
insert into class values('17CTT3', 'Công nghệ thông tin chính quy 3 khóa 17');
insert into class values('17CTTCN', 'Công nghệ thông tin cử nhân tài năng');
insert into class values('16CTT1', 'Công nghệ thông tin chính quy 1 khóa 16');

insert into subject values('NMCNPM', 'Nhập môn Công nghệ phần mềm',3);
insert into subject values('LTUDJ', 'Lập trình Ứng dụng Java',3);
insert into subject values('LTUDW', 'Lập trình Ứng dụng Web',4);
insert into subject values('LTUDM', 'Lập trình ứng dụng di động',4);
insert into subject values('NMBLCN', 'Nhập môn BlockChain',4);
insert into subject values('BDT', 'Dữ liệu lớn',4);
insert into subject values('MMT', 'Mạng máy tính',4);
insert into subject values('NOSQL', 'Cơ sở dữ liệu hiện đại',4);
insert into subject values('DB', 'Cơ sở dữ liệu',3);
insert into subject values('OOP', 'Lập trình hướng đối tượng',2);
insert into subject values('DTSC', 'Khoa học dữ liệu',4);
insert into subject values('LTNNPY', 'Lập trình ngôn ngữ Python',1);
insert into subject values('LTNNC', 'Lập trình ngôn ngữ C',1);
insert into subject values('LTNNSL', 'Lập trình ngôn ngữ Solidity', 1);
insert into subject values('CTDLGT', 'Cơ sở dữ liệu & Giải thuật', 5);

insert into student values('1710000', '12345', 'Sample Student', 1, '1999-12-5', '1710000@hcmus.edu.vn', '0862510512' ,'17CTT1');
