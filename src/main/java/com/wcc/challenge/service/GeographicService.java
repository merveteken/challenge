package com.wcc.challenge.service;

import com.wcc.challenge.dto.GeographicDistanceDto;
import com.wcc.challenge.dto.GeographicDto;
import com.wcc.challenge.exception.GeographicNotFoundException;
import com.wcc.challenge.mapper.GeographicToDtoMapper;
import com.wcc.challenge.model.Geographic;
import com.wcc.challenge.repository.GeographicRepository;
import org.springframework.stereotype.Service;


@Service
public class GeographicService {

    private final GeographicRepository geographicRepository;
    private final DistanceCalculator distanceCalculator;
    private final GeographicToDtoMapper geographicToDtoMapper;


    public GeographicService(GeographicRepository geographicRepository, DistanceCalculator distanceCalculator, GeographicToDtoMapper geographicToDtoMapper) {
        this.geographicRepository = geographicRepository;
        this.distanceCalculator = distanceCalculator;
        this.geographicToDtoMapper = geographicToDtoMapper;
    }


    public GeographicDistanceDto findDistance(String postCode1, String postCode2) {
        Geographic geographic1 = findByPostCode(postCode1);
        Geographic geographic2 = findByPostCode(postCode2);
        double distance = distanceCalculator.calculateDistance(geographic1.getLatitude(), geographic1.getLongitude(), geographic2.getLatitude(), geographic2.getLongitude());
        return convertGeographicDto(geographic1, geographic2, distance);
    }

    public GeographicDto updateGeographic(GeographicDto geographicDto) {
        Geographic oldGeographic = geographicRepository.findByLatitudeAndLongitude(geographicDto.getLatitude(), geographicDto.getLongitude())
                .orElseThrow(() -> new GeographicNotFoundException("Geographic information with latitude: " + geographicDto.getLatitude() + " and longitude: " + geographicDto.getLongitude() + " is Not Found!"));
        oldGeographic.setPostcode(geographicDto.getNewPostCode());
        Geographic updatedGeographic = geographicRepository.save(oldGeographic);
        return geographicToDtoMapper.geographicToDto(updatedGeographic);


    }

    private GeographicDistanceDto convertGeographicDto(Geographic g1, Geographic g2, double distance) {
        GeographicDistanceDto geographicDistanceDto = new GeographicDistanceDto();
        geographicDistanceDto.setFirstGeographic(g1);
        geographicDistanceDto.setSecondGeographic(g2);
        geographicDistanceDto.setDistance(distance);
        return geographicDistanceDto;
    }

    private Geographic findByPostCode(String postCode) {
        return geographicRepository.findByPostcode(postCode)
                .orElseThrow(() -> new GeographicNotFoundException("Geographic information with postCode " + postCode + " is Not Found!"));
    }


}
