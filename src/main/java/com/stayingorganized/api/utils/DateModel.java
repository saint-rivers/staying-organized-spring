package com.stayingorganized.api.utils;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public abstract class DateModel {
    private LocalDateTime dateCreated;
    private LocalDateTime lastUpdated;
}
