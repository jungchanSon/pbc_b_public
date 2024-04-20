package jungchan.poebuildcost.repository;

import jungchan.poebuildcost.repository.MongoDocumentEntity.Fractured;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FracturedRepository extends MongoRepository<Fractured, String> {
    Fractured findByText(String text);
    Fractured findByTextRegex(String text);

}
