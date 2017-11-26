package com.m0n0l0c0.kaosspad.ui;

import android.support.annotation.NonNull;
import android.support.design.widget.BaseTransientBottomBar;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.m0n0l0c0.kaosspad.R;

/**
 * Created by juanje on 26/11/17.
 */

public class RecordingSnackbar extends BaseTransientBottomBar<RecordingSnackbar> {

    private RecordingSnackbar(ViewGroup parent, View content, ContentViewCallback callback) {
        super(parent, content, callback);
    }

    public static RecordingSnackbar make(@NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View content = inflater.inflate(R.layout.snackbar_recording, parent, false);
        ContentViewCallback viewCallback = new ContentViewCallback(content);
        RecordingSnackbar customSnackbar = new RecordingSnackbar(parent, content, viewCallback);
        customSnackbar.setDuration(BaseTransientBottomBar.LENGTH_INDEFINITE);
//        customSnackbar.getView().setBackgroundColor(ContextCompat.getColor(parent.getContext(), R.color.colorSnackbarBackground));

        return customSnackbar;
    }

//    public RecordingSnackbar setFirstAction(int resImg, int resString, final View.OnClickListener listener){
//        LinearLayout actionView = getView().findViewById(R.id.snackbar_action_gallery);
//        actionView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                listener.onClick(view);
//                // Now dismiss the Snackbar
//                dismiss();
//            }
//        });
//        return this;
//    }
//
//    public RecordingSnackbar setSecondAction(int resImg, int resString, final View.OnClickListener listener){
//        LinearLayout actionView = getView().findViewById(R.id.snackbar_action_camera);
//        actionView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                listener.onClick(view);
//                dismiss();
//            }
//        });
//        return this;
//    }
//
//    public RecordingSnackbar setText(CharSequence text) {
//        TextView textView = getView().findViewById(R.id.snackbar_text);
//        textView.setText(text);
//        return this;
//    }

    private static class ContentViewCallback implements BaseTransientBottomBar.ContentViewCallback {

        private View content;

        public ContentViewCallback(View content) {
            this.content = content;
        }

        @Override
        public void animateContentIn(int delay, int duration) {
            ViewCompat.setScaleY(content, 0f);
            ViewCompat.animate(content).scaleY(1f).setDuration(duration).setStartDelay(delay);
        }

        @Override
        public void animateContentOut(int delay, int duration) {
            ViewCompat.setScaleY(content, 1f);
            ViewCompat.animate(content).scaleY(0f).setDuration(duration).setStartDelay(delay);
        }
    }
}
