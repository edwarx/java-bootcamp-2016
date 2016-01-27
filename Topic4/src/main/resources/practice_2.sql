INSERT INTO `student` VALUES 
(1,'Celty','Sturluson',null),
(2,'Mikado','Ryugamine', null),
(3,'Masaomi','Kida', null),
(4,'Anri','Sonohara', null),
(5,'Izaya','Orihara', null),
(6,'Shizuo','Heiwajima', null),
(7,'Shinra','Kishitani', null),
(8,'Walker','Yumasaki', null),
(9,'Kyohei','Kadota', null),
(10,'Erika','Karisawa', null);


INSERT INTO `teacher` VALUES (1,'Eikichi','Onizuka','1975-08-03'),(2,'Nozomu','Itoshiki','1975-11-04'),(3,'Aikuro','Mikisugi','1970-05-25');

INSERT INTO `course` (name, hours_by_week, teacher) VALUES ('English', 6, 1), ('Japanese', 4, 2), ('French', 2, 1);

INSERT INTO `grade_type` (name) VALUES ('Partial'), ('Final');

INSERT INTO student_x_course VALUES (1, 1), (2,1), (3, 1), (5, 1);
INSERT INTO student_x_course VALUES (6, 2), (9,2);

INSERT INTO `course_schedule` (day, start, end, course) VALUES ('Monday', '17:00', '19:00', 1);
INSERT INTO `course_schedule` (day, start, end, course) VALUES ('Tuesday', '17:00', '19:00', 1);
INSERT INTO `course_schedule` (day, start, end, course) VALUES ('Wednesday', '17:00', '19:00', 1);
INSERT INTO `course_schedule` (day, start, end, course) VALUES ('Monday', '08:00', '12:00', 2);
INSERT INTO `course_schedule` (day, start, end, course) VALUES ('Thursday', '08:00', '10:00', 3);

INSERT INTO `grade` VALUES (1,1,1,1,6),(2,1,1,1,6),(3,1,1,1,6),(4,1,1,2,4),(5,2,1,1,8),(6,2,1,1,9),(7,2,1,1,10),(8,2,1,2,8),(9,3,1,1,2),(10,3,1,1,2),(11,3,1,1,2),(12,3,1,2,2),(13,5,1,1,4),(14,5,1,1,5),(15,5,1,1,6),(16,5,1,2,4),(17,6,2,1,10),(18,6,2,1,10),(19,6,2,1,9),(20,6,2,2,10),(21,9,2,1,6),(22,9,2,1,5),(23,9,2,1,4),(24,9,2,2,2);

