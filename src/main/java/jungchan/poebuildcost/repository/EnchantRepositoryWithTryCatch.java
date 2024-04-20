package jungchan.poebuildcost.repository;

import jungchan.poebuildcost.repository.MongoDocumentEntity.Enchant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EnchantRepositoryWithTryCatch {

    private final EnchantRepository enchantRepository;

    public Enchant findByText(String text){
        try{
            Enchant enchant = enchantRepository.findByText(text);
            return enchant;
        } catch(Exception e) { }

        return null;
    }

    public Enchant findByTextRegex(String text){
        try{
            Enchant enchant = enchantRepository.findByTextRegex(text);;
            return enchant;
        } catch(Exception e) { }

        return null;
    }
}
