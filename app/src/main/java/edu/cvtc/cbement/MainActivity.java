package edu.cvtc.cbement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "edu.cvtc.cbement.RetirementCalculator.MainActivity";
    public static final String ODD_EVEN_MESSAGE = TAG + ".ODD_EVEN_MESSAGE";
    public static final String REQ_RETIREMENT = TAG + ".REQ_RETIREMENT";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("MainActivity", "Text");

        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "Component Started");
        Button submitButton = findViewById(R.id.button_OddEvenSubmit);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Button Clicked");
                EditText oddEvenText = ((View)view.getParent()).findViewById(R.id.editText_OddEven);
                EditText retirementText = ((View)view.getParent()).findViewById(R.id.editText_OddEven2);

                Log.d(TAG, "Input value is: " + oddEvenText.getText().toString());

                try {
                    Integer value = Integer.parseInt(oddEvenText.getText().toString());
                    Integer valueRetirement = Integer.parseInt(retirementText.getText().toString());
                    Intent intent = new Intent(view.getContext(), RetirementActivity.class);
                    intent.putExtra(REQ_RETIREMENT, value);
                    intent.putExtra(ODD_EVEN_MESSAGE, value);
                    view.getContext().startActivity(intent);
                } catch (NumberFormatException e) {
                    Log.d(TAG, "Invalid input entered");
                    Toast.makeText(view.getContext(),
                            "Please enter in an integer", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}