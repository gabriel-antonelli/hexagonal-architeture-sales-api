package com.sales.api.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ProductTest {

    @Test
    void assertThatIdIsNullWhenCreatedWithoutId() {
        var builder = Product.builder()
                .description("Prego")
                .price(240.00)
                .build();
        assertThat(builder.getId())
                .isNull();
    }

    @Test
    void assertThatIdIsNotNullWhenCreatedWithId() {
        var builder = Product.builder()
                .id(1)
                .description("Prego")
                .price(240.00)
                .build();
        assertThat(builder.getId())
                .isNotNull()
                .isEqualTo(1);
    }
}
