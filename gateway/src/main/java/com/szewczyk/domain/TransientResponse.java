package com.szewczyk.domain;

import lombok.Value;

@Value
public class TransientResponse {
    MainInformation mainInformation;
    Long time;
}