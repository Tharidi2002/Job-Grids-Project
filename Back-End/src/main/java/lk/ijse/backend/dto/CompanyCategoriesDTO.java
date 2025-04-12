package lk.ijse.backend.dto;

public class CompanyCategoriesDTO {
    private int categoryId;
    private String name;

    public CompanyCategoriesDTO() {
    }

    public CompanyCategoriesDTO(int categoryId, String name) {
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


    @Override
    public String toString() {
        return "CompanyCategoriesDTO{" +
                "categoryId='" + categoryId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
