package cs371.carstereo;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ToggleButton;

import org.w3c.dom.Text;


public class MainActivity extends Activity
        implements CompoundButton.OnCheckedChangeListener, View.OnClickListener, SeekBar.OnSeekBarChangeListener, View.OnLongClickListener {


    protected ToggleButton powerButton;
    protected TextView stationDisplay = null;
    protected TextView volumeIndicator = null;
    protected SeekBar volumeSeekBar;
    protected Button amButton;
    protected Button fmButton;
    protected ImageButton stationUpButton;
    protected ImageButton stationDownButton;
    protected boolean isAM = true;
    protected boolean isOn = false;
    protected TextView amFMtextView;
    protected Button presetButton1;
    protected Button presetButton2;
    protected Button presetButton3;
    protected Button presetButton4;
    protected Button presetButton5;
    protected Button presetButton6;
    protected int[] amArray = {550,600,650,700,750,800};
    protected int[] fmArray = {909,929,949,969,989,1009};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stationDisplay = (TextView)findViewById(R.id.stationDisplay);
        powerButton = (ToggleButton)findViewById(R.id.powerButton);
        powerButton.setOnCheckedChangeListener(this);
        volumeIndicator =(TextView)findViewById(R.id.volumeIndicator);
        volumeSeekBar = (SeekBar)findViewById(R.id.volControl);
        stationUpButton = (ImageButton)findViewById(R.id.stationUpButton);
        stationDownButton = (ImageButton)findViewById(R.id.stationDownButton);
        amButton = (Button)findViewById(R.id.amButton);
        fmButton = (Button)findViewById(R.id.fmButton);
        amButton.setOnClickListener(this);
        fmButton.setOnClickListener(this);
        stationUpButton.setOnClickListener(this);
        stationDownButton.setOnClickListener(this);
        amFMtextView = (TextView)findViewById(R.id.amFMtextView);

        presetButton1 = (Button)findViewById(R.id.presetButton1);
        presetButton2 = (Button)findViewById(R.id.presetButton2);
        presetButton3 = (Button)findViewById(R.id.presetButton3);
        presetButton4 = (Button)findViewById(R.id.presetButton4);
        presetButton5 = (Button)findViewById(R.id.presetButton5);
        presetButton6 = (Button)findViewById(R.id.presetButton6);
        presetButton1.setOnClickListener(this);
        presetButton2.setOnClickListener(this);
        presetButton3.setOnClickListener(this);
        presetButton4.setOnClickListener(this);
        presetButton5.setOnClickListener(this);
        presetButton6.setOnClickListener(this);
        presetButton1.setOnLongClickListener(this);
        presetButton2.setOnLongClickListener(this);
        presetButton3.setOnLongClickListener(this);
        presetButton4.setOnLongClickListener(this);
        presetButton5.setOnLongClickListener(this);
        presetButton6.setOnLongClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        String oldVal = this.stationDisplay.getText().toString();
        int val = 530;
        double valD1 = 881;
        int valD = 881;
        if (isOn) {

            if (isAM) {
                val = Integer.parseInt(oldVal);
            } else {
                valD1 = Double.parseDouble(oldVal);
                valD = (int)(valD1*10);
            }
            if (v.getId() == R.id.amButton) {
                stationDisplay.setText("530");
                isAM = true;
            } else if (v.getId() == R.id.fmButton) {
                stationDisplay.setText("88.1");
                isAM = false;
            } else if (v.getId() == R.id.stationUpButton) {
                if (isAM) {
                    if (val == 1700) {
                        val = 530;
                    } else {
                        val = val + 10;
                    }
                } else if (isAM == false) {
                    if (valD == 1079) {
                        valD = 881;
                    } else {
                        valD = valD + 2;
                    }
                } else {
                }
            } else if (v.getId() == R.id.stationDownButton) {
                if (isAM) {
                    if (val == 530) {
                        val = 1700;
                    } else {
                        val = val - 10;
                    }
                } else if (isAM == false) {
                    if (valD == 881) {
                        valD = 1079;
                    } else {
                        valD = valD - 2;
                    }
                } else {
                }
            } else {
            }

            if(v.getId() == R.id.presetButton1)
            {
                if(isAM) {
                    val = amArray[0];
                }
                else if(isAM==false)
                {
                    valD = fmArray[0];
                }
            }
            else if(v.getId() == R.id.presetButton2)
            {
                if(isAM) {
                    val = amArray[1];
                }
                else if(isAM==false)
                {
                    valD = fmArray[1];
                }
            }
            else if(v.getId() == R.id.presetButton3)
            {
                if(isAM) {
                    val = amArray[2];
                }
                else if(isAM==false)
                {
                    valD = fmArray[2];
                }
            }
            else if(v.getId() == R.id.presetButton4)
            {
                if(isAM) {
                    val = amArray[3];
                }
                else if(isAM==false)
                {
                    valD = fmArray[3];
                }
            }
            else if(v.getId() == R.id.presetButton5)
            {
                if(isAM) {
                    val = amArray[4];
                }
                else if(isAM==false)
                {
                    valD = fmArray[4];
                }
            }
            else if(v.getId() == R.id.presetButton6)
            {
                if(isAM) {
                    val = amArray[5];
                }
                else if(isAM==false)
                {
                    valD = fmArray[5];
                }
            }

            String newVal;
            if (isAM == true) {
                newVal = "" + val;
                amFMtextView.setText("AM");
            } else {
                newVal = valD/10 + "." + valD%10;
                amFMtextView.setText("FM");
            }
            this.stationDisplay.setText(newVal);

        }
        else {
        }


    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(isChecked) {
            stationDisplay.setTextColor((int)0xFFFFFFFF);
            volumeIndicator.setTextColor((int)0xFF000000);
            volumeSeekBar.setBackgroundColor((int) 0xFFFFFFFF);
            powerButton.setBackgroundColor((int) 0xFF7FFF00);
            amFMtextView.setTextColor((int) 0xFFFFFFFF);
            isOn = true;
        }
        else {
            stationDisplay.setTextColor((int)0xFF0000FF);
            volumeIndicator.setTextColor((int)0xFFB2B2FF);
            volumeSeekBar.setBackgroundColor((int) 0xFF000000);
            powerButton.setBackgroundColor((int)0xFFA8A8A8);
            amFMtextView.setTextColor((int) 0xFF0000FF);
            isOn = false;
        }
    }

    @Override
    public boolean onLongClick(View v) {
        String oldVal = this.stationDisplay.getText().toString();
        int val = 530;
        double valD1 = 881;
        int valD = 881;

        if (isOn){
            if (isAM)
            {
                val = Integer.parseInt(oldVal);
                if(v.getId() == R.id.presetButton1) {
                    amArray[0] = val;
                }
                else if(v.getId() == R.id.presetButton2) {
                    amArray[1] = val;
                }
                else if(v.getId() == R.id.presetButton3){
                    amArray[2] = val;
                }
                else if(v.getId() == R.id.presetButton4) {
                    amArray[3] = val;
                }
                else if(v.getId() == R.id.presetButton5) {
                    amArray[4] = val;
                }
                else if(v.getId() == R.id.presetButton6) {
                    amArray[5] = val;
                }
            }
            else {
                valD1 = Double.parseDouble(oldVal);
                valD = (int)(valD1*10);
                if(v.getId() == R.id.presetButton1) {
                    fmArray[0]= valD;
                }
                else if(v.getId() == R.id.presetButton2) {
                    fmArray[1]= valD;
                }
                else if(v.getId() == R.id.presetButton3){
                    fmArray[2]= valD;
                }
                else if(v.getId() == R.id.presetButton4) {
                    fmArray[3]= valD;
                }
                else if(v.getId() == R.id.presetButton5) {
                    fmArray[4]= valD;
                }
                else if(v.getId() == R.id.presetButton6) {
                    fmArray[5]= valD;
                }
            }
        }
        else {
        }

        return false;
    }
}
