package jungchan.poebuildcost.controller.temp.resp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;

@Setter
@Getter
@ToString
public class TradeResponse {
    String id;
    int complexity;
    ArrayList<String> result;
    int total;
}
