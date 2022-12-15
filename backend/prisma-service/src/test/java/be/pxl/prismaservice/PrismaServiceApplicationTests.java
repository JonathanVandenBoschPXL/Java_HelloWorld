package be.pxl.prismaservice;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

//@SpringBootTest
//commented out this @SpringBootTest because it tries to connect to the database otherwise
@ActiveProfiles("test")
class PrismaServiceApplicationTests {


    @Test
    void contextLoads() {

    }
}
