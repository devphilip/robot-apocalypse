package com.devphilip.robotapocalypse.model;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class Robot {
    private String model;
    private String serialNumber;
    private OffsetDateTime manufacturedDate;
    private String category;
}
