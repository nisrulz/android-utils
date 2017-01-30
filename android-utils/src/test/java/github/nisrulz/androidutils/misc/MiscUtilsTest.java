package github.nisrulz.androidutils.misc;

import org.junit.Assert;
import org.junit.Test;

public class MiscUtilsTest {
  @Test
  public void getRandomNumberInRangeWhenBothLimitsAreSame() throws Exception {
    Assert.assertEquals(MiscUtils.getRandomNumberInRange(100, 100), 100);
  }

  @Test
  public void getRandomNumberInRangeWhenBothLimitsAreDifferent() throws Exception {
    Assert.assertNotEquals(MiscUtils.getRandomNumberInRange(100, 199), 100);
  }
}