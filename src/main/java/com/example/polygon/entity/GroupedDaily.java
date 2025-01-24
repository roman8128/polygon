package com.example.polygon.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record GroupedDaily(
        Boolean adjusted,
        Integer queryCount,
        List<Result> resultList,
        Integer resultCount,
        String status
) {
    public record Result(
         @JsonProperty("T") String ticker,
         @JsonProperty("c") double close,
         @JsonProperty("h") double high,
         @JsonProperty("l") double low,
         @JsonProperty("n") int numberOfTrades,
         @JsonProperty("o") double open,
         @JsonProperty("t") long timeStamp,
         @JsonProperty("v") double volume,
         @JsonProperty("vw") double vwap

    ){}
}
