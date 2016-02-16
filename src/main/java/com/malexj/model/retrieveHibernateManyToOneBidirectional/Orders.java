package com.malexj.model.retrieveHibernateManyToOneBidirectional;

import com.malexj.model.BaseEntity;

import javax.persistence.*;

/**
 * http://websystique.com/hibernate/hibernate-many-to-one-bidirectional-annotation-example/
 */

@Entity
@Table(name = "orders")
public class Orders extends BaseEntity {

    @Column(name = "title")
    private String title;

    @Column(name = "goods")
    private String listGoods;

    @Column(name = "section")
    private String section;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Orders() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getListGoods() {
        return listGoods;
    }

    public void setListGoods(String listGoods) {
        this.listGoods = listGoods;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Orders orders = (Orders) o;

        if (title != null ? !title.equals(orders.title) : orders.title != null) return false;
        if (listGoods != null ? !listGoods.equals(orders.listGoods) : orders.listGoods != null) return false;
        if (section != null ? !section.equals(orders.section) : orders.section != null) return false;
        if (user != null ? !user.equals(orders.user) : orders.user != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (listGoods != null ? listGoods.hashCode() : 0);
        result = 31 * result + (section != null ? section.hashCode() : 0);
        result = 31 * result + (user != null ? 31 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "title='" + title + '\'' +
                ", listGoods='" + listGoods + '\'' +
                ", section='" + section + '\'' +
                ((user != null) ? ", user=" + user.getName() : "") +
                '}';
    }
}
