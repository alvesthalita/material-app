package com.example.myapplication.utils;

import android.content.Context;
import android.widget.Button;

import com.example.myapplication.R;

import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * Created by thalitaa on 08/05/18.
 */

public class Alert {

    /**
     * Exibe um alerta simples com: Título, Mensagem e Botão OK.
     *
     * @param context contexto da activity/fragment.
     * @param msg     mensagem que será exibida para o usuario.
     * @param isError true = erro; false = informativo.
     */
    public static void show(Context context, String msg, boolean isError) {
        int alertType = (isError) ? SweetAlertDialog.ERROR_TYPE : SweetAlertDialog.NORMAL_TYPE;
        if (context != null)
            new SweetAlertDialog(context, alertType)
                    .setTitleText(context.getString(R.string.app_name))
                    .setContentText(msg)
                    .show();
    }

    /**
     * Exibe um alerta simples com: Título, Mensagem e Botão OK.
     *
     * @param context    contexto da context/fragment.
     * @param msg        mensagem que será exibida para o usuario.
     * @param isError    true = erro; false = informativo.
     * @param okListener listener of confirm click
     */
    public static void show(Context context, String msg, boolean isError, SweetAlertDialog.OnSweetClickListener okListener) {
        int alertType = (isError) ? SweetAlertDialog.ERROR_TYPE : SweetAlertDialog.NORMAL_TYPE;
        if (context != null)
            new SweetAlertDialog(context, alertType)
                    .setTitleText(context.getString(R.string.app_name))
                    .setContentText(msg)
                    .setConfirmClickListener(okListener)
                    .show();
    }

    /**
     * Exibe um alerta simples com: Título, Mensagem e Listener do Botão OK
     *
     * @param context    contexto da activity/fragment.
     * @param msg        mensagem que será exibida para o usuário.
     * @param okListener listener ao clicar no botão.
     */
    public static void show(Context context, String msg, SweetAlertDialog.OnSweetClickListener okListener) {
        if (context != null) {
            SweetAlertDialog dialog = new SweetAlertDialog(context, SweetAlertDialog.NORMAL_TYPE)
                    .setTitleText(context.getString(R.string.app_name))
                    .setContentText(msg)
                    .setConfirmClickListener(okListener);

            dialog.setCancelable(false);
            dialog.show();
        }
    }

    /**
     * Exibe um alerte customizados com: Titulo, Mensagem, Botão OK e Botão Cancelar.
     *
     * @param context          contexto da activity/fragment;
     * @param title            titulo do pop up
     * @param msg              mensagem que será exibida para o usuário.
     * @param positiveTitle    título do botão OK.
     * @param positiveListener ação do botão OK.
     * @param negativeTitle    título do botão Cancelar.
     * @param negativeListener ação do botão Cancelar.
     * @param isWarn           varivael que informa se é aviso (true), não aviso (false).
     */
    public static void show(Context context, String title, String msg,
                            String positiveTitle, SweetAlertDialog.OnSweetClickListener positiveListener,
                            String negativeTitle, SweetAlertDialog.OnSweetClickListener negativeListener, boolean isWarn) {
        int alertType = (isWarn) ? SweetAlertDialog.WARNING_TYPE : SweetAlertDialog.NORMAL_TYPE;

        if (context != null)
            new SweetAlertDialog(context, alertType)
                    .setTitleText(title)
                    .setContentText(msg)
                    .setConfirmText(positiveTitle)
                    .setConfirmClickListener(positiveListener)
                    .setCancelText(negativeTitle)
                    .setCancelClickListener(negativeListener)
                    .show();
    }
}
