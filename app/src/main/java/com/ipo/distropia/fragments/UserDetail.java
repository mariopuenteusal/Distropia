package com.ipo.distropia.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.ipo.distropia.R;
import com.ipo.distropia.model.User;

/**
 * Created on 21/06/2018.
 */
public class UserDetail extends Fragment {

    User mUser;
    private TextView tvName, tvPatologia, tvTutor, tvEstado;
    private ImageView ivImage;
    private Button btAjustes,btEstadisticas;

    public static UserDetail newInstance(User u){
        UserDetail f = new UserDetail();
        f.mUser = u;
        return f;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.user_detail, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //mPlayer = (Player) getIntent().getExtras().getSerializable(EXTRA_PERSON);

        tvName = (TextView) view.findViewById(R.id.person_name);
        tvPatologia = (TextView) view.findViewById(R.id.person_patologia);
        tvTutor = (TextView) view.findViewById(R.id.person_tutor);
        tvEstado = (TextView) view.findViewById(R.id.person_estado);
        ivImage = (ImageView) view.findViewById(R.id.person_image);
        btAjustes = view.findViewById(R.id.bt_ajustes);
        btEstadisticas = view.findViewById(R.id.bt_estadisticas);



        tvName.setText(mUser.getNombre());
        tvPatologia.setText(String.valueOf(mUser.getPatologia()));
        tvTutor.setText(String.valueOf(mUser.getTutor()));
        tvEstado.setText(String.valueOf(mUser.getEstado()));
        btAjustes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.main_container,AjustesFragment.newInstance(mUser));
                ft.commit();
            }
        });
        btEstadisticas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        ivImage.setImageResource(R.mipmap.ic_launcher);

    }
}
