package tekhne.com.peliculaspractica;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Inicio extends AppCompatActivity {
    private ProgressBar progreso;
    private TextView estado;
    private int c = 0;
    private Handler  handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio);
        progreso = findViewById(R.id.progress);
        estado = findViewById(R.id.estado);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (c<100){
                    c +=1;
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            progreso.setProgress(c);
                            estado.setText((String.valueOf(c)+"/100"));
                        }
                    });
                    try{
                        Thread.sleep(100);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }

                if(c==100){
                    Intent i =  new Intent(Inicio.this,Main2Activity.class);
                    startActivity(i);
                    finish();
                }
            }
        }).start();



//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//               Intent i =  new Intent(Inicio.this,Main2Activity.class);
//               startActivity(i);
//               finish();
//            }
//        }, 8000);

    }
}
