package net.koreate.firstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Test1Activity extends AppCompatActivity implements  View.OnClickListener {

    Button visibleBtn;
    Button invisibleBtn;
    Button goneBtn;
    TextView textView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);

        visibleBtn = findViewById(R.id.visibleBtn);
        //visibleBtn = (Button)findViewById(R.id.textView);
        invisibleBtn = findViewById(R.id.inVisibleBtn);
        goneBtn = findViewById(R.id.goneBtn);
        textView = findViewById(R.id.textView);

        visibleBtn.setOnClickListener(this);
        invisibleBtn.setOnClickListener(this);
        goneBtn.setOnClickListener(this);

        /*
        visibleBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                // sout + tab
                System.out.println("visibleBtn Click");
            }
        });

        invisibleBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                // sout + tab
                System.out.println("invisibleBtn Click");
            }
        });
        */
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Button btn = (Button)view;
            System.out.println("버튼 요소의 R ID : "+btn.getId());
            System.out.println("버튼 요소의 텍스트 : "+btn.getText());

            if(view == visibleBtn){
                System.out.println(View.VISIBLE);
                textView.setVisibility(View.VISIBLE);
            }else if(view == invisibleBtn){
                System.out.println(View.INVISIBLE);
                textView.setVisibility(View.INVISIBLE);
            }else{
                System.out.println(View.GONE);
                textView.setVisibility(View.GONE);
            }
        }
    };

    @Override
    public void onClick(View view) {

        Button btn = (Button)view;
        System.out.println("버튼 요소의 R ID :  "+btn.getId());
        System.out.println("버튼 요소의 텍스트 : "+btn.getText());

        if(view == visibleBtn){
            System.out.println(View.VISIBLE);
            textView.setVisibility(View.VISIBLE);
        }else if(view == invisibleBtn){
            System.out.println(View.INVISIBLE);
            textView.setVisibility(View.INVISIBLE);
        }else{
            System.out.println(View.GONE);
            textView.setVisibility(View.GONE);
        }

    }

    public void textViewClick(View view){
        System.out.println("textView click");
    }

    // alt _ insert

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void finish() {
        super.finish();
    }


}
