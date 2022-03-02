package com.sales.api.output.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

public class SaleId implements Serializable {
    private Integer id;
    private LocalDateTime transactionTime;
}
