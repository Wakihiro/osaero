package app_osaero; //初期画面
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import es.exsample.R;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String name = intent.getStringExtra( "name" );
        setContentView(R.layout.activity_main);
        TextView tv = findViewById(R.id.textView7);
        tv.setText(name);
        Button button = findViewById(R.id.toSub1Button);
        button.setOnClickListener((View v) -> {
            if(name != null) {
                Intent intent1 = new Intent(this, SubActivity.class); //値が入力された
                intent1.putExtra("name", name);
                startActivity(intent1);
            }else{
                startActivity(new Intent(this, Main2Activity.class));
//                startActivity(new Intent(this, SubActivity.class));
            }
        });
    }
}



