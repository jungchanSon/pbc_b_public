package jungchan.poebuildcost.repository;

import jungchan.poebuildcost.repository.MongoDocumentEntity.Pseudo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PseudoRepo extends MongoRepository<Pseudo, String> {
    Pseudo findByText(String text);
    Pseudo findByTextRegex(String text);
}
