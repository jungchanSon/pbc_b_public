package jungchan.poebuildcost.repository;

import jungchan.poebuildcost.repository.MongoDocumentEntity.Veiled;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiledRepository extends MongoRepository<Veiled, String> {
    Veiled findByText(String text);
    Veiled findByTextRegex(String text);
}
