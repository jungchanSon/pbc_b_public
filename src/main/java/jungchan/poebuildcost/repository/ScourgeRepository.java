package jungchan.poebuildcost.repository;

import jungchan.poebuildcost.repository.MongoDocumentEntity.Scourge;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScourgeRepository extends MongoRepository<Scourge, String> {
    Scourge findByText(String text);
    Scourge findByTextRegex(String text);
}
