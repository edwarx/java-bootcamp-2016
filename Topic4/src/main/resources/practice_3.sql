Select c.name as 'Course', concat(t.last_name, ', ', t.first_name) as 'Teacher', concat (s.last_name, ', ', s.first_name) as 'Student'
from teacher t

join course c on t.id_teacher = c.teacher


join  student_x_course sc on sc.course = c.id_course


join student s on sc.student = s.registration_number


where c.Name = 'English'

order by s.last_name;