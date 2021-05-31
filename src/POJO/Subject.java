package POJO;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Subject {
    private String subjectId;
    private String subjectName;
    private Integer numberOfCredit;
    private Set<Course> courses;

    public Subject(){}
    public Subject(Subject _subject){
        subjectId = _subject.getSubjectId();
        subjectName = _subject.getSubjectName();
        numberOfCredit = _subject.getNumberOfCredit();
        courses = _subject.getCourses();
    }
    public Subject(String _subjectId, String _subjectName, int _numberOfCredit){
        subjectId = _subjectId;
        subjectName = _subjectName;
        numberOfCredit = _numberOfCredit;
    }

    @Id
    @Column(name = "subject_id", nullable = false, length = 10)
    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    @Basic
    @Column(name = "subject_name", nullable = true, length = 50)
    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    @Basic
    @Column(name = "number_of_credit", nullable = true)
    public Integer getNumberOfCredit() {
        return numberOfCredit;
    }

    public void setNumberOfCredit(Integer numberOfCredit) {
        this.numberOfCredit = numberOfCredit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return Objects.equals(subjectId, subject.subjectId) && Objects.equals(subjectName, subject.subjectName) && Objects.equals(numberOfCredit, subject.numberOfCredit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subjectId, subjectName, numberOfCredit);
    }

    @OneToMany(mappedBy = "subject")
    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
