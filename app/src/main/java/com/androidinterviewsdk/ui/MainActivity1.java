package com.androidinterviewsdk.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.androidinterviewsdk.R;
import com.androidinterviewsdk.model.bean.StairCategory;
import com.androidinterviewsdk.model.db.RealmHelper;

public class MainActivity1 extends Activity implements View.OnClickListener {

    private EditText etStairId;
    private EditText etStairName;

    private EditText et_Second_Id;
    private EditText et_Second_Name;

    private Button btnSubmit;
    private Button btn_DataSize;
    private int id;
    private String name;
    public static final String StairCategoryId = "StairCategoryId";
    private String mStairCategoryId;

    public static final String StairCategoryName = "StairCategoryName";
    private String mStairCategoryName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        etStairId = (EditText) findViewById(R.id.et_Stair_Id);
        etStairName = (EditText) findViewById(R.id.et_Stair_Name);

        et_Second_Id = (EditText) findViewById(R.id.et_Second_Id);
        et_Second_Name = (EditText) findViewById(R.id.et_Second_Name);

        btnSubmit = (Button) findViewById(R.id.btn_Submit);
        btn_DataSize = (Button) findViewById(R.id.btn_DataSize);
        mStairCategoryId = getIntent().getStringExtra(StairCategoryId);
        mStairCategoryName = getIntent().getStringExtra(StairCategoryName);

        etStairId.setText(mStairCategoryId);
        etStairName.setText(mStairCategoryName);

        btnSubmit.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_Submit:
                id = Integer.parseInt(etStairId.getText().toString());
                name = etStairName.getText().toString();
                StairCategory stairCategory = new StairCategory();
                stairCategory.setId(id);
                stairCategory.setName(name);
                RealmHelper.getInstance().insertStairCategory(stairCategory);
                break;
        }
    }
}
