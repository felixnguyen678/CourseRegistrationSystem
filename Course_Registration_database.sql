-- root / 12345
create database CourseRegistration;
use CourseRegistration;

create table account(
	username varchar(10) primary key,
    password varchar(10),
    account_name varchar(50),
    email varchar(50),
    phone_number varchar(50)
);
create table class(
	class_id varchar(10) primary key,
    class_name varchar(50)
);

create table student(
	student_id varchar(10) primary key,
    password varchar(10),
    full_name varchar(50),
    gender int,
    birthday date,
    email varchar(50),
    phone_number varchar(50),
    class_id varchar(10) references class(class_id)
);

create table subject(
	subject_id varchar(10) primary key,
    subject_name varchar(50),
    number_of_credit integer
);

create table semester(
	semester_id varchar(10) primary key,
    semester_name varchar(50),
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
    teacher_name varchar(50),
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
truncate table registration;

-- ADD DATA

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


insert into semester values('2020-1', 'HK1', 2020, '2020-8-1', '2021-1-18', true);
insert into semester values('2019-3', 'HK3', 2019, '2020-6-1', '2020-8-27', false);

insert into student values('1710000', '12345', 'Sample Student', 1, '1999-12-5', '1710000@hcmus.edu.vn', '0862510512' ,'17CTT1');
insert into student values('1610000', 'Gp#8iIYd+_', 'Jacob Bradley', 1 , '1988-12-22', 'dalvarado@walker-clements.com', '065-468-6133', '16CTT1' );
insert into student values('1610001', 'n*9Su#YYLv', 'Breanna Perry', 1 , '2000-11-12', 'curtisrobert@hotmail.com', '(764)327-6458', '16CTT1' );
insert into student values('1610002', '_zj6Hxglz6', 'Brian Solomon', 1 , '2014-05-19', 'wglenn@smith-meyer.biz', '+1-054-322-6681', '16CTT1' );
insert into student values('1610003', '@fxeW#A^)9', 'Ryan Hartman', 1 , '1978-03-22', 'hgarcia@vincent.com', '(161)503-1036', '16CTT1' );
insert into student values('1610004', 'UX60J)gwk@', 'Lori Green', 0 , '1995-04-04', 'gjohnston@gmail.com', '715.741.4902', '16CTT1' );
insert into student values('1610005', 'bFuM7$7xR*', 'Alexander Hoffman', 1 , '1984-10-12', 'rachaelmoore@gmail.com', '5044157758', '16CTT1' );
insert into student values('1610006', 'Q#r2Xiluc^', 'Jacob Rogers', 0 , '2011-02-22', 'mcdonaldgina@gmail.com', '615-146-9535x47662', '16CTT1' );
insert into student values('1610007', '#%VY1TNoo0', 'Edward Aguilar', 1 , '2016-03-15', 'douglas65@brown-wells.info', '604-020-0888x7705', '16CTT1' );
insert into student values('1610008', 'RX9^IWzP*E', 'Rebecca Reynolds', 1 , '1977-10-29', 'rossyolanda@yahoo.com', '280-076-6549x032', '16CTT1' );
insert into student values('1610009', '+4d+oT^fkm', 'Joshua Phillips', 0 , '1974-08-09', 'isabellawilliams@yahoo.com', '+1-727-410-8378x990', '16CTT1' );
insert into student values('1610010', '198WgapN@2', 'Mallory Anderson', 0 , '2014-11-27', 'chambersmelissa@martin.com', '086-891-3595x557', '16CTT1' );
insert into student values('1610011', '@2!Ei%*3^y', 'Edward Castillo', 0 , '2013-10-19', 'singhjohn@williams.com', '042.714.6289', '16CTT1' );
insert into student values('1610012', ')W2CLnAaqW', 'Benjamin Valencia', 1 , '1980-01-27', 'katherinecoleman@wilkinson.com', '165-308-1165', '16CTT1' );
insert into student values('1610013', 't%1YOanz0P', 'Jennifer Rodriguez', 1 , '1998-11-19', 'cynthia08@gmail.com', '(617)558-0493x337', '16CTT1' );
insert into student values('1610014', ')HV5GtL38F', 'Valerie Gray', 1 , '1991-11-30', 'cfreeman@andrews-riley.com', '+1-855-416-9261', '16CTT1' );
insert into student values('1610015', '9J4yAwNy(P', 'Mr. Logan Duarte', 1 , '2013-09-19', 'zachary32@yahoo.com', '(808)612-3598x4175', '16CTT1' );
insert into student values('1610016', '$aWj*2JaF5', 'Robert Shannon', 0 , '1999-11-17', 'jeffrey74@yahoo.com', '617.133.9265', '16CTT1' );
insert into student values('1610017', '*G3aT2n#2p', 'Terri Rivera', 0 , '2018-11-11', 'amyhanson@hudson.info', '034-385-9753x39287', '16CTT1' );
insert into student values('1610018', '_RUpad7jk1', 'Mary Olson', 0 , '1971-01-30', 'michele58@hotmail.com', '(325)690-9936', '16CTT1' );
insert into student values('1610019', '48J$+fBj!F', 'Terri Davis', 0 , '1995-10-25', 'campbellmegan@long-williams.biz', '+1-161-010-7783x290', '16CTT1' );
insert into student values('1610020', '@R(2XGuYZx', 'Gabrielle Sanchez', 1 , '1983-04-05', 'nshepard@brooks.com', '313.000.4400x674', '16CTT1' );
insert into student values('1610021', 'c59hFNt(#h', 'Nicole Wright', 1 , '1991-03-27', 'levyjames@matthews-cantu.com', '(010)845-0044x28703', '16CTT1' );
insert into student values('1610022', 'KT#2NafxuW', 'Dr. Eric Leonard', 0 , '1983-09-27', 'stephanie90@rhodes.biz', '600-748-2432x455', '16CTT1' );
insert into student values('1610023', 'u(jS6G!gF$', 'Jason Crosby', 1 , '1995-04-02', 'swansonthomas@hudson.com', '217-267-5496x59929', '16CTT1' );
insert into student values('1610024', '_bytoLm2A0', 'Xavier Greene', 1 , '1994-01-16', 'ronald55@hotmail.com', '+1-194-155-5696x8021', '16CTT1' );
insert into student values('1610025', 'A_B74%Wl&M', 'Patrick Williams', 1 , '1994-02-07', 'jcollins@powell.biz', '+1-071-876-357734', '16CTT1' );
insert into student values('1610026', '!4LT$MiecQ', 'Adrian Johnson', 1 , '1996-05-25', 'pamelalawson@pena.org', '864.671.2322x27538', '16CTT1' );
insert into student values('1610027', 'z)6jUuBeRY', 'Jeffrey West', 1 , '1998-08-17', 'jonathanmoore@nelson.biz', '+1-111-631-8677', '16CTT1' );
insert into student values('1610028', 'JYO#1W1n_w', 'Donald Ramos', 1 , '1973-06-11', 'susan56@mccormick.com', '926.225.7028x768', '16CTT1' );
insert into student values('1610029', ')4YsaJMWN%', 'Michael Smith', 0 , '2003-03-26', 'benjamin00@lopez-zamora.info', '1785712538', '16CTT1' );
insert into student values('1610030', ')0@rzKz#Cs', 'Brittany Diaz', 1 , '1988-12-14', 'juan36@morgan.com', '(221)602-7835x39009', '16CTT1' );
insert into student values('1610031', 'x_O(2RmG9c', 'Stacy Jones', 1 , '2012-03-01', 'clucas@gmail.com', '1416372210', '16CTT1' );
insert into student values('1610032', '(4Q(&FkF_@', 'Mary Obrien', 1 , '1981-09-03', 'larsenalexandra@sullivan.com', '001-982-426-6981x232', '16CTT1' );
insert into student values('1610033', 'NQ*@7ROz^K', 'Kathy Miller', 1 , '1987-08-14', 'leah15@yahoo.com', '(236)457-6979x0205', '16CTT1' );
insert into student values('1610034', 'T&7kKg&^DG', 'Michael Wright', 0 , '1980-03-08', 'harrispamela@hotmail.com', '735-029-4169', '16CTT1' );
insert into student values('1610035', 'j(0e8Tez+i', 'Rodney Boyer', 1 , '2014-04-21', 'mschmidt@williams.biz', '1255973722', '16CTT1' );
insert into student values('1610036', 's0C3Odnpx)', 'James Little', 0 , '2007-10-18', 'bchaney@walker-rubio.com', '+1-387-835-507429', '16CTT1' );
insert into student values('1610037', '+xWBOK(j7J', 'Mark Strickland', 1 , '2001-10-30', 'jacksonsamantha@hotmail.com', '(399)808-7492x746', '16CTT1' );
insert into student values('1610038', 'S@9yk2leWZ', 'Ricardo Stephenson', 0 , '2012-10-15', 'crystal02@yahoo.com', '830-579-5861', '16CTT1' );
insert into student values('1610039', 'g*6y1f@cAS', 'Maria Romero', 1 , '1999-11-14', 'ymcmahon@yahoo.com', '328-549-2507x41853', '16CTT1' );
insert into student values('1610040', 'z36HBO*lt!', 'Eric Webb', 0 , '1972-05-17', 'ashleymiller@hill-medina.info', '2968906060', '16CTT1' );
insert into student values('1610041', 'bE@hm7Fxqh', 'Heather Schultz', 1 , '2016-04-14', 'krystal35@gmail.com', '932-945-2220', '16CTT1' );
insert into student values('1610042', '@53rL7za4#', 'Arthur Navarro', 1 , '1989-02-09', 'ryangonzalez@yahoo.com', '(253)804-4385x7966', '16CTT1' );
insert into student values('1610043', '_038OTjm$a', 'Melissa Morgan', 1 , '1971-12-13', 'hjohnson@frye-ramirez.org', '+1-045-852-82324', '16CTT1' );
insert into student values('1610044', 'i@O6UYunW_', 'Joshua Luna', 0 , '2012-12-01', 'stephen87@petersen.info', '+1-301-530-1888', '16CTT1' );
insert into student values('1610045', '(9SDIpro*2', 'Mary Patterson', 0 , '2014-02-06', 'ravila@adams.com', '406-976-9677', '16CTT1' );
insert into student values('1610046', 'GaM2qEuC@6', 'Samuel Moreno', 0 , '1993-03-15', 'williamsdebra@webb-levine.biz', '(245)692-0335x00892', '16CTT1' );
insert into student values('1610047', 'REDod_0aI&', 'Jon Mccarty', 1 , '1981-08-24', 'jamesmendoza@ryan-rogers.com', '079-234-9620x76938', '16CTT1' );
insert into student values('1610048', 'o6Ngf5$U+1', 'Miranda Davis', 0 , '1998-11-12', 'bpearson@montes.net', '999-445-7342x7844', '16CTT1' );
insert into student values('1610049', 'G%16wBern+', 'Richard Parsons', 0 , '2019-07-30', 'williamslaura@hood.com', '001-527-493-4135', '16CTT1' );
insert into student values('1610050', '$2sEMVxxn)', 'Kathryn Walker', 0 , '1977-10-07', 'lmahoney@schmitt.com', '(598)765-8799', '16CTT1' );
insert into student values('1610051', '!LiHVJVfx3', 'Nicole Carney', 1 , '1979-04-12', 'gharris@santana.biz', '(095)720-1176', '16CTT1' );
insert into student values('1610052', '@9aBFaow)g', 'Jeremy Woods', 1 , '1991-11-17', 'david14@hotmail.com', '001-499-966-2782x037', '16CTT1' );
insert into student values('1610053', 'NTKE10_aE!', 'Anthony Leon', 1 , '2013-01-01', 'prattwalter@yahoo.com', '+1-832-789-1424x913', '16CTT1' );
insert into student values('1610054', 'PqIlzjIv&2', 'Jean Dean', 1 , '1990-10-14', 'fclark@rodriguez.biz', '(823)185-9120x196', '16CTT1' );
insert into student values('1610055', 'Q!1PergI8e', 'Adam Garcia', 0 , '1984-01-13', 'kellykaitlyn@yahoo.com', '954-519-3629', '16CTT1' );
insert into student values('1610056', '8IGwQTbN_p', 'Earl Jacobson', 1 , '2000-11-08', 'lisatodd@gmail.com', '(218)003-0521', '16CTT1' );
insert into student values('1610057', '&0I0#QjthM', 'Charles Wilson', 0 , '1980-11-06', 'georgeperkins@hunter-park.biz', '+1-178-350-7953x138', '16CTT1' );
insert into student values('1610058', '3uDRtHk0*q', 'Travis Ortega', 0 , '2020-06-01', 'ibright@yahoo.com', '+1-219-730-8724x4342', '16CTT1' );
insert into student values('1610059', 'q2Vfy^EW+)', 'Shawn Molina', 0 , '2014-12-24', 'zsalinas@yahoo.com', '705.274.5881x027', '16CTT1' );
insert into student values('1610060', '@yKcC0AhMa', 'John Mercado', 0 , '1993-09-22', 'bonnie28@sanchez.com', '001-916-762-6459x265', '16CTT1' );
insert into student values('1610061', '$yw@RVdF_1', 'Timothy Thompson', 1 , '1972-03-01', 'ebell@monroe.com', '+1-781-187-578474', '16CTT1' );
insert into student values('1610062', 'r+0(aGx_SE', 'Felicia Clements', 0 , '2019-10-07', 'johnhamilton@yahoo.com', '191-398-3542', '16CTT1' );
insert into student values('1610063', 's9obS+se^j', 'Christopher Wood', 1 , '1980-11-05', 'larry02@ortiz-jones.biz', '001-080-849-5518x32438', '16CTT1' );
insert into student values('1610064', 'vx19UhQg!0', 'Charles Patel', 1 , '1980-03-29', 'steinvanessa@yahoo.com', '415-8816x11363', '16CTT1' );
insert into student values('1610065', '3h1*cRIBG%', 'Nathan Garcia', 1 , '2000-07-26', 'kimberlynorman@sosa-contreras.info', '894-151-8334x33187', '16CTT1' );
insert into student values('1610066', 'i#@1HL_wRX', 'Neil Gordon', 0 , '1990-10-14', 'mariataylor@hotmail.com', '001-701-846-4984x819', '16CTT1' );
insert into student values('1610067', 'z^6PPxo$Pd', 'Ronald Smith', 1 , '1997-05-28', 'monique54@austin.com', '(984)678-9886x919', '16CTT1' );
insert into student values('1610068', '^bwGPiK6C7', 'Joshua Martinez', 1 , '1992-03-02', 'joshuanewman@yahoo.com', '9992811491', '16CTT1' );
insert into student values('1610069', 'G9&sSqHM^t', 'Christopher Ramirez', 0 , '2002-06-25', 'webbbrittany@hotmail.com', '047.153.2551x625', '16CTT1' );
insert into student values('1610070', 'y1^fUKNo$M', 'Mark Hernandez', 1 , '2019-05-31', 'lindsey13@donovan.com', '+1-597-027-8286x96820', '16CTT1' );
insert into student values('1610071', '@u5NxGBcPm', 'Michael Salinas', 0 , '1994-12-21', 'awalters@anderson-walter.com', '001-823-442-4257x667', '16CTT1' );
insert into student values('1610072', 'o20Gr9E&)*', 'Jessica Allen', 1 , '1987-04-15', 'christopherwade@jones-foster.com', '6332963171', '16CTT1' );
insert into student values('1610073', '!9B$QJvzu2', 'Phillip Hall', 0 , '1985-04-10', 'juarezrichard@sullivan-stewart.com', '(555)485-8296x8656', '16CTT1' );
insert into student values('1610074', '^ESIyy(40F', 'Steven Ford', 0 , '2000-07-01', 'pjohnson@gmail.com', '+1-535-717-4584x786', '16CTT1' );
insert into student values('1610075', '6v%E@O95#A', 'Amy Wilson', 0 , '2003-04-22', 'millermarcus@ramirez.net', '+1-643-278-3002x667', '16CTT1' );
insert into student values('1610076', '!5HavdVRRl', 'Joseph Robinson', 1 , '2010-03-28', 'williamstrong@mccoy.org', '001-614-578-5664x933', '16CTT1' );
insert into student values('1610077', 'E!84Qp*A9U', 'Dennis Zimmerman', 1 , '1993-04-05', 'cfleming@larsen-grant.com', '506-073-6767x404', '16CTT1' );
insert into student values('1610078', '+NWXe0YU2c', 'Adam Anderson', 1 , '1988-11-09', 'april29@yahoo.com', '740-335-4362', '16CTT1' );
insert into student values('1610079', '*1NwWjPVGq', 'Brandy Nguyen', 0 , '2006-03-27', 'vscott@yahoo.com', '(139)471-3506x524', '16CTT1' );
insert into student values('1610080', '(Y6&sJpu32', 'Kathleen Coleman', 1 , '1991-12-09', 'davidjohnson@yahoo.com', '001-073-888-0295x26274', '16CTT1' );
insert into student values('1610081', '#3!b*To$ez', 'Daniel Olson', 0 , '2018-07-07', 'robert03@gmail.com', '+1-861-684-3290x3888', '16CTT1' );
insert into student values('1610082', '0Q7l^y1a2%', 'Sandra Ingram', 1 , '1998-05-28', 'pyoung@green.com', '010.927.9207x2500', '16CTT1' );
insert into student values('1610083', 'jH)%3CJgCC', 'Kevin Briggs', 0 , '1998-07-20', 'goodmichael@tanner.org', '001-766-150-5665x059', '16CTT1' );
insert into student values('1610084', '(Rlg+9Guui', 'Ian Washington', 0 , '2017-10-15', 'stephaniefuentes@harvey.info', '508.067.0189', '16CTT1' );
insert into student values('1610085', 'YnCpSWwq+3', 'John Zamora', 0 , '2001-08-09', 'martinmelissa@boyer.com', '001-713-058-0914', '16CTT1' );
insert into student values('1610086', 'q(9tYa3pkK', 'Veronica Chung', 0 , '1990-10-10', 'dodsonpatrick@gmail.com', '193.937.4119x0302', '16CTT1' );
insert into student values('1610087', '#2QCJ!o5n9', 'Edward Hall', 1 , '1982-12-29', 'misty55@hotmail.com', '255.862.4927x058', '16CTT1' );
insert into student values('1610088', '(97w$O$dmZ', 'Marilyn Collins', 1 , '2020-05-04', 'jessica44@brown.net', '(969)007-0598x7308', '16CTT1' );
insert into student values('1610089', '&7GpMkNIHW', 'Amanda Griffith', 0 , '1989-05-23', 'jjohnson@hotmail.com', '+1-566-518-3083x0651', '16CTT1' );
insert into student values('1610090', 'i2GNR2D%^4', 'Lisa Dean', 1 , '1978-11-04', 'alisonsampson@gmail.com', '+1-724-165-7798x4536', '16CTT1' );
insert into student values('1610091', 'Ke)#w1VfAd', 'Joseph Edwards', 0 , '2011-04-20', 'xmyers@yahoo.com', '8874082510', '16CTT1' );
insert into student values('1610092', '&oY0Npxc7L', 'Karen Smith', 1 , '1975-07-05', 'bassrichard@berry-may.com', '+1-876-577-2693x6580', '16CTT1' );
insert into student values('1610093', 'w$3$L7ZKZr', 'Jacqueline Hernandez', 1 , '2016-08-30', 'nicolehayes@alvarez.com', '600-858-8543x5223', '16CTT1' );
insert into student values('1610094', '3OejL6Oz+W', 'Sarah Deleon', 0 , '1977-11-10', 'milleramber@young.com', '+1-273-438-5700x4832', '16CTT1' );
insert into student values('1610095', 'g9iSvCtn%k', 'Kevin Nelson', 1 , '2019-08-07', 'cmorris@yahoo.com', '(584)729-5991x9003', '16CTT1' );
insert into student values('1610096', 'kN)6qEsy+%', 'Patrick Park', 1 , '1971-12-07', 'sarafoley@marks.com', '921-238-3453', '16CTT1' );
insert into student values('1610097', '8LM)yBJd_s', 'Diamond Griffith', 1 , '2015-03-20', 'monicaburns@smith.com', '184.013.1910', '16CTT1' );
insert into student values('1610098', 'L^388fIi!D', 'Beverly Phillips', 1 , '1977-09-03', 'rhonda41@moore.org', '627.639.9259x36080', '16CTT1' );
insert into student values('1610099', 'WSn2VSWc*N', 'John Scott', 0 , '1976-06-07', 'johnstongregory@yahoo.com', '720-919-2280x145', '16CTT1' );
insert into student values('1610100', '@4pYH6v1T3', 'Robert Contreras DDS', 1 , '2005-01-27', 'beth79@hotmail.com', '899.576.2144x2876', '16CTT1' );
insert into student values('1710101', '!K1MOW6a7H', 'Christopher Robbins', 1 , '1976-12-13', 'eespinoza@lester.com', '3387913511', '17CTT1' );
insert into student values('1710102', '(!3(GOIhzn', 'Erika Williams', 1 , '2004-02-20', 'garrett53@stevenson-morris.info', '+1-074-392-8944', '17CTT1' );
insert into student values('1710103', '()53)AGwEm', 'Jessica Garner', 1 , '1974-12-07', 'monica13@lopez-norris.com', '+1-692-921-4514x0029', '17CTT1' );
insert into student values('1710104', '$*z6hYYrk&', 'Beverly Howard', 0 , '1984-01-20', 'philipunderwood@gmail.com', '001-019-257-4904', '17CTT1' );
insert into student values('1710105', 'X5DaS(7s^(', 'Kimberly Acosta', 1 , '1971-04-02', 'mbennett@gmail.com', '001-456-939-9254x44942', '17CTT1' );
insert into student values('1710106', 'W%Gdx3%gsT', 'Michael Webb', 0 , '2014-01-31', 'monicaaguirre@gmail.com', '+1-919-181-7346x60934', '17CTT1' );
insert into student values('1710107', '3dbE0CwI%A', 'Dr. Thomas Atkinson', 1 , '1977-02-08', 'wendy34@henry.com', '897.817.2933', '17CTT1' );
insert into student values('1710108', 'prEjFuCp&7', 'William Jordan', 1 , '2006-07-17', 'kylewilliams@gmail.com', '(481)576-4443x839', '17CTT1' );
insert into student values('1710109', '0nH4JqiK7#', 'Jonathan Murphy', 1 , '1982-05-23', 'jimmyvelazquez@sullivan.com', '8572946575', '17CTT1' );
insert into student values('1710110', 'k86Raupkc&', 'Austin Sims', 0 , '1996-06-24', 'nathan91@gmail.com', '483-076-0631x24864', '17CTT1' );
insert into student values('1710111', '*8^S2Xm&5I', 'Jason Snyder', 0 , '2009-04-04', 'anthony76@yahoo.com', '1044011277', '17CTT1' );
insert into student values('1710112', ')sh4HwT9A6', 'Adam Cooley', 1 , '2003-11-04', 'kevin10@hotmail.com', '+1-860-040-9867x08746', '17CTT1' );
insert into student values('1710113', '*&31(SgF9(', 'Edwin Williams', 1 , '2015-06-03', 'achang@ramirez.org', '(918)666-0823x55555', '17CTT1' );
insert into student values('1710114', '&*GyH6_^p7', 'David Wood', 0 , '2018-04-02', 'donnapalmer@baker.biz', '(835)006-8945x0328', '17CTT1' );
insert into student values('1710115', 'j$Z7cDe%iq', 'Steven Ortiz', 0 , '1973-02-21', 'fsalazar@raymond-turner.com', '+1-740-523-4848', '17CTT1' );
insert into student values('1710116', '2jb*VTGp%1', 'Emily Burke', 1 , '2012-09-05', 'christopherbrown@meyers.com', '695-905-2028', '17CTT1' );
insert into student values('1710117', '&@6i^eDm#+', 'Sara Bernard', 1 , '2020-01-22', 'hcraig@smith.com', '847.345.1907x5480', '17CTT1' );
insert into student values('1710118', '+DBU@a4M!3', 'Danielle Stark', 1 , '2007-04-17', 'hernandezstephanie@yahoo.com', '+1-007-055-9030x528', '17CTT1' );
insert into student values('1710119', 'jb8MR!vKU_', 'James Martinez', 1 , '2008-08-26', 'richard45@yahoo.com', '8987973807', '17CTT1' );
insert into student values('1710120', '%x8I7WbdmG', 'Alexis Wilson', 1 , '2002-08-10', 'morrissteven@hotmail.com', '001-139-907-0399x4186', '17CTT1' );
insert into student values('1710121', 'p41YVjiv_c', 'Maria Gibson', 0 , '1981-01-05', 'melissatodd@martin.net', '095-930-2333x00945', '17CTT1' );
insert into student values('1710122', '*f26qcAk%8', 'Melissa Horton', 0 , '2004-06-29', 'gregory06@gmail.com', '001-573-979-8369x6681', '17CTT1' );
insert into student values('1710123', '!2DITdjbAa', 'Marissa Miller', 1 , '1972-08-29', 'fredray@brown-smith.com', '+1-020-533-8535', '17CTT1' );
insert into student values('1710124', 'zF9B5Pwd!9', 'Cynthia Jackson', 1 , '2002-08-07', 'jasonellis@yahoo.com', '(161)677-8665x283', '17CTT1' );
insert into student values('1710125', '%fYBU3MqH$', 'Casey Smith', 1 , '1976-09-12', 'evansbailey@lewis.info', '(533)685-7752x3683', '17CTT1' );
insert into student values('1710126', '_G9YM+%v7x', 'Ryan Peters', 1 , '1987-12-11', 'curtis20@gmail.com', '771.821.3792', '17CTT1' );
insert into student values('1710127', '(E&x3RMf_L', 'Matthew Hardy', 1 , '1970-05-31', 'hbrown@conway-morgan.biz', '(879)378-9653x4211', '17CTT1' );
insert into student values('1710128', '0@F_HVTxp5', 'Christian Norris', 0 , '1995-05-12', 'taylor28@yahoo.com', '3315368790', '17CTT1' );
insert into student values('1710129', 'w2M_eDNy)q', 'Kelly Callahan', 0 , '1986-02-04', 'timothy29@gmail.com', '+1-841-192-3564x5392', '17CTT1' );
insert into student values('1710130', 'Fn8ytIa50#', 'Katherine Reyes', 0 , '2009-11-02', 'jacquelinesmith@gmail.com', '9025934798', '17CTT1' );
insert into student values('1710131', 'q2EQZsTe^9', 'Richard Harrington', 1 , '2011-07-11', 'gonzalezkevin@gmail.com', '335-977-3973x63992', '17CTT1' );
insert into student values('1710132', '2U!9KAWjuk', 'Lisa Bradley', 0 , '1993-10-22', 'munozalexa@ward-fowler.com', '001-145-885-9605x4934', '17CTT1' );
insert into student values('1710133', 'rGFI@&Je_9', 'Jenny Hernandez', 0 , '1985-09-12', 'wagnerdustin@gmail.com', '+1-955-378-2761x438', '17CTT1' );
insert into student values('1710134', '3EViNvmQ(V', 'Mark Castillo', 1 , '1971-03-09', 'ariley@clark.info', '233.717.6912x349', '17CTT1' );
insert into student values('1710135', 'l!J04xD@Bt', 'Amanda Marshall', 0 , '2013-08-27', 'mlewis@garcia.net', '877-771-9373x80784', '17CTT1' );
insert into student values('1710136', '41G(X1Lw+p', 'Diane Harper', 1 , '2002-04-18', 'qandrews@jones.org', '(293)384-4954', '17CTT1' );
insert into student values('1710137', 'o3&lNq$k)W', 'Justin Turner', 1 , '2002-11-29', 'monicaharrell@white.com', '+1-342-994-1390x9831', '17CTT1' );
insert into student values('1710138', 'H(Yu3TaO58', 'Jillian Johnson', 1 , '1989-06-12', 'darrellnorris@gmail.com', '449.766.2715x178', '17CTT1' );
insert into student values('1710139', '@T3JX&wz6V', 'Luis Moore', 0 , '1979-08-29', 'wyattkristi@lyons.com', '909.993.2042x1101', '17CTT1' );
insert into student values('1710140', 'vEmjnmKt@6', 'John Cook', 1 , '2015-03-04', 'moralesrichard@gmail.com', '+1-916-578-7488x49294', '17CTT1' );
insert into student values('1710141', '^nz1_MYp80', 'Craig Hopkins', 1 , '2016-10-14', 'kevin03@gmail.com', '4299942434', '17CTT1' );
insert into student values('1710142', '(!2PgQqg9(', 'Antonio Summers', 0 , '1993-01-02', 'longsusan@yahoo.com', '428-719-7602x287', '17CTT1' );
insert into student values('1710143', '^_Rq8QGj+J', 'Devon Flores', 0 , '2003-08-17', 'rodriguezrobert@gmail.com', '+1-534-403-1548x2504', '17CTT1' );
insert into student values('1710144', '%6tDptX+oi', 'Jason Mills', 0 , '1990-10-05', 'thomasjeffrey@gmail.com', '001-462-707-5241x55856', '17CTT1' );
insert into student values('1710145', '&L*6QHObry', 'Anthony Ramirez', 0 , '2019-08-29', 'kimroy@robinson-herrera.org', '(990)898-5341', '17CTT1' );
insert into student values('1710146', 'S+3AVwnfuA', 'Erica Johnson', 1 , '1991-05-27', 'davisryan@morris.com', '404-003-8505x459', '17CTT1' );
insert into student values('1710147', '@iz9RsaZGk', 'Jennifer Smith', 0 , '2012-11-21', 'frollins@gmail.com', '001-917-305-0602', '17CTT1' );
insert into student values('1710148', '&2WdVpQ5q_', 'Alexandria Huff', 0 , '1980-05-12', 'dsmith@johnson-warren.org', '4944716796', '17CTT1' );
insert into student values('1710149', 'v^0XXn0zj*', 'Rebecca Vazquez', 1 , '1988-10-13', 'robert25@hotmail.com', '966-957-7177', '17CTT1' );
insert into student values('1710150', 'Qd2KvfYu(b', 'Monica Page', 0 , '1999-06-27', 'yesenia84@hotmail.com', '490.797.1344', '17CTT1' );
insert into student values('1710151', 'esdmLX#L+5', 'Zachary Lindsey', 1 , '1973-02-21', 'ogibson@gmail.com', '560-114-1236', '17CTT1' );
insert into student values('1710152', '^hPf9zEJX8', 'Chelsea Park', 1 , '1987-12-27', 'elizabethrodriguez@gmail.com', '(259)708-0135x83863', '17CTT1' );
insert into student values('1710153', '@fHe*ATke5', 'Kristin Nguyen', 1 , '1985-08-16', 'gonzalestheresa@gmail.com', '467.211.8986', '17CTT1' );
insert into student values('1710154', '0@$G5ZlhA_', 'Christine Simon', 1 , '1993-03-05', 'alyssathomas@murphy.com', '+1-104-343-0152', '17CTT1' );
insert into student values('1710155', '!g3*9DquRF', 'Lisa Ballard', 0 , '2007-08-14', 'louisdrake@yahoo.com', '001-993-322-4624x90085', '17CTT1' );
insert into student values('1710156', 'nmcC@lE8@9', 'Angela Adams', 1 , '1981-08-18', 'kmayer@gmail.com', '001-531-667-3257x52826', '17CTT1' );
insert into student values('1710157', 'Jc&IcW1J&9', 'Phillip White', 1 , '1985-11-24', 'wilsonsteve@yahoo.com', '+1-151-961-6149x5184', '17CTT1' );
insert into student values('1710158', 'o!Q4TsjWW7', 'Sarah Norton', 0 , '1983-12-19', 'wolfmanuel@powers.com', '001-968-389-5224', '17CTT1' );
insert into student values('1710159', '@1F$Uq*zZ8', 'Katie Russell', 0 , '1973-05-27', 'millerstephanie@moore.com', '790-281-4152x894', '17CTT1' );
insert into student values('1710160', 'o%4BGFpFQk', 'Connie Nelson', 1 , '1989-09-17', 'qcooper@hotmail.com', '0638214578', '17CTT1' );
insert into student values('1710161', 'fIFZv7Fo_%', 'Brian Carter', 1 , '1974-12-24', 'ehartman@peterson.com', '976-383-6892', '17CTT1' );
insert into student values('1710162', 'a1s6%fJX)N', 'Shannon Curry', 1 , '1998-03-30', 'patrickwilliams@gmail.com', '317-501-8580', '17CTT1' );
insert into student values('1710163', '%XGt(ymY%5', 'Karen Burton', 1 , '2010-10-17', 'lking@smith.net', '636-563-6585x838', '17CTT1' );
insert into student values('1710164', 'O_888JQsNq', 'Charles Williams', 0 , '1970-05-31', 'cummingswilliam@travis-pena.com', '010.614.3695x349', '17CTT1' );
insert into student values('1710165', '*4lUFddl%Y', 'Ashley Jackson', 1 , '2007-08-18', 'alex94@gmail.com', '3954913212', '17CTT1' );
insert into student values('1710166', 'y92wARPy(%', 'Jamie Wilcox MD', 1 , '2008-03-14', 'brittany32@payne-jackson.com', '+1-081-476-6688', '17CTT1' );
insert into student values('1710167', 'FU2AsRmQI@', 'Jamie Randall', 1 , '1975-05-23', 'chenkim@anderson.net', '740-421-9617x674', '17CTT1' );
insert into student values('1710168', ')p8nJIwwvY', 'Jordan Waters', 0 , '2004-07-19', 'vmcdonald@gmail.com', '+1-138-255-6536x49714', '17CTT1' );
insert into student values('1710169', '!HK1fwZa6U', 'Laura Brown', 0 , '1990-04-21', 'thomasholly@yahoo.com', '(318)909-2294x4592', '17CTT1' );
insert into student values('1710170', 'et0cAFYR&1', 'Shawn Thomas', 0 , '1986-06-20', 'carlakeith@hotmail.com', '001-157-930-1962x4084', '17CTT1' );
insert into student values('1710171', 'IX3V4P#x^S', 'Calvin Kelly', 0 , '2002-10-30', 'susan24@hotmail.com', '762.752.0245', '17CTT1' );
insert into student values('1710172', 'U$WCWKEh)9', 'Eric Payne', 0 , '1985-05-22', 'robert66@gmail.com', '613.995.3522x937', '17CTT1' );
insert into student values('1710173', '$ursrSU_4s', 'Kimberly Jones', 0 , '2015-12-06', 'xroberts@hotmail.com', '219.067.6682x7810', '17CTT1' );
insert into student values('1710174', 'u1%5hXh3gQ', 'Jerry Carter', 0 , '1987-09-10', 'rebeccabarton@nguyen-harrison.com', '0653323377', '17CTT1' );
insert into student values('1710175', '4GzVffxU%V', 'Dennis Williams', 0 , '2008-03-29', 'rgray@gmail.com', '001-981-404-3270x73935', '17CTT1' );
insert into student values('1710176', 'W%*535Zh!*', 'James Wells', 0 , '2012-11-06', 'james31@moore.info', '297.011.0128x169', '17CTT1' );
insert into student values('1710177', '!@UOs8z33M', 'Susan Woods', 0 , '2004-10-04', 'heather08@gomez.info', '859-795-0424x78701', '17CTT1' );
insert into student values('1710178', 'Cyv6V0La)h', 'John Sandoval', 1 , '1994-01-09', 'eibarra@yahoo.com', '+1-084-998-7135x905', '17CTT1' );
insert into student values('1710179', 'L+5KvPTidE', 'Mr. Joel Anderson', 0 , '1973-08-02', 'gjordan@gmail.com', '400.849.1649', '17CTT1' );
insert into student values('1710180', 'h#L53M^d(u', 'Brenda Mayo', 0 , '1996-04-13', 'raymond12@evans-johnson.com', '207-149-9157', '17CTT1' );
insert into student values('1710181', '%_33SezHG!', 'Peter Wood', 0 , '1988-02-13', 'clementschristina@brown.net', '450.883.5880x1112', '17CTT1' );
insert into student values('1710182', '@_5NWoeB*r', 'Danielle Hamilton', 0 , '2012-09-29', 'jordandeborah@hotmail.com', '9651571644', '17CTT1' );
insert into student values('1710183', '^3^8F9pNyO', 'Robert Vincent', 1 , '1994-01-20', 'lwheeler@yahoo.com', '+1-915-634-7114x49528', '17CTT1' );
insert into student values('1710184', ')Y%a0As90)', 'Stephanie Frazier', 0 , '2006-04-16', 'alexanderlarry@gmail.com', '001-668-281-9704x473', '17CTT1' );
insert into student values('1710185', 'o5oAaBzY*D', 'Philip Williams', 1 , '1980-02-12', 'qtravis@hotmail.com', '(614)675-0978x661', '17CTT1' );
insert into student values('1710186', ')$OrtrYjo8', 'Andre Nichols', 0 , '1994-09-04', 'sonia11@mckinney.com', '+1-082-606-8781', '17CTT1' );
insert into student values('1710187', '@3wHSN8del', 'Brandy Mercado', 0 , '1996-05-24', 'melissabarker@yahoo.com', '224.555.2185x009', '17CTT1' );
insert into student values('1710188', 'Pr18WoNg!8', 'Cory Adams', 0 , '1987-05-01', 'batesjaclyn@gmail.com', '417.133.4901', '17CTT1' );
insert into student values('1710189', 'u37jEnzZ!H', 'Christine Khan', 0 , '1999-04-25', 'darrellallen@hotmail.com', '+1-282-828-3693x005', '17CTT1' );
insert into student values('1710190', 'y0HjUJ!x#k', 'Patricia Walker', 1 , '1995-05-29', 'jsmith@yahoo.com', '427.681.2225x116', '17CTT1' );
insert into student values('1710191', '(03bTaV9+G', 'Maria Bray', 1 , '1973-01-13', 'mday@morris.com', '6300650370', '17CTT1' );
insert into student values('1710192', '*H6LNkXI+z', 'Rebecca Poole', 0 , '2007-08-14', 'yhensley@hanson.com', '659.784.0638x575', '17CTT1' );
insert into student values('1710193', 'w87@lFvd!9', 'Jenna Chavez', 1 , '1981-06-22', 'william24@gmail.com', '808.842.5338x664', '17CTT1' );
insert into student values('1710194', '0W!E6TTzwX', 'Lori Flores', 1 , '1977-01-04', 'jared52@yahoo.com', '001-582-516-1517x856', '17CTT1' );
insert into student values('1710195', 'sP0JsG^qu@', 'Dakota Clarke', 1 , '1989-02-06', 'annasimmons@hotmail.com', '(307)554-7017', '17CTT1' );
insert into student values('1710196', '%BHf0YRf(N', 'William Lester', 1 , '1986-07-27', 'kevinbrown@yahoo.com', '001-329-777-4786x86155', '17CTT1' );
insert into student values('1710197', '+Ud46Ak1Ws', 'Katherine Massey', 0 , '2012-05-25', 'abbottemily@yahoo.com', '+1-328-779-8283', '17CTT1' );
insert into student values('1710198', 'Y!07IcqPo$', 'Christopher Landry', 0 , '2013-10-05', 'petersdonald@gmail.com', '3131119101', '17CTT1' );
insert into student values('1710199', '&7HXypgWvh', 'Robert Ruiz', 0 , '1995-05-02', 'garciasean@yahoo.com', '001-401-374-9460x3338', '17CTT1' );
insert into student values('1710200', '85p2P6v2P)', 'Courtney Baird', 0 , '1982-10-03', 'webbjessica@cook-kim.org', '950.056.2681', '17CTT1' );
insert into student values('1710201', '_Enf2BPi#Z', 'Nancy Hale', 0 , '1996-03-10', 'kelly24@hotmail.com', '+1-714-336-0294x806', '17CTTCN' );
insert into student values('1710202', 'M8TYgxwB+3', 'William Sanders', 0 , '2012-03-12', 'hunterspencer@hotmail.com', '518.102.2642x23673', '17CTTCN' );
insert into student values('1710203', '@&2CYVxko!', 'Maria Ramos', 1 , '1989-04-03', 'davidlewis@medina.com', '730-018-0942', '17CTTCN' );
insert into student values('1710204', '@v7^RCaheu', 'Garrett Garcia', 0 , '1986-08-06', 'kimberly52@lam-herrera.com', '855-117-3461', '17CTTCN' );
insert into student values('1710205', '^5gDG49b3Q', 'Wayne Phillips', 0 , '1989-03-06', 'jmeyer@hotmail.com', '655.208.6085x3198', '17CTTCN' );
insert into student values('1710206', '^)ot0FPoP&', 'Ian Mccormick', 1 , '1997-01-02', 'toddwells@cherry-stafford.com', '855-201-3684x2519', '17CTTCN' );
insert into student values('1710207', 'vqy4YZ!^m(', 'Brian Fields', 1 , '2008-02-19', 'williamromero@hotmail.com', '8478614002', '17CTTCN' );
insert into student values('1710208', '#)yICEdx6B', 'Frank Stewart', 1 , '2018-01-22', 'brittneylowery@gmail.com', '+1-245-818-0067x91854', '17CTTCN' );
insert into student values('1710209', '5auS0JG_u!', 'Patrick Johnson', 0 , '2005-07-16', 'sanchezsamantha@gmail.com', '(760)436-9161x838', '17CTTCN' );
insert into student values('1710210', '@KX9TKjt+!', 'Tammy Schwartz', 0 , '1995-01-16', 'joseph49@yahoo.com', '613.910.7300x693', '17CTTCN' );
insert into student values('1710211', 'e6BrS)lV(A', 'Michelle Escobar', 1 , '1976-02-26', 'sean74@gmail.com', '170-107-2410x50081', '17CTTCN' );
insert into student values('1710212', 'Y9gUf5ur+$', 'Nicholas Hanson', 0 , '1971-03-25', 'karen33@gmail.com', '144-908-2648x7831', '17CTTCN' );
insert into student values('1710213', ')cKHFGxFU7', 'Stephen Collier', 1 , '1980-02-08', 'khanrobert@dunn-daniels.com', '194-954-5856', '17CTTCN' );
insert into student values('1710214', '%eIU!!fk4B', 'Donald Rodriguez', 0 , '2020-12-15', 'cruzlindsay@hotmail.com', '(678)797-8659x4971', '17CTTCN' );
insert into student values('1710215', 'L_Zp9Xf%)x', 'Courtney Peters', 0 , '1975-08-02', 'carol56@hotmail.com', '074.597.4137x1114', '17CTTCN' );
insert into student values('1710216', 'B4CFha$t_5', 'Lisa Kelley', 0 , '1996-01-01', 'gclark@hotmail.com', '(072)785-7041', '17CTTCN' );
insert into student values('1710217', 'hl47Bo(v$C', 'Mikayla Walters', 1 , '1977-03-30', 'kevinbranch@yahoo.com', '(011)192-3477x146', '17CTTCN' );
insert into student values('1710218', 'EfKP+6Zp55', 'John Sims', 1 , '1980-11-13', 'flowerssarah@ward-bell.net', '001-909-365-0655x50064', '17CTTCN' );
insert into student values('1710219', '&6N6nsGfbt', 'Lisa Gallagher', 0 , '2017-11-16', 'leerichard@hotmail.com', '817-066-3568x377', '17CTTCN' );
insert into student values('1710220', '+%3JAyCo3s', 'Michelle Guerra', 1 , '2014-03-21', 'blairbrandon@gmail.com', '+1-918-634-3322x34203', '17CTTCN' );
insert into student values('1710221', 'l25CI&v$%g', 'Cindy King', 1 , '2018-09-08', 'bmills@bell.org', '+1-236-575-6314', '17CTTCN' );
insert into student values('1710222', 'kq3Q8V7c+i', 'Carolyn Liu', 1 , '1994-10-30', 'allisonamy@martinez.biz', '001-127-879-6249x0772', '17CTTCN' );
insert into student values('1710223', '!+b$0Fjn_^', 'Erin Anderson', 0 , '2010-11-27', 'mcbriderobert@le.net', '(148)163-1795', '17CTTCN' );
insert into student values('1710224', '!qVdIS$u7Q', 'Mrs. Kristen Tucker MD', 1 , '2011-07-18', 'jonathanscott@kaufman-glenn.biz', '001-676-734-7944x353', '17CTTCN' );
insert into student values('1710225', 'R1fb^1Rb+L', 'Jordan Carter', 1 , '1970-06-11', 'shannonadams@yahoo.com', '7502013405', '17CTTCN' );
insert into student values('1710226', 'PQ365HgN@U', 'Linda Morris', 0 , '2010-06-10', 'gdavis@gmail.com', '001-857-767-2213x49043', '17CTTCN' );
insert into student values('1710227', '_22rFHB&mg', 'Christopher Stephens', 0 , '1975-05-23', 'shawn94@brown.biz', '018-737-2634x1232', '17CTTCN' );
insert into student values('1710228', 'P1#TOI6e!O', 'Michael Holden', 0 , '2020-03-05', 'xchapman@huynh.com', '001-051-854-7405x008', '17CTTCN' );
insert into student values('1710229', '3_1C1D9sve', 'Dennis Gross', 0 , '2011-06-03', 'ericmarquez@jones.org', '748-290-5539x9658', '17CTTCN' );
insert into student values('1710230', 'd2QCvVes$Z', 'Laura Castro', 1 , '1976-11-29', 'petersonmadison@yahoo.com', '+1-314-547-4068x819', '17CTTCN' );
insert into student values('1710231', '$l5Lacg6a#', 'Rhonda Garcia', 1 , '2010-11-10', 'bradleynewton@perez.com', '872.837.2829', '17CTTCN' );
insert into student values('1710232', '_^2$Wmr1^V', 'Amy Frazier', 1 , '2016-08-07', 'turnerangel@sullivan.com', '+1-092-979-9995x249', '17CTTCN' );
insert into student values('1710233', 'GE4%Djg9$7', 'Jamie Cross', 1 , '1987-01-10', 'christopher47@gmail.com', '7946914257', '17CTTCN' );
insert into student values('1710234', '5A1pvSXp(U', 'Dwayne Cook', 0 , '1972-03-27', 'marco88@yahoo.com', '001-085-662-0381x383', '17CTTCN' );
insert into student values('1710235', 'y%A8MjZa4n', 'Jeffrey White', 0 , '1995-01-07', 'zjackson@farmer-walls.com', '456.929.6074x348', '17CTTCN' );
insert into student values('1710236', '@E5Hv7e1!L', 'Rodney Harper', 1 , '1989-08-16', 'rodney60@gmail.com', '081-523-0476', '17CTTCN' );
insert into student values('1710237', ')YD9D_i4df', 'Renee Palmer', 0 , '1986-02-18', 'vgreen@yahoo.com', '902.725.9797x656', '17CTTCN' );
insert into student values('1710238', 'e0Dg3AZn%l', 'Amber Moore', 1 , '1987-05-24', 'matthew56@yahoo.com', '(354)257-5127x69489', '17CTTCN' );
insert into student values('1710239', 'r9GDYMkU@U', 'Erik Davis', 0 , '2011-03-04', 'amyfitzgerald@gmail.com', '+1-715-418-1254', '17CTTCN' );
insert into student values('1710240', '_y52QVhvbm', 'Jeffrey Frazier', 1 , '2008-05-15', 'vthomas@hotmail.com', '(336)262-0172x450', '17CTTCN' );
insert into student values('1710241', '!^IHsGtI&2', 'Christopher Jones', 1 , '2003-06-09', 'chapmanamanda@yahoo.com', '909-450-2064x897', '17CTTCN' );
insert into student values('1710242', '^fQGEnqUB2', 'Nicole Reynolds', 1 , '1996-02-14', 'johnsmith@allison.info', '244.065.4309x96446', '17CTTCN' );
insert into student values('1710243', '6mx99MZVS%', 'Catherine Berger', 0 , '2016-02-11', 'kfaulkner@moses.net', '961-140-6101x066', '17CTTCN' );
insert into student values('1710244', 'S6osIdtu#e', 'Keith Maldonado', 0 , '2004-07-17', 'kathrynleonard@williams.biz', '001-153-305-3943x8406', '17CTTCN' );
insert into student values('1710245', '(7DfhIxg#s', 'Benjamin Rice', 1 , '2005-11-28', 'ekelly@woods.com', '(184)747-7208x02719', '17CTTCN' );
insert into student values('1710246', '_9Axcgy42#', 'Bianca Johnson', 1 , '2006-09-28', 'megan73@farrell-chapman.com', '635.261.7068x36214', '17CTTCN' );
insert into student values('1710247', 'b_i7bXnh)!', 'William Dixon', 1 , '2019-09-26', 'johnsanders@adams.org', '517-569-8606x525', '17CTTCN' );
insert into student values('1710248', 'a9E4bwmT+^', 'Connie Montgomery', 0 , '1983-11-25', 'bcombs@gmail.com', '278.636.5322x6424', '17CTTCN' );
insert into student values('1710249', '&K#*3OtguP', 'Karl Golden', 0 , '1982-08-19', 'michaelandersen@davis-green.com', '+1-722-512-7627x0441', '17CTTCN' );
insert into student values('1710250', '@qO@4etao3', 'Erin Anderson', 0 , '2015-06-28', 'franklinsteven@jimenez-murillo.com', '184-398-7453x0596', '17CTTCN' );
insert into student values('1710251', '^$nt8PDeNV', 'John Rosales', 1 , '2008-10-12', 'robert71@gmail.com', '179-263-5856x507', '17CTTCN' );
insert into student values('1710252', '+O2iNDz0g6', 'Christopher Morales', 0 , '2001-05-19', 'christopher69@yahoo.com', '382-766-0082x27676', '17CTTCN' );
insert into student values('1710253', 'a4kZ3Bf*)X', 'Heather Harris', 1 , '2011-07-24', 'tracymata@meyers-perkins.com', '(616)846-0660', '17CTTCN' );
insert into student values('1710254', 'aj1+LCyC_G', 'Mr. Steven Velasquez DDS', 0 , '1991-03-03', 'hdavis@hotmail.com', '4476267927', '17CTTCN' );
insert into student values('1710255', 'Rx)3Evp6fE', 'Alexander Hayes', 0 , '2019-08-14', 'gonzalesfrancis@gmail.com', '669-809-4919', '17CTTCN' );
insert into student values('1710256', 'Xi9qV%i&*%', 'Gerald Pacheco', 1 , '1988-05-21', 'grahamvanessa@hotmail.com', '247-787-3798x2781', '17CTTCN' );
insert into student values('1710257', '91nH8ltw&j', 'Julie Gross', 1 , '1970-06-01', 'lawsonnancy@yahoo.com', '001-596-469-4921x76762', '17CTTCN' );
insert into student values('1710258', '50wdSNsc#M', 'Ashley Ramsey', 0 , '2015-06-03', 'elizabeth75@brown-larson.com', '057.700.5189x089', '17CTTCN' );
insert into student values('1710259', 'T5XTXI%z!H', 'Kimberly Barker', 1 , '1976-09-29', 'brownryan@gmail.com', '+1-257-658-8315x62702', '17CTTCN' );
insert into student values('1710260', '$blE$MKzR6', 'Alexander Kline', 0 , '2015-06-14', 'monique81@yahoo.com', '353-436-8795', '17CTTCN' );
insert into student values('1710261', ')AZr*kJkY5', 'Jeffery Hoffman', 1 , '2004-08-05', 'rosalesmakayla@hammond.com', '(897)463-4556x6352', '17CTTCN' );
insert into student values('1710262', '%9iyHi7AKu', 'Andrew Matthews', 0 , '2016-02-01', 'nguyenkeith@yahoo.com', '(473)437-5079', '17CTTCN' );
insert into student values('1710263', '%b+2Me1nM!', 'David Hancock', 0 , '1993-03-18', 'bpatterson@jordan.com', '8717286900', '17CTTCN' );
insert into student values('1710264', '^4u35Nbr%(', 'Jennifer Thompson', 1 , '2009-03-28', 'stacey54@young.com', '(172)206-7163x6781', '17CTTCN' );
insert into student values('1710265', 'eHhFD&+b&3', 'Andrew Oconnell', 1 , '1997-07-01', 'russellamy@torres.info', '573.159.3469', '17CTTCN' );
insert into student values('1710266', ')cE0Wt6l0$', 'Katelyn Williams', 1 , '1998-05-15', 'wrightmichael@key-benton.com', '(503)982-0981x4639', '17CTTCN' );
insert into student values('1710267', 'kRUnlkfR)1', 'James Garcia', 1 , '1985-02-01', 'shannon57@hotmail.com', '940.805.5646x61302', '17CTTCN' );
insert into student values('1710268', '#8x_HES_*b', 'Brian Ross', 0 , '1982-01-12', 'campbellamanda@galloway.com', '(662)647-3208x860', '17CTTCN' );
insert into student values('1710269', '++B*P5a&A1', 'Colton Sherman', 0 , '2006-11-22', 'dmitchell@yahoo.com', '551.622.5346x10952', '17CTTCN' );
insert into student values('1710270', 'e)*7DAwDME', 'Jeremy Vasquez', 0 , '2017-12-16', 'mtaylor@gmail.com', '(692)513-4743x5894', '17CTTCN' );
insert into student values('1710271', 'U4*lbXsv(I', 'James Johnson', 0 , '1970-01-11', 'david42@flowers-robinson.org', '+1-854-872-0460x7341', '17CTTCN' );
insert into student values('1710272', '2_1FCOfpn6', 'Melissa Hays', 0 , '1999-08-18', 'lauragarner@hicks-roberts.com', '194-228-1887', '17CTTCN' );
insert into student values('1710273', '!y*JV^cj(8', 'Mackenzie Smith', 0 , '1980-12-29', 'zrice@gmail.com', '(518)115-8341x097', '17CTTCN' );
insert into student values('1710274', '^vMH6z4A1t', 'Ashley Dixon', 1 , '2019-11-26', 'kyle38@hernandez-martin.com', '001-253-820-8593x17362', '17CTTCN' );
insert into student values('1710275', '8TxbJ@lS_4', 'Matthew Turner', 0 , '1984-12-04', 'thompsonkristen@miller.org', '(652)159-7163x954', '17CTTCN' );
insert into student values('1710276', '!bRFlsAp3_', 'Krista Johnson', 0 , '2006-10-23', 'daniel48@woods.com', '(545)843-0580', '17CTTCN' );
insert into student values('1710277', 'm&g9qLysr!', 'Maria Harris', 1 , '2005-03-23', 'zcampbell@gmail.com', '001-177-147-0809x58729', '17CTTCN' );
insert into student values('1710278', 'l^1&lsBgrN', 'Andrew Simpson', 0 , '2005-01-12', 'crystal89@hotmail.com', '8373502833', '17CTTCN' );
insert into student values('1710279', '##1^m5Of9C', 'Robert Owens', 0 , '1998-09-04', 'williamclements@hotmail.com', '952.556.9966', '17CTTCN' );
insert into student values('1710280', '2M#3^OKs(O', 'Jennifer Garcia', 1 , '1975-01-22', 'laura35@rivera-frazier.com', '495.446.9013', '17CTTCN' );
insert into student values('1710281', 'z2(GW!Tl%f', 'Keith Brown', 0 , '1977-12-09', 'harmonmichael@yahoo.com', '(485)028-3389x58311', '17CTTCN' );
insert into student values('1710282', '%4(VCWf%nK', 'Crystal Coleman', 0 , '2006-11-18', 'elizabethcoleman@knight.com', '497-579-0566x973', '17CTTCN' );
insert into student values('1710283', 'WrY&VAs9@3', 'Becky Davis', 0 , '1971-09-11', 'melissa54@bautista.com', '589.112.2144x37537', '17CTTCN' );
insert into student values('1710284', '#X1IFs@gc&', 'Lisa Tapia', 1 , '1982-10-14', 'william60@gmail.com', '001-296-627-2001', '17CTTCN' );
insert into student values('1710285', 'P8DNbB@9^m', 'Mark Frost', 1 , '2000-02-27', 'charlesmorton@yahoo.com', '257-175-3683x920', '17CTTCN' );
insert into student values('1710286', '^0iAL8nx5c', 'Debra Madden', 1 , '1970-01-12', 'samanthagraves@turner.com', '032-586-5642', '17CTTCN' );
insert into student values('1710287', '6zI1K^a2**', 'Scott Anderson', 1 , '1999-05-24', 'maria09@hotmail.com', '3314820315', '17CTTCN' );
insert into student values('1710288', '!V0EkvX%jE', 'Mark Campbell', 0 , '2020-03-25', 'stephanie44@brown-garcia.com', '1574976093', '17CTTCN' );
insert into student values('1710289', 'MnK8Cag5!@', 'Charles Kelly', 1 , '1998-11-27', 'claytonrobert@yahoo.com', '052.888.5874x784', '17CTTCN' );
insert into student values('1710290', 'H&9UpyOFmG', 'Cory Chaney', 0 , '2006-07-03', 'handerson@hotmail.com', '(296)301-4594x78971', '17CTTCN' );
insert into student values('1710291', '405hPH7f(%', 'Travis Wilkerson', 0 , '1982-07-15', 'wilsonanthony@gmail.com', '(357)539-0071x15749', '17CTTCN' );
insert into student values('1710292', 'r_1SvhphGW', 'Michael Gilbert', 0 , '1982-03-10', 'markhorton@gmail.com', '442-472-3110', '17CTTCN' );
insert into student values('1710293', '#1lmyWvG&T', 'Kimberly Davis', 1 , '1976-04-28', 'amy46@gmail.com', '470-917-7186x8262', '17CTTCN' );
insert into student values('1710294', 'Ph#1U3uz%3', 'Robin Lester', 1 , '1976-09-21', 'lclark@bates.biz', '452-166-0846x37487', '17CTTCN' );
insert into student values('1710295', 's0SD%@Ly)f', 'Randall Garza', 1 , '1987-04-19', 'smithkimberly@yahoo.com', '155.244.0598', '17CTTCN' );
insert into student values('1710296', 'Z%4KI*b$Bf', 'Scott Cole', 1 , '1997-03-31', 'dparker@diaz.org', '001-247-287-1061', '17CTTCN' );
insert into student values('1710297', 'G62BgZxF(Z', 'Lisa Dickerson', 1 , '2001-08-29', 'xcobb@hotmail.com', '001-388-273-2590', '17CTTCN' );
insert into student values('1710298', '6k3HZ%Xjb#', 'Christie Garcia', 1 , '1995-10-03', 'thomassimpson@bennett-cook.info', '(882)499-1722', '17CTTCN' );
insert into student values('1710299', 'Y#u(5NDaZq', 'Joseph Singleton', 1 , '1972-09-23', 'agill@velez.com', '853-622-6908', '17CTTCN' );
insert into student values('1710300', '*mHD0uOs2$', 'Brenda Bray', 0 , '2019-04-27', 'scottantonio@gmail.com', '084.714.3313x50606', '17CTTCN' );
insert into student values('1710301', 'Nk!Z0RNinu', 'Brianna Lopez', 1 , '2016-03-17', 'bartlettwalter@grant.com', '801.480.1119', '17CTT2' );
insert into student values('1710302', 'vR0toJfq^1', 'Christina Tyler', 0 , '1988-09-20', 'smithwilliam@hotmail.com', '341.660.4322', '17CTT2' );
insert into student values('1710303', '+31dfXuiAf', 'Anita Flores', 0 , '2015-08-08', 'christopherfernandez@hernandez.org', '001-226-349-0394x48995', '17CTT2' );
insert into student values('1710304', 'YYR2%Opvk@', 'Kimberly Jones', 0 , '2014-02-04', 'beckstephen@hotmail.com', '270.939.3638x571', '17CTT2' );
insert into student values('1710305', '0J1bVzj@&0', 'Molly Osborne', 1 , '1985-06-16', 'marissa10@gmail.com', '635-441-9187x454', '17CTT2' );
insert into student values('1710306', 'z7%$1ZoeaM', 'Anthony Jenkins', 1 , '1982-03-18', 'gonzalezannette@cook.com', '179-867-9735x04085', '17CTT2' );
insert into student values('1710307', '*uJ5Y!TmK#', 'Rachel Stephens', 1 , '1988-05-27', 'eclark@gray.com', '712-745-1742x6735', '17CTT2' );
insert into student values('1710308', 'qg21GUKa+(', 'Krystal Martin', 1 , '2005-02-18', 'kylecannon@gmail.com', '456-640-0117', '17CTT2' );
insert into student values('1710309', '!6E%AVbMeE', 'Laura Garcia', 1 , '1985-07-31', 'kvillanueva@yahoo.com', '4346496779', '17CTT2' );
insert into student values('1710310', 'btTS0Mg(_(', 'Charles Howell', 0 , '2017-03-04', 'leonardwilkerson@peterson-reeves.com', '(712)244-9177x8090', '17CTT2' );
insert into student values('1710311', 'T$mrHZpv+2', 'Stacey Johnson', 0 , '1980-09-01', 'gabrielaustin@gmail.com', '(077)094-3578x53846', '17CTT2' );
insert into student values('1710312', '(^9OsDDp$5', 'John Hernandez', 0 , '1993-04-04', 'willie78@shelton.info', '752-090-6920', '17CTT2' );
insert into student values('1710313', 'R9LP+qPZ#^', 'Jeremy Collins', 1 , '2013-10-24', 'luisbennett@smith.biz', '(549)284-8339x5816', '17CTT2' );
insert into student values('1710314', '!J4CDLsCZ8', 'Adrienne Thompson', 1 , '2001-09-26', 'padams@gmail.com', '(755)820-9827x58275', '17CTT2' );
insert into student values('1710315', '!1Yr8eIkqD', 'Alexandra Perez', 0 , '1990-03-21', 'danielsmaria@morgan.com', '001-920-200-0695x48157', '17CTT2' );
insert into student values('1710316', '@5Iue@0s6p', 'Steven Case', 1 , '1988-07-26', 'frances14@hotmail.com', '635-309-0775x4708', '17CTT2' );
insert into student values('1710317', 'hVx2TGhf*A', 'Christopher Ramirez', 0 , '1979-08-10', 'sharpkaren@bennett-villarreal.com', '(325)742-1178x350', '17CTT2' );
insert into student values('1710318', 'EqhJRWeh#1', 'Mark Murphy', 1 , '2007-03-31', 'elizabeth93@bradford.net', '001-040-496-0808', '17CTT2' );
insert into student values('1710319', 'hlZOh#XG!6', 'James Sims', 0 , '2003-09-08', 'melanienelson@hotmail.com', '001-734-162-7441x4402', '17CTT2' );
insert into student values('1710320', 'DTY3vCVb%t', 'Louis Walker', 0 , '2008-11-21', 'harrisedward@chase.biz', '(944)344-9978x0719', '17CTT2' );
insert into student values('1710321', 'w0lvRHSE+8', 'Sheri Robertson', 0 , '1988-03-14', 'perezamber@gmail.com', '001-812-326-2998x9144', '17CTT2' );
insert into student values('1710322', '6)8s@sIkXC', 'Natalie Grant', 0 , '1992-09-27', 'mitchellbrandon@gmail.com', '+1-430-699-2836', '17CTT2' );
insert into student values('1710323', 'Em82WWye1#', 'Carmen Reynolds', 0 , '2010-02-02', 'bethanyfigueroa@gmail.com', '(403)028-3501', '17CTT2' );
insert into student values('1710324', '8^PBptXT%b', 'Lisa Davis', 1 , '1974-10-24', 'mjones@yahoo.com', '(665)869-7251', '17CTT2' );
insert into student values('1710325', '@0SNKHoWpe', 'Kristin Ramirez', 0 , '2006-05-08', 'kyle90@wheeler.com', '829.778.2560x86015', '17CTT2' );
insert into student values('1710326', 'j6_Ba%Vo!*', 'Brian Meyer', 0 , '2009-05-15', 'misty38@norris.net', '501-038-7230', '17CTT2' );
insert into student values('1710327', 'k3fE5xfz(B', 'Kimberly Sanchez', 0 , '2001-04-01', 'jessicahall@gmail.com', '205-271-5563x71230', '17CTT2' );
insert into student values('1710328', 'z@8Hjrrey%', 'Stacey Carney', 0 , '2018-05-09', 'julie25@gmail.com', '233.953.8003x285', '17CTT2' );
insert into student values('1710329', '6b!S69Xp_n', 'Crystal Burns', 0 , '2019-06-26', 'hector03@baker.com', '629-287-4415x5681', '17CTT2' );
insert into student values('1710330', '(jN_ia#20Y', 'Nicholas Brock', 0 , '2007-10-07', 'rnguyen@sexton-mills.org', '001-227-821-2347', '17CTT2' );
insert into student values('1710331', ')2thFTCy@Z', 'Stacey Ray', 1 , '2015-02-22', 'davismary@wallace.com', '654-094-0358', '17CTT2' );
insert into student values('1710332', 'x1j7_V$g$Q', 'Debbie Mckinney', 0 , '2012-10-26', 'tonyabell@hotmail.com', '001-291-335-1778', '17CTT2' );
insert into student values('1710333', '+93RCdmf!S', 'Jesse Bell', 0 , '1980-05-06', 'anthony09@haas-welch.com', '335.491.8297x8539', '17CTT2' );
insert into student values('1710334', '(iP8MjVBhR', 'Michael Robinson', 1 , '2021-03-04', 'phillipsluke@hotmail.com', '001-358-752-5186', '17CTT2' );
insert into student values('1710335', '%UspPurj9c', 'Jeffrey Garcia', 0 , '1989-03-07', 'hlewis@bennett.com', '818-585-1679', '17CTT2' );
insert into student values('1710336', 's6VA@t#u!J', 'Ryan Carter', 1 , '1985-01-20', 'walter86@mitchell-lewis.biz', '(048)019-2863x57771', '17CTT2' );
insert into student values('1710337', '&#RfxNJr@2', 'Destiny Hill', 1 , '1975-01-10', 'yholmes@moore.com', '+1-817-277-8472x35478', '17CTT2' );
insert into student values('1710338', 'wC4dH5kU9%', 'Matthew Hall', 0 , '2020-12-24', 'edward00@day-hamilton.com', '(133)156-9099x369', '17CTT2' );
insert into student values('1710339', '_RI5IDnm09', 'Daniel Brady', 1 , '2004-03-27', 'davidgonzalez@cooper-everett.org', '001-324-030-0586x28915', '17CTT2' );
insert into student values('1710340', '(KJlihQp!4', 'Nina Smith', 0 , '1973-11-11', 'kmitchell@gmail.com', '855.305.8366', '17CTT2' );
insert into student values('1710341', 'hFv2Oj%74$', 'Geoffrey Thompson', 1 , '1979-01-24', 'cynthia67@scott-hicks.net', '+1-586-628-9727x7485', '17CTT2' );
insert into student values('1710342', '*7TCKMVrzy', 'Jennifer Greene', 0 , '2020-04-13', 'jacqueline34@hotmail.com', '708-358-7459', '17CTT2' );
insert into student values('1710343', '&knl6cVzNT', 'Daniel Hess', 1 , '1990-01-16', 'jmartin@chapman-rodriguez.info', '001-249-008-4815x49193', '17CTT2' );
insert into student values('1710344', '&QbK2Yvv2h', 'Paul Mckinney', 1 , '2018-04-06', 'wwhite@pearson-williams.com', '394-841-6383x393', '17CTT2' );
insert into student values('1710345', 'Y^(73PrA1a', 'Angela Mills', 1 , '2016-06-29', 'aaron19@brown-smith.org', '001-745-841-0041x553', '17CTT2' );
insert into student values('1710346', '+YWf&BIt%9', 'John Vasquez', 1 , '2017-03-04', 'wrightmatthew@gmail.com', '(811)757-5513x73827', '17CTT2' );
insert into student values('1710347', '%yKkoc59*1', 'Charles Li', 0 , '2005-12-04', 'jamesatkins@yahoo.com', '298-863-7506x7062', '17CTT2' );
insert into student values('1710348', '@izM8pFh39', 'Christopher Warren', 1 , '2015-05-18', 'whitedaniel@patterson.com', '096-909-2067x06418', '17CTT2' );
insert into student values('1710349', '$MfT6P)ei3', 'Jason Parker', 1 , '1982-04-02', 'mitchellhenson@hotmail.com', '928-329-9972', '17CTT2' );
insert into student values('1710350', 'aQPTp!Yy^7', 'Matthew Kelly', 1 , '1975-05-11', 'destinyritter@alvarado-bond.com', '(997)856-8026x139', '17CTT2' );
insert into student values('1710351', '_pQhXPLK5i', 'Michael Miller', 1 , '2008-08-21', 'grayrachel@yahoo.com', '087-654-6575x3523', '17CTT2' );
insert into student values('1710352', 'g2SRyC3f^F', 'David Andrews', 1 , '1988-08-11', 'jacoblove@ortiz.com', '(695)134-1022x5531', '17CTT2' );
insert into student values('1710353', '4xp)1PuM_3', 'Sean Brown', 0 , '1989-07-13', 'castrolisa@hotmail.com', '001-093-336-1483', '17CTT2' );
insert into student values('1710354', '8bHO9Gva_E', 'Sarah Wagner', 1 , '2015-04-27', 'smcguire@yahoo.com', '(732)172-3696x6082', '17CTT2' );
insert into student values('1710355', '#SiH5qEl)_', 'Mr. Gabriel Campbell', 0 , '2016-03-11', 'silvawilliam@gmail.com', '(241)616-1477', '17CTT2' );
insert into student values('1710356', 'WE)2q&Brz$', 'Sharon Duarte DDS', 0 , '2005-01-17', 'angelahahn@hotmail.com', '001-042-477-9284x99323', '17CTT2' );
insert into student values('1710357', '&LHKQeQoz5', 'Rebecca Quinn', 1 , '1998-11-13', 'christina23@gmail.com', '001-284-657-4951x29895', '17CTT2' );
insert into student values('1710358', '9kdAOU1L!w', 'Brent Landry', 0 , '1999-01-31', 'thomas65@hotmail.com', '+1-905-640-5768x856', '17CTT2' );
insert into student values('1710359', '&8Pv@nkUaK', 'Ashley Stevens', 1 , '2017-12-19', 'kara36@gmail.com', '4721839048', '17CTT2' );
insert into student values('1710360', '*C1Ke2aEBf', 'Jonathan Reilly', 1 , '1970-08-28', 'nicholas31@hunt.net', '(043)977-8441x9967', '17CTT2' );
insert into student values('1710361', 'WD#SG3Xw+W', 'Sherry Gonzales', 1 , '2006-11-18', 'jakeandrews@walker.com', '667.893.4417', '17CTT2' );
insert into student values('1710362', '(8KJGtCzRm', 'Kevin Hughes', 1 , '2008-08-16', 'chamberspenny@hotmail.com', '(009)226-9746', '17CTT2' );
insert into student values('1710363', '2RCJxUn0%d', 'Karen Johnson', 1 , '2011-01-04', 'mmoore@hotmail.com', '148-446-5209', '17CTT2' );
insert into student values('1710364', '&2FBGikG9)', 'Joshua Carlson', 0 , '1970-09-09', 'deantimothy@payne.com', '562.246.5667x63339', '17CTT2' );
insert into student values('1710365', '%JXz%Khm8D', 'Jill Vargas', 1 , '2006-03-21', 'chayes@hotmail.com', '+1-890-750-4836x9126', '17CTT2' );
insert into student values('1710366', '&60YuFRyjr', 'Jennifer Pena', 1 , '1970-01-09', 'econtreras@gmail.com', '571-503-1391', '17CTT2' );
insert into student values('1710367', 'Y+%72Y3dB*', 'Tammy Russell', 0 , '1974-10-06', 'steven41@yahoo.com', '733.881.0046x802', '17CTT2' );
insert into student values('1710368', '&0Tgo8Hhq6', 'Felicia Thomas', 0 , '2017-10-06', 'alicialevine@flores.org', '844.295.7546x459', '17CTT2' );
insert into student values('1710369', '*R1#NaLjXH', 'Christopher Stewart', 1 , '1985-01-18', 'berrygregory@gmail.com', '+1-153-671-1292x411', '17CTT2' );
insert into student values('1710370', 'eHaGXKjY(9', 'Morgan Burton', 1 , '1974-10-15', 'donald38@hotmail.com', '+1-964-173-9889x6420', '17CTT2' );
insert into student values('1710371', 'Xzi&PC_@%1', 'Andrew Patterson', 1 , '2001-06-11', 'hgarcia@hotmail.com', '001-732-934-6825x67653', '17CTT2' );
insert into student values('1710372', 'N*E8CazyJ5', 'Matthew Jarvis', 0 , '1975-10-01', 'kirsten65@smith.net', '(600)560-9762x9573', '17CTT2' );
insert into student values('1710373', '_7dTEt9z#&', 'Anthony Davis', 1 , '1985-07-19', 'shannonward@gmail.com', '(962)227-0526', '17CTT2' );
insert into student values('1710374', '&B3b11HpLI', 'Candice Thompson', 1 , '2015-05-18', 'brandondavis@rivera.com', '0078955611', '17CTT2' );
insert into student values('1710375', 'V(x0XoWvc$', 'Molly Ortiz', 0 , '2014-05-01', 'charleskeith@brown.com', '(143)539-7831', '17CTT2' );
insert into student values('1710376', '9RvGL1@v)Q', 'Kenneth Harrison', 0 , '2004-12-14', 'williamsmelissa@montes-barton.net', '(858)739-6944x8049', '17CTT2' );
insert into student values('1710377', '#(6Mqf@aIp', 'Tiffany Sampson', 1 , '2017-02-11', 'gashley@hotmail.com', '+1-058-917-6620x9762', '17CTT2' );
insert into student values('1710378', 'j@2Y7jTd$J', 'Dr. Patrick Anderson', 0 , '1973-09-27', 'charlesrobertson@gmail.com', '(897)668-4715x0218', '17CTT2' );
insert into student values('1710379', '&65Al%3u%1', 'Jamie Brown DVM', 1 , '1975-06-15', 'vanessa12@hotmail.com', '071-817-2500', '17CTT2' );
insert into student values('1710380', 'S_8pgDxc59', 'Eric Glass', 1 , '1973-05-04', 'jefferynovak@gmail.com', '606.767.8998', '17CTT2' );
insert into student values('1710381', 'Kd6YljQyR@', 'Nicole Villegas', 0 , '2016-12-29', 'rallison@yahoo.com', '954.591.4004x235', '17CTT2' );
insert into student values('1710382', '40JSt!*F@w', 'Steven Payne', 0 , '1978-09-26', 'jerrylewis@smith.info', '(209)919-5630x4758', '17CTT2' );
insert into student values('1710383', '&Uz)JyVee8', 'Charlotte Vega', 0 , '2007-11-16', 'johnstonjoshua@hotmail.com', '(522)903-0600', '17CTT2' );
insert into student values('1710384', 'ey_VN0Nu)^', 'Jeremiah Hoffman', 0 , '2008-01-27', 'lindsey33@perry.com', '997-494-9066x36667', '17CTT2' );
insert into student values('1710385', 'y#P7v7Nz4h', 'Bryan Schmidt', 0 , '2016-03-11', 'ewyatt@lowe.com', '(412)730-3014x669', '17CTT2' );
insert into student values('1710386', '^NEF*19l75', 'Carlos Clark', 1 , '2008-08-10', 'cliu@yahoo.com', '(649)513-9910x74434', '17CTT2' );
insert into student values('1710387', '%c6C9uJQG7', 'Devin Lewis', 1 , '2014-02-04', 'danielledavis@hotmail.com', '(437)904-6894', '17CTT2' );
insert into student values('1710388', 'Y9E#c5WxwG', 'Judy Cook', 0 , '1984-02-07', 'dilloneric@palmer.com', '790-912-1327', '17CTT2' );
insert into student values('1710389', 'NBq0LpNOi(', 'Christopher Haynes', 0 , '1978-08-28', 'mooreryan@medina.biz', '+1-291-881-0593x421', '17CTT2' );
insert into student values('1710390', '4&4a4Ifr+6', 'Pamela Hicks DDS', 1 , '2004-04-13', 'aliciamartinez@hotmail.com', '+1-634-156-8405x1907', '17CTT2' );
insert into student values('1710391', '&YY8*7pf+4', 'Tracey Carpenter', 0 , '2011-08-22', 'kevinlewis@mathis-page.com', '+1-034-036-7433x835', '17CTT2' );
insert into student values('1710392', '2%5dG7ekP&', 'Nancy Wood', 1 , '2002-11-16', 'crossmaria@hotmail.com', '+1-854-335-2481x994', '17CTT2' );
insert into student values('1710393', '@gl1NAe_rf', 'Robert Dean', 0 , '1996-01-18', 'igross@brown-juarez.com', '734.434.0469x608', '17CTT2' );
insert into student values('1710394', ')y2KM36lT*', 'Scott Lane', 0 , '1999-12-08', 'wrightleonard@adams-hansen.info', '223-974-8407x84767', '17CTT2' );
insert into student values('1710395', '**1QzhPHM9', 'Timothy Barnett MD', 1 , '1987-11-02', 'ihill@yahoo.com', '+1-130-904-4797x385', '17CTT2' );
insert into student values('1710396', 'Nu*_0BQa%X', 'Lindsay Johnson', 0 , '1970-11-08', 'daniel05@simpson.com', '+1-010-062-5465x52872', '17CTT2' );
insert into student values('1710397', '##xt*0BmE1', 'Rebecca Roberts', 1 , '2021-05-24', 'christianlee@jacobs.biz', '482.171.8684', '17CTT2' );
insert into student values('1710398', '_T&3eYUnN1', 'Brandon Thomas', 1 , '2006-06-08', 'ericafisher@gmail.com', '3527288972', '17CTT2' );
insert into student values('1710399', 'HE(5lQaci%', 'Heather Walsh', 1 , '2017-02-18', 'gailanderson@yahoo.com', '023-834-1715', '17CTT2' );
insert into student values('1710400', 'XB0NBiWZQ#', 'Thomas Hardin', 0 , '1988-02-22', 'alexander57@schmitt.com', '001-181-780-3970x80759', '17CTT2' );
insert into student values('1710401', '6cdKuy!A(*', 'Eric Gonzalez', 1 , '1993-03-14', 'areilly@gmail.com', '432.685.6451x6290', '17CTT3' );
insert into student values('1710402', 'OnXKk1kl&2', 'Maria Lawrence', 1 , '2011-10-02', 'matthewmendoza@yahoo.com', '001-224-025-9966', '17CTT3' );
insert into student values('1710403', 'N3l^uPfe&n', 'Lisa Weaver', 0 , '2020-02-03', 'tsmith@gmail.com', '(932)859-8271x1895', '17CTT3' );
insert into student values('1710404', ')M^846Gg7$', 'Christopher Hampton', 1 , '2011-01-15', 'michael94@williams.org', '(372)127-5072', '17CTT3' );
insert into student values('1710405', '!$%O9LZhy7', 'Angela Gibson', 0 , '2002-09-03', 'kara33@anderson-schmidt.info', '+1-211-940-0173', '17CTT3' );
insert into student values('1710406', '&0J1L**Q)f', 'Alex Tyler', 0 , '1989-04-20', 'clarknicholas@hotmail.com', '001-760-466-1139x02854', '17CTT3' );
insert into student values('1710407', '*iFji9OoA*', 'Henry Murphy', 0 , '1994-07-24', 'dillon08@beard.com', '723-380-1493', '17CTT3' );
insert into student values('1710408', 'v@4gVrUD+U', 'Laura Taylor', 0 , '2006-11-13', 'leah66@oconnor.com', '(494)110-2792x570', '17CTT3' );
insert into student values('1710409', 'z&@8zeUa&a', 'Lisa Washington', 0 , '2018-10-27', 'austin00@yahoo.com', '0121093343', '17CTT3' );
insert into student values('1710410', 'GtM5SJfor#', 'Jaclyn Herrera', 1 , '1981-09-08', 'rogersshelly@hotmail.com', '012-835-8621', '17CTT3' );
insert into student values('1710411', '0u0MJSyHY(', 'Bonnie Perez', 1 , '1974-12-02', 'brittanyperry@gmail.com', '001-756-471-2693x8474', '17CTT3' );
insert into student values('1710412', ')r9Nyvf8$y', 'Joseph Cruz', 1 , '2015-11-22', 'tiffany68@gmail.com', '(808)337-4201x04135', '17CTT3' );
insert into student values('1710413', 'O)5G0bZmvi', 'Melanie Thompson', 0 , '1983-12-22', 'quinndavid@hart.com', '+1-766-532-8146x185', '17CTT3' );
insert into student values('1710414', ')2ItD@!zh9', 'John Richards', 0 , '2010-09-14', 'daniel22@coleman-hoffman.com', '(243)591-5129x060', '17CTT3' );
insert into student values('1710415', 'M#K6GWd4uT', 'Jared Nguyen', 1 , '1998-01-02', 'felicia99@gmail.com', '437-975-9467x18997', '17CTT3' );
insert into student values('1710416', '^&#*Lv@wB9', 'Jeanne Burton', 0 , '2014-01-22', 'riosmark@hotmail.com', '(367)422-6982x6288', '17CTT3' );
insert into student values('1710417', '_0Y+@q6pT%', 'Sean Cooper', 0 , '1978-04-21', 'jean35@hernandez-flynn.info', '+1-583-680-9659', '17CTT3' );
insert into student values('1710418', '(AN#rvW21e', 'John Vega', 0 , '1983-05-11', 'mpearson@gmail.com', '366.770.1940x733', '17CTT3' );
insert into student values('1710419', 'VH_8B@&vjM', 'James Decker', 1 , '1992-11-15', 'walter93@ingram.com', '(543)987-4955', '17CTT3' );
insert into student values('1710420', 'EY3CoG0v&@', 'Raymond Baker', 1 , '1977-05-20', 'drodriguez@floyd-jones.com', '+1-770-823-0622x4887', '17CTT3' );
insert into student values('1710421', '8b8c1VS9k+', 'April Kemp', 0 , '2015-09-12', 'lynchelizabeth@gmail.com', '+1-177-313-7441x26868', '17CTT3' );
insert into student values('1710422', '8EValnZ&$n', 'Richard Garrett', 1 , '1995-07-24', 'otaylor@yahoo.com', '605.718.4295', '17CTT3' );
insert into student values('1710423', 'CbO7BWx_d#', 'Robert Brown', 1 , '1991-03-25', 'clarkekim@hernandez.com', '0141308751', '17CTT3' );
insert into student values('1710424', '^nX5Bzj7^H', 'Louis Anderson', 0 , '2007-02-19', 'tommy81@hotmail.com', '(924)689-4089x7069', '17CTT3' );
insert into student values('1710425', '*mnWDVdsn0', 'Timothy Jones', 0 , '2004-11-05', 'ehopkins@carr.com', '912.270.2094', '17CTT3' );
insert into student values('1710426', '(6KARrQP9Q', 'Dana Madden', 0 , '1974-12-01', 'amiller@ellis.com', '842-948-0270', '17CTT3' );
insert into student values('1710427', 'mpxT4Wgc*9', 'Michelle Conley', 0 , '1992-04-16', 'jmoreno@yahoo.com', '(985)953-2113x2875', '17CTT3' );
insert into student values('1710428', '%2k7Eo!fl8', 'Nathan Miller', 1 , '1975-10-01', 'cmills@hotmail.com', '(243)148-5822', '17CTT3' );
insert into student values('1710429', 'K#Tt7YIb%v', 'Victoria Moyer', 1 , '2006-03-28', 'larajoshua@gmail.com', '(249)534-5459', '17CTT3' );
insert into student values('1710430', 'jq4SVz+eW*', 'Danielle Rosales', 0 , '2008-03-08', 'alyssamacias@hotmail.com', '(808)990-5534x85512', '17CTT3' );
insert into student values('1710431', 'S6)#46QjS1', 'Grace Jackson', 1 , '2009-10-29', 'michael02@hotmail.com', '+1-262-531-6549', '17CTT3' );
insert into student values('1710432', 'Xp5AxkPF_4', 'Sean Rivera', 1 , '2010-02-18', 'alexhamilton@wheeler-alvarez.com', '001-421-896-2653', '17CTT3' );
insert into student values('1710433', '$1YzsUgX1!', 'Kimberly Green', 1 , '1971-02-16', 'markmorrison@yahoo.com', '986-311-8597x778', '17CTT3' );
insert into student values('1710434', '*(2QsUiw*A', 'Erik Higgins', 0 , '2011-12-12', 'wfields@hubbard.com', '(334)314-0659x3551', '17CTT3' );
insert into student values('1710435', '$b)%l8We&+', 'Deanna Graves', 0 , '2015-01-11', 'randymarshall@gmail.com', '892.949.0886x02026', '17CTT3' );
insert into student values('1710436', 'W$I6CiJ2&N', 'Dustin Allen', 1 , '2017-10-28', 'zthomas@liu-long.biz', '815.262.8745x3188', '17CTT3' );
insert into student values('1710437', '%S07HO8jXI', 'Nicolas Dougherty', 0 , '2000-07-18', 'kturner@hotmail.com', '001-852-746-8515x906', '17CTT3' );
insert into student values('1710438', 'CL@1S$1r_C', 'Ashley Henry', 0 , '2012-11-03', 'brownbrian@miller.com', '929-643-4950x8650', '17CTT3' );
insert into student values('1710439', 'i&3IGtDk()', 'Thomas Phillips', 0 , '2017-03-31', 'terrelladam@jones.com', '121-622-3847x40721', '17CTT3' );
insert into student values('1710440', 'a7IQZZu+(y', 'Brianna Hernandez', 1 , '1978-10-26', 'zhangmaria@smith.com', '(622)138-6203x9288', '17CTT3' );
insert into student values('1710441', 'FQ)8J&Wf*G', 'Sarah Clarke', 0 , '1970-10-14', 'shanepotter@gmail.com', '539.345.0327', '17CTT3' );
insert into student values('1710442', 'nX_v_9Bu$6', 'William Gibbs', 0 , '2012-10-07', 'mary21@yahoo.com', '+1-679-004-5689x500', '17CTT3' );
insert into student values('1710443', '20mkWP!o^7', 'Karen Thompson', 0 , '2012-11-06', 'howardcynthia@taylor.net', '001-359-320-1927x22368', '17CTT3' );
insert into student values('1710444', 'Rt$k2oION_', 'Mr. Andrew Black', 0 , '1975-10-22', 'brandi00@flores.biz', '496.505.5313', '17CTT3' );
insert into student values('1710445', 'Mw(5gMteW@', 'Pamela Thomas', 0 , '2014-05-25', 'leslie81@hotmail.com', '822.044.8502', '17CTT3' );
insert into student values('1710446', '$9cVSEbzD4', 'Angela Smith', 0 , '2011-08-13', 'newmananthony@ramirez.info', '001-219-379-1864x412', '17CTT3' );
insert into student values('1710447', 'nj2@OEqcW*', 'James Carter', 0 , '2016-03-06', 'heather38@pena.org', '005.651.7642', '17CTT3' );
insert into student values('1710448', 'p44Vgnk5Q$', 'Cynthia Warren', 1 , '1997-09-07', 'tony24@hotmail.com', '(452)990-9241', '17CTT3' );
insert into student values('1710449', 'u7gZV$Oz&!', 'Elizabeth Espinoza', 1 , '1990-07-11', 'singhcarolyn@bridges-molina.com', '(958)369-4168x3545', '17CTT3' );
insert into student values('1710450', '*a802Vbp+*', 'Mathew Murray', 1 , '1979-08-08', 'perezkent@huang.biz', '+1-896-580-9215x90405', '17CTT3' );
insert into student values('1710451', 'KdRwcxLL^5', 'Sean Suarez', 0 , '1990-01-02', 'rtyler@mack.com', '+1-137-562-9341x31608', '17CTT3' );
insert into student values('1710452', 'i1ZWd(9@@s', 'David Hardy', 1 , '2013-10-18', 'juliadowns@hamilton.org', '(185)308-6862x76841', '17CTT3' );
insert into student values('1710453', '_M&LtzgPk9', 'Sylvia Mejia', 1 , '1999-11-21', 'teresa19@moore.com', '(984)860-4211', '17CTT3' );
insert into student values('1710454', '(IY4tX*hS6', 'James Parker', 1 , '2006-08-27', 'nicholaspeterson@yahoo.com', '001-498-027-6682x3095', '17CTT3' );
insert into student values('1710455', 'Lj&5Fowx4J', 'Micheal Adkins', 0 , '2010-05-10', 'pknight@perez.com', '+1-157-731-2586x78779', '17CTT3' );
insert into student values('1710456', '71*HCf@y$0', 'John Nguyen', 0 , '2014-02-04', 'claytonjackson@hicks-bush.com', '+1-883-421-4587x60425', '17CTT3' );
insert into student values('1710457', 'l(j36CXj!N', 'Patricia Taylor', 0 , '1999-12-17', 'rileyerin@brown.info', '(456)140-7621', '17CTT3' );
insert into student values('1710458', 'UDt0U#z4*(', 'Lawrence Miller', 1 , '1971-01-03', 'montgomerymary@yahoo.com', '(756)872-7330x5313', '17CTT3' );
insert into student values('1710459', '#URm73ErQ%', 'Melanie Griffin', 0 , '2016-10-01', 'veronica19@weber-parker.com', '891.064.9100x42531', '17CTT3' );
insert into student values('1710460', 'e6&41EHoHk', 'Sara Garcia', 1 , '2006-03-20', 'zthompson@gmail.com', '(166)806-9978x533', '17CTT3' );
insert into student values('1710461', '0hbZEWut!2', 'Sean White', 0 , '2010-04-01', 'ycastro@atkins-keller.net', '215-674-3134x043', '17CTT3' );
insert into student values('1710462', '_!i5ATSv5)', 'Emily Carroll', 1 , '1998-06-11', 'blankenshipvictor@holt-phillips.org', '072-161-0834x7900', '17CTT3' );
insert into student values('1710463', '+$45BFKs$h', 'Karen Sparks', 1 , '2008-08-08', 'brianna44@gmail.com', '168.229.3436', '17CTT3' );
insert into student values('1710464', 'oY_le6ThAe', 'Juan Griffin', 0 , '1990-08-04', 'watersdiana@hotmail.com', '001-959-725-1123', '17CTT3' );
insert into student values('1710465', '7I!TJDzo+g', 'Gary Carter', 0 , '2002-08-31', 'jgentry@yahoo.com', '001-487-821-7315x81293', '17CTT3' );
insert into student values('1710466', '^1YjJwqO+p', 'Michelle Lopez', 0 , '1991-06-10', 'kpearson@knapp.biz', '(718)747-5841', '17CTT3' );
insert into student values('1710467', 'B_8(wnBxj1', 'Frances Anthony', 1 , '1996-08-07', 'qzuniga@baker-quinn.com', '854-716-0188x666', '17CTT3' );
insert into student values('1710468', 'Xl#3YBsn0Q', 'Andrew Cruz', 0 , '1987-01-03', 'cwilliams@gmail.com', '579.751.2219', '17CTT3' );
insert into student values('1710469', '&9OWNSEqhp', 'William Hall', 0 , '1999-09-26', 'cheryl02@miller.com', '401-136-4494', '17CTT3' );
insert into student values('1710470', 'Ht5JpUbS#N', 'Brooke Mcfarland', 0 , '1989-08-03', 'rflores@mcmahon.com', '+1-387-669-3767x782', '17CTT3' );
insert into student values('1710471', '@o6Gpeyru8', 'Lauren Fox', 1 , '2008-05-24', 'williskatherine@hotmail.com', '+1-814-419-8095x76410', '17CTT3' );
insert into student values('1710472', '*LM$P2JqKH', 'Ryan Hooper', 1 , '2018-09-06', 'parkergregory@jones-gordon.com', '+1-924-933-8811x1094', '17CTT3' );
insert into student values('1710473', 'r226wwSi_c', 'Jermaine Carter', 0 , '1983-04-22', 'qmartinez@hotmail.com', '824-293-7327x4526', '17CTT3' );
insert into student values('1710474', 'wE0Y51kl)*', 'Brandi Scott', 0 , '2014-01-03', 'baldwinkathy@tucker.biz', '+1-130-539-4920x5361', '17CTT3' );
insert into student values('1710475', '#E6Vxt!w8j', 'Christopher Reese', 0 , '1982-12-31', 'gonzalesanthony@yahoo.com', '001-955-939-3170', '17CTT3' );
insert into student values('1710476', '^6zxUCk$X9', 'Dominique Boyle', 0 , '1998-05-29', 'douglaskristen@hotmail.com', '0058550630', '17CTT3' );
insert into student values('1710477', 'FM3fLFa5@_', 'Mr. Edgar Montoya', 0 , '2015-12-28', 'serranotyler@hotmail.com', '(294)250-7547', '17CTT3' );
insert into student values('1710478', '&UY*iZlA&5', 'Lisa Ellis', 0 , '1992-01-15', 'bakermichelle@gmail.com', '001-157-419-8872x6988', '17CTT3' );
insert into student values('1710479', 'o4#wxAb+)2', 'Brandon Lewis', 1 , '1973-11-02', 'ybarrett@bean.com', '181.384.7116x63595', '17CTT3' );
insert into student values('1710480', '8XT3&Fn2$p', 'Nicole Matthews', 1 , '2020-11-23', 'adam27@pacheco-jimenez.com', '257.244.0212', '17CTT3' );
insert into student values('1710481', '%Xk9uP2fu%', 'Danielle Diaz', 1 , '2012-02-11', 'susanhess@hotmail.com', '(013)965-6359x4768', '17CTT3' );
insert into student values('1710482', 'E&J9bEozAt', 'Tyler Mitchell', 0 , '2017-03-20', 'tyler07@gmail.com', '001-345-776-4954x93022', '17CTT3' );
insert into student values('1710483', '!*82U&al^b', 'Howard Wilkinson', 1 , '1989-05-21', 'stephensmith@gmail.com', '551-588-8751x0057', '17CTT3' );
insert into student values('1710484', '^9ErF$CsXq', 'Nicole Hall', 1 , '1976-07-10', 'jessica81@cox-stephens.info', '001-119-453-1073x3352', '17CTT3' );
insert into student values('1710485', '%IOQaImd!1', 'Edward Johnson', 1 , '1999-04-24', 'bfoley@yahoo.com', '001-587-245-6520x214', '17CTT3' );
insert into student values('1710486', '52Wt$m&+(Q', 'Patricia Daniel', 1 , '1992-06-09', 'whitney71@myers-wheeler.net', '491.479.3116x379', '17CTT3' );
insert into student values('1710487', 'T81eQeXf@I', 'Reginald Carter', 0 , '2007-02-12', 'mcculloughalan@hotmail.com', '9770035130', '17CTT3' );
insert into student values('1710488', 'Kp4hU@eR&3', 'James Smith', 1 , '1998-06-24', 'richard76@giles.com', '(356)501-1934', '17CTT3' );
insert into student values('1710489', 'kqh#5Jxr0Y', 'Mark Chavez', 1 , '2002-02-06', 'kevinacevedo@cole.com', '001-919-808-9420', '17CTT3' );
insert into student values('1710490', '4D(Fg@Ia_9', 'Teresa Bass', 1 , '1980-06-01', 'charlesdonaldson@gmail.com', '375-820-1538', '17CTT3' );
insert into student values('1710491', 'VTxGFbn2^3', 'Miss Brittany Watts', 0 , '1996-02-01', 'mahoneyelizabeth@hotmail.com', '001-537-520-0099x9901', '17CTT3' );
insert into student values('1710492', 'N+iF5H@yhX', 'Amber Dixon', 0 , '1991-09-06', 'kathy68@gmail.com', '+1-883-401-8797x567', '17CTT3' );
insert into student values('1710493', 'd7X)XkeE*j', 'Ryan Jordan', 0 , '1973-01-31', 'hfischer@harrison.net', '(105)872-5040', '17CTT3' );
insert into student values('1710494', '(4X6qWVdGH', 'Thomas Martin', 0 , '2017-05-03', 'adamseric@yahoo.com', '(982)082-9333x94517', '17CTT3' );
insert into student values('1710495', '%S9nhGtrho', 'Eric Larson', 0 , '2011-06-13', 'lmcmillan@gray.com', '600.322.7097x26365', '17CTT3' );
insert into student values('1710496', 'y5Snnrog)Q', 'Zachary Gilmore', 1 , '1997-03-04', 'perezbrian@gmail.com', '(925)481-9933x03770', '17CTT3' );
insert into student values('1710497', '$kR+ZLan8A', 'Jordan Johnson', 0 , '1988-07-14', 'vanessa58@haynes-smith.com', '7692045160', '17CTT3' );
insert into student values('1710498', '*hCnFA3d!2', 'Ms. Jennifer Grimes', 0 , '1996-05-03', 'karnold@taylor.com', '001-252-290-4129x8927', '17CTT3' );
insert into student values('1710499', 'H2Wap9Ic$7', 'Jessica Wade', 0 , '1970-07-02', 'benjaminevans@gmail.com', '046-970-6367x00758', '17CTT3' );

