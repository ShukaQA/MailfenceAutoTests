package core.driver;

import org.openqa.selenium.chrome.ChromeOptions;

class ChromeOptionsFactory {

    ChromeOptions build() {

        ChromeOptions optionsChrome = new ChromeOptions();
        optionsChrome.addArguments("start-maximized");
        optionsChrome.addArguments("--ignore-certificate-errors");
        optionsChrome.addArguments("lang=en-US");
        //optionsChrome.addArguments("--headless");
        //optionsChrome.setAcceptInsecureCerts(true);

        return optionsChrome;
    }
}
