package com.wcc.challenge.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GeographicDto {
    private double latitude;
    private double longitude;
    private String newPostCode;
}
