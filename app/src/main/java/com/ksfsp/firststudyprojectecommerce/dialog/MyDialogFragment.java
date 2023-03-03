package com.ksfsp.firststudyprojectecommerce.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.ksfsp.firststudyprojectecommerce.MainActivity;
import com.ksfsp.firststudyprojectecommerce.ShoppingCart;
import com.ksfsp.firststudyprojectecommerce.Test;
import com.ksfsp.firststudyprojectecommerce.model.Order;

public class MyDialogFragment extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        String title = "Confirm Deletion";
        String message = "Select the correct answer";
        String button1String = "DELETE";
        String button2String = "CANCEL";

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setCancelable(true);
        builder.setPositiveButton(button1String, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Order.itemsId.clear();
                Intent intent = new Intent(getActivity(), ShoppingCart.class);
                startActivity(intent);
            }
        });
        builder.setNegativeButton(button2String, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        return builder.create();
    }
}
