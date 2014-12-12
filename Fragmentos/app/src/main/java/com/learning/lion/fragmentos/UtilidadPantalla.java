package com.learning.lion.fragmentos;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.Display;

/**
 * Created by lion on 11/12/14.
 */
public class UtilidadPantalla {

    private DisplayMetrics metrics;
    private Display display;
    private float dpAncho, dpAlto;
    private Activity activity;

    public UtilidadPantalla(Activity activity) {
       this.activity = activity;

        display = activity.getWindowManager().getDefaultDisplay();
        metrics = new DisplayMetrics();

        display.getMetrics(metrics);

        float densidad = activity.getResources().getDisplayMetrics().density;
        dpAlto = metrics.heightPixels / densidad;
        dpAncho = metrics.widthPixels / densidad;
    }

    public Display getDisplay() {
        return display;
    }

    public DisplayMetrics getMetrics() {
        return metrics;
    }

    float getDpAncho(){
        return this.dpAncho;
    }

    float getDpAlto() {
        return this.dpAlto;
    }
}
