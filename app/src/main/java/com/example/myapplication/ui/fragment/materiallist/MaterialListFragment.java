package com.example.myapplication.ui.fragment.materiallist;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.myapplication.MaterialAdapter;
import com.example.myapplication.R;
import com.example.myapplication.core.web.entities.MaterialResult;
import com.example.myapplication.core.web.services.ServiceMaterial;
import com.example.myapplication.core.web.servicesoffline.LoadOffline;
import com.example.myapplication.interfaces.OnValidateUserEventListener;
import com.example.myapplication.ui.activity.main.MainActivity;
import com.example.myapplication.ui.activity.materialdetails.MaterialDetailsActivity;
import com.example.myapplication.ui.fragment.generic.GenericFragment;
import com.example.myapplication.utils.Alert;
import com.google.gson.Gson;

import java.util.Objects;

import butterknife.BindView;

public class MaterialListFragment extends GenericFragment implements OnValidateUserEventListener {

    @BindView(R.id.list_item) ListView listView;
    @BindView(R.id.tv_quantity_item) TextView txt_quantity;
    @BindView(R.id.txt_total_price) TextView txt_total;
    @BindView(R.id.tv_subtotal_price) TextView txt_subtotal;
    @BindView(R.id.tv_taxes_price) TextView txt_taxes;
    @BindView(R.id.tv_shipping_price) TextView txt_shipping;

    private MaterialAdapter adapter;
    private MaterialResult[] materialResults;
    private ServiceMaterial serviceMaterial;

    public MaterialListFragment() {
        super(R.layout.fragment_material_list, R.string.app_name);
    }

    @Override
    public void getObjects() {

    }

    @Override
    public void setObjects() {
//        loadOnline();
        loadOffline();
        showProductDetails();
    }

    private void loadOnline(){
        serviceMaterial = new ServiceMaterial(getContext());
        serviceMaterial.setOnValidateRequestEventListener(this);
        serviceMaterial.loadOnline();
    }

    private void loadOffline(){
        String result = new LoadOffline(getContext()).loadJSONFromAsset();
        materialResults = new Gson().fromJson(result, MaterialResult[].class);
        adapter = new MaterialAdapter(getContext(), materialResults);
        listView.setAdapter(adapter);
        setResultPrice(materialResults);
    }

    @SuppressLint("DefaultLocale")
    private void setResultPrice(MaterialResult[] result){
        int quantity = 0;
        int total = 0;
        int shipping = 0;
        int taxes = 0;

        for (MaterialResult materialResult : result) {
            quantity += 1;
            total = total + Integer.valueOf(materialResult.getPrice());
            shipping = shipping + Integer.valueOf(materialResult.getShipping());
            taxes = taxes + Integer.valueOf(materialResult.getTax());
        }

        int subtotal = taxes - shipping;

        txt_quantity.setText(String.format("%d items in your cart", quantity));
        txt_total.setText(String.valueOf(total));
        txt_subtotal.setText(String.valueOf(subtotal));
        txt_shipping.setText(String.valueOf(shipping));
        txt_taxes.setText(String.valueOf(taxes));
    }

    private void showProductDetails(){
        listView.setOnItemClickListener((parent, view, position, id) -> {
            MaterialResult listItem = (MaterialResult) listView.getItemAtPosition(position);
            openDetails(listItem);
        });
    }

    private void openDetails(MaterialResult item){
        Bundle b = new Bundle();
        b.putSerializable("itemProduct", item);
        ((MainActivity) Objects.requireNonNull(getActivity())).startActivity(MaterialDetailsActivity.class, b);
    }

    @Override
    public void onValidateRequestSuccess(MaterialResult[] result) {
        if(result != null){
            adapter = new MaterialAdapter(getContext(), result);
            listView.setAdapter(adapter);
            setResultPrice(result);
        }
    }

    @Override
    public void onValidateRequestFail(String error) {
        if(!error.isEmpty()){
            Alert.show(getContext(), Objects.requireNonNull(getContext()).getString(R.string.missing_connection), true);
        }
    }
}
