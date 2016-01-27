package com.globant.Topic4.Practice7;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

public class MySQLAccess {
		  private Connection connect = null;
		  private Statement statement = null;
		  private ResultSet resultSet = null;

		  public void connectToDatabase() throws Exception {
		    try {
		      Class.forName("com.mysql.jdbc.Driver");
		      
		      connect = DriverManager.getConnection(
		    		  "jdbc:mysql://localhost/high-school?"
		              + "user=root&password=zawazawa");
		      
		      statement = connect.createStatement();
		      resultSet = statement
		          .executeQuery("select concat(t.last_name, \', \', t.first_name) as \'Teacher\', concat (cs.day, \' \', date_format(cs.start, \'%H:%i\'), \' - \', date_format(cs.end, \'%H:%i\'), \': \', c.name) as \'Schedule\' from teacher t join course c on c.teacher = t.id_teacher join course_schedule cs on cs.course = c.id_course where t.id_teacher = 1 order by FIELD(lower(cs.day), \'monday\', \'tuesday\', \'wednesday\', \'thursday\', \'friday\', \'saturday\', \'sunday\'), cs.start");
		      writeResultSet(resultSet);
		    } catch (Exception e) {
		      throw e;
		    } finally {
		      close();
		    }

		  }
		  private void writeResultSet(ResultSet resultSet) throws SQLException {
		    while (resultSet.next()) {
		      String teacher = resultSet.getString("teacher");
		      String schedule = resultSet.getString("schedule");
		      if(resultSet.isFirst()) {
		    	  System.out.println("\nTeacher: " + teacher);
		    	  System.out.println("Schedule: ");
		      }
		      System.out.println(schedule);
		      }
		  }

		  private void close() {
		    try {
		      if (resultSet != null) {
		        resultSet.close();
		      }

		      if (statement != null) {
		        statement.close();
		      }

		      if (connect != null) {
		        connect.close();
		      }
		    } catch (Exception e) {

		    }
		  }

		} 
