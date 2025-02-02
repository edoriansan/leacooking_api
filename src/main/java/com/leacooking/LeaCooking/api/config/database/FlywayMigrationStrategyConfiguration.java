package com.leacooking.LeaCooking.api.config.database;

import com.leacooking.LeaCooking.api.config.property.FlywayProperty;
import lombok.RequiredArgsConstructor;
import org.flywaydb.core.Flyway;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FlywayMigrationStrategyConfiguration implements FlywayMigrationStrategy {

    private final FlywayProperty flywayProperty;

    @Override
    public void migrate(Flyway flyway) {
        if (flywayProperty.getEnabled() != null && flywayProperty.getEnabled()) {
            if (flywayProperty.getRepair() != null && flywayProperty.getRepair()) {
                flyway.repair();
            }

            if (flywayProperty.getMigrate() != null && flywayProperty.getMigrate()) {
                flyway.migrate();
            }
        }
    }
}

