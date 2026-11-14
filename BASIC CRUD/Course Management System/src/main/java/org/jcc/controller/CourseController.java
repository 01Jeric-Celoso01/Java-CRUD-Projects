package org.jcc.controller;

import org.jcc.enums.CourseStatus;
import org.jcc.implement.CourseImpRepository;
import org.jcc.model.Course;
import org.jcc.service.CourseService;
import org.jcc.ui.Design;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CourseController {
    static Scanner input;

    public CourseController(Scanner input) {
        this.input = input;
    }

    static CourseImpRepository courseImplement = new CourseImpRepository();
    static CourseService courseService = new CourseService(courseImplement);


    // CREATE CONTROLLER
    public void registerController() {
        System.out.print("||| COURSE ID: ");
        String id = input.nextLine();
        System.out.print("||| COURSE CODE: ");
        String code = input.nextLine();
        System.out.print("||| COURSE NAME: ");
        String name = input.nextLine();
        System.out.print("||| COURSE DESC: ");
        String description = input.nextLine();
        System.out.print("||| COURSE LEVEL:");
        String level = input.nextLine();
        System.out.print("||| COURSE DURATION: ");
        int duration = input.nextInt();

        System.out.print("||| COURSE FEE: ");
        BigDecimal fee = BigDecimal.valueOf(input.nextDouble());

        System.out.print("||| COURSE TOTAL UNITS: ");
        int units = input.nextInt();
        input.nextLine();

        System.out.print("||| MAJOR: ");
        String major = input.nextLine();

        Design.choices("1) ACTIVE     2) INACTIVE     3) ARCHIVED");
        System.out.print("||| STATUS: ");
        int status = input.nextInt();
        CourseStatus courseStatus = null;
        if (status >= 1 && status <= CourseStatus.values().length) {
            courseStatus = CourseStatus.values()[status - 1];
            input.nextLine();
        } else {
            courseStatus = CourseStatus.OTHERS;
            input.nextLine();
        }


        System.out.print("||| CREATED_AT: ");
        String created_at = input.nextLine();
        LocalDateTime createdAt = LocalDateTime.parse(created_at);

        System.out.print("||| UPDATED_AT: ");
        String updated_at = input.nextLine();
        LocalDateTime updatedAt = LocalDateTime.parse(updated_at);

        Course c = new Course(id, code, name, description, level, duration ,fee, units, major, courseStatus, createdAt, updatedAt);

        if (courseService.create(c)) {
            Design.border();
            Design.status("SUCCESSFULLY REGISTER");
            Design.border();
        } else {
            Design.border();
            Design.status("REGISTER FAILED");
            Design.border();
        }
    }


    // VIEW ALL CONTROLLER
    public void viewAllController() {
        List<Course> courses = courseService.viewAll();

        Design.border();
        System.out.printf("||| %-10s |  %-11s | %-60s | %-70s | %-25s | %-15s | %-15s | %-15s | %-30s | %-10s | %-16s | %-16s |||\n", "COURSE ID", "COURSE CODE", "COURSE NAME", "COURSE DESCRIPTION", "COURSE LEVEL", "DURATION", "COURSE FEE", "TOTAL UNITS", "MAJOR", "STATUS", "CREATED AT", "UPDATED AT");
        Design.border();
        for (Course c : courses) {
            System.out.printf("||| %-10s |  %-11s | %-60s | %-70s | %-25s | %-15s | %-15s | %-15s | %-30s | %-10s | %-16s | %-16s |||\n", c.getCourse_id(), c.getCourse_code(), c.getCourse_name(), c.getCourse_description(), c.getCourse_level(), c.getDuration(), c.getCourse_fee(), c.getTotal_units(), c.getMajor(), c.getStatus(), c.getCreated_at(), c.getUpdated_at());
            Design.border();
        }
    }


    // FIND BY ID CONTROLLER
    public void searchController() {
        System.out.print("||| COURSE ID: ");
        String id = input.nextLine();

        Course c = courseService.findById(id);

        if (c.getCourse_id().equals(id)) {
            System.out.printf("||| %-10s |  %-10s | %-30s | %-50s | %-6s | %-8s | %-5s | %-8s | %-30s | %-30s | %-30s | %-30s |||\n", c.getCourse_id(), c.getCourse_code(), c.getCourse_name(), c.getCourse_description(), c.getCourse_level(), c.getDuration(), c.getCourse_fee(), c.getTotal_units(), c.getMajor(), c.getStatus(), c.getCreated_at(), c.getUpdated_at());
            Design.border();
        }
    }


    // UPDATE CONTROLLER
    public void updateController() {
        System.out.print("||| COURSE ID: ");
        String id = input.nextLine();

        Course c = courseService.update(id);

        if (c.getCourse_id().equals(id)) {
            System.out.print("||| CHOOSE INFO UPDATE: ");
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("||| ");
                    c.setCourse_code(input.nextLine());
                    break;
                case 2:
                    System.out.print("||| ");
                    c.setCourse_name(input.nextLine());
                    break;
                case 3:
                    System.out.print("||| ");
                    c.setCourse_description(input.nextLine());
                    break;
                case 4:
                    System.out.print("||| ");
                    c.setCourse_level(input.nextLine());
                    break;
                case 5:
                    c.setDuration(input.nextInt());
                    System.out.print("||| ");
                    break;
                case 6:
                    c.setCourse_fee(BigDecimal.valueOf(input.nextDouble()));
                    System.out.print("||| ");
                    break;
                case 7:
                    c.setTotal_units(input.nextInt());
                    System.out.print("||| ");
                    break;
                case 8:
                    c.setMajor(input.nextLine());
                    System.out.print("||| ");
                    break;
                case 9:
                    System.out.print("||| ");
                    int status = input.nextInt();

                    CourseStatus courseStatus = null;
                    if (status >= 1 &&  status <= CourseStatus.values().length) {
                        courseStatus = CourseStatus.values() [status - 1];
                    }

                    c.setStatus(courseStatus);
                    break;
                default:
                    Design.status("INVALID CHOICE PLEASE TRY AGAIN");
                    break;
            }
        }
    }



    // DELETE CONTROLLER
    public void deleteController() {
        System.out.print("||| COURSE ID: ");
        String id = input.nextLine();

        boolean courses = courseService.delete(id);

        if (courses) {
            Design.status(id + "SUCCESSFULLY DELETED");
        } else {
            Design.status(id + "NOT FOUND PLEASE TRY AGAIN");
        }
    }
}
