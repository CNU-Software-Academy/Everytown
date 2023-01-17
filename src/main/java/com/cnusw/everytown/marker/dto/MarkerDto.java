package com.cnusw.everytown.marker.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class MarkerDto {

    protected final int id;
    protected final PointDto point;
    protected final String type;

}