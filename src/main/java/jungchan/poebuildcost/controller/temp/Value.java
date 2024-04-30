package jungchan.poebuildcost.controller.temp;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Value {
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    Integer min;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    Integer max;
}
