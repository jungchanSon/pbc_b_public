package jungchan.poebuildcost.repository;

import jungchan.poebuildcost.repository.MongoDocumentEntity.Enchant;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnchantRepository extends MongoRepository<Enchant, String> {
    Enchant findByText(String text);
    Enchant findByTextRegex(String text);
}
