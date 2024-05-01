package jungchan.poebuildcost.entity.trade.request;

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
