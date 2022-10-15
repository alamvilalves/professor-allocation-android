package com.example.professorallocation.ui;
import android.view.LayoutInflater;
import android.app.Activity;
import android.app.AlertDialog;
import com.example.professorallocation.R;

public class LoaddingDialog {

    private final Activity activity;
    private AlertDialog dialog;

    public LoaddingDialog(Activity activity) {
        this.activity = activity;
    }

    public void startDialog() {
        LayoutInflater inflater = activity.getLayoutInflater();
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setView(inflater.inflate(R.layout.loadding, null));

        dialog = builder.create();
        dialog.show();
    }

    public void dismissDialog() {
        dialog.dismiss();
    }
}
