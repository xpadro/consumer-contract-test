package com.xpadro.consumercontracttest.domain;

import java.util.List;

public class CityServiceResponse {
    private String cityName;
    private List<HospitalResponse> hospitals;

    public CityServiceResponse() {
    }

    public CityServiceResponse(String cityName, List<HospitalResponse> hospitals) {
        this.cityName = cityName;
        this.hospitals = hospitals;
    }

    public String getCityName() {
        return cityName;
    }

    public List<HospitalResponse> getHospitals() {
        return hospitals;
    }
}
