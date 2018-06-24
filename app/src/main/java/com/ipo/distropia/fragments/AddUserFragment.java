package com.ipo.distropia.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ipo.distropia.R;
import com.ipo.distropia.data.Data;
import com.ipo.distropia.model.User;

/**
 * Created on 24/06/2018.
 */
public class AddUserFragment extends Fragment {

    private static User myUser;
    private EditText et_name,et_patologia,et_tutor,et_estado;
    private Button button_actualizar;
    private Data mData;

    public static AddUserFragment newInstance(User u){
        myUser = u;
        AddUserFragment ajustesFragment = new AddUserFragment();
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
        mData = Data.getInstance();

        button_actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mData.getUsers().add(new User(et_name.getText().toString(),et_patologia.getText().toString(),
                        et_tutor.getText().toString(), et_estado.getText().toString()));

                Toast toast = Toast.makeText(getActivity(),"Usuario añadido",Toast.LENGTH_SHORT);
                toast.show();

            }});



    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.adduser_fragment,container,false);
    }


}
