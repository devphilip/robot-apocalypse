package com.devphilip.robotapocalypse.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "Survivor")
public class Survivor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;
    private Integer age;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private Boolean isInfected = Boolean.FALSE;
    private Integer reportedInfectionCount = 0;
    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<Resource> resources;
    @Embedded
    private Location location;

    public enum Gender {MALE, FEMALE, OTHERS}

    public enum Resource {WATER, FOOD, MEDICATION, AMMUNITION}

}
