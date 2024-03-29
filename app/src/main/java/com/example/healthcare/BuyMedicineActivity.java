package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BuyMedicineActivity extends AppCompatActivity {

    private String[][] packges =
            {
                    {"Uprise-D3 1000IU Capsule", "", "", "","50"},
                    {"HealthVit Cromium Picolinate 200mcg Capsule", "", "", "","350"},
                    {"vitamin B Complex Capsule", "", "", "","448"},
                    {"Inlife vitamin E Wheat Germ Oil Capsule", "", "", "","539"},
                    {"Dolo 650 Tablet", "", "", "","30"},
                    {"Crocin 650 Advance Tablet", "", "", "","50"},
                    {"strepsils Medicated Lozenges for Sore Throat", "", "", "","40"},
                    {"Tata 1mg Calcium + Vitamin D3", "", "", "","50"},
                    {"Feronia -XT Tablet ", "", "", "","130"},
            };
    private String[] package_details = {
            "Building and keeping the bones & teeth strong\n" +
                    "Reducing Fatigue/Stress and muscular pains\n" +
                    "Boosting immunity and increasing resistance against infection",
            "Chromium is an essential trace mineral that plays an important role in helping regulate blood glucose.",
            "Provides relief form vitamin B deficiencies\n" +
                    "Helps in formation of red blood cells\n"+
                    "Maintain healthy nerves system",
            "It promote health as well as skin benefit.\n" +
                    "It helps reduce skin blemish and pigmentation.\n" +
                    "It act as safeguard the skin from the harsh UVA and UVB sun rays.",
            "Dolo 650 Tablet helps relieve pain and fever buy blocking the release of certain chemical messengers responsibility for fever and pain.",
            "Helps relieve fever and bring down a high temperature\n"+
                    "Suitable for  people with heart condition or high blood pressure",
            "Relieves the symptoms of a bacterial throat infection and infection and soothes the recovery process\n" +
                    "Provides a warm and comforting feeling during sore throat",
            "Reduce the risk of calcium deficiency, Rickets, and Osteoporosis\n" +
                    "Promotes mobility and flexible of joints",
            "Helps to reduce the iron deficiency due to chronic blood loss or low intake of iron"
    };

    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    ListView lst;
    Button btnBack,btnGoToCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine);

        lst = findViewById(R.id.listviewBM);
        btnBack = findViewById(R.id.buttonBMBack);
        btnGoToCart = findViewById(R.id.buttonBMGoToCart);

        btnGoToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BuyMedicineActivity.this,CartBuyMedicineActivity.class));
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BuyMedicineActivity.this,HomeActivity.class));
            }
        });

        list = new ArrayList();
        for(int i=0; i<packges.length;i++){
            item = new HashMap<String,String>();
            item.put("line1",packges[i][0]);
            item.put("line2",packges[i][1]);
            item.put("line3",packges[i][2]);
            item.put("line4",packges[i][3]);
            item.put("line5", "Total Cost: "+packges[i][4]+"/-");
            list.add(item);
        }

        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[] { "line1","line2","line3","line4","line5"},
                new int[] {R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Intent it = new Intent(BuyMedicineActivity.this,BuyMedicineDetailActivity.class);
                it.putExtra("text1",packges[i][0]);
                it.putExtra("text2",package_details[i]);
                it.putExtra("text3",packges[i][4]);
                startActivity(it);
            }
        });
    }
}