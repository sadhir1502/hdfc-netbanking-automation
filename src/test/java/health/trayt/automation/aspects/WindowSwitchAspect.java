package health.trayt.automation.aspects;

import health.trayt.automation.annotations.SwitchWindowTo;
import health.trayt.automation.utilities.WindowSwitchUtil;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class WindowSwitchAspect {

    @Autowired
    private WindowSwitchUtil windowSwitchUtil;

    @Before("@target(switchWindowTo) && within(health.trayt.automation.pages..*)")
    public void before(SwitchWindowTo switchWindowTo){
        this.windowSwitchUtil.switchWindowByTitle(switchWindowTo.value());
    }

    @After("@target(switchWindowTo) && within(health.trayt.automation.pages..*)")
    public void after(SwitchWindowTo switchWindowTo){
        this.windowSwitchUtil.switchWindowByIndex(0);
    }

}
