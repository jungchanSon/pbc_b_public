package jungchan.poebuildcost.entity.trade.request;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
@Setter
@Getter
public class Stats {
    ArrayList<StatFilters> filters;
    String type;
}
