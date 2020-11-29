select reimbursement_id, date_submition, amount_requested, dirsup_approval_date , dephead_approval_date, 
benco_approval_date ,notes ,status,name, grading_format, first_name, last_name ,grade_letter from reimbursement
inner join event on reimbursement.event_id =event.event_id 
inner join employee on reimbursement.employee_id = employee.employee_id 
inner join grading_format_company on  grading_format_company.grading_format_id=event.grading_format_id
inner join  reimbursement_status  on reimbursement.reimbursement_status_id = reimbursement_status.reimbursement_status_id
inner join grade on event.grade_id=grade.grade_id 
where reimbursement.employee_id = 100 ;

select *
from event e
left outer join reimbursement r 
on r.event_id = e.event
where employee_id = 100;

-- ** REPORTS TO REIMBURSEMENTS
select r.reimbursement_id, r.employee_id, r.event_id, r.date_submition, r.employee_cancel, r.justification, 
r.amount_requested, r.dirsup_approval_date, r.dephead_approval_date, r.benco_approval_date, r.reimbursement_status_id,
r.notes, r.upload_file_id 
from reimbursement r 
inner join employee e 
on r.employee_id = e.employee_id 
where reports_to = 200;

-- READ EVENTS REORTS TO.
select e.event_id, e.event_type_id, e."name", e.description, e.start_date, e.end_date, e."location", e.grading_format_id, e.grade_id 
from "event" e
join reimbursement r 
on e.event_id = r.event_id 
join employee em
on r.employee_id = em.employee_id 
where em.reports_to = 200;



