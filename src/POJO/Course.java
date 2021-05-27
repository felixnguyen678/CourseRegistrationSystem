package POJO;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Course {
    private String courseId;
    private String classroom;
    private String weekday;
    private Integer shift;
    private Integer maximumNumberOfSlot;
    private Subject subject;
    private Semester semester;

    @Id
    @Column(name = "course_id", nullable = false, length = 10)
    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

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
        return Objects.equals(courseId, course.courseId) && Objects.equals(classroom, course.classroom) && Objects.equals(weekday, course.weekday) && Objects.equals(shift, course.shift) && Objects.equals(maximumNumberOfSlot, course.maximumNumberOfSlot);
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
}
