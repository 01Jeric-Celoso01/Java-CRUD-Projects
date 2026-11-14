package org.jcc.model;

import org.jcc.enums.CourseStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Course {
    private String course_id;
    private String course_code;
    private String course_name;
    private String course_description;
    private String course_level;
    private int duration;
    private BigDecimal course_fee;
    private int total_units;
    private String major;
    private CourseStatus status;
    LocalDateTime created_at;
    LocalDateTime updated_at;

    public Course(String course_id, String course_code, String course_name, String course_description, String course_level, int duration, BigDecimal course_fee, int total_units, String major, CourseStatus status, LocalDateTime created_at, LocalDateTime updated_at) {
        this.course_id = course_id;
        this.course_code = course_code;
        this.course_name = course_name;
        this.course_description = course_description;
        this.course_level = course_level;
        this.duration = duration;
        this.course_fee = course_fee;
        this.total_units = total_units;
        this.major = major;
        this.status = status;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }


    // GETTER

    public String getCourse_id() {
        return course_id;
    }

    public String getCourse_code() {
        return course_code;
    }

    public String getCourse_name() {
        return course_name;
    }

    public String getCourse_description() {
        return course_description;
    }

    public String getCourse_level() {
        return course_level;
    }

    public int getDuration() {
        return duration;
    }

    public BigDecimal getCourse_fee() {
        return course_fee;
    }

    public int getTotal_units() {
        return total_units;
    }

    public String getMajor() {
        return major;
    }

    public CourseStatus getStatus() {
        return status;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }



    // SETTER
    public void setCourse_Id(String course_id) {
        this.course_id = course_id;
    }

    public void setCourse_code(String course_code) {
        this.course_code = course_code;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public void setCourse_description(String course_description) {
        this.course_description = course_description;
    }

    public void setCourse_level(String course_level) {
        this.course_level = course_level;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setCourse_fee(BigDecimal course_fee) {
        this.course_fee = course_fee;
    }

    public void setTotal_units(int total_units) {
        this.total_units = total_units;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setStatus(CourseStatus status) {
        this.status = status;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }
}
