/******
*DROP Tables*
************/
Drop Table "login";
Drop table "reimbursement_amount";
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
	"employee_id" int,	
	"username" varchar(100),
  	"password" varchar(100)
);

CREATE INDEX "PK.FK" ON  "login" ("employee_id");

CREATE TABLE "employee" (
	"employee_id" int default nextval ('seqPK_employee'),
  	"title" varchar(50),
  	"reports_to" int4,
  	"first_name" varchar(40),
  	"middle_name" varchar(40),
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
	"reimbursement_id" int default nextval ('seqPK_reimbursement'),
	"employee_id" int4,
	"event_id" int4,
	"date_submition" date,
	"employee_cancel" boolean,
	"justification" varchar(280),
	"amount_requested" numeric(6,2),
	"amount_awarded" numeric(6,2),
	"benco_approval_date" date,
	"dirsup_approval_date" date,
	"dephead_approval_date" date,
	"reimbursement_status_id" int4,
	"notes" varchar(350),
	"upload_file_id" int4,
	PRIMARY KEY ("reimbursement_id")
);

CREATE TABLE "upload_file" (
	"upload_file_id" serial,
	"reimbursement_id" int4,
	"content" bytea,
	PRIMARY KEY ("upload_file_id")
);

CREATE TABLE "reimbursement_status" -- Reference Table
(
	"reimbursement_status_id" int4,
	"status" varchar(250),
	PRIMARY KEY ("reimbursement_status_id")
);

CREATE TABLE "reimbursement_amount" (
	"reimbursement_amount_id" serial,
	"employee_id" int4,
	"pending_amount" numeric(6,2),
	"awarded_amount" numeric(6,2),
	"total_amount" numeric(6,2),
	"available_amount" numeric(6,2),
	PRIMARY KEY ("reimbursement_amount_id")
);

CREATE TABLE "event" (
	"event_id" int default nextval ('seqPK_event'),
	"event_type_id" int4,
	"name" varchar(80),
	"description" varchar(350),
	"start_date" date,
	"end_date" date,
	"time" time,
	"location" varchar(100),
	"cost" numeric(6,2),
	"grading_format_event" varchar(50),
	"grading_format_id" int4,
	"grade_id" int4,
	PRIMARY KEY ("event_id")
);

CREATE TABLE "event_type" --- Reference Table
(
	"event_type_id" int4, 
	"event_type_names" varchar(100),
	"event_type_percentage" numeric(3,2),
	PRIMARY KEY ("event_type_id")	
);

CREATE TABLE "grading_format_company" -- Reference TABLE
(
	"grading_format_id" int4,
	"grading_format" varchar(100), 
	PRIMARY KEY ("grading_format_id")
);

CREATE TABLE "grade" -- Reference Table
(
	"grade_id" int4, 
	"grade_letter" varchar(3),
	"min_percentage" numeric(6,2),
	"max_percentage" numeric(6,2), 
	"pass_fail" varchar(4),
	PRIMARY KEY ("grade_id")
);


/****************************
*Add Foriegn Key Constraints*
****************************/
ALTER TABLE reimbursement ADD CONSTRAINT FK_Employee_ID
FOREIGN KEY (employee_id) REFERENCES employee (employee_id);

ALTER TABLE reimbursement ADD CONSTRAINT FK_Event_ID
FOREIGN KEY (event_id) REFERENCES "event" (event_id);

ALTER TABLE reimbursement ADD CONSTRAINT FK_UploadFile_ID
FOREIGN KEY (upload_file_id) REFERENCES upload_file (upload_file_id);

ALTER TABLE reimbursement ADD CONSTRAINT FK_ReimStatus_ID
FOREIGN KEY (reimbursement_status_id) REFERENCES reimbursement_status (reimbursement_status_id);

ALTER TABLE "event" ADD CONSTRAINT FK_EventType_ID
FOREIGN KEY (event_type_id) REFERENCES event_type (event_type_id);

ALTER TABLE "event" ADD CONSTRAINT FK_GradeFormat_ID
FOREIGN KEY (grading_format_id) REFERENCES grading_format_company (grading_format_id);

ALTER TABLE "event" ADD CONSTRAINT FK_Grad_ID
FOREIGN KEY (grade_id) REFERENCES grade (grade_id);

ALTER TABLE reimbursement_amount ADD CONSTRAINT FK_Employee_ID
FOREIGN KEY (employee_id) REFERENCES employee (employee_id);

/*************************
*Add Reference Table Data*
*************************/

INSERT INTO event_type (event_type_id, event_type_names, event_type_percentage) VALUES (1, 'University Course', 0.80);
INSERT INTO event_type (event_type_id, event_type_names, event_type_percentage) VALUES (2, 'Seminar', 0.60);
INSERT INTO event_type (event_type_id, event_type_names, event_type_percentage) VALUES (3, 'Certification Preparation Classe', 0.75);
INSERT INTO event_type (event_type_id, event_type_names, event_type_percentage) VALUES (4, 'Certification Exam', 1.00);
INSERT INTO event_type (event_type_id, event_type_names, event_type_percentage) VALUES (5, 'Technical Training', 0.90);
INSERT INTO event_type (event_type_id, event_type_names, event_type_percentage) VALUES (6, 'Other', 0.30);

INSERT INTO grading_format_company (grading_format_id, grading_format) VALUES (1, 'Letter grading and variations');
INSERT INTO grading_format_company (grading_format_id, grading_format) VALUES (2, 'Percentage Grading');
INSERT INTO grading_format_company (grading_format_id, grading_format) VALUES (3, 'Pass/Fail');

INSERT INTO grade (grade_id, grade_letter, min_percentage, max_percentage, pass_fail) VALUES (1,'A', 90, 100, 'Pass');
INSERT INTO grade (grade_id, grade_letter, min_percentage, max_percentage, pass_fail) VALUES (2,'B', 80,  89, 'Pass');
INSERT INTO grade (grade_id, grade_letter, min_percentage, max_percentage, pass_fail) VALUES (3,'C', 70,  79, 'Pass');
INSERT INTO grade (grade_id, grade_letter, min_percentage, max_percentage, pass_fail) VALUES (4,'D', 60,  69, 'Fail');
INSERT INTO grade (grade_id, grade_letter, min_percentage, max_percentage, pass_fail) VALUES (5,'F',  0,  59, 'Fail');

INSERT INTO reimbursement_status (reimbursement_status_id, status) VALUES (1,'Pending');
INSERT INTO reimbursement_status (reimbursement_status_id, status) VALUES (2,'Grade Pending');
INSERT INTO reimbursement_status (reimbursement_status_id, status) VALUES (3,'Approval Pending');
INSERT INTO reimbursement_status (reimbursement_status_id, status) VALUES (4,'Awarded');
INSERT INTO reimbursement_status (reimbursement_status_id, status) VALUES (5,'Cancelled');
INSERT INTO reimbursement_status (reimbursement_status_id, status) VALUES (6,'Urgent');
INSERT INTO reimbursement_status (reimbursement_status_id, status) VALUES (7,'Denied');