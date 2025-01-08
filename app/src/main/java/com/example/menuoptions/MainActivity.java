package com.example.menuoptions;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity{

    EditText ET1, ET2;
    TextView TV1;
    float num1, num2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            //Linking Edit text and Text view
            ET1 = findViewById(R.id.frstNumET);
            ET2 = findViewById(R.id.secNumET);
            TV1 = findViewById(R.id.resultView);

        }

        @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {

        // In case numbers aren't valid
        try
        {
            // Get numbers from ET
            num1 = Float.parseFloat(String.valueOf(ET1.getText()));
            num2 = Float.parseFloat(String.valueOf(ET2.getText()));
        }

        catch (NumberFormatException e)
        {
            //Displays error msg and returns
            Toast.makeText(MainActivity.this, "Invalid input. Please enter valid numbers.", Toast.LENGTH_SHORT).show();
            return super.onOptionsItemSelected(item);

        }

        // Get menu choice
        String st = item.getTitle().toString();

        // Clears ALL texts
        switch (st) {
            case "C":
                ET1.setText("");
                ET2.setText("");
                TV1.setText("");
                break;

            // Adds num1 and num2
            case "+":
                TV1.setText(String.valueOf(num1 + num2));
                break;

            // Subtracts num2 from num1
            case "-":
                TV1.setText(String.valueOf(num1 - num2));
                break;

            // Multiplies num1 by num2
            case "*":
                TV1.setText(String.valueOf(num1 * num2));
                break;

            // Divides num2 from num1
            case "/":
                TV1.setText(String.valueOf(num1 / num2));
                break;
        }

        // Returns
        return super.onOptionsItemSelected(item);
    }
}
