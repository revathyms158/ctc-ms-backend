package au.com.optus.ctc.model;

public enum GenderEnum {

    F("F"), M("M"), NA("F,M");

    private final String value;

    private GenderEnum(String s) {
        this.value = s;
    }

    public String value() { return value; }

    public String toString() {
        return this.value;
    }

}
