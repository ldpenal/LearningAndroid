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

public class Fragmento3 extends Fragment implements View.OnClickListener {

    private CallBacks container;
    private Button backFromHere;

    public Fragmento3() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragmento3, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //backFromHere = (Button) view.findViewById(R.id.back3);
        //backFromHere.setOnClickListener(this);
        container.makeOperations(0);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        container = (CallBacks) activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onClick(View view) {
        //container.makeOperations(0);
    }
}
