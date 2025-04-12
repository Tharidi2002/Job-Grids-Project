package lk.ijse.backend.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class CompanyCategories implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;
    private String name;


    public CompanyCategories() {
    }

    public CompanyCategories(int categoryId, String name) {
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
//        return "CompanyCategories{" +
//                "categoryId='" + categoryId + '\'' +
//                ", name='" + name + '\'' +
//                ", items=" + items +
//                '}';
//    }
}
