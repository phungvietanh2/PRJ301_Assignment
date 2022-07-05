
Create Table Student
 ( Sid int  primary key  not null,
   Sname nvarchar(50) not null,
   Sgender nvarchar(50)not null ,
   Sdob  date not null ,
   Sgmail nvarchar(50)not null ,
   Sstart nvarchar(50) not null ,
 )
 
Create Table Teacher
 ( Teid int  primary key IDENTITY(1,1) not null,
   Tename   nvarchar(50)  not null
 )

  create table Term (
   Tid int primary key IDENTITY(1,1) not null ,
   Tname nvarchar(50)  not null 
 )
 Create Table Course
 (  
   Coid nvarchar(50) primary key  NOT NULL ,
   Coname nvarchar(50) not null ,
   Cocredit int not null,
   Tid int foreign key references [Term](Tid) not null ,
   Teid int foreign key references [Teacher](Teid) not null
 )
 create table [Group] (
     Gid  nvarchar(50) primary key not null ,
     Coid  nvarchar(50)  foreign key references Course(Coid) not null ,
	 Teid  int foreign key references Teacher(Teid) not null ,
	  Clstart date not null ,
    Clend date not null
 )
 create table [GroupStudent] (
     Gid nvarchar(50)  foreign key references  [Group](Gid) not null,
     Sid  int  foreign key references Student(Sid) not null ,
	  PRIMARY KEY (Gid,Sid) 
 )

Create Table Assessment
 (
   Aid int  primary key  not null,
   Aname nvarchar(50) not null ,
   Aweight float ,
   Coid nvarchar(50) foreign key references Course(Coid) not null
)
Create Table AssessmentIDStudent 
 ( 
   Asid int primary key IDENTITY(1,1) not null,
   Aid int  foreign key references Assessment(Aid) not null,
   Sid int  foreign key references Student(Sid)not null,
   Mark float not null ,
   Asdate date not null
)

 create table Account (
	  username nvarchar(150) primary key not null,
	  [password] nvarchar(150) not null, 
	  displayname nvarchar(150) not null ,
	  Sid int foreign key references Student(Sid) , 
	  Teid int foreign key references Teacher(Teid)  
	  Arole int not null;
 )

 create table Role (
	 Rid int primary key not null,
	 Rname nvarchar(150) not null
 )

 create table [Role Acount ]  (
     username nvarchar(150) foreign key references Account(username) not null,
	 Rid int foreign key references Role(Rid) not null,
	 PRIMARY KEY (username,Rid) 
 )
 create table [Feature]  (
     Fid int PRIMARY KEY  not null ,
	 Fname nvarchar(150) not null,
	 Furl nvarchar(max) not null
 )

  create table [Role Feature ]  (
     Fid int foreign key references [Feature](Fid) not null,
	 Rid int foreign key references Role(Rid) not null,
	 PRIMARY KEY (Fid,Rid) 
 )

insert into Term values('Summer2022')

insert into Student values( 153700,N'Bùi Hoàng Việt','Male ','2001/09/01','21@fpt.edu.vn','SU22 ')
insert into Student values(153701,N'Nguyễn Ngọc Năng','Male ','2001/09/01','21@fpt.edu.vn','SU22')
insert into Student values(153702,N'Nguyễn Anh Kiên','Male ','2001/09/01','21@fpt.edu.vn','SU22 ')
insert into Student values(153703,N'Lương Quang Thọ','Male ','2001/09/01','21@fpt.edu.vn','SU22 ')
insert into Student values( 153704,N'Tống Sỹ Nhật','Male ','2001/09/01','21@fpt.edu.vn','SU22')
insert into Student values(153705,N'Nguyễn Trường Thành','Male ','2001/09/01','21@fpt.edu.vn','SU22')
insert into Student values(153706,N'Đỗ Đức Việt','Male ','2001/09/01','21@fpt.edu.vn','SU22')
insert into Student values(153707,N'Phùng Tuấn Việt','Male ','2001/09/01','21@fpt.edu.vn','SU22')

insert into Teacher values(N'Đinh Thành Trung')
insert into Teacher values(N'Nguyễn Hoàng Anh')
insert into Teacher values(N'Ngô Tùng Sơn')
insert into Teacher values(N'Hoàng Xuân Sơn')
insert into Teacher values(N'Phạm Đức Thắng')

insert into Course values('IOT102','Internet of Things (IOT102)',3,1, 4)
insert into Course values('JPD123 ','Elementary Japanese 1-A1.2 (JPD123) ',3,1,2)
insert into Course values('MAS291','Statistics and Probability (MAS291)',3,1,1)
insert into Course values('PRJ301','Java Web Application Development (PRJ301) ',3,1,3)
insert into Course values('SWE201c','	Introduction to Software Engineering(SWE201c)',3,1,5)


insert into [Group] values('SE1',N'IOT102',4, '2022-01-01','2022-04-01')
insert into [Group] values('SE2',N'JPD123',2, '2022-01-01','2022-04-01')
insert into [Group] values('SE3',N'MAS291', 1,'2022-01-01','2022-04-01')
insert into [Group] values('SE4',N'PRJ301',3, '2022-01-01','2022-04-01')
insert into [Group] values('SE5',N'SWE201C',5, '2022-01-01','2022-04-01')

insert into GroupStudent values('SE1',153700 )
insert into GroupStudent values('SE1',153701 )
insert into GroupStudent values('SE1',153702 )
insert into GroupStudent values('SE1',153703)
insert into GroupStudent values('SE1',153704)

insert into GroupStudent values('SE2',153705 )
insert into GroupStudent values('SE2',153706)
insert into GroupStudent values('SE2',153707)
insert into GroupStudent values('SE2',153700)
insert into GroupStudent values('SE2',153702)

insert into GroupStudent values('SE3' ,153700)

insert into GroupStudent values('SE4',153700)
insert into GroupStudent values('SE5',153700)
insert into GroupStudent values('SE6',153700)



insert into Assessment values(1,'Active learning',0.1,N'IOT102')
insert into Assessment values(2,'Exercise 1',0.05,N'IOT102' )
insert into Assessment values(3,'Exercise 2',0.05,N'IOT102' )
insert into Assessment values(4,'Presentation',0.1,N'IOT102')
insert into Assessment values(5,'Project',0.3,N'IOT102' )
insert into Assessment values(6,'Final Exam',0.4,N'IOT102' )


insert into Assessment  values(7,'Progress test 1',0.05,N'PRJ301')
insert into Assessment values(8,'Progress test 2',0.05,N'PRJ301')
insert into Assessment values(9,'Workshop 1',0.05,N'PRJ301' )
insert into Assessment values(10,'Workshop 2',0.05,N'PRJ301' )
insert into Assessment values(11,'Practical Exam',0.2,N'PRJ301')
insert into Assessment values(12,'Assignment',0.4,N'PRJ301' )
insert into Assessment  values(13,'Final Exam ',0.2,N'PRJ301')

insert into Assessment values(14,'Participation',0.05,N'JPD123' )
insert into Assessment  values(15,'Progress test 1',0.05,N'JPD123')
insert into Assessment values(16,'Progress test 2',0.05,N'JPD123')
insert into Assessment values(17,'Mid-term test',0.05,N'JPD123' )
insert into Assessment values(18,'FE: Listening',0.2,N'JPD123')
insert into Assessment values(19,'FE: GVR',0.4,N'JPD123' )


insert into Assessment values(20,'Computer Project',15,N'MAS291' )
insert into Assessment values(21,'Assignment 1',10,N'MAS291' )
insert into Assessment values(22,'Assignment 2',10,N'MAS291')
insert into Assessment  values(23,'Progress test 1',10,N'MAS291')
insert into Assessment values(24,'Progress test 2',10,N'MAS291')
insert into Assessment values(25,'Progress test 3',10,N'MAS291' )
insert into Assessment values(26,'Final Exam',35,N'MAS291' )


insert into Assessment values(27,'Practical Exam',50,N'SWE201c' )
insert into Assessment values(28,'Final Exam',50,N'SWE201c' )

insert into Assessment values(29,'Assignment 1',10,N'SWP391' )
insert into Assessment values(30,'Assignment 2',10,N'SWP391')
insert into Assessment  values(31,'Progress test 1',10,N'SWP391')
insert into Assessment values(32,'Progress test 2',10,N'SWP391')
insert into Assessment values(33,'Computer Project',30,N'SWP391' )
insert into Assessment values(34,'Final Exam',30,N'SWP391' )

insert into AssessmentIDStudent values(7,153700,1,'2001-01-01')
insert into AssessmentIDStudent values(2,1,9,'2002-01-01')
insert into AssessmentIDStudent values(7,2,9,'2002-01-01')
