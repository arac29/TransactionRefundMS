insert into event (event_type_id, name, description, start_date,end_date, location, grading_format_id, employee_grade, grade_id) -- PASS | Approved
values (1, 'Masters Data Science', '4 credits for a Data Science course for Masters Degree', '2020-05-01','2020-09-01','Texas University', 1, 'A', 1);

insert into event (event_type_id, name, description, start_date,end_date, location, grading_format_id, employee_grade, grade_id) -- Pending
values (2, 'Microsoft Azure', 'Seminar About Microsoft Azure Basics', '2021-01-20','2021-01-20','Las Vegas', 4, '', null);

insert into event (event_type_id, name, description, start_date,end_date, location, grading_format_id, employee_grade, grade_id) --  Pending
values (3, 'Ethical Hacker', 'Classes for preparation of certification', '2020-11-30','2021-12-30','Standford University', 2, '', null);

insert into event (event_type_id, name, description, start_date,end_date, location, grading_format_id, employee_grade, grade_id) --  Pending 
values (4, 'CompTIA Security+', 'Security Certification Exam', '2021-02-02','2021-03-30','Massachusetts Institute of Technology',3, '', null);

insert into event (event_type_id, name, description, start_date,end_date, location, grading_format_id, employee_grade, grade_id) -- Fail | Declined 
values (5, 'Paython Course', 'Online Course Basics of Paython', '2020-03-05','2020-06-29','Texas University', 1, 'F', 5);

insert into event (event_type_id, name, description, start_date,end_date, location, grading_format_id, employee_grade, grade_id) -- PASS | Approved
values (6, 'Data Science', '4 credits for a Data Science course for Data Science', '2020-11-01','2020-11-28','Texas University', 1, 'A', 1);

insert into event (event_type_id, name, description, start_date,end_date, location, grading_format_id, employee_grade, grade_id) -- Passed | Approved
values (2, 'C# Semminar', 'C# Learning  New Syntax', '2020-11-20','2020-11-20', 'TexasUniversity', 4, 'Present at seminar', 1);


insert into event (event_type_id, name, description, start_date,end_date, location, grading_format_id, employee_grade, grade_id) -- Pending
values (3, 'Google Certified Professional Cloud Architect', 'GCA Certification Classes Basic', '2020-12-28','2021-03-30','Massachusetts Institute of Technology', 2, '', null);

insert into event (event_type_id, name, description, start_date,end_date, location, grading_format_id, employee_grade, grade_id) -- Waiting for grade
values (4, 'AWS Certified Developer  Associate', 'AWS Certification Examn', '2020-11-01','2020-11-30','Massachusetts Institute of Technology', 3, 'Pass 69%', null);

insert into event (event_type_id, name, description, start_date,end_date, location, grading_format_id, employee_grade, grade_id) -- pending
values (4, 'Certified Information Systems Security Professional', 'ISS Certification Examn', '2020-12-20','2021-03-29','Massachusetts Institute of Technology', 3, '', null);

insert into event (event_type_id, name, description, start_date,end_date, location, grading_format_id, employee_grade, grade_id) -- Declined
values (5, 'Web Development', 'Course for Web Development', '2020-02-15','2020-03-14','Massachusetts Institute of Technology', 4, 'Fail Course 44%', 4);

insert into event (event_type_id, name, description, start_date,end_date, location, grading_format_id, employee_grade, grade_id) -- urgent
values (1, 'Programming Basics', '4 credits Learning Basic Programming (VS)', '2020-12-01','2020-12-29','Miami University', 2, '', null);

insert into event (event_type_id, name, description, start_date,end_date, location, grading_format_id, employee_grade, grade_id) -- cancel
values (1, 'Masters Data Science', '4 credits for a Data Science course for Masters Degree', '2020-02-05','2020-05-08','Texas University', 1, 'A', 1);

insert into event (event_type_id, name, description, start_date,end_date, location, grading_format_id, employee_grade, grade_id) -- Pass
values (1, 'Masters Data Science', '4 credits for a Data Science course for Masters Degree', '2020-05-01','2020-09-01','Massachusetts Institute of Technology', 1, 'A', 1);

insert into event (event_type_id, name, description, start_date,end_date, location, grading_format_id, employee_grade, grade_id) -- approval pending
values (1, 'Masters Data Science', '4 credits for a Data Science course for Masters Degree', '2020-10-12','2020-11-25','Standford University', 1, 'A', 1);


/*** Reimbursement ***/

insert into reimbursement (employee_id, event_id, date_submition, employee_cancel, justification, amount_requested, adjusted_amount,
dephead_approval_date, dirsup_approval_date, benco_approval_date, reimbursement_status_id, notes, upload_file_id)
values (100, 1, '2020-04-15', false, 'Implement data science on workplace while working on new technologies', 550.00, 440.00,
'2020-09-16', '2020-09-25', '2020-09-28', 4, 'Presentation was uploaded late', null);

insert into reimbursement (employee_id, event_id, date_submition, employee_cancel, justification, amount_requested, adjusted_amount,
dephead_approval_date, dirsup_approval_date, benco_approval_date, reimbursement_status_id, notes, upload_file_id)
values (104, 2, '2020-11-30', false, 'Learn how to use Azure technologies to implement', 100.00, 60.00, '', '', '', 1, '', null);

insert into reimbursement (employee_id, event_id, date_submition, employee_cancel, justification, amount_requested, adjusted_amount,
dephead_approval_date, dirsup_approval_date, benco_approval_date, reimbursement_status_id, notes, upload_file_id)
values (100, 3, '2020-11-02', false, 'Protect the technologies and information form hackers', 350.00, 262.50, '', '', '', 2, 'Waiting for grades', null);

insert into reimbursement (employee_id, event_id, date_submition, employee_cancel, justification, amount_requested, adjusted_amount,
dephead_approval_date, dirsup_approval_date, benco_approval_date, reimbursement_status_id, notes, upload_file_id)
values (101, 4, '2020-12-05', false, 'Get certified on Security for implementation on work enviorment', 775.00, 775.00, '', '', '', 1, '', null);

insert into reimbursement (employee_id, event_id, date_submition, employee_cancel, justification, amount_requested, adjusted_amount,
dephead_approval_date, dirsup_approval_date, benco_approval_date, reimbursement_status_id, notes, upload_file_id)
values (203, 5, '2020-02-25', false, 'Use paython to create applications', 200.00, 180.00, '2020-07-17', null, '2020-07-22', 7, 'Failed the course - bad grade', null);

insert into reimbursement (employee_id, event_id, date_submition, employee_cancel, justification, amount_requested, adjusted_amount,
dephead_approval_date, dirsup_approval_date, benco_approval_date, reimbursement_status_id, notes, upload_file_id)
values (102, 6, '2020-10-25', false, 'implementing kwnoledge on new technologies', 800.00, 240.00, '2020-11-30', '', '', 2, '', null);

insert into reimbursement (employee_id, event_id, date_submition, employee_cancel, justification, amount_requested, adjusted_amount,
dephead_approval_date, dirsup_approval_date, benco_approval_date, reimbursement_status_id, notes, upload_file_id)
values (200, 7, '2020-10-30', false, 'Starting to work with C# on applications', 150.00, 90.00,  '2020-11-20', null, '2020-11-23', 3, 'Waiting for presentation', null);

insert into reimbursement (employee_id, event_id, date_submition, employee_cancel, justification, amount_requested, adjusted_amount,
dephead_approval_date, dirsup_approval_date, benco_approval_date, reimbursement_status_id, notes, upload_file_id)
values (103, 8, '2020-11-30', false, 'Implementation of new cloud, learning the basics', 500.00, 375.00, '', '', '', 1, '', null);

insert into reimbursement (employee_id, event_id, date_submition, employee_cancel, justification, amount_requested, adjusted_amount,
dephead_approval_date, dirsup_approval_date, benco_approval_date, reimbursement_status_id, notes, upload_file_id)
values (103, 9, '2020-10-14', false, 'Work with AWS Cloud', 550.00, 550.00, '', '', '', 3, '', null);

insert into reimbursement (employee_id, event_id, date_submition, employee_cancel, justification, amount_requested, adjusted_amount,
dephead_approval_date, dirsup_approval_date, benco_approval_date, reimbursement_status_id, notes, upload_file_id)
values (104, 10, '2020-11-30', false, 'Security for applications', 650.00, 650.00, '', '', '', 1, '', null);

insert into reimbursement (employee_id, event_id, date_submition, employee_cancel, justification, amount_requested, adjusted_amount,
dephead_approval_date, dirsup_approval_date, benco_approval_date, reimbursement_status_id, notes, upload_file_id)
values (200, 11, '2020-01-28', false, 'Fix webpages or create new ones', 700.00, 630.00, '2020-03-20', null, '2020-03-30', 7, 'Failed', null);

insert into reimbursement (employee_id, event_id, date_submition, employee_cancel, justification, amount_requested, adjusted_amount,
dephead_approval_date, dirsup_approval_date, benco_approval_date, reimbursement_status_id, notes, upload_file_id)
values (105, 12, '2020-11-28', false, 'Learn about the subject to implement', 800.00, 640.00, '', '', '', 6, 'Employee knew about the event late', null);

insert into reimbursement (employee_id, event_id, date_submition, employee_cancel, justification, amount_requested, adjusted_amount,
dephead_approval_date, dirsup_approval_date, benco_approval_date, reimbursement_status_id, notes, upload_file_id)
values (100, 13, '2020-01-15', true, '', 650.00, 520.00, '', '', '2020-04-11', 5, 'Employee Cancelled Request', null);

insert into reimbursement (employee_id, event_id, date_submition, employee_cancel, justification, amount_requested, adjusted_amount,
dephead_approval_date, dirsup_approval_date, benco_approval_date, reimbursement_status_id, notes, upload_file_id)
values (107, 14, '2020-04-28', false, 'Learn how to work with the applications', 800.00, 640.00, '2020-09-11', '2020-09-15', '2020-09-30', 4, '', null);

insert into reimbursement (employee_id, event_id, date_submition, employee_cancel, justification, amount_requested, adjusted_amount,
dephead_approval_date, dirsup_approval_date, benco_approval_date, reimbursement_status_id, notes, upload_file_id)
values (106, 15, '2020-09-28', false, 'learning', 900.00, 720.00, '2020-11-28', '', '', 3, 'Waiting for grades', null);

