package com.globant.Topic5.dao;

import com.globant.Topic5.entity.Student;
import com.mongodb.MongoClient;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;

/**
 * DAO Class that maps a Student object.
 * @author Eduardo Salgueiro
 *
 */
public class StudentDAO extends BasicDAO<Student, ObjectId> {

	public StudentDAO(Morphia morphia, MongoClient mongo) {
		super(mongo, morphia, "high-school");
	}
}
