package jungchan.poebuildcost.repository;

import jungchan.poebuildcost.repository.MongoDocumentEntity.Implicit;
import org.springframework.stereotype.Component;

@Component
public class ImplicitRepositoryWithTryCatch {

    private final ImplicitRepository implicitRepo;

    public ImplicitRepositoryWithTryCatch(ImplicitRepository implicitRepository) {
        this.implicitRepo = implicitRepository;
    }

    public Implicit findByText(String text){
        try{
            return implicitRepo.findByText(text);
        } catch(Exception e) { }

        return null;
    }

    public Implicit findByTextRegex(String text){
        try{
            return implicitRepo.findByTextRegex(text);

        } catch(Exception e) { }

        return null;
    }
}
