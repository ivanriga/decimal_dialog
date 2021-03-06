/*
 * Copyright (C) 2008 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package numeric.dialog.input;



import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;

import android.widget.LinearLayout;


public class DecimalPicker extends LinearLayout  {

    public interface Formatter {
        String toString(int value);
    }



    public DecimalPicker(Context context) {
        this(context, null);
    }

    public DecimalPicker(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }


    public DecimalPicker(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs);
        setOrientation(VERTICAL);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.decimal_picker, this, true);
    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
       
        setEnabled(false);
    }


}