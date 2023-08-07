package SampleType;

public class Warter extends SampleType {
    private String identification;   // nhận dạng

    public Warter(String name, String identification) {
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
