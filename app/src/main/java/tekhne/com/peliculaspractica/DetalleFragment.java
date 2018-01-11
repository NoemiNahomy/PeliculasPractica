package tekhne.com.peliculaspractica;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import tekhne.com.peliculaspractica.modelo.Pelicula;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetalleFragment extends Fragment {
    private  int posicion = 0;
    private TextView nombre;
    private  TextView detalle;

    public DetalleFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState  == null){
            if(getArguments()!=null){
                posicion = getArguments().getInt("posicion");
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detalle2, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        nombre = (TextView)view.findViewById(R.id.nombre);
        detalle = (TextView)view.findViewById(R.id.detalle);

        nombre.setText(Pelicula.listaPeliculas[posicion]);
        detalle.setText(Pelicula.detallePeliculas[posicion]);



    }
}
