package jungchan.poebuildcost.entity.trade.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class SearchTradeReqForm {

    Query query;
    Sort sort;
}
