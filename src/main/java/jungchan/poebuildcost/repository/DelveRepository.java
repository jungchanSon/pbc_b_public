package jungchan.poebuildcost.repository;

import jungchan.poebuildcost.repository.MongoDocumentEntity.Delve;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DelveRepository extends MongoRepository<Delve, String> {
    Delve findByText(String text);
    Delve findByTextRegex(String text);
}
