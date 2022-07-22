package com.wcc.challenge.dto;

import com.wcc.challenge.model.Geographic;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GeographicDistanceDto {
    private Geographic firstGeographic;
    private Geographic secondGeographic;
    private double distance;
    private String unit = "km";


}
