package github.nisrulz.scripts.convert;

/**
 * The type Convert utils.
 *
 * @author Nishant Srivastava
 */
public class ConvertUtils {


    /**
     * short array to byte array.
     *
     * @param sData the s data
     * @return the byte []
     */
    public static byte[] short2byte(short[] sData) {
        int shortArrsize = sData.length;
        byte[] bytes = new byte[shortArrsize * 2];
        for (int i = 0; i < shortArrsize; i++) {
            bytes[i * 2] = (byte) (sData[i] & 0x00FF);
            bytes[(i * 2) + 1] = (byte) (sData[i] >> 8);
            sData[i] = 0;
        }
        return bytes;
    }


}
