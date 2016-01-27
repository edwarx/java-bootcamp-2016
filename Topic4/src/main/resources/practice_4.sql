SELECT count(*) * 100 / (select count(*) from student_x_course sc join course c on sc.course = c.id_course where c.name like 'English') as 'Passed %' 
from student_x_course sc
join course c on sc.course = c.id_course
join grade g on sc.course = g.course and sc.student = g.student
join grade_type gt on g.grade_type = gt.grade_type_id
where c.name LIKE 'English' 
and gt.name LIKE 'Final'
and g.grade >= 4;

SELECT count(*) * 100 / (select count(*) from student_x_course sc join course c on sc.course = c.id_course where c.name like 'English') as 'Passed %' 
from student_x_course sc
join course c on sc.course = c.id_course
join grade g on sc.course = g.course and sc.student = g.student
join grade_type gt on g.grade_type = gt.grade_type_id
where c.name LIKE 'English' 
and gt.name LIKE 'Final'
and g.grade < 4;
