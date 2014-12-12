package fragments;


import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.learning.lion.callbacks.R;

import callbacks.CallBacks;

public class Fragmento1 extends Fragment implements View.OnClickListener {

    private CallBacks llamadaHaciaAtrás;
    private Button toOne;
    private Button toTwo;

    public Fragmento1() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragmento1, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        toOne = (Button) view.findViewById(R.id.toF2);
        toTwo = (Button) view.findViewById(R.id.toF3);

        toOne.setOnClickListener(this);
        toTwo.setOnClickListener(this);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        llamadaHaciaAtrás = (CallBacks) activity;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.toF2:
                llamadaHaciaAtrás.makeOperations(1);
                break;

            case R.id.toF3:
                llamadaHaciaAtrás.makeOperations(2);
                break;
        }
    }
}
