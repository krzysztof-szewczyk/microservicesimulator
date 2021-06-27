package com.szewczyk.domain;

import lombok.Value;

import java.util.Date;

@Value
public class GatewayResponse {
    MainInformation response;
    boolean isCached;
    Date currentDate;
    Date resultDate;
}