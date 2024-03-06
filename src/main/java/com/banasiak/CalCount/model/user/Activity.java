package com.banasiak.CalCount.model.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Activity {

    VERY_LOW(1.2),
    LOW(1.375),
    MODERATE(1.55),
    HIGH(1.725),
    VERY_HIGH(1.9);

    private final double value;
}
