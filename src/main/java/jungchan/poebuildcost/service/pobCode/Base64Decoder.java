package jungchan.poebuildcost.service.pobCode;

import org.springframework.stereotype.Component;
import org.springframework.util.Base64Utils;

@Component
public class Base64Decoder implements Decoder {
    @Override
    public byte[] decode(String pobCode) {
        return Base64Utils.decodeFromUrlSafeString(pobCode);
    }
}
