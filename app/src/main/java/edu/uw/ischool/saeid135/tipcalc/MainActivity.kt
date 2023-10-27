package edu.uw.ischool.saeid135.tipcalc

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import edu.uw.ischool.saeid135.tipcalc.ui.theme.TipcalcTheme

class MainActivity : ComponentActivity() {
    private lateinit var btn : Button
    private lateinit var txt : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txt = findViewById(R.id.txt)
        btn = findViewById(R.id.btn)

        val textWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                if (txt.text.toString() != "$") {
                    btn.isEnabled = true
                }
                else {
                    btn.isEnabled = false
                }
            }
        }
        txt.addTextChangedListener(textWatcher)
        btn.setOnClickListener {
            var newTxt = txt.getText().toString()
            newTxt = newTxt.drop(1)
            var newNum1 = newTxt.toFloat()
            var newNum2 = newNum1 * 0.15
            var roundup = String.format("%.2f", newNum2)
            var finalText = "$" + roundup
            Toast.makeText(this, finalText, Toast.LENGTH_SHORT).show()

        }

    }
}