package tekhne.com.peliculaspractica;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import tekhne.com.peliculaspractica.interfases.OnItemSelectPeliculaListener;

public class Main2Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, OnItemSelectPeliculaListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        addFragment();
    }

    private void addFragment(){
        PeliculaFragment fragment1 = new PeliculaFragment();
        FragmentTransaction ft1 = getSupportFragmentManager().beginTransaction();
        ft1.add(R.id.contenedor3,fragment1);
        ft1.addToBackStack("f1");
        ft1.commit();
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {

            int count = getSupportFragmentManager().getBackStackEntryCount();
            if(count==0){
                super.onBackPressed();
            }else{
               getSupportFragmentManager().popBackStack();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {
            Toast.makeText(this,"Hola",Toast.LENGTH_LONG).show();

        } else if (id == R.id.nav_send) {

            AlertDialog.Builder  builder = new AlertDialog.Builder(this, R.style.Theme_AppCompat_Dialog_Alert);
            builder.setMessage("Desea registrarse.")
                    .setTitle("Registro")
                    .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            startActivity(new Intent(getBaseContext(),LoginActivity.class));
                        }
                    });
            builder.create().show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onPeliculaSeleccionada(int posicion) {

        DetalleFragment fragment2 = new DetalleFragment();
        Bundle parametro = new Bundle();
        parametro.putInt("posicion", posicion);
        fragment2.setArguments(parametro);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.contenedor3, fragment2)
                .addToBackStack("f2")
                .commit();
       // FragmentTransaction ft1 = getSupportFragmentManager().beginTransaction();
        //ft1.add(R.id.contenedor3,fragment2);
        //ft1.addToBackStack("f2");
        //ft1.commit();
    }

    @Override
    public void dummy() {

    }
}
