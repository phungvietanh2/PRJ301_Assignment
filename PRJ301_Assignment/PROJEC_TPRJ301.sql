USE [master]
GO
/****** Object:  Database [GradeManagement]    Script Date: 6/24/2022 9:55:50 PM ******/
CREATE DATABASE [GradeManagement]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'GradeManagement', FILENAME = N'E:\Program\MSSQL15.SQLEXPRESS\MSSQL\DATA\GradeManagement.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'GradeManagement_log', FILENAME = N'E:\Program\MSSQL15.SQLEXPRESS\MSSQL\DATA\GradeManagement_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [GradeManagement] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [GradeManagement].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [GradeManagement] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [GradeManagement] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [GradeManagement] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [GradeManagement] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [GradeManagement] SET ARITHABORT OFF 
GO
ALTER DATABASE [GradeManagement] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [GradeManagement] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [GradeManagement] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [GradeManagement] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [GradeManagement] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [GradeManagement] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [GradeManagement] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [GradeManagement] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [GradeManagement] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [GradeManagement] SET  DISABLE_BROKER 
GO
ALTER DATABASE [GradeManagement] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [GradeManagement] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [GradeManagement] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [GradeManagement] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [GradeManagement] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [GradeManagement] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [GradeManagement] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [GradeManagement] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [GradeManagement] SET  MULTI_USER 
GO
ALTER DATABASE [GradeManagement] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [GradeManagement] SET DB_CHAINING OFF 
GO
ALTER DATABASE [GradeManagement] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [GradeManagement] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [GradeManagement] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [GradeManagement] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [GradeManagement] SET QUERY_STORE = OFF
GO
USE [GradeManagement]
GO
/****** Object:  Table [dbo].[Account]    Script Date: 6/24/2022 9:55:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Account](
	[id] [int] NOT NULL,
	[username] [nvarchar](16) NOT NULL,
	[password] [nvarchar](16) NOT NULL,
 CONSTRAINT [PK_Account] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Class]    Script Date: 6/24/2022 9:55:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Class](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[class_name] [nvarchar](10) NOT NULL,
 CONSTRAINT [PK_CLass] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Grade]    Script Date: 6/24/2022 9:55:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Grade](
	[id_student] [int] NOT NULL,
	[id_subject] [int] NOT NULL,
	[assignment1] [float] NULL,
	[assignment2] [float] NULL,
	[midpoint] [float] NULL,
	[final] [float] NULL,
	[grade] [float] NULL,
	[status] [nvarchar](10) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Role_Account]    Script Date: 6/24/2022 9:55:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Role_Account](
	[id_student] [int] NULL,
	[id_account] [int] NULL,
	[role] [nvarchar](10) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Student]    Script Date: 6/24/2022 9:55:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Student](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[student_name] [nvarchar](50) NOT NULL,
	[student_code] [nvarchar](8) NOT NULL,
 CONSTRAINT [PK_student] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Student_Class]    Script Date: 6/24/2022 9:55:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Student_Class](
	[id_student] [int] NOT NULL,
	[id_class] [int] NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Student_Subject]    Script Date: 6/24/2022 9:55:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Student_Subject](
	[id_student] [int] NOT NULL,
	[id_subject] [int] NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Subject]    Script Date: 6/24/2022 9:55:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Subject](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[subject_name] [nvarchar](10) NOT NULL,
 CONSTRAINT [PK_Subject] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Subject_Class]    Script Date: 6/24/2022 9:55:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Subject_Class](
	[id_subject] [int] NOT NULL,
	[id_class] [int] NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Term]    Script Date: 6/24/2022 9:55:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Term](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[term_name] [nvarchar](12) NOT NULL,
 CONSTRAINT [PK_Term] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Account] ([id], [username], [password]) VALUES (1, N'lamnt', N'123456')
INSERT [dbo].[Account] ([id], [username], [password]) VALUES (2, N'anhpn', N'123456')
INSERT [dbo].[Account] ([id], [username], [password]) VALUES (3, N'admin', N'admin')
GO
SET IDENTITY_INSERT [dbo].[Class] ON 

INSERT [dbo].[Class] ([id], [class_name]) VALUES (1, N'SE1609')
INSERT [dbo].[Class] ([id], [class_name]) VALUES (2, N'SE1521')
SET IDENTITY_INSERT [dbo].[Class] OFF
GO
INSERT [dbo].[Role_Account] ([id_student], [id_account], [role]) VALUES (1, 1, N'user')
INSERT [dbo].[Role_Account] ([id_student], [id_account], [role]) VALUES (2, 2, N'admin')
INSERT [dbo].[Role_Account] ([id_student], [id_account], [role]) VALUES (3, 3, N'admin')
GO
SET IDENTITY_INSERT [dbo].[Student] ON 

INSERT [dbo].[Student] ([id], [student_name], [student_code]) VALUES (1, N'Nguyễn Tùng Lâm', N'HE156781')
INSERT [dbo].[Student] ([id], [student_name], [student_code]) VALUES (3, N'Nguyễn Việt Anh', N'HE167231')
INSERT [dbo].[Student] ([id], [student_name], [student_code]) VALUES (4, N'Lâm Đình Khoa', N'HE161237')
INSERT [dbo].[Student] ([id], [student_name], [student_code]) VALUES (5, N'Tô Hồng Linh', N'HE176283')
SET IDENTITY_INSERT [dbo].[Student] OFF
GO
SET IDENTITY_INSERT [dbo].[Subject] ON 

INSERT [dbo].[Subject] ([id], [subject_name]) VALUES (1, N'PRJ301')
INSERT [dbo].[Subject] ([id], [subject_name]) VALUES (2, N'PRO192')
INSERT [dbo].[Subject] ([id], [subject_name]) VALUES (3, N'SWP391')
INSERT [dbo].[Subject] ([id], [subject_name]) VALUES (4, N'PRF192')
INSERT [dbo].[Subject] ([id], [subject_name]) VALUES (5, N'MAD201')
SET IDENTITY_INSERT [dbo].[Subject] OFF
GO
SET IDENTITY_INSERT [dbo].[Term] ON 

INSERT [dbo].[Term] ([id], [term_name]) VALUES (1, N'Spring 2022')
INSERT [dbo].[Term] ([id], [term_name]) VALUES (2, N'Summer 2022')
INSERT [dbo].[Term] ([id], [term_name]) VALUES (3, N'Fall 2022')
SET IDENTITY_INSERT [dbo].[Term] OFF
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [IX_Account]    Script Date: 6/24/2022 9:55:51 PM ******/
CREATE UNIQUE NONCLUSTERED INDEX [IX_Account] ON [dbo].[Account]
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Grade] ADD  CONSTRAINT [DF_grade_status]  DEFAULT (N'NOT PASS') FOR [status]
GO
USE [master]
GO
ALTER DATABASE [GradeManagement] SET  READ_WRITE 
GO
