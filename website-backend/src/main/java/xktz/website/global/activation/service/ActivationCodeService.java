package xktz.website.global.activation.service;

/**
 * Service for activation
 */
public interface ActivationCodeService {

    /**
     * Message that the activate code is not existed
     */
    int MESSAGE_CODE_ACTIVATE_FAILED_NOT_EXIST = -1;

    /**
     * Message that activation success
     */
    int MESSAGE_CODE_ACTIVATE_SUCCESS = 0;

    /**
     * Check if contains the key or not
     *
     * @param key the key
     * @return contains or not
     */
    boolean contains(String key);

    /**
     * Add an activation Code
     *
     * @param code the code
     * @param user the user
     * @return successfully adding or not
     */
    boolean addActivationCode(String code, int user);

    /**
     * Activate a code
     *
     * @param code the code
     */
    void activate(String code);

    /**
     * Register the email address
     * @param email email address
     * @param user user
     */
    void registerEmail(String email, int user);
}
