package jungchan.poebuildcost.entity.Stats;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class Result {
    String id;
    String label;
    ArrayList<Entry> entries;
}
