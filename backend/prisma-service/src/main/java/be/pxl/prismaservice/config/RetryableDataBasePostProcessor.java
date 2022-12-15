package be.pxl.prismaservice.config;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Order;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Slf4j
@Order(value = Ordered.HIGHEST_PRECEDENCE)
@Component
public class RetryableDataBasePostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof DataSource dataSourceBean) {
            log.info("----> retryable datasource configureren voor bean met naam {}", beanName);
            return new RetryableDataSource(dataSourceBean);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
