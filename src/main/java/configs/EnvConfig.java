package configs;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;

import java.time.Duration;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:${env}-env.properties",
        "classpath:default.properties"})
public interface EnvConfig  extends Config {

    EnvConfig ENV_CONFIG = ConfigFactory.create(EnvConfig.class);

    //URL
    @Key("url")
    String baseUrl();

    //USER
    @Key("user.login")
    String userLogin();

    @Key("user.password")
    String userPassword();

    @Key("page.load.timeout")
    @ConverterClass(DurationConverter.class)
    Duration pageLoadDuration();

    @Key("web.element.refresh.timeout")
    @ConverterClass(DurationConverter.class)
    Duration webElmRefreshDuration();
}
