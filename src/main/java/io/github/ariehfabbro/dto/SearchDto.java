package io.github.ariehfabbro.dto;

import com.univocity.parsers.annotations.Parsed;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class SearchDto extends BaseDto {

    @Parsed(field = "SearchText", defaultNullRead = "")
    private String searchText;
}
