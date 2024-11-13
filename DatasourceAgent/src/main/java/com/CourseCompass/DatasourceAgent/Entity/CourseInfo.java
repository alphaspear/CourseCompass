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

    @Column(name = "title", columnDefinition = "TEXT")
    private String title;

    @Column(name = "overall_rating")
    private Double overallRating;

    @Column(name = "topic", columnDefinition = "TEXT")
    private String topic;

    @Column(name = "instructor", columnDefinition = "TEXT")
    private String instructor;

    @Column(name = "video_duration_hr")
    private Integer videoDurationHr;

    @Column(name = "is_paid", columnDefinition = "TEXT")
    private String isPaid;

    @Column(name = "price")
    private Double price;



    // Getters and Setters

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getOverallRating() {
        return overallRating;
    }

    public void setOverallRating(Double overallRating) {
        this.overallRating = overallRating;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public Integer getVideoDurationHr() {
        return videoDurationHr;
    }

    public void setVideoDurationHr(Integer videoDurationHr) {
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
}
