package com.azovcevae.helpers;

import com.azovcevae.drivers.BrowserstackMobileDriver;
import com.azovcevae.drivers.EmulatorDriver;

public class DeviceSelection {
    public static String getDeviceDriver(String deviceHost) {

        switch (deviceHost) {
            case "emulation":
                return EmulatorDriver.class.getName();
            case "browserstack":
                return BrowserstackMobileDriver.class.getName();

            default:
                throw new RuntimeException("Please select only " +
                        "emulation / browserstack / -DdeviceHost parameter");
        }
    }
}
