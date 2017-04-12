package com.androidinterviewsdk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.androidinterviewsdk.model.bean.StairCategory;
import com.androidinterviewsdk.model.db.RealmHelper;
import com.androidinterviewsdk.ui.MainActivity1;
import com.androidinterviewsdk.ui.adpater.StairCategoryAdapter;

import java.util.List;

public class MainActivity extends Activity implements View.OnClickListener {

    private EditText etStairId;
    private EditText etStairName;
    private Button btnSubmit;
    private ListView ls;
    private StairCategoryAdapter stairCategoryAdapter;
    private List<StairCategory> mStairCategories;
    private int id;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etStairId = (EditText) findViewById(R.id.et_Stair_Id);
        etStairName = (EditText) findViewById(R.id.et_Stair_Name);
        btnSubmit = (Button) findViewById(R.id.btn_Submit);
        ls = (ListView) findViewById(R.id.ls);
        stairCategoryAdapter = new StairCategoryAdapter(this);
        ls.setAdapter(stairCategoryAdapter);
        btnSubmit.setOnClickListener(this);
        mStairCategories = RealmHelper.getInstance().getStairCategoryList();
        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                StairCategory stairCategory = mStairCategories.get(position);
                Intent intent = new Intent(MainActivity.this, MainActivity1.class);
                intent.putExtra(MainActivity1.StairCategoryId, String.valueOf(stairCategory.getId()));
                intent.putExtra(MainActivity1.StairCategoryName, stairCategory.getName());
                startActivity(intent);
            }
        });

        ls.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                StairCategory stairCategory = mStairCategories.get(position);
                RealmHelper.getInstance().deleteStairCategory(stairCategory.getId());
                mStairCategories = RealmHelper.getInstance().getStairCategoryList();
                stairCategoryAdapter.setData(mStairCategories);
                return true;
            }
        });

        if (mStairCategories != null && mStairCategories.size() > 0) {
            StairCategory stairCategory = mStairCategories.get(mStairCategories.size() - 1);
            String id = String.valueOf(stairCategory.getId());
            int tempId = Integer.parseInt(id) + 1;
            etStairId.setText(String.valueOf(tempId));
            stairCategoryAdapter.setData(mStairCategories);
        } else {
            etStairId.setText("1");
        }
        ItemOnLongClick1();
    }

    private void ItemOnLongClick1() {
//注：setOnCreateContextMenuListener是与下面onContextItemSelected配套使用的
        ls
                .setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {

                    public void onCreateContextMenu(ContextMenu menu, View v,
                                                    ContextMenu.ContextMenuInfo menuInfo) {
                        menu.add(0, 0, 0, "删除");
                        menu.add(0, 1, 0, "修改");

                    }
                });
    }

    private void setTextId() {
        mStairCategories = RealmHelper.getInstance().getStairCategoryList();
        if (mStairCategories != null && mStairCategories.size() > 0) {
            StairCategory stairCategory = mStairCategories.get(mStairCategories.size() - 1);
            String id = String.valueOf(stairCategory.getId());
            int tempId = Integer.parseInt(id) + 1;
            etStairId.setText(String.valueOf(tempId));
            stairCategoryAdapter.setData(mStairCategories);
        }
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
                setTextId();
                break;
        }
    }
}
