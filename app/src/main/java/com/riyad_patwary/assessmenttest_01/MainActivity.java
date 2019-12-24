package com.riyad_patwary.assessmenttest_01;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.tomer.fadingtextview.FadingTextView;

public class MainActivity extends AppCompatActivity {
    ImageView background_img, clover;
    LinearLayout textSplash;
    LinearLayout textHome;
    ConstraintLayout mainView;
    Animation fromBottom;
    FadingTextView fadingTextView;

    //
    EditText productID, productName, productCategory, productDescription, productPrice;
    Button insertBtn, updateBtn, deleteBtn, viewBtn;
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //load animation...
        fromBottom = AnimationUtils.loadAnimation(this, R.anim.frombottom);

        //layout mapping...
        background_img = (ImageView) findViewById(R.id.backGround_img_id);
        clover = (ImageView) findViewById(R.id.clover_id);
        textSplash = (LinearLayout) findViewById(R.id.textSplash_id);
        textHome = (LinearLayout) findViewById(R.id.textHome_id);
        mainView = (ConstraintLayout) findViewById(R.id.mainView_constraint_id);
        fadingTextView = (FadingTextView) findViewById(R.id.fadingTextView_id);

        productID = findViewById(R.id.product_id_editText_id);
        productName = findViewById(R.id.product_name_editText_id);
        productCategory = findViewById(R.id.product_category_editText_id);
        productDescription = findViewById(R.id.product_description_editText_id);
        productPrice = findViewById(R.id.product_price_editText_id);

        insertBtn = findViewById(R.id.insert_btn_id);
        updateBtn = findViewById(R.id.update_btn_id);
        deleteBtn = findViewById(R.id.delete_btn_id);
        viewBtn = findViewById(R.id.view_btn_id);

        //animation customization...
        background_img.animate().translationY(-2000).setDuration(500).setStartDelay(2500);
        clover.animate().alpha(0).setDuration(2000).setStartDelay(300);
        textSplash.animate().translationY(-650).alpha(0).setDuration(600).setStartDelay(2500);
        textSplash.animate().translationX(-150).alpha(0).setDuration(600).setStartDelay(2500);

        //start animation...
        textHome.startAnimation(fromBottom);
        mainView.startAnimation(fromBottom);

        openHelper = new Database_Helper(this);

        insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Product_Name = productName.getText().toString();
                String Product_Category = productCategory.getText().toString();
                String Product_Description = productCategory.getText().toString();
                String Product_Price = productPrice.getText().toString().trim();
                db = openHelper.getWritableDatabase();
                insertData(Product_Name, Product_Category, Product_Category, Product_Price);
                Toast.makeText(getApplicationContext(), "Data Inserted", Toast.LENGTH_SHORT).show();
            }
        });

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db = openHelper.getWritableDatabase();
                String position = productID.getText().toString().trim();
                deleteData(position);
                Toast.makeText(getApplicationContext(), "Data Deleted", Toast.LENGTH_SHORT).show();
            }
        });

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Product_Name = productName.getText().toString();
                String Product_Category = productCategory.getText().toString();
                String Product_Description = productCategory.getText().toString();
                String Product_Price = productPrice.getText().toString().trim();
                db = openHelper.getWritableDatabase();
                updateData(Product_Name, Product_Category, Product_Category, Product_Price);
                Toast.makeText(getApplicationContext(), "Data Updated", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void insertData(String Product_Name, String Product_Category, String Product_Description, String Product_Price) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(Database_Helper.COLUMN_2, Product_Name);
        contentValues.put(Database_Helper.COLUMN_3, Product_Category);
        contentValues.put(Database_Helper.COLUMN_4, Product_Description);
        contentValues.put(Database_Helper.COLUMN_5, Product_Price);
        long id = db.insert(Database_Helper.TABLE_NAME, null, contentValues);
    }

    public boolean deleteData(String position) {
        return db.delete(Database_Helper.TABLE_NAME, Database_Helper.COLUMN_1 + "=?", new String[]{position}) > 0;
    }

    public boolean updateData(String Product_Name, String Product_Category, String Product_Description, String Product_Price) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(Database_Helper.COLUMN_2, Product_Name);
        contentValues.put(Database_Helper.COLUMN_3, Product_Category);
        contentValues.put(Database_Helper.COLUMN_4, Product_Description);
        contentValues.put(Database_Helper.COLUMN_5, Product_Price);
        String position = productID.getText().toString().trim();
        return db.update(Database_Helper.TABLE_NAME, contentValues, Database_Helper.COLUMN_1 + "=?", new String[]{position}) > 0;
    }
}
