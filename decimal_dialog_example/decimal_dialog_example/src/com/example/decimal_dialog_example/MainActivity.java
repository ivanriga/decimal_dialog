/*Ivan Gorbachov 2015
 * Example of input of decimal digits. 
 * Based on android sources.
 * Very convenient for input.
 */

package com.example.decimal_dialog_example;

import numeric.dialog.input.DigitDialog;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b1 = (Button) findViewById(R.id.button1);
        b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				GetNumeric(R.id.textView1, true);
				
			}
		});
    }
	private void GetNumeric(int id, boolean bDecimal) {
		DigitDialog dd1 = new DigitDialog();
		TextView et1 = (TextView) findViewById(id);
		float f1 = 0;
		try {

			f1 = Float.parseFloat(et1.getText().toString());
		} catch (Exception ex1) {
			//
		}
		dd1.GetInput(this, f1, et1, bDecimal);
		

	}
}
