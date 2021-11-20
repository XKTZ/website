package xktz.website.excep;

/**
 * Exception that cannot find a key
 */
public abstract class KeyNotFoundException extends RuntimeException {

    protected static final String MESSAGE_FORMAT_KEY_NOT_FIND = "Cannot find %s: %s";

    private String name;

    private String value;

    public KeyNotFoundException(String name, String value) {
        super(String.format(MESSAGE_FORMAT_KEY_NOT_FIND, name, value));
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
