package be.pxl.prismaservice.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.AbstractDataSource;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Slf4j
@RequiredArgsConstructor
public class RetryableDataSource extends AbstractDataSource {

    private final DataSource dataSource;

    @Override
    @Retryable(maxAttempts = 5, backoff = @Backoff(multiplier = 1.1, maxDelay = 10000))
    public Connection getConnection() throws SQLException {
        log.info("connectie maken ...");
        return dataSource.getConnection();
    }

    @Override
    @Retryable(maxAttempts = 5, backoff = @Backoff(multiplier = 1.1, maxDelay = 10000))
    public Connection getConnection(String username, String password) throws SQLException {
        log.info("connectie maken met username en paswoord ...");
        return dataSource.getConnection(username, password);
    }
}