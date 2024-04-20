package jungchan.poebuildcost.repository;

import jungchan.poebuildcost.repository.MongoDocumentEntity.*;
import lombok.AllArgsConstructor;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@AllArgsConstructor
public class AllOptionRepository {
    private final CraftedRepository craftedRepository;
    private final CrucibleRepository crucibleRepository;
    private final DelveRepository delveRepository;
    private final EnchantRepository enchantRepository;
    private final ExplicitRepository explicitRepository;
    private final FracturedRepository fracturedRepository;
    private final ImplicitRepository implicitRepository;
    private final PseudoRepo pseudoRepo;
    private final SanctumRepository sanctumRepository;
    private final ScourgeRepository scourgeRepository;
    private final UltimatumRepository ultimatumRepository;
    private final VeiledRepository veiledRepository;

    public List<Object> findOption(String text) {
        List<Object> options = new ArrayList<>();
        try {
            Crafted crafted = craftedRepository.findByText(text);
            if (crafted != null) options.add(crafted);

            Crucible crucible = crucibleRepository.findByText(text);
            if (crucible != null) options.add(crucible);

            Delve delve = delveRepository.findByText(text);
            if (delve != null) options.add(delve);

            Enchant enchant = enchantRepository.findByText(text);
            if (enchant != null) options.add(enchant);

            Explicit explicit = explicitRepository.findByText(text);
            if (explicit != null) options.add(explicit);

            Fractured fractured = fracturedRepository.findByText(text);
            if (fractured != null) options.add(fractured);

            Implicit implicit = implicitRepository.findByText(text);
            if (implicit != null) options.add(implicit);

            Pseudo pseudo = pseudoRepo.findByText(text);
            if (pseudo != null) options.add(pseudo);

            Sanctum sanctum = sanctumRepository.findByText(text);
            if (sanctum != null) options.add(sanctum);

            Scourge scourge = scourgeRepository.findByText(text);
            if (scourge != null) options.add(scourge);

            Ultimatum ultimatum = ultimatumRepository.findByText(text);
            if (ultimatum != null) options.add(ultimatum);

            Veiled veiled = veiledRepository.findByText(text);
            if (veiled != null) options.add(veiled);
        } catch (IncorrectResultSizeDataAccessException i) {
            return options;
        }

        return options;
    }

    public List<Object> findOptionByRegex(String text) {
        List<Object> options = new ArrayList<>();
        try {
            Crafted crafted = craftedRepository.findByTextRegex(text);
            if (crafted != null) options.add(crafted);

            Crucible crucible = crucibleRepository.findByTextRegex(text);
            if (crucible != null) options.add(crucible);

            Delve delve = delveRepository.findByTextRegex(text);
            if (delve != null) options.add(delve);

            Enchant enchant = enchantRepository.findByTextRegex(text);
            if (enchant != null) options.add(enchant);

            Explicit explicit = explicitRepository.findByTextRegex(text);
            if (explicit != null) options.add(explicit);

            Fractured fractured = fracturedRepository.findByTextRegex(text);
            if (fractured != null) options.add(fractured);

            Implicit implicit = implicitRepository.findByTextRegex(text);
            if (implicit != null) options.add(implicit);

            Pseudo pseudo = pseudoRepo.findByTextRegex(text);
            if (pseudo != null) options.add(pseudo);

            Sanctum sanctum = sanctumRepository.findByTextRegex(text);
            if (sanctum != null) options.add(sanctum);

            Scourge scourge = scourgeRepository.findByTextRegex(text);
            if (scourge != null) options.add(scourge);

            Ultimatum ultimatum = ultimatumRepository.findByTextRegex(text);
            if (ultimatum != null) options.add(ultimatum);

            Veiled veiled = veiledRepository.findByTextRegex(text);
            if (veiled != null) options.add(veiled);
        } catch (IncorrectResultSizeDataAccessException i) {
            throw i;
        }
        return options;
    }
}
