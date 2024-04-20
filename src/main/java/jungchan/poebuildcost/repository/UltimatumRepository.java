package jungchan.poebuildcost.repository;

import jungchan.poebuildcost.repository.MongoDocumentEntity.Ultimatum;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UltimatumRepository extends MongoRepository<Ultimatum, String> {
    Ultimatum findByText(String text);
    Ultimatum findByTextRegex(String text);
}
