package xktz.website.util;

import java.util.HashMap;
import java.util.Map;

public class RequestUtil {

    public static final Integer CODE_UPDATE_NOT_UPDATE = 0;
    public static final Integer CODE_UPDATE_TRUE = 1;
    public static final Integer CODE_UPDATE_FALSE = 2;

    public static final Map<Integer, Boolean> CODE_UPDATE_MAP = new HashMap<>(){{
        put(CODE_UPDATE_NOT_UPDATE, null);
        put(CODE_UPDATE_TRUE, true);
        put(CODE_UPDATE_FALSE, false);
    }};
}
