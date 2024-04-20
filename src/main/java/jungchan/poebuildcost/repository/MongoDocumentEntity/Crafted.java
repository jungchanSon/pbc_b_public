package jungchan.poebuildcost.repository.MongoDocumentEntity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@ToString
@Document(collection = "crafted")
public class Crafted {
    @Id
    private String id;
    private String text;
    private String textId;
}
