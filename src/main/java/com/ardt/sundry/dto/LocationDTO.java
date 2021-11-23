package com.ardt.sundry.dto;

import com.ardt.sundry.model.Location;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Builder
@Setter
public class LocationDTO {
    private String id;
    @NonNull public Double lat;
    @NonNull public Double lng;
    private String addrS;
    private String addrT;
    private String name;

    public Location toLocation() {
        return Location.builder()
                .id(id)
                .lat(lat)
                .lng(lng)
                .addrS(addrS)
                .addrT(addrT)
                .name(name)
                .build();
    }
}