package com.sales.api.usecase;

import com.sales.api.domain.Sale;
import com.sales.api.usecase.port.ProductRepository;
import com.sales.api.usecase.port.SaleRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CreateSaleTest {

    @Mock
    private SaleRepository saleRepository;

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private CreateSale createSale;

    private final Sale sale = Sale.builder()
            .id(1)
            .productId(1)
            .totalPrice(420.00)
            .quantity(42)
            .build();

    @Test
    void shouldCreateSaleAndUpdateProductIfProductExists(){
        when(productRepository.exists(1)).thenReturn(true);
        final var createdSale = createSale.create(sale);
        verify(productRepository).exists(1);
        verify(saleRepository).create(sale);
        verify(productRepository).updateQuantity(1, 42);
        assertThat(sale).isEqualTo(createdSale);
    }

    @Test
    void shouldThrownProductNotFoundExceptionIfNoProduct(){
        when(productRepository.exists(1)).thenReturn(false);
        assertThatThrownBy(() -> createSale.create(sale))
                .hasMessage("No product: " + sale.getProductId() + " found.");
        verify(productRepository).exists(1);
        verify(saleRepository, times(0)).create(sale);
        verify(productRepository, times(0)).updateQuantity(1, 42);
    }
}
