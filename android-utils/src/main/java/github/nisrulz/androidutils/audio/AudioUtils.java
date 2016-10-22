package github.nisrulz.androidutils.audio;

import android.media.AudioRecord;

/**
 * The type Audio utils.
 *
 * @author Nishant Srivastava
 */
public class AudioUtils {

  private AudioUtils() {
    throw new UnsupportedOperationException(
        "Should not create instance of Util class. Please use as static..");
  }

  /**
   * Get a valid sample rate for the device
   *
   * @param channelConfiguration
   *     the channel configuration
   * @param audioEncoding
   *     the audio encoding
   * @return the valid sample rates
   */
  public static int getValidSampleRates(int channelConfiguration, int audioEncoding) {
    for (int rate : new int[] {
        8000, 11025, 16000, 22050, 44100
    }) {  // add the rates you wish to check against
      int bffrSize = AudioRecord.getMinBufferSize(rate, channelConfiguration, audioEncoding);
      if (bffrSize > 0) {
        return bffrSize;
      }
    }
    return 0;
  }

  /**
   * Check correct buffer size for your AudioRecord instance
   *
   * @param audioSource
   *     the audio source
   * @param fs
   *     the fs
   * @param channelConfiguration
   *     the channel configuration
   * @param audioEncoding
   *     the audio encoding
   * @return the int
   */
  public static int checkCorrectBufferSize(int audioSource, int fs, int channelConfiguration,
      int audioEncoding) {
    for (int buffer : new int[] {
        256, 512, 1024, 2048, 4096
    }) {  // add the rates you wish to check against
      AudioRecord audioRecordTemp =
          new AudioRecord(audioSource, fs, channelConfiguration, audioEncoding, buffer);
      if (audioRecordTemp != null && audioRecordTemp.getState() == AudioRecord.STATE_INITIALIZED) {
        return buffer;
      }
    }
    return 0;
  }
}
