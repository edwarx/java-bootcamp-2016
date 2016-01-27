select concat(t.last_name, ', ', t.first_name) as 'Teacher', concat (cs.day, ' ', date_format(cs.start, '%H:%i'), ' - ', date_format(cs.end, '%H:%i'), ': ', c.name) as 'Schedule'
from teacher t join course c on c.teacher = t.id_teacher
join course_schedule cs on cs.course = c.id_course
where t.id_teacher = 1
order by FIELD(lower(cs.day), 'monday', 'tuesday', 'wednesday', 'thursday', 'friday', 'saturday', 'sunday'), cs.start;