package POJO;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Student {
    private Clazz clazz;

    @OneToOne
    @JoinColumn(name = "class_id", referencedColumnName = "class_id")
    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }
}
