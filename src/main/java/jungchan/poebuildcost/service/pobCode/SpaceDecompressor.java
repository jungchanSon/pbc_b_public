package jungchan.poebuildcost.service.pobCode;

import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

@Component
public class SpaceDecompressor implements Decompressor {

    @Override
    public byte[] decompressSpace(byte[] decodedPobCode) throws DataFormatException, IOException {

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(decodedPobCode.length);
        byte[] buff = new byte[1024];

        Inflater inflater = new Inflater();
        inflater.setInput(decodedPobCode);

        while(!inflater.finished()) {
            int cnt = inflater.inflate(buff);
            byteArrayOutputStream.write(buff, 0, cnt);
        }
        byteArrayOutputStream.close();
        String stringXML = new String(byteArrayOutputStream.toByteArray());

        return stringXML.replaceAll(">\\s*<", "><").getBytes();

    }
}
