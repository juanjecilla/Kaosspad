package com.m0n0l0c0.kaosspad.utils;

import android.content.ContentValues;
import android.content.Context;
import android.media.AudioFormat;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Environment;
import android.provider.MediaStore;

import com.m0n0l0c0.kaosspad.interfaces.OnAudioRecorderListener;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

/**
 * Created by juanje on 19/10/17.
 */

public class RecordManager {

    private Context context;

    private static final int RECORDER_SAMPLERATE = 44100;
    private static final int RECORDER_CHANNELS = AudioFormat.CHANNEL_IN_MONO;
    private static final int RECORDER_AUDIO_ENCODING = AudioFormat.ENCODING_PCM_16BIT;

    private MediaRecorder mediaRecorder;
    private MediaPlayer mediaPlayer;
    private Thread recordingThread = null;
    private boolean isRecording = false;

    int BufferElements2Rec = 1024; // want to play 2048 (2K) since 2 bytes we use only 1024
    int BytesPerElement = 2; // 2 bytes in 16bit format
    private boolean recording;
    private String filePath;
    private File file;

    public RecordManager(Context context) {
        this.context = context;
        mediaRecorder = new MediaRecorder();
        mediaPlayer = new MediaPlayer();
    }

    public void startRecording() {
        if (!recording){
            recording = true;
            try {
                file = File.createTempFile("kaosspad_" + Calendar.getInstance().getTimeInMillis(),".3gpp");
            } catch (IOException e) {
                e.printStackTrace();
            }
            filePath = Environment.getExternalStorageDirectory()+"/" + Calendar.getInstance().getTimeInMillis()+".3gpp";
            mediaRecorder = new MediaRecorder();
            ContentValues values = new ContentValues(3);
            values.put(MediaStore.MediaColumns.TITLE, "audio");
            mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
            mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
            mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AAC);
            mediaRecorder.setOutputFile(file.getAbsolutePath());
            try {
                mediaRecorder.prepare();
            } catch (Exception e){
                e.printStackTrace();
            }

            mediaRecorder.start();
        }
    }

    private void stopRecording(){
        if (recording){
            recording = false;
            mediaRecorder.stop();
            mediaRecorder.release();

            ((OnAudioRecorderListener)context).onAudioRecorded(file.getAbsolutePath());
        }
    }
}
