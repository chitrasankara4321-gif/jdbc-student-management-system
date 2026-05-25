package com.studentmanagement.dao;

import java.sql.*;

import com.studentmanagement.model.Student;
import com.studentmanagement.util.DBConnection;

public class StudentDAOImpI implements StudentDAO {

    Connection con;

    public StudentDAOImpI() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/studentdb",
                "root",
                "sankar"
            );

        } catch(Exception e) {

            e.printStackTrace();
        }
    }

    @Override
    public void addStudent(Student s) {

        try {

            String query =
            "insert into students values(?,?,?,?)";

            PreparedStatement ps =
            con.prepareStatement(query);

            ps.setInt(1, s.getId());
            ps.setString(2, s.getName());
            ps.setString(3, s.getDepartment());
            ps.setDouble(4, s.getMarks());

            int rows = ps.executeUpdate();

            System.out.println(rows + " inserted");

        } catch(Exception e) {

            e.printStackTrace();
        }
    }

    @Override
    public void viewStudents() {

        try {

            String query = "select * from students";

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(query);

            while(rs.next()) {

                System.out.println(
                    rs.getInt(1) + " " +
                    rs.getString(2) + " " +
                    rs.getString(3) + " " +
                    rs.getDouble(4)
                );
            }

        } catch(Exception e) {

            e.printStackTrace();
        }
    }

    @Override
    public void updateStudent(int id, double marks) {

        try {

            String query =
            "update students set marks=? where id=?";

            PreparedStatement ps =
            con.prepareStatement(query);

            ps.setDouble(1, marks);
            ps.setInt(2, id);

            int rows = ps.executeUpdate();

            System.out.println(rows + " updated");

        } catch(Exception e) {

            e.printStackTrace();
        }
    }

    @Override
    public void deleteStudent(int id) {

        try {

            String query =
            "delete from students where id=?";

            PreparedStatement ps =
            con.prepareStatement(query);

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            System.out.println(rows + " deleted");

        } catch(Exception e) {

            e.printStackTrace();
        }
    }
}