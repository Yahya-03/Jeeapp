package model;

public class Specalist {
    private int id;
    private String specialistName;

    public Specalist() {
        super();

    }

    public Specalist(int id, String specialistName) {
        super();
        this.id = id;
        this.specialistName = specialistName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSpecialistName() {
        return specialistName;
    }

    public void setSpecialistName(String specialistName) {
        this.specialistName = specialistName;
    }
}
