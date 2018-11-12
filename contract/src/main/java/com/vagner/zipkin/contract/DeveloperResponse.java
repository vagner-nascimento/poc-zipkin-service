package com.vagner.zipkin.contract;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeveloperResponse {
    private Integer id;
    private String name;
    private Long salary;
}
