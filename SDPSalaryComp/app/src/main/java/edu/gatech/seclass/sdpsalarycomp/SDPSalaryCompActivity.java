package edu.gatech.seclass.sdpsalarycomp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class SDPSalaryCompActivity extends AppCompatActivity {
    private EditText baseSalary;
    private EditText targetSalary;
    private Spinner currentCity;
    private Spinner newCity;

    private Map<String, Integer> map;
    private String salary;
    private int curIdx, newIdx;
    private boolean valid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sdpsalary_comp);

        map = new HashMap<>();
        map.put("Atlanta, GA", 160);
        map.put("Austin, TX", 152);
        map.put("Boston, MA", 197);
        map.put("Honolulu, HI", 201);
        map.put("Las Vegas, NV", 153);
        map.put("Mountain View, CA", 244);
        map.put("New York City, NY", 232);
        map.put("San Francisco, CA", 241);
        map.put("Seattle, WA", 198);
        map.put("Springfield, MO", 114);
        map.put("Tampa, FL", 139);
        map.put("Washington D.C.", 217);
        salary = "0";
        curIdx = 160;
        newIdx = 160;
        valid = false;

        baseSalary = (EditText) findViewById(R.id.baseSalary);
        targetSalary = (EditText) findViewById(R.id.targetSalary);
        targetSalary.setKeyListener(null);
        targetSalary.setText("0");
        currentCity = (Spinner) findViewById(R.id.currentCity);
        newCity = (Spinner) findViewById(R.id.newCity);

        baseSalary.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                salary = baseSalary.getText().toString();
                if (validNum(salary)) {
                    targetSalary.setText(getTarget());
                    valid = true;
                }
                else {
                    targetSalary.setText("");
                    baseSalary.setError("Invalid salary");
                    valid = false;
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });

        currentCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long l) {
                String city = parent.getItemAtPosition(pos).toString();
                curIdx = map.get(city);
                if (valid) targetSalary.setText(getTarget());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });

        newCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long l) {
                String city = parent.getItemAtPosition(pos).toString();
                newIdx = map.get(city);
                if (valid) targetSalary.setText(getTarget());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });
    }

    public String getTarget() {
        double base = Double.parseDouble(salary);
        double target = base * newIdx / curIdx;
        DecimalFormat format = new DecimalFormat("#");
        format.setRoundingMode(RoundingMode.HALF_UP);
        return String.valueOf(format.format(target));
    }

    private boolean validNum(String val) {
        if (val.isEmpty() || val.charAt(0) == '-') return false;
        for (char c : val.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }
}
