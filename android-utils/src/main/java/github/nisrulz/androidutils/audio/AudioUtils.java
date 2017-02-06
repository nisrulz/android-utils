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
        8000, 11025, 16000, 22050, 44100, 48000
    }) {  // add the rates you wish to check against
      int bufferSize = AudioRecord.getMinBufferSize(rate, channelConfiguration, audioEncoding);
      if (bufferSize > 0) {
        return rate;
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
  public static int getValidBufferSize(int audioSource, int fs, int channelConfiguration,
      int audioEncoding) {
    for (int bufferSize : new int[] {
        256, 512, 1024, 2048, 4096
    }) {  // add the rates you wish to check against
      AudioRecord audioRecordTemp =
          new AudioRecord(audioSource, fs, channelConfiguration, audioEncoding, bufferSize);
      if (audioRecordTemp != null && audioRecordTemp.getState() == AudioRecord.STATE_INITIALIZED) {
        return bufferSize;
      }
    }
    return 0;
  }
}
