package xktz.website.global.activation.model;

import xktz.website.excep.KeyNotFoundException;

public class ActivationCodeNotFoundException extends KeyNotFoundException {

    private static final String NAME_ACTIVATION_CODE = "Activation Code";

    public ActivationCodeNotFoundException(String value) {
        super(NAME_ACTIVATION_CODE, value);
    }
}
