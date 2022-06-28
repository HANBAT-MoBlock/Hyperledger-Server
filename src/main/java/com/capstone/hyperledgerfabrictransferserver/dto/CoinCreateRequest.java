package com.capstone.hyperledgerfabrictransferserver.dto;

import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class CoinCreateRequest {

    private String coinName;

    @Builder
    public CoinCreateRequest(String coinName) {
        this.coinName = coinName;
    }
}
