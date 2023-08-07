package SampleType;

import java.io.Serializable;

public class SampleType implements Serializable{
//    private String earth;
//    private String water;
//    private String air;
//    private String sediment;
    private String name;

    public SampleType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
