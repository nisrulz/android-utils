/*
 * Copyright (C) 2016 Nishant Srivastava
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package github.nisrulz.androidutils.ktx.audio

import android.media.AudioDeviceInfo
import android.media.AudioManager
import android.os.Build
import android.support.annotation.RequiresApi
import android.util.Log


@RequiresApi(Build.VERSION_CODES.M)
fun AudioManager.getOutputAudioDevice(): Array<out AudioDeviceInfo>? {
    return this.getDevices(AudioManager.GET_DEVICES_OUTPUTS)
}

@RequiresApi(Build.VERSION_CODES.M)
fun AudioManager.getSampleRate(): Int {
    val sampleRateStr: String? = this.getProperty(AudioManager.PROPERTY_OUTPUT_SAMPLE_RATE)
    return sampleRateStr?.let { str ->
        Integer.parseInt(str).takeUnless { it == 0 }
    } ?: 44100 // Use a default value if property not found

}

@RequiresApi(Build.VERSION_CODES.M)
fun AudioManager.getFramesPerBuffer(): Int {
    val framesPerBuffersStr: String? =
            this.getProperty(AudioManager.PROPERTY_OUTPUT_FRAMES_PER_BUFFER)
    return framesPerBuffersStr?.let { str ->
        Integer.parseInt(str).takeUnless { it == 0 }
    } ?: 256 // Use default
}

@RequiresApi(Build.VERSION_CODES.M)
fun AudioManager.getOutputLatencyOnAudioRouteChange(audioDevices: Array<out AudioDeviceInfo>?): Int {
    var systemOutputLatency = 0
    audioDevices?.forEach {
        when (it.type) {
        // Bluetooth
            AudioDeviceInfo.TYPE_BLUETOOTH_A2DP -> systemOutputLatency =
                    getSystemOutputLatencyInMs()
            AudioDeviceInfo.TYPE_BLUETOOTH_SCO -> systemOutputLatency = getSystemOutputLatencyInMs()

        // HDMI
            AudioDeviceInfo.TYPE_HDMI -> systemOutputLatency = getSystemOutputLatencyInMs()
            AudioDeviceInfo.TYPE_HDMI_ARC -> systemOutputLatency = getSystemOutputLatencyInMs()

        //Wired Headphones
            AudioDeviceInfo.TYPE_WIRED_HEADPHONES -> systemOutputLatency =
                    getSystemOutputLatencyInMs()

        // Wired Headset
            AudioDeviceInfo.TYPE_WIRED_HEADSET -> systemOutputLatency = getSystemOutputLatencyInMs()
        }
    }
    return systemOutputLatency
}

/**
 * Retrieve system latency from the Audio Manager using reflection to access the hidden system api
 * Refer to: https://stackoverflow.com/questions/15802659/how-do-you-determine-the-audio-latency-audiotrack-on-android/37625791
 *
 * This api is currently added to greylist in Android P
 * Link: https://android.googlesource.com/platform/frameworks/base/+/master/config/hiddenapi-p-light-greylist.txt#3140
 *
 * @return Int latency in milliseconds
 */
fun AudioManager.getSystemOutputLatencyInMs(): Int {
    return try {
        val method = this.javaClass.getMethod("getOutputLatency", Int::class.javaPrimitiveType)
        method.invoke(this, AudioManager.STREAM_MUSIC) as Int
    } catch (e: Exception) {
        Log.d("AudioManager", "System Latency not reported by the system, default to 0 ms")
        0
    }
}

/**
 * Check if the music audio stream is muted
 * @receiver AudioManager
 * @return Boolean
 */
@RequiresApi(Build.VERSION_CODES.M)
fun AudioManager.isStreamMuted() = this.isStreamMute(AudioManager.STREAM_MUSIC)