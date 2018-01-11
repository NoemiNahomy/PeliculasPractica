package tekhne.com.peliculaspractica;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import tekhne.com.peliculaspractica.modelo.Pelicula;

/**
 * Created by desarrollo on 06-01-18.
 */

public class itemPeliculaAdpater extends BaseAdapter {

    private ArrayList<Pelicula> listapeliculas;
    private Context context;

    public  itemPeliculaAdpater(Context context,ArrayList<Pelicula> peliculas){
        this.listapeliculas=peliculas;
        this.context=context;
    }
    @Override
    public int getCount() {
        return listapeliculas.size();
    }

    @Override
    public Object getItem(int position) {
        return listapeliculas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v =convertView;
        if (v == null){
            v = LayoutInflater.from(context).inflate(R.layout.item_pelicula,parent,false);

        }
        Pelicula  p = listapeliculas.get(position);
        TextView txtTitulo = (TextView) v.findViewById(R.id.txtitulo);
        TextView txtDescripcion = (TextView) v.findViewById(R.id.txtdescripcion);
        txtTitulo.setText(p.getNombre());
        txtDescripcion.setText(p.getDescripcion());

        return v;
    }
}
