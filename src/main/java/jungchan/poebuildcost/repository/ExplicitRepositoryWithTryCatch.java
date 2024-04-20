package jungchan.poebuildcost.repository;

import jungchan.poebuildcost.repository.MongoDocumentEntity.Explicit;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ExplicitRepositoryWithTryCatch {
    private final ExplicitRepository explicitRepo;

    public Explicit findByText(String text){
        try{
            Explicit explicit = explicitRepo.findByText(text);
            return explicit;
        } catch(Exception e) { }

        return null;
    }

    public Explicit findByTextRegex(String text){
        try{
            Explicit explicit = explicitRepo.findByTextRegex(text);;
            return explicit;

        } catch(Exception e) { }

        return null;
    }
}
