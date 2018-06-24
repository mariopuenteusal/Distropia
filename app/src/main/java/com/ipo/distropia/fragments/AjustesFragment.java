package com.ipo.distropia.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.ipo.distropia.MainActivity;
import com.ipo.distropia.R;
import com.ipo.distropia.model.User;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Created on 24/06/2018.
 */
public class AjustesFragment extends Fragment {
    private EditText et_name,et_patologia,et_tutor,et_estado;
    private Button button_actualizar;
    private static User myUser;

    public static AjustesFragment newInstance(User u){
        myUser = u;
        AjustesFragment ajustesFragment = new AjustesFragment();
        return ajustesFragment;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //--------------MyModel----------------


        //------------Widgets--------------


        et_name = (EditText) view.findViewById(R.id.te_changeUser);
        et_patologia = (EditText) view.findViewById(R.id.te_changePatologia);
        et_tutor = (EditText) view.findViewById(R.id.te_changeTutor);
        et_estado= (EditText) view.findViewById(R.id.te_changeEstado);
        button_actualizar = (Button) view.findViewById(R.id.button_changeMyData);

        et_name.setText(myUser.getNombre());
        et_patologia.setText(myUser.getPatologia());
        et_tutor.setText(myUser.getTutor());
        et_estado.setText(myUser.getEstado());

        button_actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast toast = Toast.makeText(getActivity(),"Datos actualizados",Toast.LENGTH_SHORT);
                toast.show();

        }});



    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.ajustes_fragment,container,false);
    }


}
