package com.github.jjfhj.helpers;

import com.github.jjfhj.drivers.BrowserstackMobileDriver;
import com.github.jjfhj.drivers.EmulationMobileDriver;
import com.github.jjfhj.drivers.RealMobileDriver;
import com.github.jjfhj.drivers.SelenoidMobileDriver;

public class RunHelper {

    public static String deviceHost = System.getProperty("deviceHost");

    private RunHelper() {
    }

    public static RunHelper runHelper() {
        return new RunHelper();
    }

    public Class<?> getDriverClass() {
        if (deviceHost == null) {
            throw new RuntimeException("Необходимо ввести обязательный параметр -DdeviceHost");
        }

        switch (deviceHost) {
            case "browserstack":
                return BrowserstackMobileDriver.class;
            case "selenoid":
                return SelenoidMobileDriver.class;
            case "emulation":
                return EmulationMobileDriver.class;
            case "real":
                return RealMobileDriver.class;
            default:
                throw new RuntimeException("Параметр -DdeviceHost может принимать только одно из следующих значений: " +
                        "browserstack/selenoid/emulation/real");
        }
    }
}
