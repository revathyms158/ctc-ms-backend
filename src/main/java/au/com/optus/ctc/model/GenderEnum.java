package au.com.optus.ctc.model;

public enum GenderEnum {
    F("F"),M("M");
    private final String name;

    private GenderEnum(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {
        return name.equals(otherName);
    }

    public String toString() {
        return this.name;
    }
}
