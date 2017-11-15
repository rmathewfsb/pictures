package edu.codeanywhere.j4.pictures.configuration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * TODO This class ___
 *
 * @author rmathew
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles(profiles="local")
public class BeanConfigTest
{
    /**
     * The logger.
     */
    private static final Logger LOG = LoggerFactory.getLogger(BeanConfigTest.class);
    
    @Autowired
    EnvDataSource aBean;

    @Test
    public void testBeanAvailablity() {
      LOG.debug("Enter testBeanAvailablity");
      assertThat(aBean).isNotNull();
      assertThat(aBean.getName()).isEqualTo("local");
      LOG.debug("Exit testBeanAvailablity");      
    }
}

