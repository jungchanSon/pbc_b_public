package jungchan.poebuildcost.service.pobCode;

import java.io.IOException;
import java.util.zip.DataFormatException;

public interface Decompressor {

    byte[] decompressSpace(byte[] decodedPobCode) throws DataFormatException, IOException;
}
