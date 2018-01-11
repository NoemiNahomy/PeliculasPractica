package tekhne.com.peliculaspractica;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import tekhne.com.peliculaspractica.interfases.OnItemSelectPeliculaListener;
import tekhne.com.peliculaspractica.modelo.Pelicula;

public class MainActivity extends AppCompatActivity implements OnItemSelectPeliculaListener {


     private Button btnAction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAction = (Button)findViewById(R.id.button);
        btnAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Intent actionSend  = new Intent(Intent.ACTION_SEND);
                //actionSend.setType("text/html");
                //actionSend.putExtra(Intent.EXTRA_TEXT, " Hola te invito a visitarnos en http://mipagina.com");
                //startActivity(Intent.createChooser(actionSend,"Pelicula"));

               // Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.facebook.com"));
                //startActivity(i);
                // not found
                // Intent i = new Intent(android.content.Intent.ACTION_DIAL, Uri.parse("+5916543214"));
               // startActivity(i);
                double latitud =  -17.7797;
                double longitud = -63.1681;

                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:-17.7797,-63.1681"));
                startActivity(i);

               // startActivity(new Intent());

            }
        });


        PeliculaFragment fragment1 = new PeliculaFragment();
        FragmentTransaction ft1 = getSupportFragmentManager().beginTransaction();
        ft1.add(R.id.contenedor1,fragment1);
        ft1.commit();


        if(getResources().getConfiguration().orientation== Configuration.ORIENTATION_LANDSCAPE){
            DetalleFragment fragment2 = new DetalleFragment();
            FragmentTransaction ft2  = getSupportFragmentManager().beginTransaction();
            ft2.add(R.id.contenedor2,fragment2);
            ft2.commit();
        }
    }

    @Override
    public void onPeliculaSeleccionada(int posicion) {
       // Log.d("peliculas","vengo de la lista");
        DetalleFragment fragment2 = new DetalleFragment();
        Bundle parametro = new Bundle();
        parametro.putInt("posicion", posicion);
        fragment2.setArguments(parametro);
        if(getResources().getConfiguration().orientation==Configuration.ORIENTATION_LANDSCAPE){
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedor2, fragment2).commit();
        }else{
           getSupportFragmentManager().beginTransaction().replace(R.id.contenedor1, fragment2).commit();
        }
    }

    @Override
    public void dummy() {

    }

    @Override
    public void onBackPressed() {
        if(getSupportFragmentManager().getBackStackEntryCount()==1){
            finish();
        }else {
            super.onBackPressed();
        }

    }
}
