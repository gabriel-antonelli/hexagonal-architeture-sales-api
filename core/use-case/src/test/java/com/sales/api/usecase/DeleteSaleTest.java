package com.sales.api.usecase;

import com.sales.api.domain.Sale;
import com.sales.api.usecase.port.ProductRepository;
import com.sales.api.usecase.port.SaleRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DeleteSaleTest {

    @Mock
    private SaleRepository saleRepository;

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private DeleteSale deleteSale;

    @Test
    void shouldDeleteSale(){
        final var sale = Sale.builder()
                .id(1)
                .productId(1)
                .totalPrice(420.00)
                .quantity(42)
                .build();
        when(saleRepository.findById(1)).thenReturn(Optional.ofNullable(sale));
        deleteSale.delete(1);
        verify(productRepository).updateQuantity(1, 42);
        verify(saleRepository).findById(1);
        verify(saleRepository).delete(1);
    }

    @Test
    void shouldThrownSaleNotFoundExceptionWhenNoIdFound(){
        when(saleRepository.findById(1)).thenReturn(Optional.empty());
        assertThatThrownBy(() -> deleteSale.delete(1))
                .hasMessage("No sale with id 1 found");
        verify(saleRepository).findById(1);
        verify(saleRepository, times(0)).delete(any());
        verify(productRepository, times(0)).updateQuantity(any(), any());
    }
}
