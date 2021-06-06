package POJO;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Course {
    private String courseId;
    private String teacherName;
    private String classroom;
    private String weekday;
    private Integer shift;
    private Integer maximumNumberOfSlot;
    private Subject subject;
    private Semester semester;
    private Set<Registration> registrations;

    public Course(){}

    public Course(String courseId,String teacherName, String classroom, String weekday, Integer shift, Integer maximumNumberOfSlot, Subject subject, Semester semester) {
        this.courseId = courseId;
        this.teacherName = teacherName;
        this.classroom = classroom;
        this.weekday = weekday;
        this.shift = shift;
        this.maximumNumberOfSlot = maximumNumberOfSlot;
        this.subject = subject;
        this.semester = semester;
    }

    @Id
    @Column(name = "course_id", nullable = false, length = 20)
    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    @Basic
    @Column(name = "teacher_name", nullable = true, length = 50)
    public String getTeacherName(){ return teacherName;}

    public void setTeacherName(String teacherName) { this.teacherName = teacherName;}

    @Basic
    @Column(name = "classroom", nullable = true, length = 10)
    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    @Basic
    @Column(name = "weekday", nullable = true, length = 10)
    public String getWeekday() {
        return weekday;
    }

    public void setWeekday(String weekday) {
        this.weekday = weekday;
    }

    @Basic
    @Column(name = "shift", nullable = true)
    public Integer getShift() {
        return shift;
    }

    public void setShift(Integer shift) {
        this.shift = shift;
    }

    @Basic
    @Column(name = "maximum_number_of_slot", nullable = true)
    public Integer getMaximumNumberOfSlot() {
        return maximumNumberOfSlot;
    }

    public void setMaximumNumberOfSlot(Integer maximumNumberOfSlot) {
        this.maximumNumberOfSlot = maximumNumberOfSlot;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(courseId, course.courseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId, classroom, weekday, shift, maximumNumberOfSlot);
    }

    @ManyToOne
    @JoinColumn(name = "subject_id", referencedColumnName = "subject_id")
    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @ManyToOne
    @JoinColumn(name = "semester_id", referencedColumnName = "semester_id")
    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    @OneToMany(mappedBy = "course")
    public Set<Registration> getRegistrations() {
        return registrations;
    }

    public void setRegistrations(Set<Registration> registrations) {
        this.registrations = registrations;
    }
}
