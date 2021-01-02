package com.ufr.mim.angryballs.server;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public final class PropertiesLoader {

    private final Properties properties;

    public PropertiesLoader(final URL url) throws IOException {
        this(url.getPath());
    }

    public PropertiesLoader(final String url) throws IOException {
        this.properties = new Properties();
        try(var input = new FileInputStream(url)) { properties.load(input); }
    }

    public String getIp() { return (String) properties.get("server.ip"); }

    public int getPort() { return Integer.parseInt((String) properties.get("server.port")); }
}
