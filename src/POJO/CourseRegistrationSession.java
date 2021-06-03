package POJO;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "course_registration_session", schema = "courseregistration")
public class CourseRegistrationSession {
    private String semesterId;
    private Timestamp fistDay;
    private Timestamp lastDay;
    private Semester semester;

    public CourseRegistrationSession(String semesterId, Timestamp fistDay, Timestamp lastDay, Semester semester) {
        this.semesterId = semesterId;
        this.fistDay = fistDay;
        this.lastDay = lastDay;
        this.semester = semester;
    }
    public CourseRegistrationSession(){}

    @Id
    @Column(name = "semester_id", nullable = false, length = 10)
    public String getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(String semesterId) {
        this.semesterId = semesterId;
    }

    @Basic
    @Column(name = "fist_day", nullable = true)
    public Timestamp getFistDay() {
        return fistDay;
    }

    public void setFistDay(Timestamp fistDay) {
        this.fistDay = fistDay;
    }

    @Basic
    @Column(name = "last_day", nullable = true)
    public Timestamp getLastDay() {
        return lastDay;
    }

    public void setLastDay(Timestamp lastDay) {
        this.lastDay = lastDay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseRegistrationSession that = (CourseRegistrationSession) o;
        return Objects.equals(fistDay, that.fistDay) && Objects.equals(lastDay, that.lastDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fistDay, lastDay);
    }

    @OneToOne
    @JoinColumn(name = "semester_id", referencedColumnName = "semester_id", nullable = false)
    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }
}
