package com.sales.api.usecase;

import com.sales.api.domain.Product;
import com.sales.api.domain.Sale;
import com.sales.api.usecase.port.SaleRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindAllSalesTest {

    @Mock
    private SaleRepository saleRepository;

    @InjectMocks
    private FindAllSales findAllSales;

    @Test
    void shouldReturnAllSales(){

        final List<Sale> saleList = new ArrayList<>();
        final var sale = Sale.builder()
                .id(1)
                .productId(1)
                .totalPrice(420.00)
                .quantity(420)
                .build();
        saleList.add(sale);

        when(saleRepository.findAll()).thenReturn(Optional.of(saleList));

        final var result = findAllSales.findAll();

        verify(saleRepository).findAll();

        assertThat(result)
                .isEqualTo(saleList);
    }

    @Test
    void shouldThrownNoSaleFoundWhenNoSales() {
        when(saleRepository.findAll()).thenReturn(Optional.empty());

        assertThatThrownBy(() -> findAllSales.findAll())
                .hasMessage("No sales found");

        verify(saleRepository).findAll();
    }
}
