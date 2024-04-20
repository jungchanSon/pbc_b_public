package jungchan.poebuildcost.repository;

import jungchan.poebuildcost.repository.MongoDocumentEntity.Sanctum;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SanctumRepository extends MongoRepository<Sanctum, String> {
    Sanctum findByText(String text);
    Sanctum findByTextRegex(String text);
}
