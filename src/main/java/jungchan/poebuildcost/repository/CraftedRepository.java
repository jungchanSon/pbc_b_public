package jungchan.poebuildcost.repository;

import jungchan.poebuildcost.repository.MongoDocumentEntity.Crafted;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CraftedRepository extends MongoRepository<Crafted, String> {
    Crafted findByText(String text);
    Crafted findByTextRegex(String text);
}
