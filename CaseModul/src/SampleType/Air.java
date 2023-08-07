package SampleType;

public class Air extends SampleType{
    private String identification;

    public Air(String name, String identification) {
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
