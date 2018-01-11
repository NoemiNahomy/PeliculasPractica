package tekhne.com.peliculaspractica;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import tekhne.com.peliculaspractica.interfases.OnItemSelectPeliculaListener;
import tekhne.com.peliculaspractica.modelo.Pelicula;


/**
 * A simple {@link Fragment} subclass.
 */
public class PeliculaFragment extends Fragment  {
    private ListView listItems;
    private ArrayList<Pelicula> lisPeliculas = new ArrayList<>();
    itemPeliculaAdpater adapter;
    private OnItemSelectPeliculaListener listener;

    public PeliculaFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // adapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1, Pelicula.listaPeliculas);
     lisPeliculas.add(new Pelicula(0, "Moana",null, null,"Pelicula pirata de disney", null,null));
        adapter = new itemPeliculaAdpater(getContext(),lisPeliculas);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pelicula, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listItems = (ListView)view.findViewById(R.id.list_items);
        listItems.setAdapter(adapter);
        listItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("pelicula", "click");
                listener.onPeliculaSeleccionada(position);
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if( context instanceof OnItemSelectPeliculaListener  ){
            this.listener = (OnItemSelectPeliculaListener)context;
        }else{
            throw  new  ClassCastException(context.toString()+ "error");
        }

    }

}
