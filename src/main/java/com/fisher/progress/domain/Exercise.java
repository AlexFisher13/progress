package com.fisher.progress.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Exercise {
    private String name;
    private List<Set> sets;
}
