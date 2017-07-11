package ua.dto;

/**
 * Created by admin on 7/4/2017.
 */
public class DepartmentDto {

    private int id;

    private String name;

    public DepartmentDto() {
    }

    public DepartmentDto(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "DepartmentDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
