/*Ivan Gorbachov 2015
library for decimal input (range from 0.0 to 999.9)*/

package numeric.dialog.input;



import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;



public  class DigitDialog {
	public    float returnFloat=0;
	private TextView alterTv = null;
	public  void GetInput(Context aContext, float inputFloat, final TextView et1)
	{
		GetInput( aContext,  inputFloat,   et1, true);
	}
	public  void GetInput(Context aContext, float inputFloat, final TextView et1,final TextView et2)
	{
		alterTv = et2;
		GetInput( aContext,  inputFloat,   et1, true);
	}
	
	public  void GetInput(Context aContext, float inputFloat, final TextView et1, final boolean bDecimal) {
		returnFloat = inputFloat;
		
		LayoutInflater factory = LayoutInflater.from(aContext);
		final View textEntryView = factory.inflate(R.layout.decimal_dialog,
				null);
		AlertDialog.Builder alert = new AlertDialog.Builder(aContext);
		alert.setTitle(R.string.inputNumber);

		alert.setView(textEntryView);

		if (returnFloat > 1000) {
			returnFloat = returnFloat -(int)(returnFloat / 1000) * 1000;
		}
		final int i3 = (int) (returnFloat / 100);
		final int i2 = (int) ((returnFloat - i3 * 100) / 10);
		final int i1 = (int) (returnFloat - i3 * 100 - i2 * 10);
		final int i0 = (int)  Math.round((returnFloat - i3 * 100 - i2 * 10 - i1) * 10);

		final NumberPicker n3 = (NumberPicker) textEntryView
				.findViewById(R.id.numberPicker3);
		n3.setCurrent(i3);
		final NumberPicker n2 = (NumberPicker) textEntryView
				.findViewById(R.id.NumberPicker2);
		n2.setCurrent(i2);
		final NumberPicker n1 = (NumberPicker) textEntryView
				.findViewById(R.id.NumberPicker1);
		n1.setCurrent(i1);
		final NumberPicker n0 = (NumberPicker) textEntryView
				.findViewById(R.id.NumberPicker0);
		final DecimalPicker d0 = (DecimalPicker) textEntryView
				.findViewById(R.id.decimalPicker1);
		n0.setCurrent(i0);
		
			n1.setNextNumberPicker(n2);
			
			n2.setNextNumberPicker(n3);
			
		
		if (!bDecimal)
		{
			n0.setVisibility(View.GONE);
			d0.setVisibility(View.GONE);
		}
		else
		{
			n0.setNextNumberPicker(n1);
		

		}
		alert.setPositiveButton(android.R.string.ok,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						
					double dresult=(double)  (n3.getCurrent()*100+
								n2.getCurrent()*10+
								n1.getCurrent()+
								n0.getCurrent()/10.0)  ;
						if (!bDecimal)
						{
							et1.setText((int)dresult+"");
						}
						else
						{
						et1.setText(dresult+"");
						}
					
						if (alterTv!=null)
						{
							String s1 =alterTv.getText().toString();
							Float f2 = 0f;
							try
							{
								f2= Float.parseFloat(s1);
							}
							catch (NumberFormatException ex1)
							{
								//
							}
							
							if (f2==0f )
							{
								alterTv.setText(et1.getText());
							}
						}
						
					}
				});

		alert.setNegativeButton(android.R.string.cancel,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {

						dialog.cancel();

					}
				});
		alert.show();

	}
}
