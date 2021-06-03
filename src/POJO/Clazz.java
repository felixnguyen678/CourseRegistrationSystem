package POJO;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "class", schema = "courseregistration")
public class Clazz {
    private String classId;
    private String className;
    private Set<Student> students;

    public Clazz(){}
    public Clazz(String _classId, String _className){
        this.classId = _classId;
        this.className = _className;
    }
    public Clazz(Clazz clazz){
        this.classId = clazz.getClassId();
        this.className = clazz.getClassName();
        this.students = clazz.getStudents();
    }

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
        return Objects.equals(classId, clazz.classId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(classId, className);
    }

    @OneToMany(mappedBy = "clazz")
    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public int countStudent(){
        int res = 0;
        if(students == null) return 0;
        return students.size();
    }
    public int countMale(){
        int res = 0;
        if(students == null) return 0;
        for(Student s: students){
            if(s.getGender() == 1)
                res++;
        }
        return res;
    }
    public int countFemale(){
        int res = 0;
        if(students.size() == 0) return 0;
        for(Student s: students){
            if(s.getGender() == 0)
                res++;
        }
        return res;
    }
}
