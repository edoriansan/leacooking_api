package com.leacooking.LeaCooking.api.config.property;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import java.io.Serial;
import java.io.Serializable;


@Validated
@ConfigurationProperties(prefix = "application.flyway")
@Getter
@Setter
public class FlywayProperty implements Serializable {

    @Serial
    private static final long serialVersionUID = 1;

    private Boolean enabled;
    private Boolean repair;
    private Boolean migrate;
    private String locations;
}
