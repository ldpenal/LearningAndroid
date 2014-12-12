package com.learning.lion.fragmentos;

import android.app.Fragment;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;
import java.util.Objects;

/**
 * Created by lion on 11/12/14.
 */
public class MyFirstFragment extends ListFragment {

    public MyFirstFragment() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_first_fragment, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // String strings[] = {"Name1", "Name2"};
        // ArrayAdapter<String> datos = new ArrayAdapter<String>(getActivity().getApplicationContext(), android.R.layout.activity_list_item, strings);
        // setListAdapter(datos);
    }

    /**
     * @author lion
     */
    public interface CallBacks {
        abstract  public void itemSeleccionado(Adapter ada);
    }
}
