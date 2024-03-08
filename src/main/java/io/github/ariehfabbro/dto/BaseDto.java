package io.github.ariehfabbro.dto;

import com.univocity.parsers.annotations.Parsed;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class BaseDto {

    @Parsed(field = "Test Case ID", defaultNullRead = "")
    private String testCaseId;

    @Parsed(field = "Test Case Description", defaultNullRead = "")
    private String testCaseDescription;
}
