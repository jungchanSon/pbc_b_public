package jungchan.poebuildcost.repository;

import jungchan.poebuildcost.repository.MongoDocumentEntity.Explicit;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExplicitRepository extends MongoRepository<Explicit, String> {
    Explicit findByText(String text);
    Explicit findByTextRegex(String text);
}
