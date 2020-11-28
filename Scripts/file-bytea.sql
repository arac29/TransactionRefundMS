insert into upload_file (upload_file_id, "fileName", "content")
values(1, 'Grades Certification Exan', pg_read_binary_file('C:/grades/grade.pdf'));

select *
from upload_file 
where upload_file_id = 1;

update upload_file 
set 
"fileName" = 'Grades',
"content"  = pg_read_binary_file('C:/grades/grades1.pdf')
where upload_file_id = 1;

delete from upload_file where upload_file_id = 1;