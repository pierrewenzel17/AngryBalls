package com.ufr.mim.angryballs.client.utils;

/**
 * Class static de constantes
 */
public final class ConstantsUtil {

    public static final String FXML_FILE = "fxml";

    public static final String FILE_SEPARATOR = "/";

    //Paramètres du client-serveur
    public static final int port = 2345;
    public static final String host = "127.0.0.1";

    private ConstantsUtil() {
        throw new IllegalAccessError("not instantiable");
    }
}
