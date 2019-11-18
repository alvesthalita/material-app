package com.example.myapplication.ui.activity.materialdetails;

import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.core.web.entities.MaterialResult;
import com.example.myapplication.ui.activity.generic.GenericActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MaterialDetailsActivity extends GenericActivity {

    @BindView(R.id.txt_product_name) TextView product_name;
    @BindView(R.id.txt_stock_avaiable) TextView stock_avaiable;
    @BindView(R.id.txt_price) TextView price;
    @BindView(R.id.txt_product_description) TextView description;
    @BindView(R.id.iv_details) ImageView inaage_product;
    private MaterialResult productItem;

    @Override
    public void setLayout() {
        setContentView(R.layout.activity_material_details);
        ButterKnife.bind(this);
    }

    @Override
    public void getObjects() {

    }

    @Override
    public void setObjects() {
        setHomeAsUp();
        setProductItem();
    }

    private void setProductItem(){
        productItem = (MaterialResult) getIntent().getSerializableExtra("itemProduct");
        product_name.setText(productItem.getName());
        stock_avaiable.setText(productItem.getStock());
        price.setText(productItem.getPrice());
        description.setText(productItem.getDescription());

        switch (productItem.getName()){
            case "Pencil":
                inaage_product.setImageDrawable(getResources().getDrawable(R.drawable.pencil));
                break;
            case "Rubberbands":
                inaage_product.setImageDrawable(getResources().getDrawable(R.drawable.rubberbands));
                break;
            case "Rulers":
                inaage_product.setImageDrawable(getResources().getDrawable(R.drawable.rulers));
                break;
            case "Clock":
                inaage_product.setImageDrawable(getResources().getDrawable(R.drawable.clock));
                break;
            default:
                inaage_product.setImageDrawable(getResources().getDrawable(R.drawable.error_circle));
                break;
        }
    }
}
