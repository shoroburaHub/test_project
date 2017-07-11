package ua;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import ua.entity.Department;
import ua.entity.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootApplication
public class BackendApplication extends WebMvcConfigurerAdapter {
    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
//        init();
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        PageableHandlerMethodArgumentResolver resolver = new PageableHandlerMethodArgumentResolver();
        resolver.setOneIndexedParameters(true);
        argumentResolvers.add(resolver);
    }


    public static void init(){

        Random random = new Random();

        try {
            Connection connection =
                    DriverManager.getConnection("jdbc:mysql://localhost/test","root", "root");

            List<Department> departments = new ArrayList<>();

            departments.add(new Department("HR"));
            departments.add(new Department("Tech"));
            departments.add(new Department("Finance"));


            for (Department department : departments) {

                PreparedStatement preparedStatement =
                        connection.prepareStatement("INSERT INTO department(name) VALUES (?)");

                preparedStatement.setString(1, department.getName());

                preparedStatement.execute();

            }

            for (int i = 1; i < 100; i++) {
                PreparedStatement preparedStatement =
                        connection.prepareStatement("INSERT INTO employee(name, active, department_id) VALUES (?, ?, ?)");

                preparedStatement.setString(1, "employee_"+i);
                preparedStatement.setBoolean(2, i % 2 == 0 ? true : false);
                preparedStatement.setInt(3, random.nextInt(3 - 1 + 1) + 1);

                preparedStatement.execute();

            }

            connection.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


}
