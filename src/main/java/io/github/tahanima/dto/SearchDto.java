package io.github.tahanima.dto;

import com.univocity.parsers.annotations.Parsed;

import lombok.Getter;
import lombok.ToString;

/**
 * @author tahanima
 */
@Getter
@ToString(callSuper = true)
public class SearchDto extends BaseDto {

    @Parsed(field = "SearchText", defaultNullRead = "")
    private String searchText;
}
