package au.com.optus.ctc.model;

/**
 * @author revathyms
 */
public enum AnswerValueEnum {

    YES("Y"),
    NO("N"),
    NOT_SURE("Y/N"),
    POSITIVE("POS"),
    NEGATIVE("NEG"),
    UNKNOWN("POS/NEG");

    private final String value;

    private AnswerValueEnum(String s) {
        this.value = s;
    }

    public String value() { return value; }

    public String toString() {
        return this.value;
    }
}
