select date_submition, amount_requested, dirsup_approval_date , dephead_approval_date, 
benco_approval_date ,notes ,status,name, grading_format, first_name, last_name from reimbursement
inner join event on reimbursement.event_id =event.event_id 
inner join employee on reimbursement.employee_id = employee.employee_id 
inner join grading_format_company on  grading_format_company.grading_format_id=event.grading_format_id
inner join  reimbursement_status  on reimbursement.reimbursement_status_id = reimbursement_status.reimbursement_status_id
where reimbursement.employee_id = 100 ;
