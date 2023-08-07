package Template;

import SampleType.SampleType;

import java.io.Serializable;
import java.util.concurrent.locks.Condition;

public class Template implements Serializable {
    private String name;
    private int id;
    private int price;
    private SampleType type;    // loại mẫu
    private String condition;    // trạng thái mẫu
    private String companyName;

    public Template(String name, int id, int price, SampleType type, String condition, String companyName) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.type = type;
        this.condition = condition;
        this.companyName = companyName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public SampleType getType() {
        return type;
    }

    public void setType(SampleType type) {
        this.type = type;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return name + ", " + price + ", " + type.getName() + ", " + condition + ", " + companyName;
    }
}
