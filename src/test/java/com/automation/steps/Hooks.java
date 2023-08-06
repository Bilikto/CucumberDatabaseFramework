package com.automation.steps;

import com.automation.utils.ConfigFileReaderUtils;
import com.automation.utils.DataBaseUtils;
import com.automation.utils.DriverUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

   @Before
    public void setUp() {
        ConfigFileReaderUtils.initConfig();
        DataBaseUtils.initDatabase();
        DriverUtils.createDriver();
    }

    @After
    public void cleanUp() {
       DriverUtils.getDriver().quit();
       DataBaseUtils.closeDatabase();
    }

}
