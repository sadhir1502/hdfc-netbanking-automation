package health.trayt.automation.utilities;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class WindowSwitchUtil {
    @Autowired
    private ApplicationContext ctx;

    public void switchWindowByTitle(final String title) {
        WebDriver driver = this.ctx.getBean(WebDriver.class);

        boolean windowSwitched = driver
                .getWindowHandles()
                .stream()
                .map(handle -> driver
                        .switchTo()
                        .window(handle)
                        .getTitle())
                .anyMatch(t -> t.startsWith(title));
        log.info("Switched to window with title:{}",windowSwitched);
        Assert.assertTrue("Window switch failed",windowSwitched);
    }

    public void switchWindowByIndex(final int index) {
        WebDriver driver = this.ctx.getBean(WebDriver.class);

        String[] handles = driver
            .getWindowHandles()
            .toArray(new String[0]);

        driver
            .switchTo()
            .window(handles[index]);
    }

}
