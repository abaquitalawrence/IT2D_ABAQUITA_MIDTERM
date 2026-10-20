package com.yourdomain.model;

// Java record with exactly five attributes, as required.
public record ScenarioEntity(
    int orderId,
    String customerName,
    int qty5Gallon,
    int qty1Gallon,
    String orderStatus
) {
}
