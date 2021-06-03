package POJO;

import javax.persistence.*;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;

@Entity
public class Semester {
    private String semesterId;
    private String semesterName;
    private Integer year;
    private Date firstDay;
    private Date lastDay;
    private Byte isCurrent;
    private Set<Course> courses;
    private CourseRegistrationSession registrationSession;

    public Semester(){}
    public Semester(Semester _semester){
        this.semesterId = _semester.semesterId;
        this.semesterName = _semester.semesterName;
        this.year = _semester.year;
        this.firstDay = _semester.firstDay;
        this.lastDay = _semester.lastDay;
        this.isCurrent = _semester.isCurrent;
        this.courses = _semester.courses;
        this.registrationSession = _semester.registrationSession;
    }
    public Semester(String _semesterId,
                    String _semesterName,
                    Integer _year,
                    Date _firstDay,
                    Date _lastday,
                    Byte _isCurrent
    ) throws ParseException {

        semesterId = _semesterId;
        semesterName = _semesterName;
        year = _year;
        firstDay = _firstDay;
        lastDay = _lastday;
        isCurrent = _isCurrent;
    }

    @Id
    @Column(name = "semester_id", nullable = false, length = 10)
    public String getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(String semesterId) {
        this.semesterId = semesterId;
    }

    @Basic
    @Column(name = "semester_name", nullable = true, length = 50)
    public String getSemesterName() {
        return semesterName;
    }

    public void setSemesterName(String semesterName) {
        this.semesterName = semesterName;
    }

    @Basic
    @Column(name = "year", nullable = true)
    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Basic
    @Column(name = "first_day", nullable = true)
    public Date getFirstDay() {
        return firstDay;
    }

    public void setFirstDay(Date firstDay) {
        this.firstDay = firstDay;
    }

    @Basic
    @Column(name = "last_day", nullable = true)
    public Date getLastDay() {
        return lastDay;
    }

    public void setLastDay(Date lastDay) {
        this.lastDay = lastDay;
    }

    @Basic
    @Column(name = "is_current", nullable = true)
    public Byte getIsCurrent() {
        return isCurrent;
    }

    public void setIsCurrent(Byte isCurrent) {
        this.isCurrent = isCurrent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Semester semester = (Semester) o;
        return Objects.equals(semesterId, semester.semesterId) && Objects.equals(semesterName, semester.semesterName) && Objects.equals(year, semester.year) && Objects.equals(firstDay, semester.firstDay) && Objects.equals(lastDay, semester.lastDay) && Objects.equals(isCurrent, semester.isCurrent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(semesterId, semesterName, year, firstDay, lastDay, isCurrent);
    }

    @OneToMany(mappedBy = "semester")
    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    @OneToOne(mappedBy = "semester")
    public CourseRegistrationSession getRegistrationSession() {
        return registrationSession;
    }

    public void setRegistrationSession(CourseRegistrationSession registrationSession) {
        this.registrationSession = registrationSession;
    }

}
