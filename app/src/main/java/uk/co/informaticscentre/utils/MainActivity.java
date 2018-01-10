package uk.co.informaticscentre.utils;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;
import android.widget.Toast;

import com.appyvet.materialrangebar.RangeBar;

import java.util.ArrayList;
import java.util.List;

import uk.co.informaticscentre.utils.controls.SeekbarWithIntervals;


public class MainActivity extends AppCompatActivity {
    private SeekbarWithIntervals SeekbarWithIntervals = null;

    private ArrayList<String> texts =  new ArrayList<String>() {{
        add("1");
        add("5");
        add("15");
        add("50");
        add("100");
        add("300");
        add("500");
    }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<String> seekbarIntervals = getIntervals();
        getSeekbarWithIntervals().setIntervals(seekbarIntervals);
        getSeekbarWithIntervals().setTickChangeListener(new RangeBar.OnRangeBarTextListener() {
            @Override
            public String getPinValue(RangeBar rangeBar, int tickIndex) {
                    return texts.get(tickIndex);
            }
        });

        getSeekbarWithIntervals().setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "onStopTrackingTouch", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private List<String> getIntervals() {
        return texts;
    }

    private SeekbarWithIntervals getSeekbarWithIntervals() {
        if (SeekbarWithIntervals == null) {
            SeekbarWithIntervals = (SeekbarWithIntervals) findViewById(R.id.seekbarWithIntervals);
        }

        return SeekbarWithIntervals;
    }

}
