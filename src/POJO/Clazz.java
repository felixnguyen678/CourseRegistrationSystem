package POJO;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "class", schema = "courseregistration", catalog = "")
public class Clazz {
    private String classId;
    private String className;
    private Student[] students;

    @Id
    @Column(name = "class_id", nullable = false, length = 10)
    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    @Basic
    @Column(name = "class_name", nullable = true, length = 50)
    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clazz clazz = (Clazz) o;
        return Objects.equals(classId, clazz.classId) && Objects.equals(className, clazz.className);
    }

    @Override
    public int hashCode() {
        return Objects.hash(classId, className);
    }

    @OneToMany
    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }
}
