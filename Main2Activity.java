package app_osaero;

import android.app.DatePickerDialog.OnDateSetListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;

import java.util.Locale;

import es.exsample.R;

public class Main2Activity extends FragmentActivity implements OnDateSetListener {
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView = findViewById(R.id.textView);
        Button returnButton = findViewById(R.id.returnButton);
        returnButton.setOnClickListener((View view2)->{
            //finish();
            Intent intent = new Intent(this, MainActivity.class); //値が入力された
            if(textView.getText() != null){
                String str = textView.getText().toString();
                intent.putExtra("name", str);
                startActivity(intent);
                finish();
            }else{
                String str = null;
                intent.putExtra("name", (String) null);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        String str = String.format(Locale.US, "%d/%d/%d",year, monthOfYear+1, dayOfMonth);
        textView.setText( str );
    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new MyDialogFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }
}


