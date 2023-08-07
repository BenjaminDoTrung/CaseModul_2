package SampleType;

public class Soil extends SampleType{
    private String identification;

    public Soil(String name, String identification) {
        super(name);
        this.identification = identification;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }
}
