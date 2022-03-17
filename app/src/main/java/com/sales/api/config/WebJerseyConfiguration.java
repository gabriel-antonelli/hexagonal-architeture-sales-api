package com.sales.api.config;

import com.sales.api.usecase.FindAllSales;
import jakarta.enterprise.context.ApplicationScoped;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class WebJerseyConfiguration extends ResourceConfig {

    public WebJerseyConfiguration() {
        packages("com.sales.api.controller");
    }
}