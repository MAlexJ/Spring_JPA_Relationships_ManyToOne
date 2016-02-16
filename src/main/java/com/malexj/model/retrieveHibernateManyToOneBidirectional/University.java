package com.malexj.model.retrieveHibernateManyToOneBidirectional;

import com.malexj.model.BaseEntity;

import javax.persistence.*;
import java.util.List;

/** http://websystique.com/hibernate/hibernate-many-to-one-bidirectional-annotation-example/ */

@Entity
@Table(name = "university")
public class University extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "country")
    private String country;

    @OneToMany(mappedBy = "university", cascade = CascadeType.ALL)
    private List<Student> students;

    public University() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        University that = (University) o;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (country != null ? !country.equals(that.country) : that.country != null) return false;
        if (students != null ? !students.equals(that.students) : that.students != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (students != null ? students.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "University{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", students=" + students +
                '}';
    }
}
