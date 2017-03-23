package paho.mqtt.java.example;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import java.util.ArrayList;

public class Groupe_Activity extends AppCompatActivity {
    Button button_add_someone;
    String id_a_ajouter;
    ArrayAdapter<String> adapter;
    ListView list;

    Menbres menbres= Menbres.getInstance();


    // TODO recuperer la liste qui serait sauvegarde

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groupe_);

        menbres.menbres.add("Antoine");
        menbres.menbres.add("Benoit");
        menbres.menbres.add("Cyril");
        menbres.menbres.add("David");
        menbres.menbres.add("Eloise");
        menbres.menbres.add("Florent");


        list = (ListView) findViewById(R.id.list);
        adapter = new ArrayAdapter<String>(Groupe_Activity.this,
                android.R.layout.simple_list_item_1, menbres.menbres);
        list.setAdapter(adapter);

        button_add_someone = (Button) findViewById(R.id.Add_someone);
        button_add_someone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater layoutInflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                final View popupView = layoutInflater.inflate(R.layout.popup, null);
                final PopupWindow popupWindow = new PopupWindow(
                        popupView,
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);

                Button btnOK = (Button) popupView.findViewById(R.id.ok);
                btnOK.setOnClickListener(new Button.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        TextView textView = (TextView) popupView.findViewById(R.id.id_a_ajouter);
                        id_a_ajouter =  textView.getText().toString();
                        Log.i("ST",id_a_ajouter);
                        menbres.menbres.add(id_a_ajouter); //bizarre a modifier
                        adapter.add(id_a_ajouter);
                        list.setAdapter(adapter);
                        //mqtt subscribe

                        popupWindow.dismiss();
                    }
                });

                popupWindow.showAsDropDown(button_add_someone, 50, -30);


            }
        });


    }
}


