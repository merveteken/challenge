package com.wcc.challenge.service;

import com.wcc.challenge.dto.GeographicDto;
import com.wcc.challenge.mapper.GeographicToDtoMapper;
import com.wcc.challenge.model.Geographic;
import com.wcc.challenge.repository.GeographicRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GeographicServiceTest {

    @InjectMocks
    GeographicService geopraphicService;

    @Mock
    GeographicRepository geographicRepository;

    @Mock
    GeographicToDtoMapper geographicToDtoMapper;

    @Mock
    DistanceCalculator distanceCalculator;


    @Test
    void findDistance() {
        when(geographicRepository.findByPostcode(any())).thenReturn(Optional.of(new Geographic()));
        geopraphicService.findDistance("A","B");
        verify(geographicRepository,times(2)).findByPostcode(any());



    }

    @Test
    void updateGeographic() {
        GeographicDto geographicDto = new GeographicDto();
        geographicDto.setLatitude(1);
        geographicDto.setLongitude(1);
        geographicDto.setNewPostCode("new postcode");

        Geographic geographic = new Geographic();
        geographic.setLatitude(1);
        geographic.setLongitude(1);

        geographic.setPostcode(geographicDto.getNewPostCode());


        when(geographicRepository.findByLatitudeAndLongitude(1,1)).thenReturn(Optional.of(geographic));
        geopraphicService.updateGeographic(geographicDto);

        verify(geographicRepository).findByLatitudeAndLongitude(1,1);
        verify(geographicRepository).save(geographic);
    }
}