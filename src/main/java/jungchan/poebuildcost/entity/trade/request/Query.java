package jungchan.poebuildcost.entity.trade.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Setter
@Getter
public class Query {
    Filters filters;
    ArrayList<Stats> stats;
    String status;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    String name;
}
