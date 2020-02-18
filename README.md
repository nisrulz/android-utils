<h1 align="center">Android-Utils&nbsp;<a href="https://twitter.com/intent/tweet?text=Checkout%20Android-Utils%3A%20Android%20Library%20facilitating%20some%20very%20common%20functionalities%20in%20the%20form%20of%20utility%20classes%20for%20Android&url=https://github.com/nisrulz/android-utils&via=nisrulz&hashtags=AndroidDev,android,library,OpenSource">
        <img src="https://img.shields.io/twitter/url/http/shields.io.svg?style=social"/>
    </a></h1>

<div align="center">
  <strong>Android Library facilitating some very common functionalities in the form of utility classes for Android</strong>
</div>
<br/>
<div align="center">
    <!-- Bintray -->
    <a href="https://bintray.com/nisrulz/maven/com.github.nisrulz%3Aandroid-utils/_latestVersion">
        <img src="https://api.bintray.com/packages/nisrulz/maven/com.github.nisrulz%3Aandroid-utils/images/download.svg"/>
    </a>
    <!-- API -->
    <a href="https://android-arsenal.com/api?level=14">
        <img src="https://img.shields.io/badge/API-14%2B-orange.svg?style=flat"/>
    </a>
    <!-- Android Arsenal -->
    <a href="https://android-arsenal.com/details/1/4068">
        <img src="https://img.shields.io/badge/Android%20Arsenal-android--utils-green.svg?style=true"/>
    </a>
    <!-- Android Dev Digest -->
    <a href="https://www.androiddevdigest.com/digest-106/">
        <img src="https://img.shields.io/badge/AndroidDev%20Digest-%23106-blue.svg"/>
    </a>
    <!-- GitHub stars -->
    <a href="https://github.com/nisrulz/android-utils">
        <img src="https://img.shields.io/github/stars/nisrulz/android-utils.svg?style=social&label=Star"/>
    </a>
    <!-- GitHub forks -->
    <a href="https://github.com/nisrulz/android-utils/fork">
        <img src="hhttps://img.shields.io/github/forks/nisrulz/android-utils.svg?style=social&label=Fork"/>
    </a>
    <!-- GitHub watchers -->
    <a href="https://github.com/nisrulz/android-utils">
        <img src="https://img.shields.io/github/watchers/nisrulz/android-utils.svg?style=social&label=Watch"/>
    </a>
    <!-- Say Thanks! -->
    <a href="https://saythanks.io/to/nisrulz">
        <img src="https://img.shields.io/badge/Say%20Thanks-!-1EAEDB.svg"/>
    </a>
    <a href="https://www.paypal.me/nisrulz/5usd">
        <img src="https://img.shields.io/badge/$-donate-ff69b4.svg?maxAge=2592000&amp;style=flat">
    </a>
    <br/>
     <!-- GitHub followers -->
    <a href="https://github.com/nisrulz/android-utils">
        <img src="https://img.shields.io/github/followers/nisrulz.svg?style=social&label=Follow%20@nisrulz"/>
    </a>
    <!-- Twitter Follow -->
    <a href="https://twitter.com/nisrulz">
        <img src="https://img.shields.io/twitter/follow/nisrulz.svg?style=social"/>
    </a>
</div>

<div align="center">
  <sub>Built with ❤︎ by
  <a href="https://twitter.com/nisrulz">Nishant Srivastava</a> and
  <a href="https://github.com/nisrulz/android-utils/graphs/contributors">
    contributors
  </a>
</div>
<br/>
<br/>

# Including in your project

Android-Utils is available in the Jcenter, so getting it as simple as adding it as a dependency

```gradle
// Required dependencies
implementation 'androidx.annotation:annotation:1.1.0'
implementation 'androidx.appcompat:appcompat:1.1.0'
implementation 'com.squareup.okhttp3:okhttp:4.4.0'
implementation 'com.squareup.okhttp3:logging-interceptor:4.4.0'

// android-utils
implementation 'com.github.nisrulz:android-utils:{latest version}'
```
where `{latest version}` corresponds to published version in [ ![Download](https://api.bintray.com/packages/nisrulz/maven/com.github.nisrulz%3Aandroid-utils-ktx/images/download.svg) ](https://bintray.com/nisrulz/maven/com.github.nisrulz%3Aandroid-utils-ktx/_latestVersion)

---

Android-Utils-Ktx is available in the Jcenter, so getting it as simple as adding it as a dependency

```gradle
// Required dependencies
implementation 'org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.3.61'
implementation 'androidx.annotation:annotation:1.1.0'
implementation 'androidx.core:core:1.1.0'
implementation 'com.google.android.material:material:1.1.0'
implementation 'androidx.fragment:fragment-ktx:1.2.1'

// android-utils-ktx
implementation 'com.github.nisrulz:android-utils-ktx:{latest version}'
```

where `{latest version}` corresponds to published version in [ ![Download](https://api.bintray.com/packages/nisrulz/maven/com.github.nisrulz%3Aandroid-utils/images/download.svg) ](https://bintray.com/nisrulz/maven/com.github.nisrulz%3Aandroid-utils/_latestVersion)

### Utils

- [activity](/android-utils/src/main/java/github/nisrulz/androidutils/activity/ActivityUtils.java)
- [audio](/android-utils/src/main/java/github/nisrulz/androidutils/audio/AudioUtils.java)
- [battery](/android-utils/src/main/java/github/nisrulz/androidutils/battery/BatteryUtils.java)
- [broadcastreceiver](/android-utils/src/main/java/github/nisrulz/androidutils/broadcastreceiver/BroadcastReceiverUtils.java)
- [convert](/android-utils/src/main/java/github/nisrulz/androidutils/convert/ConvertUtils.java)
- [crypto](/android-utils/src/main/java/github/nisrulz/androidutils/crypto)
- [fileio](/android-utils/src/main/java/github/nisrulz/androidutils/fileio/FileIOUtil.java)
- [fragments](/android-utils/src/main/java/github/nisrulz/androidutils/fragments)
- [json](/android-utils/src/main/java/github/nisrulz/androidutils/json/JSONUtils.java)
- [misc](/android-utils/src/main/java/github/nisrulz/androidutils/misc/MiscUtils.java)
- [network](/android-utils/src/main/java/github/nisrulz/androidutils/network)
- [rateapp](/android-utils/src/main/java/github/nisrulz/androidutils/rateapp/RateMyApp.java)
- [service](/android-utils/src/main/java/github/nisrulz/androidutils/service/ServiceUtils.java)
- [sharedpreferences](/android-utils/src/main/java/github/nisrulz/androidutils/sharedpreferences/SharedPrefUtils.java)
- [string](/android-utils/src/main/java/github/nisrulz/androidutils/string/StringUtils.java)
- [view](/android-utils/src/main/java/github/nisrulz/androidutils/view/ViewUtil.java)
- [wakelock](/android-utils/src/main/java/github/nisrulz/androidutils/wakelock/WakeLockUtils.java)
- [webview](/android-utils/src/main/java/github/nisrulz/androidutils/webview/WebViewUtils.java)

# Pull Requests

I welcome and encourage all pull requests. It usually will take me within 24-48 hours to respond to any issue or request. Here are some basic rules to follow to ensure timely addition of your request:

1. Match coding style (braces, spacing, etc.) This is best achieved using CMD+Option+L (Reformat code) on Mac (not sure for Windows) with Android Studio defaults. This project uses a [modified version of Grandcentrix's code style](https://github.com/nisrulz/AndroidCodeStyle/tree/nishant-config), so please use the same when editing this project.
2. If its a feature, bugfix, or anything please only change code to what you specify.
3. Please keep PR titles easy to read and descriptive of changes, this will make them easier to merge :)
4. Pull requests _must_ be made against `develop` branch. Any other branch (unless specified by the maintainers) will get rejected.
5. Check for existing [issues](https://github.com/nisrulz/android-utils/issues) first, before filing an issue.
6. Have fun!

## License

Licensed under the Apache License, Version 2.0, [click here for the full license](/LICENSE.txt).

## Author & support

This project was created by [Nishant Srivastava](https://github.com/nisrulz/nisrulz.github.io#nishant-srivastava) but hopefully developed and maintained by many others. See the [the list of contributors here](https://github.com/nisrulz/android-utils/graphs/contributors).

If you appreciate my work, consider [buying me](https://www.paypal.me/nisrulz/5usd) a cup of :coffee: to keep me recharged :metal: [[PayPal](https://www.paypal.me/nisrulz/5usd)]

<img src="http://forthebadge.com/images/badges/built-for-android.svg" />
