package com.sales.api.usecase;

import com.sales.api.domain.Sale;
import com.sales.api.usecase.port.SaleRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindSaleTest {

    @Mock
    private SaleRepository saleRepository;

    @InjectMocks
    private FindSale findSale;

    @Test
    void shouldReturnSale() {

        final var sale = Sale.builder()
                .id(1)
                .productId(1)
                .totalPrice(420.00)
                .quantity(550)
                .build();
        when(saleRepository.findById(1)).thenReturn(Optional.ofNullable(sale));
        var result = findSale.findById(1);
        verify(saleRepository).findById(1);
        assertThat(result)
                .isEqualTo(sale);
    }

    @Test
    void shouldThrownNoSaleFoundWhenNoSaleWithId() {
        when(saleRepository.findById(1)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> findSale.findById(1))
                .hasMessage("No sale found with id: 1");

        verify(saleRepository).findById(1);
    }
}
