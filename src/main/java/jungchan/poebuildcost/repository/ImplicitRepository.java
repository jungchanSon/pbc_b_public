package jungchan.poebuildcost.repository;

import jungchan.poebuildcost.repository.MongoDocumentEntity.Implicit;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImplicitRepository extends MongoRepository<Implicit, String> {
    Implicit findByText(String text);
    Implicit findByTextRegex(String text);
}
