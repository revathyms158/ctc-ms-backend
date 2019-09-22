package au.com.optus.ctc.model;

/**
 * @author revathyms
 */
public enum NodeNumberEnum {

    Zero("0");
    private final String name;

    private NodeNumberEnum(String s) {
        name = s;
    }

    public String toString() {
        return this.name;
    }
}
