package lk.ijse.backend.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
public class Categories implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;
    private String name;


    public Categories() {
    }

    public Categories(int categoryId, String name) {
        this.categoryId = categoryId;
        this.name = name;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


//    @Override
//    public String toString() {
//        return "Categories{" +
//                "categoryId='" + categoryId + '\'' +
//                ", name='" + name + '\'' +
//                ", items=" + items +
//                '}';
//    }
}
