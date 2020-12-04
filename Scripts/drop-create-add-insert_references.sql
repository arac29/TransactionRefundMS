/***********************
*DROP Database Tables*
***********************/
Drop Table "login";
Drop Table "reimbursement";
Drop Table "reimbursement_status";
Drop Table "upload_file";
Drop Table "event";
Drop table "grade";
Drop Table "event_type";
Drop Table "grading_format_company";
Drop Table "employee";

Drop sequence seqPK_employee;
Drop sequence seqPK_reimbursement;
Drop sequence seqPK_event;
/*****************************
*Create Primary Key Sequences*
*****************************/
CREATE SEQUENCE seqPK_employee;
CREATE SEQUENCE seqPK_reimbursement;
CREATE SEQUENCE seqPK_event;
/***********************
*Create Database Tables*
***********************/
CREATE TABLE "login" (
    "employee_id" int4 not null,    
    "username" varchar(100),
    "password" varchar(100)
);
CREATE INDEX "PK.FK" ON  "login" ("employee_id");


CREATE TABLE "employee" (
	"employee_id" int default nextval ('seqPK_employee') not null,
  	"title" varchar(50),
  	"reports_to" int4,
  	"first_name" varchar(40),
  	"last_name" varchar(40),
  	"date_birth" date,
  	"phone_number" varchar(24),
  	"email" varchar(60),
  	"address" varchar(80),
  	"city" varchar(50),
  	"state" varchar(50),
  	"country" varchar(50),
  	"postal_code" varchar(10),
  	PRIMARY KEY ("employee_id")
);
CREATE TABLE "reimbursement" (
	"reimbursement_id" int default nextval ('seqPK_reimbursement') not null,
	"employee_id" int4 not null,
	"event_id" int4 not null,
	"date_submition" date,
	"employee_cancel" boolean,
	"justification" varchar(280),
	"amount_requested" numeric(6,2), -- original amount
	"adjusted_amount" numeric(6,2), -- fixed amount
	"dephead_approval_date" varchar(50),
	"dirsup_approval_date" varchar(50),
	"benco_approval_date" varchar(50),
	"reimbursement_status_id" int4,
	"notes" varchar(350),
	"upload_file_id" int4,
	PRIMARY KEY ("reimbursement_id")
);


CREATE TABLE "upload_file" (
	"upload_file_id" serial,
	"fileName" varchar(150),
	"content" bytea,
	PRIMARY KEY ("upload_file_id")
);

CREATE TABLE "reimbursement_status" -- Reference Table
(
	"reimbursement_status_id" int4 not null,
	"status" varchar(250),
	PRIMARY KEY ("reimbursement_status_id")
);


CREATE TABLE "event" (
	"event_id" int default nextval ('seqPK_event') not null,
	"event_type_id" int4 not null,
	"name" varchar(80),
	"description" varchar(350),
	"start_date" varchar(50),
	"end_date" varchar(50),
	"location" varchar(100),
	"grading_format_id" int4,
	"employee_grade" varchar(30),
	"grade_id" int4,
	PRIMARY KEY ("event_id")
);

CREATE TABLE "event_type" --- Reference Table
(
	"event_type_id" int4 not null, 
	"event_type_names" varchar(100),
	"event_type_percentage" numeric(3,2),
	PRIMARY KEY ("event_type_id")	
);

CREATE TABLE "grading_format_company" -- Reference TABLE
(
	"grading_format_id" int4 not null,
	"grading_format" varchar(100), 
	PRIMARY KEY ("grading_format_id")
);

CREATE TABLE "grade" -- Reference Table
(
	"grade_id" int4 not null, 
	"grade_letter" varchar(3),
	"min_percentage" numeric(6,2),
	"max_percentage" numeric(6,2), 
	"pass_fail" varchar(4),
	"reference_grade" varchar(10),
	PRIMARY KEY ("grade_id")
);


/****************************
Add Foriegn Key Constraints
****************************/
ALTER TABLE reimbursement ADD CONSTRAINT FK_Employee_ID
FOREIGN KEY (employee_id) REFERENCES employee (employee_id);
ALTER TABLE reimbursement ADD CONSTRAINT FK_Event_ID
FOREIGN KEY (event_id) REFERENCES "event" (event_id);
ALTER TABLE reimbursement ADD CONSTRAINT FK_UploadFile_ID
FOREIGN KEY (upload_file_id) REFERENCES upload_file (upload_file_id)
on delete cascade;
ALTER TABLE reimbursement ADD CONSTRAINT FK_ReimStatus_ID
FOREIGN KEY (reimbursement_status_id) REFERENCES reimbursement_status (reimbursement_status_id);
ALTER TABLE "event" ADD CONSTRAINT FK_EventType_ID
FOREIGN KEY (event_type_id) REFERENCES event_type (event_type_id);
ALTER TABLE "event" ADD CONSTRAINT FK_GradeFormat_ID
FOREIGN KEY (grading_format_id) REFERENCES grading_format_company (grading_format_id);
ALTER TABLE "event" ADD CONSTRAINT FK_Grad_ID
FOREIGN KEY (grade_id) REFERENCES grade (grade_id);

/*************************
*Add Reference Table Data*
*************************/
INSERT INTO event_type (event_type_id, event_type_names, event_type_percentage) VALUES (1, 'University Course', 0.80);
INSERT INTO event_type (event_type_id, event_type_names, event_type_percentage) VALUES (2, 'Seminar', 0.60);
INSERT INTO event_type (event_type_id, event_type_names, event_type_percentage) VALUES (3, 'Certification Preparation Classes', 0.75);
INSERT INTO event_type (event_type_id, event_type_names, event_type_percentage) VALUES (4, 'Certification Exam', 1.00);
INSERT INTO event_type (event_type_id, event_type_names, event_type_percentage) VALUES (5, 'Technical Training', 0.90);
INSERT INTO event_type (event_type_id, event_type_names, event_type_percentage) VALUES (6, 'Other', 0.30);

INSERT INTO grading_format_company (grading_format_id, grading_format) VALUES (1, 'Letter grading and variations');
INSERT INTO grading_format_company (grading_format_id, grading_format) VALUES (2, 'Percentage Grading');
INSERT INTO grading_format_company (grading_format_id, grading_format) VALUES (3, 'Pass/Fail');
INSERT INTO grading_format_company (grading_format_id, grading_format) VALUES (4, 'Reference Grade');

INSERT INTO grade (grade_id, grade_letter, min_percentage, max_percentage, pass_fail, reference_grade) VALUES (1,'A', 90, 100, 'Pass', 'Excellent');
INSERT INTO grade (grade_id, grade_letter, min_percentage, max_percentage, pass_fail, reference_grade) VALUES (2,'B', 80,  89, 'Pass', 'Good');
INSERT INTO grade (grade_id, grade_letter, min_percentage, max_percentage, pass_fail, reference_grade) VALUES (3,'C', 70,  79, 'Pass', 'Average');
INSERT INTO grade (grade_id, grade_letter, min_percentage, max_percentage, pass_fail, reference_grade) VALUES (4,'D', 60,  69, 'Fail', 'Poor, pass');
INSERT INTO grade (grade_id, grade_letter, min_percentage, max_percentage, pass_fail, reference_grade) VALUES (5,'F',  0,  59, 'Fail', 'Failure');

INSERT INTO reimbursement_status (reimbursement_status_id, status) VALUES (1,'Pending');
INSERT INTO reimbursement_status (reimbursement_status_id, status) VALUES (2,'Grade Pending');
INSERT INTO reimbursement_status (reimbursement_status_id, status) VALUES (3,'Approval Pending');
INSERT INTO reimbursement_status (reimbursement_status_id, status) VALUES (4,'Awarded');
INSERT INTO reimbursement_status (reimbursement_status_id, status) VALUES (5,'Cancelled');
INSERT INTO reimbursement_status (reimbursement_status_id, status) VALUES (6,'Urgent');
INSERT INTO reimbursement_status (reimbursement_status_id, status) VALUES (7,'Denied');
/*****************************
*Add Dummy Information Tables*
*****************************/
--insert into event (event_type_id,name,description,start_date,end_date,total_hours_on_event, location, grading_format_id, grade_id) values (1, 'Masters Data Science', '4 credits for a Data Science course for Masters Degree',
--'2020-12-20','2021-03-29', null,'Texas University',3,1);

-- after adding even, add reimbursement
insert into reimbursement (employee_id, event_id, date_submition, employee_cancel, justification, amount_requested, 
dirsup_approval_date, dephead_approval_date, benco_approval_date, reimbursement_status_id, notes, upload_file_id) 
values (200, 1, '2020-09-10', false, 'Learn more about JavaScript', 500.00, '2020-09-13', '2020-09-20', '2020-09-30', 
2, 'Waiting for grade to be awarded', null);
insert into reimbursement_amount (employee_id, awarded_amount, total_amount, available_amount) 
values (200, 0.0, 1000.00, 1000.00);



