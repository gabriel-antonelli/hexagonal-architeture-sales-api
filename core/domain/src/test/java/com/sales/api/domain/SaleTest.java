package com.sales.api.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class SaleTest {

    @Test
    void shouldThrownEmptyProductListExceptionWhenProductIdIsNull() {
        var builder = Sale.builder()
                .id(1)
                .totalPrice(400.00);

        assertThatThrownBy(builder::build)
                .hasMessage("Product cannot be null");
    }

    @Test
    void shouldThrownNoPriceExceptionWhenTotalPriceIsNull() {
        var builder = Sale.builder()
                .id(1)
                .productId(25);

        assertThatThrownBy(builder::build)
                .hasMessage("Total sale price cannot be null");
    }

    @Test
    void shouldThrownNoQuantityExceptionWhenQuantityIsNull() {
        var builder = Sale.builder()
                .id(1)
                .productId(25)
                .totalPrice(42.00);

        assertThatThrownBy(builder::build)
                .hasMessage("Sale quantity cannot be null or less than 1");
    }

    @Test
    void shouldThrownNoQuantityExceptionWhenQuantityIsLessThan1() {
        var builder = Sale.builder()
                .id(1)
                .productId(25)
                .quantity(-1)
                .totalPrice(42.00);

        assertThatThrownBy(builder::build)
                .hasMessage("Sale quantity cannot be null or less than 1");
    }

    @Test
    void assertThatSaleIsBuildCorrect() {
        var sale = Sale.builder()
                .productId(14)
                .totalPrice(400.00)
                .quantity(40)
                .build();

        assertThat(sale.getProductId())
                .isEqualTo(14);
    }
}
