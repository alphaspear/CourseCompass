package com.CourseCompass.DatasourceAgent.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "course_info")
public class CourseInfo {

    @Id
    @Column(name = "course_id", nullable = false)
    private Integer courseId;

    @Column(name = "institution", columnDefinition = "TEXT")
    private String institution;

    @Column(name = "course_number", columnDefinition = "TEXT")
    private String courseNumber;

    @Column(name = "launch_date", columnDefinition = "TEXT")
    private String launchDate;

    @Column(name = "course_title", columnDefinition = "TEXT")
    private String courseTitle;

    @Column(name = "instructors", columnDefinition = "TEXT")
    private String instructors;

    @Column(name = "course_subject", columnDefinition = "TEXT")
    private String courseSubject;

    @Column(name = "enrolled")
    private Integer enrolled;

    @Column(name = "review")
    private Integer review;

    @Column(name = "total_course_duration_days")
    private Integer totalCourseDurationDays;

    @Column(name = "video_duration_hr")
    private Float videoDurationHr;

    @Column(name = "is_paid", columnDefinition = "TEXT")
    private String isPaid;

    @Column(name = "price")
    private Double price;

    @Column(name = "overall_rating")
    private Float overallRating;

    @Column(name = "difficulty_level", columnDefinition = "TEXT")
    private String difficultyLevel;

    @Column(name = "source_platform", columnDefinition = "TEXT")
    private String sourcePlatform;

    // Getters and Setters

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    public String getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(String launchDate) {
        this.launchDate = launchDate;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getInstructors() {
        return instructors;
    }

    public void setInstructors(String instructors) {
        this.instructors = instructors;
    }

    public String getCourseSubject() {
        return courseSubject;
    }

    public void setCourseSubject(String courseSubject) {
        this.courseSubject = courseSubject;
    }

    public Integer getEnrolled() {
        return enrolled;
    }

    public void setEnrolled(Integer enrolled) {
        this.enrolled = enrolled;
    }

    public Integer getReview() {
        return review;
    }

    public void setReview(Integer review) {
        this.review = review;
    }

    public Integer getTotalCourseDurationDays() {
        return totalCourseDurationDays;
    }

    public void setTotalCourseDurationDays(Integer totalCourseDurationDays) {
        this.totalCourseDurationDays = totalCourseDurationDays;
    }

    public Float getVideoDurationHr() {
        return videoDurationHr;
    }

    public void setVideoDurationHr(Float videoDurationHr) {
        this.videoDurationHr = videoDurationHr;
    }

    public String getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(String isPaid) {
        this.isPaid = isPaid;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Float getOverallRating() {
        return overallRating;
    }

    public void setOverallRating(Float overallRating) {
        this.overallRating = overallRating;
    }

    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public String getSourcePlatform() {
        return sourcePlatform;
    }

    public void setSourcePlatform(String sourcePlatform) {
        this.sourcePlatform = sourcePlatform;
    }
}
