package logging;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@SpringBootTest
class SpringM1ApplicationTests {

    @Test
    void contextLoads() {
    }

    Logger logger = LoggerFactory.getLogger(SpringM1ApplicationTests.class);

    @Autowired
    Environment env;

    @Test
    void logEnv() {
        logger.info("authCode {}", env.getProperty("authCode"));
        logger.info("devName {}", env.getProperty("devName"));
        logger.info("homo? {}", env.getProperty("homo"));
    }

}