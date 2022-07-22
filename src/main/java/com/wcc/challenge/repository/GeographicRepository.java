package com.wcc.challenge.repository;


import com.wcc.challenge.model.Geographic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GeographicRepository extends JpaRepository<Geographic, Integer> {
    Optional<Geographic> findByPostcode(String postcode);
    Optional<Geographic> findByLatitudeAndLongitude(double latitude, double longitude);


}
