package jungchan.poebuildcost.controller.temp;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StatFilters {
    String id;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    Value value;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    Boolean disabled;
}
