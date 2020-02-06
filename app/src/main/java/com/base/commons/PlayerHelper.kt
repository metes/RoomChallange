package com.base.commons

import android.content.Context
import android.media.MediaPlayer
import android.net.Uri

class PlayerHelper {

    private var mediaPlayer: MediaPlayer? = null
    private var floatValue = 100f

    @Throws(Exception::class)
    fun playAudio(context: Context?, url: String?, onPlayCompleted: () -> Unit) {
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(context, Uri.parse(url))
        }
        mediaPlayer?.setOnCompletionListener {
            killMediaPlayer()
            onPlayCompleted()
        }
        mediaPlayer?.start()
    }

    fun setVolume(volume: Int) {
        floatValue = (volume.toFloat() / 100)
        mediaPlayer?.setVolume(floatValue, floatValue)
    }

    fun killMediaPlayer() {
        mediaPlayer?.let {
            try {
                mediaPlayer?.reset()
                mediaPlayer?.release()
                mediaPlayer = null
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}