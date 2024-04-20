package jungchan.poebuildcost.repository;

import jungchan.poebuildcost.repository.MongoDocumentEntity.Crucible;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrucibleRepository extends MongoRepository<Crucible, String> {
    Crucible findByText(String text);
    Crucible findByTextRegex(String text);
}
